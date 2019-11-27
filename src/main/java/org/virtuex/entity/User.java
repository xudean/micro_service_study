package org.virtuex.entity;



import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author virtuex
 * @email xuda.it@outlook.com
 * @Description: 1.Model与Swagger集成需要在对应的controller中加入@RequestBody注解，否则Swagger不显示Model且不报错
 * 2.如果结合lombok需要有@ Data注解（否则就要有getter/setter）,否则swagger上不显示字段信息
 * @date 2019/11/5 14:00
 */
@Data
@Component
@ApiModel(value = "User", description = "用户实体类")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户名" , example = "张三")
    private int username;

    @ApiModelProperty(value = "密码")
    private String password;

}
