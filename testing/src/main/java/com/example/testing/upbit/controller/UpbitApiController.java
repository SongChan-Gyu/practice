package com.example.testing.upbit.controller;

import com.example.testing.upbit.Domain.model.Account;
import com.example.testing.upbit.Service.UpbitTestService;
import com.example.testing.upbit.util.apiUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Slf4j
public class UpbitApiController {

    @Autowired
    private apiUtil util;

    @Autowired
    private UpbitTestService service;

    @PostMapping("/upbit/accounts")
    public @ResponseBody String accountList() throws Exception{

        String url = "/v1/accounts";
        HashMap<String,String> params = new HashMap<>();
        String body = util.request(url, params);

        ObjectMapper mapper = new ObjectMapper();

        List<Account> accountList = mapper.readValue(body, new TypeReference<List<Account>>() {});

        //log.info(accountList.stream().collect(Collectors.toList()).toString());

        service.saveAccounts(accountList);

        log.info(service.selectAll().stream().collect(Collectors.toList()).toString());

        return "test";
    }

    @PostMapping("/upbit/orderChance")
    public @ResponseBody String orderAvailableList() throws Exception {

        String url = "/v1/orders/chance?";
        HashMap<String,String> params = new HashMap<>();
        params.put("market", "KRW-BTC");
        String body = util.request(url, params);

        return body;
    }

}
