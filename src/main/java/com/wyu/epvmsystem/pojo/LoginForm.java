package com.wyu.epvmsystem.pojo;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author afglow
 * @Date Create in 2022-10-2022/10/31-21:46
 * @Description
 */
@Data
public class LoginForm {
    private String loginUsername;
    private String loginPassword;
    private Integer authType;
    private String verifyCode;
}
