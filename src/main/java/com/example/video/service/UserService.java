package com.example.video.service;

import com.example.video.entity.Users;
import org.springframework.stereotype.Service;


public interface UserService {

    /**
     * @Description: 判断用户名是否存在
     */
    boolean queryUsernameIsExist(String username);

    /**
     * @Description: 保存用户(用户注册)
     */
    public void saveUser(Users user);
}
