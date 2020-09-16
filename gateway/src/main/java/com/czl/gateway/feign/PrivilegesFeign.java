package com.czl.gateway.feign;

import com.czl.base.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @描述: 老pcfeign
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-03-16
 * @创建时间: 14:22
 */
@FeignClient(contextId = "PrivilegesFeign", value = "privilegesFeign", url = "localhost:8083")
public interface PrivilegesFeign {

    /**
     * 根据用户id查询全部的接口权限
     */
    @GetMapping("/privileges/user/userId/getInterfacePath")
    ApiResponse< List< String > > getInterfacePathByUserId(@RequestParam Long userId);


}
