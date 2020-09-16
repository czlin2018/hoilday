package com.czl.privileges.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czl.base.idprodect.SnowFlakeId;
import com.czl.privileges.entity.User;
import com.czl.privileges.mapper.UserMapper;
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
@Repository(value = "userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        user.setUserId ( SnowFlakeId.generateId () );
        return userMapper.insert(user);
    }

    @Override
    public List< User > selectAll(User user) {
        return userMapper.selectList(new QueryWrapper<>(user));
    }

    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(new QueryWrapper<>(user));
    }
}
