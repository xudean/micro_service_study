package org.virtuex.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.virtuex.entity.User;
import org.virtuex.model.AddDataResponse;
import org.virtuex.model.Response401;
import org.virtuex.model.Response403;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author virtuex
 * @email xuda.it@outlook.com
 * @Description:
 * @date 2019/11/6 11:34
 */
@RestController
@Api("用户管理")
public class UserController {

    @ApiOperation("添加用户")
    @PostMapping("/add")
    @ApiResponses({@ApiResponse(code = 200, response = AddDataResponse.class, message = "成功"),
            @ApiResponse(code = 401, response = Response401.class, message = "未认证"),
            @ApiResponse(code = 403, response = Response403.class, message = "禁止访问")
    })
    public String addAdmin(@RequestBody User user){
        return "OK";
    }
}
