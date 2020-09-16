package com.czl.base.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页传输对象
 */
@Data
public class PageRequestDTO {

    /**
     * 页码:默认第一页
     */
    @Min ( 1 )
    private long pageNo = 1;
    /**
     * 每页数量:默认10
     */
    @Min ( 1 )
    @Max ( 200 )
    private long pageSize = 10;

}