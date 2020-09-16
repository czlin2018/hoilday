package com.czl.privileges.dto;

import lombok.Data;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-09-14
 * @创建时间: 10:02
 */
@Data
public class AuthenticationDTO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 接口路径
     */
    private String interfacePath;
}
