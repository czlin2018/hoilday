package com.czl.base.response;

import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.base.response.enums.ApiResponseEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @author: Jackson
 * @date: 2019/11/6
 * @description:
 */
public class ApiResponse <T> {

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

    /**
     * 接口响应数据
     */
    private T data;

    /**
     * 服务端响应时间戳
     */
    private long timestamp;

    /**
     * 服务端接口响应版本
     */
    private String version = "v1.0.0";


    private ApiResponse (ApiBaseEnum apiBaseEnum) {
        this.code = apiBaseEnum.getCode();
        this.msg = apiBaseEnum.getMsg().toLowerCase();
        this.note = apiBaseEnum.getNote();
        this.timestamp = new Date().getTime();
    }

    private ApiResponse (ApiBaseEnum apiBaseEnum, T data) {
        this(apiBaseEnum);
        this.data = data;
    }

    private ApiResponse (ApiBaseEnum apiBaseEnum, T data, String note) {
        this(apiBaseEnum);
        this.data = data;
        if (StringUtils.isNotBlank(note)) {
            this.note = note;
        }
    }

    private ApiResponse (int customCode, T data, String customNote) {
        this.code = customCode;
        this.timestamp = new Date().getTime();
        this.data = data;
        if (StringUtils.isNotBlank(customNote)) {
            this.note = customNote;
        }
    }

    public ApiResponse () {
    }

    public static <T> ApiResponse<T> respond() {
        return new ApiResponse<>(ApiResponseEnum.SUCCESS);
    }

    public static <T> ApiResponse<T> respond(T data) {
        return new ApiResponse<>(ApiResponseEnum.SUCCESS, data);
    }

    public static <T> ApiResponse<T> respond(T data, ApiBaseEnum apiBaseEnum) {
        return new ApiResponse<>(apiBaseEnum, data);
    }

    public static <T> ApiResponse<T> respond(ApiBaseEnum apiBaseEnum) {
        return new ApiResponse<>(apiBaseEnum);
    }

    public static <T> ApiResponse<T> respond(T data, ApiBaseEnum apiBaseEnum, String customNote) {
        return new ApiResponse<>(apiBaseEnum, data, customNote);
    }

    public static <T> ApiResponse<T> respond(T data, int customCode, String customNote) {
        return new ApiResponse<>(customCode, data, customNote);
    }

    public static <T> ApiResponse<T> respond(ApiBaseEnum apiBaseEnum, String errors) {
        ApiResponse<T> apiResponse = respond(apiBaseEnum);
        if (errors == null) {
            return apiResponse;
        } else {
            apiResponse.note = errors;
            return apiResponse;
        }
    }

    public static <T> ApiResponse<T> respond(String errors) {
        ApiResponse<T> apiResponse = new ApiResponse<>(ApiResponseEnum.FAIL);
        apiResponse.note = errors;
        return apiResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
