package com.donkey.response;

import lombok.Data;

import java.util.List;

@Data
public class PageResponse<T> {

    //偏移量
    private  long offset;

    //查询记录数
    private int count;

    //总记录数
    private  long amount;

    //查询结果籍
    private List<T> list;
}
