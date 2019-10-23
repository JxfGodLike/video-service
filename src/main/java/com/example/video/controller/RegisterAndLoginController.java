package com.example.video.controller;

import com.example.video.common.utils.R;
import com.example.video.common.utils.MD5Utils;
import com.example.video.dao.UsersDao;
import com.example.video.entity.UsersEntity;
import com.example.video.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(value = "用户注册与登陆",tags = {"注册与登陆controller"})
public class RegisterAndLoginController {

    @Autowired
    private UserService userService;
    @Resource
    private UsersDao usersDao;

    @PostMapping("/register")
    @ApiOperation(value = "用户注册",notes = "用户注册的接口")
    public R register(@RequestBody UsersEntity user) throws Exception {

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return R.errorMsg("用户名和密码不能为空");
        }
        // 2. 判断用户名是否存在
        UsersEntity usersEntity = userService.queryByUsername(user.getUsername());

        // 3. 保存用户，注册信息
        if (usersEntity==null){
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0L);
            user.setReceiveLikeCounts(0L);
            user.setFollowCounts(0L);
            userService.insert(user);
        } else {
            return R.errorMsg("用户名已经存在，请换一个再试");
        }
        return R.ok(user);
    }
    @PostMapping("/login")
    @ApiOperation(value = "用户登陆",notes = "用户登陆的接口")
    public R login(@RequestBody UsersEntity user) throws Exception {

        // 1. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())){
            return R.errorMsg("用户名和密码不能为空");
        }
        // 2. 判断用户名是否存在
        UsersEntity userResult = userService.queryByNameAndPwd(user.getUsername(),MD5Utils.getMD5Str(user.getPassword()));

        // 3. 保存用户，注册信息
        if (userResult!=null){
            userResult.setPassword("");
            return R.ok(userResult);
        } else {
            return R.errorMsg("用户名或密码不正确");
        }
    }
}
