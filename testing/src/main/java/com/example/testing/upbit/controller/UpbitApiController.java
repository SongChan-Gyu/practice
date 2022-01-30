package com.example.testing.upbit.controller;

import com.example.testing.upbit.util.apiUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class UpbitApiController {

    @Autowired
    private apiUtil util;

    @PostMapping("/upbit/1")
    public @ResponseBody String upbitBasic() throws Exception {

        String url = "/v1/accounts";
        HttpEntity entity = util.request(url);
        return "test";

    }


}
