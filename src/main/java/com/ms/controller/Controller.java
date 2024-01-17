package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private RepeaterTestImpl repeaterTest;

    @GetMapping("/mock/{id}")
    public String mock(@PathVariable("id") String id) {
        System.out.println("run code");
        System.out.println("this is my mock id:".getClass());
        return "this is my mock id:" + id;
    }

    @GetMapping("/regress/repeater")
    public String repeater() {
        return repeaterTest.slogan();
    }

    @GetMapping("/sayhello")
    public String nginx() {
        System.out.println("hello");
        return "hello";
    }
}
