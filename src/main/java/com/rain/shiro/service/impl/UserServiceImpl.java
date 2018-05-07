package com.rain.shiro.service.impl;

import com.rain.shiro.dao.BaseDao;
import com.rain.shiro.dao.UserDao;
import com.rain.shiro.domain.User;
import com.rain.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    @Autowired
    private UserDao dao;

    @Override
    public BaseDao<User> getRepository() {
        return dao;
    }
}
