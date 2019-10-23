package com.example.video.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.video.entity.UsersEntity;

import java.util.List;


public interface UserService extends IService<UsersEntity> {

    UsersEntity queryByUsername(String username);

    UsersEntity queryByNameAndPwd(String username,String password);
}
