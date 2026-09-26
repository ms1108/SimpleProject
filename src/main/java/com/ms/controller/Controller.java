package com.ms.controller;

import User.JarTestBase;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Api(tags = "用户管理")
@RestController
public class Controller {

    @Autowired
    private RepeaterTestImpl repeaterTest;
    @Autowired
    private DataSource localDB;

    @GetMapping("/mock/{id}")
    public String mock(@PathVariable("id") String id) {
        System.out.println("run code");
        MockTest mockTest = new MockTest();
        List<MyUser> myUsers = mockTest.mockTestList(id);
        System.out.println("list:"+myUsers);
        Map<String,Object> test = mockTest.mockTest("id:"+id);
        System.out.println("map:"+test);
        MyUser myUser = mockTest.mockTestMyUser(id);
        System.out.println("myUser:"+myUser);
        Map<String,MyUser> mockTestMapMyUser = mockTest.mockTestMapMyUser(id);
        System.out.println("mockTestMapMyUser:"+mockTestMapMyUser);
        System.out.println(mockTest.testException(id));
        mockTest.testExceptionVoid(id);
        //mockTest.requestOkhttp(id);
        return id;
    }

    @GetMapping("/lazy")
    public String lazy() {
        System.out.println("1");
        String queryResult = new JdbcTemplate(localDB).queryForObject("select name from t_user where id=1 limit 1;", String.class);
        return queryResult;
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
    @ApiOperation(value = "hello knife4j",notes="author = 作者;<br> api_des = 接口描述;")
    //@ApiResponses(value = {@ApiResponse(code = 200, message = "返回描述")})
    @PostMapping("/hello_knife4j")
    //@ApiOperationSupport(author = "开发者")
    //@ApiImplicitParam(name = "username",defaultValue = "3")
    public String hello_knife4j(@RequestBody MyUser myUser) {
        System.out.println("hello,"+ myUser.getUsername());
        return "{\"name\":\"haha\",\"code\":1}";
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
