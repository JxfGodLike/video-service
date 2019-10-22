package com.example.video.service;

import com.baomidou.mybatisplus.service.IService;
import com.example.video.entity.Users;

import java.util.List;


public interface UserService extends IService<Users> {

    List<Users> queryByUsername(String username);
}
