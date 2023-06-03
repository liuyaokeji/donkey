package com.donkey.infrastructure.exception;

import com.donkey.response.ResultCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Map;

/**
 * 业务异常类
 * @author liu'yao
 */
@Getter
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    Map<String,String> extra;
    private ResultCode resultCode;
    private String displayMeg;

    public BusinessException(ResultCode resultCode) {
        super(resultCode.getCode());
        this.resultCode = resultCode;
    }
}
