package com.ms.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(description = "User details")
public class MyUser {

    @ApiModelProperty(value = "username", example = "haha")
    private String username = "myusername";

    @ApiModelProperty(value = "password", example = "1", required = true)
    private Integer age =0;

    private List<String> friend=new ArrayList<>();
    //@ApiModelProperty(value = "test", example = "{\"test\": \"test22\"}", required = true)
    //private Test test;
    //
    //@Data
    //public static class Test {
    //    @ApiModelProperty(value = "test", example = "test22", required = true)
    //    private String test;
    //}
}
