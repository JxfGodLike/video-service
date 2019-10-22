package com.example.video.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.example.video.dao.UsersMapper;
import com.example.video.entity.Users;
import com.example.video.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
    public class UserServiceImpl extends ServiceImpl<UsersMapper,Users> implements UserService {

    @Resource
    private UsersMapper usersMapper;


    @Override
    public List<Users> queryByUsername(String username) {
        return usersMapper.selectList(new EntityWrapper<Users>().eq("username",username));
    }
}
