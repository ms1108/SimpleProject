package com.ms.controller;

import User.JarTest;
import User.JarTestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;


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

    //@GetMapping("/getJar")
    public static void main(String[] args) {
        //JarTest jarTest = new JarTest();
        //System.out.println(jarTest.getName());
        try {
            String json = "{\"name\":\"John\"}";
            ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:" + "/lib/jarTest-1.0-SNAPSHOT.jar.jar")}, Controller.class.getClassLoader());
            Class<JarTestBase> aClass = (Class<JarTestBase>) Class.forName("User.JarTest", true, classLoader);
            Gson gson = new Gson();
            JarTestBase jarTestBase = gson.fromJson(json, aClass);
            jarTestBase.handle();
            System.out.println(jarTestBase);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/getJar")
    public String getJar() {
        String handle = "";
        try {
            String json = "{\"name\":\"John\"}";
            ClassLoader classLoader = URLClassLoader.newInstance(new URL[]{new URL("file:" + "/lib/jarTest-1.0-SNAPSHOT.jar.jar")}, Controller.class.getClassLoader());
            Class<JarTestBase> aClass = (Class<JarTestBase>) Class.forName("User.JarTest", true, classLoader);
            Gson gson = new Gson();
            JarTestBase jarTestBase = gson.fromJson(json, aClass);
            handle = jarTestBase.handle();
            System.out.println(jarTestBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return handle;
    }
}
