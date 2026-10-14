package com.ms.controller;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private int pageNum;

    private int pageSize;

    private long total;

    private List<T> data;
}
