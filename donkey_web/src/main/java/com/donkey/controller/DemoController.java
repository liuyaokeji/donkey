package com.donkey.controller;


import com.donkey.domain.User;
import com.donkey.response.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @PostMapping("/addMoney")
    public BaseResponse<User> demo(@RequestBody User user){
        BaseResponse<User> response = new BaseResponse<>();
        response.setData(user);
        response.setResultCode("00001");
        response.setDisplayMsg("success");
        int i = 1/0;
        System.out.println(123);
        System.out.println(123);
        return BaseResponse.success(user);
    }
}
