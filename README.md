#仿抖音小程序后台
##开发环境
        MacOS
        maven
        springmvc
        springboot
        mybatis-plus
        mybatis-pagehelper
        redis
        ffmpeg
        druid
        mariadb/mysql
        zookeeper音频操作
##项目启动说明：
        1.开启mysql,redis服务
        2.利用ngrok内网穿透将域名暴露供小程序客户端使用
            @终端输入./ngrok -config=ngrok.conf -subdomain xxx port
            @xxx表示域名前缀,80表示端口号,必须和SpringBoot启动端口号保持一致
            @具体参考http://ngrok.ciqiuwl.cn
        3.启动SpringBoot应用
        4.开启微信小程序客户端就可以愉快的玩耍了