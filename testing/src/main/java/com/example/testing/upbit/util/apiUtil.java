package com.example.testing.upbit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.*;

@Slf4j
@PropertySource("classpath:key.properties")
@Component
public class apiUtil {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretKey}")
    private String secretKey;

    @Value("${serverUrl}")
    private String serverUrl;


    public String request(String url, HashMap<String,String> params) throws Exception{

        log.info("util.request("+url+")"+" START");
        log.info("TEST: **** accessKey =["+accessKey+"]");
        log.info("TEST: **** secretKey =["+secretKey+"]");
        log.info("TEST: **** serverUrl =["+serverUrl+"]");

        //1. 토큰생성
        HashMap<String, Object> map = makeAuthenticationToken(params);

        String authenticationToken = map.get("authenticationToken").toString();
        String queryString = map.get("queryString").toString();

        //2. request header 설정
        HttpGet request = makeRequest(url,authenticationToken, queryString);

        HttpClient client = HttpClientBuilder.create().build();

        //3. 요청
        HttpResponse response = client.execute(request);

        //4. resonse
        HttpEntity entity = response.getEntity();


        return EntityUtils.toString(entity, "UTF-8");

    }

    private HashMap<String,Object> makeAuthenticationToken(HashMap<String,String> params) throws Exception{

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String authenticationToken;
        String jwtToken;
        String queryString="";

        if(params.isEmpty()){
            jwtToken = JWT.create()
                        .withClaim("access_key", accessKey)
                        .withClaim("nonce", UUID.randomUUID().toString())
                        .sign(algorithm);

            authenticationToken = "Bearer " + jwtToken;

        }else{

            ArrayList<String> queryElements = new ArrayList<>();
            for(Map.Entry<String, String> entity : params.entrySet()) {
                queryElements.add(entity.getKey() + "=" + entity.getValue());
            }

            queryString = String.join("&", queryElements.toArray(new String[0]));

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(queryString.getBytes("UTF-8"));

            String queryHash = String.format("%0128x", new BigInteger(1, md.digest()));

            log.info("queryHash   =["+ queryHash+"]");
            log.info("queryString =["+ queryString+"]");

            jwtToken = JWT.create()
                        .withClaim("access_key", accessKey)
                        .withClaim("nonce", UUID.randomUUID().toString())
                        .withClaim("query_hash", queryHash)
                        .withClaim("query_hash_alg", "SHA512")
                        .sign(algorithm);

            authenticationToken = "Bearer " + jwtToken;
        }

        HashMap<String,Object> map = new HashMap<>();
        map.put("authenticationToken", authenticationToken);
        map.put("queryString", queryString);

        return map;
    }

    private HttpGet makeRequest(String url, String authenticationToken, String queryString){

        HttpGet request = new HttpGet(serverUrl + url + queryString);
        request.setHeader("Content-Type", "application/json");
        request.addHeader("Authorization", authenticationToken);

        return request;
    }

}
