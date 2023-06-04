package com.donkey.request.auth;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LogoutRequestVo implements Serializable {
    private static final long serialVersionUID = -6449786331307085580L;
    @NotNull
    private String userId;
}
