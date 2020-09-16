package com.czl.privileges.repository;


import com.czl.privileges.entity.User;
import com.czl.privileges.entity.UserRoleRelationship;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface UserRoleRelationshipRepository {

    /**
     * 新增
     * @param userRoleRelationship
     * @return
     */
    int insert ( UserRoleRelationship userRoleRelationship );

    /**
     * 查询全部
     * @param userRoleRelationship
     * @return
     */
    List< UserRoleRelationship > selectAll ( UserRoleRelationship userRoleRelationship );

    /**
     * 查询单个
     * @param userRoleRelationship
     * @return
     */
    UserRoleRelationship selectOne ( UserRoleRelationship userRoleRelationship );
}
