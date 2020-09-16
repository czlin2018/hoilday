package com.czl.privileges.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.czl.base.idprodect.SnowFlakeId;
import com.czl.privileges.entity.Interfaces;
import com.czl.privileges.entity.User;
import com.czl.privileges.mapper.InterfacesMapper;
import com.czl.privileges.mapper.UserMapper;
import com.czl.privileges.repository.InterfacesRepository;
import com.czl.privileges.repository.UserRepository;
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
@Repository(value = "interfacesRepository")
public class InterfacesRepositoryImpl implements InterfacesRepository {

    @Autowired
    private InterfacesMapper interfacesMapper;

    @Override
    public int insert( Interfaces interfaces) {
        interfaces.setInterfaceId ( SnowFlakeId.generateId () );
        return interfacesMapper.insert(interfaces);
    }

    @Override
    public List< Interfaces > selectAll(Interfaces interfaces) {
        return interfacesMapper.selectList(new QueryWrapper<>(interfaces));
    }

    @Override
    public Interfaces selectOne(Interfaces interfaces) {
        return interfacesMapper.selectOne(new QueryWrapper<>(interfaces));
    }

    @Override
    public List<Interfaces> getAllByInterfacesIds ( List<Long> interfacesIds ){
        QueryWrapper<Interfaces> objectQueryWrapper = new QueryWrapper<> ( );
        objectQueryWrapper.in ( "interface_id",interfacesIds );
        return interfacesIds.size ()<1? Collections.EMPTY_LIST: interfacesMapper.selectList(objectQueryWrapper);
    }
}
