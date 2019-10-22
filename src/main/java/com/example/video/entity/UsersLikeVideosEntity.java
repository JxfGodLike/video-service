package com.example.video.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName(value = "users_like_videos")
public class UsersLikeVideosEntity {
    @TableId
    private Long id;

    /**
     * 用户
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 视频
     */
    @TableField(value = "video_id")
    private Long videoId;

}