package com.czl.gateway.controller;

import com.czl.gateway.feign.PrivilegesFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-09-14
 * @创建时间: 11:46
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PrivilegesFeign privilegesFeign;

    @GetMapping("/test")
    public Object login() {
        return privilegesFeign.getInterfacePathByUserId(1l);
    }



}
