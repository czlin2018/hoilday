package com.czl.privileges.repository;


import com.czl.privileges.entity.User;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface UserRepository {

    /**
     * 新增用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 查询全部
     * @param user
     * @return
     */
    List< User > selectAll(User user);

    /**
     * 查询单个
     * @param user
     * @return
     */
    User selectOne(User user);
}
