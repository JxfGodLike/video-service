package com.example.video.controller;

import com.example.video.common.utils.IMoocJSONResult;
import com.example.video.common.utils.MD5Utils;
import com.example.video.dao.UsersMapper;
import com.example.video.entity.Users;
import com.example.video.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RegisterAndLoginController {

    @Autowired
    private UserService userService;
    @Resource
    private UsersMapper usersMapper;

    @PostMapping("/register")
    public IMoocJSONResult register(@RequestBody Users user) throws Exception {

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return IMoocJSONResult.errorMsg("用户名和密码不能为空");
        }
        // 2. 判断用户名是否存在
        List<Users> usersList = userService.queryByUsername(user.getUsername());

        // 3. 保存用户，注册信息
        if (usersList==null){
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0);
            user.setReceiveLikeCounts(0);
            user.setFollowCounts(0);
            userService.insert(user);
        } else {
            return IMoocJSONResult.errorMsg("用户名已经存在，请换一个再试");
        }
        return IMoocJSONResult.ok();
    }
}
