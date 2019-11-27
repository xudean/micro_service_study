package org.virtuex.model.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public abstract class BaseModel {
    @ApiModelProperty(value = "业务流水号" , example = "123-454-845-454")
    private String bizId;
}
