package com.czl.privileges.controller;

import com.czl.base.response.ApiResponse;
import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.privileges.dto.AuthenticationDTO;
import com.czl.privileges.dto.UserInsertDTO;
import com.czl.privileges.dto.UserLoginDTO;
import com.czl.privileges.entity.User;
import com.czl.privileges.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @描述:
 * @版权: Copyright (c) 2016-2018
 * @公司: lumi
 * @作者: 泽林
 * @创建日期: 2020-09-13
 * @创建时间: 17:12
 */
@RestController
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     * @param userInsertDto
     * @return
     */
    @PostMapping( "/insert" )
    public ApiResponse addUser(@RequestBody UserInsertDTO userInsertDto) {
        ApiBaseEnum apiBaseEnum = userService.insert ( userInsertDto );
        return ApiResponse.respond(apiBaseEnum);
    }

    /**
     * 登录
     *
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    public ApiResponse< User > login(@RequestBody UserLoginDTO userLoginDTO) {
        User user = userService.login(userLoginDTO);
        return ApiResponse.respond(user);
    }

    /**
     * 根据用户id获得接口权限
     * @param userId
     * @return
     */
    @GetMapping( "/userId/getInterfacePath" )
    public ApiResponse<List<String>> getInterfacePathByUserId ( Long userId) {
        List<String> result= userService.getInterfacePathByUserId ( userId );
        return ApiResponse.respond(result);
    }

    /**
     * 查询用户是否有某接口的权限
     *
     * @param authenticationDTO
     * @return
     */
    @PostMapping("/authentication")
    public ApiResponse< Boolean > authentication(AuthenticationDTO authenticationDTO) {
        Boolean result = userService.authentication(authenticationDTO);
        return ApiResponse.respond(result);
    }




}
