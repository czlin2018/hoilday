package com.czl.privileges.repository;


import com.czl.privileges.entity.RoleInterfaceRelationship;
import com.czl.privileges.entity.User;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface RoleInterfaceRelationshipRepository {

    /**
     * 新增
     * @param relationship
     * @return
     */
    int insert ( RoleInterfaceRelationship relationship );

    /**
     * 查询全部
     * @param relationship
     * @return
     */
    List< RoleInterfaceRelationship > selectAll ( RoleInterfaceRelationship relationship );

    /**
     * 查询全部
     * @param roleIds
     * @return
     */
    List< RoleInterfaceRelationship > selectAllByRoleIds ( List<Long> roleIds );

    /**
     * 查询单个
     * @param relationship
     * @return
     */
    RoleInterfaceRelationship selectOne ( RoleInterfaceRelationship relationship );
}
