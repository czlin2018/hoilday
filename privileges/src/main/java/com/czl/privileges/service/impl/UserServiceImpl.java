package com.czl.privileges.service.impl;

import com.czl.base.request.BizException;
import com.czl.base.response.enums.ApiBaseEnum;
import com.czl.base.response.enums.ApiResponseEnum;
import com.czl.base.util.BeanCopyUtil;
import com.czl.privileges.dto.AuthenticationDTO;
import com.czl.privileges.dto.UserInsertDTO;
import com.czl.privileges.dto.UserLoginDTO;
import com.czl.privileges.entity.Interfaces;
import com.czl.privileges.entity.RoleInterfaceRelationship;
import com.czl.privileges.entity.User;
import com.czl.privileges.entity.UserRoleRelationship;
import com.czl.privileges.repository.*;
import com.czl.privileges.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @描述:
 * @公司: lumi
 * @author: 泽林
 * @创建日期: 2020-05-28
 * @创建时间: 16:37
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private InterfacesRepository interfacesRepository;

    @Autowired
    private UserRoleRelationshipRepository userRoleRelationshipRepository;

    @Autowired
    private RoleInterfaceRelationshipRepository roleInterfaceRelationshipRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ApiBaseEnum insert(UserInsertDTO userInsertDto) {
        User user = BeanCopyUtil.copy ( User.class , userInsertDto );
        int insert = userRepository.insert(user);
        return insert > 0 ? ApiResponseEnum.SUCCESS : ApiResponseEnum.FAIL;
    }

    @Override
    public List<String> getInterfacePathByUserId ( Long userId ){

        //获取用户角色id
        List<UserRoleRelationship> userRoleRelationships = userRoleRelationshipRepository.selectAll ( UserRoleRelationship.builder ( ).userId ( userId ).build ( ) );
        List<Long> roleIds = userRoleRelationships.stream ( ).map ( UserRoleRelationship :: getRoleId ).collect ( Collectors.toList ( ) );

        //获取角色的接口权限id
        List<Long> interfaceIds=roleInterfaceRelationshipRepository.selectAllByRoleIds ( roleIds )
                .stream ().map ( RoleInterfaceRelationship :: getInterfaceId ).collect ( Collectors.toList ( ) );

        //获取接口
        return interfacesRepository.getAllByInterfacesIds ( interfaceIds ).stream ().map ( Interfaces ::getInterfacePath ).collect( Collectors.toList());
    }

    @Override
    public Boolean authentication(AuthenticationDTO dto) {
        return getInterfacePathByUserId(dto.getUserId()).contains(dto.getInterfacePath());
    }

    @Override
    public User login(UserLoginDTO dto) {
        User user = userRepository.selectOne(User.builder().userAccount(dto.getUserAccount()).userPassword(dto.getUserPassword()).build());
        if (null == user) {
            throw new BizException(ApiResponseEnum.ILLEGAL_USER);
        }
        return user;
    }
}
