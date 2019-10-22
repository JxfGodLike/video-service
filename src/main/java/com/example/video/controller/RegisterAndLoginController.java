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
        List<UsersEntity> usersEntityList = userService.queryByUsername(user.getUsername());

        // 3. 保存用户，注册信息
        if (usersEntityList.size()==0){
            user.setNickname(user.getUsername());
            user.setPassword(MD5Utils.getMD5Str(user.getPassword()));
            user.setFansCounts(0L);
            user.setReceiveLikeCounts(0L);
            user.setFollowCounts(0L);
            userService.insert(user);
        } else {
            return R.errorMsg("用户名已经存在，请换一个再试");
        }
        return R.ok();
    }
}
