package com.czl.privileges.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czl.base.idprodect.SnowFlakeId;
import com.czl.privileges.entity.Interfaces;
import com.czl.privileges.entity.RoleInterfaceRelationship;
import com.czl.privileges.entity.User;
import com.czl.privileges.mapper.RoleInterfaceRelationshipMapper;
import com.czl.privileges.mapper.UserMapper;
import com.czl.privileges.repository.RoleInterfaceRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
@Repository(value = "roleInterfaceRelationshipRepository")
public class RoleInterfaceRelationshipRepositoryImpl implements RoleInterfaceRelationshipRepository {

    @Autowired
    private RoleInterfaceRelationshipMapper relationshipMapper;

    @Override
    public int insert(RoleInterfaceRelationship relationship) {
        return relationshipMapper.insert(relationship);
    }

    @Override
    public List< RoleInterfaceRelationship > selectAll(RoleInterfaceRelationship relationship) {
        return relationshipMapper.selectList(new QueryWrapper<>(relationship));
    }

    @Override
    public List<RoleInterfaceRelationship> selectAllByRoleIds ( List<Long> roleIds ){
        QueryWrapper<RoleInterfaceRelationship> objectQueryWrapper = new QueryWrapper<> ( );
        objectQueryWrapper.in ( "role_id",roleIds );
        return roleIds.size ()<1? Collections.EMPTY_LIST:relationshipMapper.selectList(objectQueryWrapper);
    }

    @Override
    public RoleInterfaceRelationship selectOne(RoleInterfaceRelationship relationship) {
        return relationshipMapper.selectOne(new QueryWrapper<>(relationship));
    }
}
