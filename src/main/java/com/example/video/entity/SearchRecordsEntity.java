package com.example.video.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@Data
@TableName(value = "search_records")
public class SearchRecordsEntity {
    @TableId
    private Long id;

    /**
     * 搜索的内容
     */
    private String content;

}