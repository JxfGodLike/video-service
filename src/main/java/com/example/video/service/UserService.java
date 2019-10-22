package com.example.video.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.video.entity.UsersEntity;

import java.util.List;


public interface UserService extends IService<UsersEntity> {

    List<UsersEntity> queryByUsername(String username);
}
