package com.example.testing;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Slf4j
public class ControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void account가_리턴된다() throws Exception{
        String account = "account";

        mvc.perform(MockMvcRequestBuilders.get("/account1"))
                .andExpect(status().isOk())
                .andExpect(content().string(account))
                .andDo(MockMvcResultHandlers.print());
    }
}
