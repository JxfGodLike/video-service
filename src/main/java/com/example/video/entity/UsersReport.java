package com.example.video.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


import java.util.Date;

@TableName(value = "users_report")
public class UsersReport {
    @TableId
    private String id;

    /**
     * 被举报用户id
     */
    @TableField(value = "deal_user_id")
    private String dealUserId;

    @TableField(value = "deal_video_id")
    private String dealVideoId;

    /**
     * 类型标题，让用户选择，详情见 枚举
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 举报人的id
     */
    private String userId;

    /**
     * 举报时间
     */
    @TableField(value = "create_date")
    private Date createDate;

}