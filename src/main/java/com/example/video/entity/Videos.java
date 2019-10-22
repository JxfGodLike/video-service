package com.example.video.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;


import java.util.Date;
@TableName(value = "videos")
public class Videos {
    @TableId
    private String id;

    /**
     * 发布者id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 用户使用音频的信息
     */
    @TableField(value = "audio_id")
    private String audioId;

    /**
     * 视频描述
     */
    @TableField(value = "video_desc")
    private String videoDesc;

    /**
     * 视频存放的路径
     */
    @TableField(value = "video_path")
    private String videoPath;

    /**
     * 视频秒数
     */
    @TableField(value = "video_seconds")
    private Float videoSeconds;

    /**
     * 视频宽度
     */
    @TableField(value = "video_width")
    private Integer videoWidth;

    /**
     * 视频高度
     */
    @TableField(value = "video_height")
    private Integer videoHeight;

    /**
     * 视频封面图
     */
    @TableField(value = "cover_path")
    private String coverPath;

    /**
     * 喜欢/赞美的数量
     */
    @TableField(value = "like_counts")
    private Long likeCounts;

    /**
     * 视频状态：
    1、发布成功
    2、禁止播放，管理员操作
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

}