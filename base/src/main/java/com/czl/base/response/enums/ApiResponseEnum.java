package com.czl.base.response.enums;

/**
 * @author: Jackson
 * @date: 2019/11/6
 * @description:
 */
public enum ApiResponseEnum implements ApiBaseEnum {

    /**
     * 公共错误码100-操作失败
     */
    FAIL(100, "FAIL", "操作失败"),

    /**
     * 公共成功响应状态码200-操作成功
     */
    SUCCESS(200, "SUCCESS", "操作成功"),

    /**
     * 公共错误码201-非法参数
     */
    PARAMETER_INVALID(201, "PARAMETER INVALID", "非法参数"),

    /**
     * 公共错误码202-非法用户
     */
    ILLEGAL_USER(202, "ILLEGAL USER", "非法用户");

    /**
     * api响应code码
     */
    private int code;

    /**
     * api错误码描述
     */
    private String msg;

    /**
     * 错误详细备注
     */
    private String note;

    ApiResponseEnum (int code, String msg, String note) {
        this.code = code;
        this.msg = msg;
        this.note = note;
    }

    public int getCode () {
        return code;
    }

    public String getMsg () {
        return msg;
    }

    public String getNote () {
        return note;
    }


}
