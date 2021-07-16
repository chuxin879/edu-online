package com.guodong.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;

import lombok.Data;

import java.io.Serializable;


@Data
public class TeacherQuery implements Serializable {
    private static final long serivalVersionUID = 1L;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "讲师level")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2020-06-09 04:05:06")
    private String begin;
    @ApiModelProperty(value = "查询结束时间", example = "2020-06-09 04:05:06")
    private String end;

}
