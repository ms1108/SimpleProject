package com.ms.controller;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RepeaterTestImpl {
    private String[] slogans = new String[]{"JAVA", "Python", "PHP", "C#", "C++", "Javascript", "GO"};
    private AtomicInteger sequence = new AtomicInteger(0);

    public String slogan() {

        return slogans[sequence.getAndIncrement() % slogans.length] + "是世界上最好的语言!";

    }

}
