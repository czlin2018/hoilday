package com.czl.privileges.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czl.base.idprodect.SnowFlakeId;
import com.czl.privileges.entity.User;
import com.czl.privileges.entity.UserRoleRelationship;
import com.czl.privileges.mapper.UserMapper;
import com.czl.privileges.mapper.UserRoleRelationshipMapper;
import com.czl.privileges.repository.UserRepository;
import com.czl.privileges.repository.UserRoleRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
@Repository(value = "userRoleRelationshipRepository")
public class UserRoleRelationshipRepositoryImpl implements UserRoleRelationshipRepository {

    @Autowired
    private UserRoleRelationshipMapper mapper;

    @Override
    public int insert( UserRoleRelationship relationship) {
        return mapper.insert(relationship);
    }

    @Override
    public List< UserRoleRelationship > selectAll(UserRoleRelationship relationship) {
        return mapper.selectList(new QueryWrapper<>(relationship));
    }

    @Override
    public UserRoleRelationship selectOne(UserRoleRelationship relationship) {
        return mapper.selectOne(new QueryWrapper<>(relationship));
    }
}
