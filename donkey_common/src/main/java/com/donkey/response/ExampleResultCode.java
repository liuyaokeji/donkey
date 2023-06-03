package com.donkey.response;

public enum ExampleResultCode implements ResultCode{
    SUCCESS,
    FAIL,
    INVALID_PARAM,
    DATA_ACCESS_FAIL;
    @Override
    public String getCode() {
        return this.name().toLowerCase();
    }
}
