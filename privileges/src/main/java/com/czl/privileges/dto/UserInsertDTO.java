package com.czl.privileges.dto;

import lombok.Data;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2020-09-13
 * @创建时间: 17:14
 */
@Data
public class UserInsertDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String userPassword;

}
