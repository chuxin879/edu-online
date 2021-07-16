package com.guodong.commonutils;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    private Integer code;

    private String messsage;

    private Map<String, Object> data = new HashMap<>();

    private R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMesssage("success");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMesssage("ERROR");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R message(String message){
        this.setMesssage(message);
        return this;
    }

    public R data(HashMap<String, Object> data){
        this.setData(data);
        return this;

    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }
}
