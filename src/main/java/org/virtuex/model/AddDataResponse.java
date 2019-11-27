package org.virtuex.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.virtuex.model.base.BaseModel;

@Data
@ApiModel(value = "AddDataResponse", description = "响应实体")
public class AddDataResponse extends BaseModel {
    @ApiModelProperty(value = "响应状态码" , example = "200")
    private Integer code;
    @ApiModelProperty(value = "描述" , example = "创建成功")
    private String desc;
}
