package com.example.video.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author shkstart
 * @create 2019-10-24 22:24
 */
@Data
@ApiModel(value = "用户表",description = "用户对象")

public class UsersEntityVo {


    @ApiModelProperty(hidden = true)
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",name = "username",example = "imoocuser",required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",name = "password",example = "123456",required = true)
    private String password;


    private String userToken;

    /**
     * 我的头像，如果没有默认给一张
     */
    @ApiModelProperty(hidden = true)
    private String faceImage;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 我的粉丝数量
     */
    @ApiModelProperty(hidden = true)
    private Long fansCounts;

    /**
     * 我关注的人总数
     */
    @ApiModelProperty(hidden = true)
    private Long followCounts;

    /**
     * 我接受到的赞美/收藏 的数量
     */
    @ApiModelProperty(hidden = true)
    private Long receiveLikeCounts;

}
