package com.czl.business.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-21
 * @创建时间: 11:34
 */
@Data
public class UserDTO {

    @NotBlank
    private String name;
}
