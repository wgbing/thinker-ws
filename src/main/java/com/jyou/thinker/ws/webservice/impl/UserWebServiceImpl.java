package com.jyou.thinker.ws.webservice.impl;

import cn.hutool.json.JSONUtil;
import com.jyou.thinker.ws.common.Constant;
import com.jyou.thinker.ws.common.param.Query;
import com.jyou.thinker.ws.domain.User;
import com.jyou.thinker.ws.mapper.UserMapper;
import com.jyou.thinker.ws.webservice.UserWebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Slf4j
@Component
@WebService(
        targetNamespace = Constant.NAMESPACE_URI, //wsdl命名空间
        name = UserWebServiceImpl.WS_PREFIX+"PortType",                 //portType名称 客户端生成代码时 为接口名称
        serviceName = UserWebServiceImpl.WS_PREFIX+"Service",           //服务name名称
        portName = UserWebServiceImpl.WS_PREFIX+"PortName",             //port名称
        endpointInterface = "com.jyou.thinker.ws.webservice.UserWebService")//指定发布webservcie的接口类，此类也需要接入@WebService注解
public class UserWebServiceImpl implements UserWebService{
    public static final String WS_PREFIX = "user";

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getById(Long id) {
        User user = new User();
        if(id != null){
            user = userMapper.selectByPrimaryKey(id);
        }
        return user;
    }

    @Override
    public int deleteById(Long id) {
        int count = 0;
        if(id != null){
            count = userMapper.deleteByPrimaryKey(id);
        }
        return count;
    }

    @Override
    public int save(String user) {
        int count = 0;
        User u = JSONUtil.parseObj(user).toBean(User.class);
        count = userMapper.save(u);
        return count;
    }

    @Override
    public int update(String user) {
        int count = 0;
        User u = JSONUtil.parseObj(user).toBean(User.class);
        count = userMapper.updateByPrimaryKey(u);
        return count;
    }

    @Override
    public List<User> list() {
        return userMapper.selectAll();
    }
}
