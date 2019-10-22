package com.example.video.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName(value = "users_fans")
public class UsersFans {
    @TableId
    private String id;

    /**
     * 用户
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 粉丝
     */
    @TableField(value = "fan_id")
    private String fanId;

}