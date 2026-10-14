package com.ms.controller;

import lombok.Data;

@Data
public class Response<T> {

    private int status;

    private T page;
}
