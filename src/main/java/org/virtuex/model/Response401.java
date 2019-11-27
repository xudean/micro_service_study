package org.virtuex.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.virtuex.model.base.BaseModel;

@Data
@ApiModel(value = "Response401", description = "401响应实体")
public class Response401 extends BaseModel {

    @ApiModelProperty(value = "描述" , example = "未认证")
    private String message;
    @ApiModelProperty(value = "建议" , example = "请先认证")
    private String suggestion;
}
