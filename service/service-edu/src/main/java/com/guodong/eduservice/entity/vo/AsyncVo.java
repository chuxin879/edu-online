package com.guodong.eduservice.entity.vo;

import lombok.Data;
import org.springframework.web.context.request.async.DeferredResult;


@Data
public class AsyncVo<I,O> {
    /**
     * 请求参数
     */
    private I params;

    public DeferredResult<O> result;




}
