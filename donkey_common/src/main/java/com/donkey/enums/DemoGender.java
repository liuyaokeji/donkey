package com.donkey.enums;


import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 枚举示例 枚举统一放在此目录
 */
public enum DemoGender {
    UNKNOWN(2,"性别未知"),

    FEMALE(0,"性别女"),

    MALE(1,"性别男");

    @EnumValue
    private int code;
    private String name;

    DemoGender(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
