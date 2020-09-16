package com.czl.privileges.repository;


import com.czl.privileges.entity.Role;
import com.czl.privileges.entity.User;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface RoleRepository {

    /**
     * 新增
     * @param role
     * @return
     */
    int insert ( Role role );

    /**
     * 查询全部
     * @param role
     * @return
     */
    List< Role > selectAll ( Role role );

    /**
     * 查询单个
     * @param role
     * @return
     */
    Role selectOne ( Role role );
}
