package com.czl.base.request;

import com.czl.base.response.enums.ApiBaseEnum;

/**
 * @author: Jackson
 * @date: 2019/11/6
 * @description:
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = - 653112170620824445L;

    private final ApiBaseEnum apiBaseEnum;

    private String customMsg;

    public BizException (ApiBaseEnum apiBaseEnum, String customMsg) {
        super(customMsg);
        this.customMsg = customMsg;
        this.apiBaseEnum = apiBaseEnum;
    }

    public BizException (ApiBaseEnum apiBaseEnum) {
        super(apiBaseEnum.getNote());
        this.apiBaseEnum = apiBaseEnum;
    }

    public ApiBaseEnum getApiEnum () {
        return this.apiBaseEnum;
    }

    public String getCustomMsg () {
        return customMsg;
    }
}
