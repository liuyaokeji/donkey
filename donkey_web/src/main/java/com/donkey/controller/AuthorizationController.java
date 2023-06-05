package com.donkey.controller;

import com.donkey.response.auth.LoginResponseVo;
import com.donkey.response.auth.LogoutResponseVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liu'yao
 */
@RestController
@RequestMapping("/donkey/auth")
public class AuthorizationController {
    /**登录接口**/
    public LoginResponseVo login(@Validated @RequestBody LoginResponseVo loginResponseVo){
        return null;
    }


    /**注销接口**/
    public LogoutResponseVo login(@Validated @RequestBody LogoutResponseVo logoutResponseVo){
        return null;
    }
}
