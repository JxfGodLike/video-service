package com.example.video.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName(value = "bgm")
public class Bgm {
    @TableId
    private String id;

    private String author;

    private String name;

    /**
     * 播放地址
     */
    private String path;

}