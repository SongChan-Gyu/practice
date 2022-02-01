package com.example.testing.upbit.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class startRunner implements ApplicationRunner {

    @Autowired
    public ThreadTest threadTest;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        ThreadTest tr = new ThreadTest.ThreadTestBuilder().build();
//        tr.testThread();

        threadTest.testThread();

    }


}
