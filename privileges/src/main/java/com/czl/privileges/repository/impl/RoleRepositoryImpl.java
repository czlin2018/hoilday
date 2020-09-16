package com.czl.privileges.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czl.base.idprodect.SnowFlakeId;
import com.czl.privileges.entity.Role;
import com.czl.privileges.entity.User;
import com.czl.privileges.mapper.RoleMapper;
import com.czl.privileges.mapper.UserMapper;
import com.czl.privileges.repository.RoleRepository;
import com.czl.privileges.repository.UserRepository;
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
@Repository(value = "roleRepository")
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert( Role role) {
        role.setRoleId ( SnowFlakeId.generateId () );
        return roleMapper.insert(role);
    }

    @Override
    public List< Role > selectAll(Role role) {
        return roleMapper.selectList(new QueryWrapper<>(role));
    }

    @Override
    public Role selectOne(Role role) {
        return roleMapper.selectOne(new QueryWrapper<>(role));
    }
}
