package com.guodong.servicebase.exception;


import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //生成get set方法
@AllArgsConstructor //生成有参构造
@NoArgsConstructor //生成无参构造
public class MyException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer code;

    private  String msg;

    @Override
    public String toString() {
        return "GuliException{" +
                "message=" + this.getMessage() +
                ", code=" + code +
                '}';
    }
}
