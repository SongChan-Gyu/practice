package com.example.testing.upbit;

import com.example.testing.upbit.controller.UpbitApiController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest
public class apiTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void Api테스트() throws Exception{

        mvc.perform(MockMvcRequestBuilders.post("/upbit/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

        throw new Exception();
    }

}
