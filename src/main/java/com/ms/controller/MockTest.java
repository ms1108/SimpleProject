package com.ms.controller;

import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.*;

public class MockTest {
    public Map<String,Object> mockTest(String param) {
        //mock工具，会在执行完代码之后才修改数据
        System.out.println(param);
        Map<String,Object>  objects = new HashMap<>();
        objects.put("mockTest_not_target_mock",param);
        objects.put("mockTest_not_target_mock2",param);
        return objects;
    }
    public List<MyUser> mockTestList(String param) {
        //mock工具，会在执行完代码之后才修改数据
        System.out.println(param);
        List<MyUser> objects = new ArrayList<>();
        MyUser myUser = new MyUser();
        myUser.setUsername(param+"_mockTestList_not_target_mock");
        myUser.setAge(1);
        objects.add(myUser);
        return objects;
    }
    public MyUser mockTestMyUser(String param) {
        //mock工具，会在执行完代码之后才修改数据
        System.out.println(param);
        MyUser myUser = new MyUser();
        myUser.setUsername(param+"_mockTestMyUser_not_target_mock");
        myUser.setAge(1);
        return myUser;
    }

    public Map<String,MyUser> mockTestMapMyUser(String param) {
        System.out.println(param);
        Map<String, MyUser> map = new HashMap<>();
        MyUser myUser = new MyUser();
        myUser.setUsername(param+"_mockTestMapMyUser_not_target_mock");
        myUser.setAge(1);
        map.put("user",myUser);
        return map;
    }

    public Map<String,Object> testException(String id) {
        if (id.equals("exception")) {
            System.out.println("主动抛出异常");
            throw new RuntimeException("测试异常");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("exception","no target mock testException");
        return map;
    }
    public void testExceptionVoid(String id) {
        if (id.equals("exceptionVoid")) {
            System.out.println("主动抛出异常");
            throw new RuntimeException("测试异常");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("exception","no target mock testExceptionVoid");
        System.out.println(map);
    }

    public String requestOkhttp(String id) {
        OkHttpClient client = new OkHttpClient();

        // 构建请求
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/todos/1") // 请求 URL
                .get() // 默认就是 GET 方法，可省略
                .addHeader("Accept", "application/json") // 添加请求头
                .build();

        // 发送请求并处理响应
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("请求失败: " + response);
            }

            // 获取响应体
            String responseBody = response.body().string();
            System.out.println("响应内容: " + responseBody);

            // 获取响应头
            System.out.println("响应状态码: " + response.code());
            return responseBody;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MockTest mockTest = new MockTest();
        mockTest.requestOkhttp("1");
    }
}
