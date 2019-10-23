package com.example.video.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.example.video.common.utils.MD5Utils;
import com.example.video.dao.UsersDao;
import com.example.video.entity.UsersEntity;
import com.example.video.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
    public class UserServiceImpl extends ServiceImpl<UsersDao, UsersEntity> implements UserService {

    @Resource
    private UsersDao usersDao;


    @Override
    public UsersEntity queryByUsername(String username) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(username);
        return usersDao.selectOne(usersEntity);
    }

    @Override
    public UsersEntity queryByNameAndPwd(String username, String password) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setUsername(username);
        usersEntity.setPassword(password);
        return usersDao.selectOne(usersEntity);
    }
}
