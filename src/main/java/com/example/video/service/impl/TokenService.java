package com.example.video.service.impl;

import com.example.video.common.utils.RedisOperator;
import com.example.video.entity.UsersEntity;
import com.example.video.vo.UsersEntityVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author shkstart
 * @create 2019-10-24 22:37
 */
@Service("tokenService")
public class TokenService {

    public static final String USER_TOKEN = "user-token";


    @Autowired
    RedisOperator redis;

    public UsersEntityVo createToken(UsersEntity user){
        String uniqueToken = UUID.randomUUID().toString();
        redis.set(USER_TOKEN + ":" + user.getId(),uniqueToken,30*60*1000);

        UsersEntityVo usersEntityVo = new UsersEntityVo();
        BeanUtils.copyProperties(user,usersEntityVo);
        usersEntityVo.setUserToken(uniqueToken);
        return usersEntityVo;
    }
}
