package com.example.testing.upbit.thread;


import com.example.testing.upbit.Service.UpbitTestService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadTest {

    @Autowired
    public UpbitTestService service;


    public void testThread(){
        Thread thread = new Thread(()-> this.ex());
        thread.start();
    }

    public void ex(){
        service.selectAll();
    }



}
