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

import java.util.UUID;

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


    public HttpEntity request(String url) throws Exception{

        log.info("util.request("+url+")"+" START");
        log.info("TEST: **** accessKey  =["+accessKey+"]");
        log.info("TEST: **** secretKey =["+secretKey+"]");
        log.info("TEST: **** serverUrl =["+serverUrl+"]");

        //1. 토큰생성
        String authenticationToken = makeAuthenticationToken();

        //2. request header 설정
        HttpGet request = makeRequest(url,authenticationToken);

        HttpClient client = HttpClientBuilder.create().build();

        //3. 요청
        HttpResponse response = client.execute(request);

        //4. resonse
        HttpEntity entity = response.getEntity();

        log.info(EntityUtils.toString(entity, "UTF-8"));

        return entity;

    }

    private String makeAuthenticationToken(){

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        String jwtToken = JWT.create()
                .withClaim("access_key", accessKey)
                .withClaim("nonce", UUID.randomUUID().toString())
                .sign(algorithm);

        String authenticationToken = "Bearer " + jwtToken;

        return authenticationToken;
    }

    private HttpGet makeRequest(String url, String authenticationToken){

        HttpGet request = new HttpGet(serverUrl + url);
        request.setHeader("Content-Type", "application/json");
        request.addHeader("Authorization", authenticationToken);

        return request;
    }

}
