package com.czl.privileges.repository;


import com.czl.privileges.entity.Interfaces;
import com.czl.privileges.entity.User;

import java.util.List;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:29
 */
public interface InterfacesRepository {

    /**
     * 新增
     * @param interfaces
     * @return
     */
    int insert ( Interfaces interfaces);

    /**
     * 查询全部
     * @param interfaces
     * @return
     */
    List< Interfaces > selectAll ( Interfaces interfaces );

    /**
     * 查询单个
     * @param interfaces
     * @return
     */
    Interfaces selectOne ( Interfaces interfaces );

    /**
     * 根据接口id获取数据
     * @param interfacesIds
     * @return
     */
    List<Interfaces> getAllByInterfacesIds ( List<Long> interfacesIds );
}
