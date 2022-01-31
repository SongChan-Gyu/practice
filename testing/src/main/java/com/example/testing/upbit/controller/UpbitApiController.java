package com.example.testing.upbit.controller;

import com.example.testing.upbit.util.apiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@Slf4j
public class UpbitApiController {

    @Autowired
    private apiUtil util;

    @PostMapping("/upbit/accounts")
    public @ResponseBody String accountList() throws Exception {

        String url = "/v1/accounts";
        HashMap<String,String> params = new HashMap<>();
        //params.put("market", "KRW-BTC");
        HttpEntity entity = util.request(url, params);

        return EntityUtils.toString(entity, "UTF-8");
    }

    @PostMapping("/upbit/orderChance")
    public @ResponseBody String orderAvailableList() throws Exception {

        String url = "/v1/orders/chance?";
        HashMap<String,String> params = new HashMap<>();
        params.put("market", "KRW-BTC");
        HttpEntity entity = util.request(url, params);

        return EntityUtils.toString(entity, "UTF-8");

    }

}
