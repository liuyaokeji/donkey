package com.donkey.response.auth;

import lombok.Data;

import java.io.Serializable;
@Data
public class LogoutResponseVo implements Serializable {
    private static final long serialVersionUID = 7453754258646519864L;
    private String userId;
}
