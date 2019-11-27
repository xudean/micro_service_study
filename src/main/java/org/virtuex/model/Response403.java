package org.virtuex.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.virtuex.model.base.BaseModel;

@Data
@ApiModel(value = "Response403", description = "403响应实体")
public class Response403 extends BaseModel {
    @ApiModelProperty(value = "描述" , example = "禁止访问")
    private String message;
    @ApiModelProperty(value = "建议" , example = "请确认是否有权限访问")
    private String suggestion;
}

