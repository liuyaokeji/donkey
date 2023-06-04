package com.donkey.request.auth;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LoginRequestVo implements Serializable {
    private static final long serialVersionUID = 8924086735679691923L;

    @NotNull(message = "手机号不能为空")
    @Length(min = 11,max = 11,message = "手机号格式错误")
    private String phone;
    @NotNull(message = "密码不能为空")
    private String password;

}
