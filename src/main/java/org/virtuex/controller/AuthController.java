package org.virtuex.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("认证与授权")
@RestController("/auth")
public class AuthController {

    @ApiOperation("获取会话")
    @GetMapping("/session")
    public void getSession() {

    }

    @ApiOperation("获取令牌")
    @GetMapping("/token")
    public void getToken() {

    }

}


