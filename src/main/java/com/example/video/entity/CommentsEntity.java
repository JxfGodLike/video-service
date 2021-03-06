package com.example.video.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


import java.util.Date;
@Data
@TableName(value = "comment")
public class CommentsEntity {
    @TableId
    private Long id;

    @TableField(value = "father_comment_id")
    private Long fatherCommentId;

    @TableField(value = "to_user_id")
    private Long toUserId;

    /**
     * 视频id
     */
    @TableField(value = "video_id")
    private Long videoId;

    /**
     * 留言者，评论的用户id
     */
    @TableField(value = "from_user_id")
    private Long fromUserId;

    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 评论内容
     */
    private String comment;

}