# quaint-blog

**个人博客项目**

**启动:**

    修改 application.yml 里面的部分内容
        1. server:
             port: 80  建议修改为不冲突的 如 8081 8082 等
        2. datasource:
           url: jdbc:mysql://127.0.0.1:3306/quaintblog
           最后改为你自己的数据库名称
           然后依次添加  quaintblog-sql.md  里面用到的表
        3. mail:
            #host: smtp.qq.com  #个人 host使用这个
            host: smtp.exmail.qq.com  #企业  host使用这个
            下面两个 是个人邮箱或者企业邮箱 账号 和 授权码(或密码)
            username: your_qq_num@qq.com
            password: your_licenseKey_or_password
    修改javaMailUtil里面的部分内容
         把发送邮箱的地址改为  你上面填写的邮箱
         
    然后启动应该就没问题了
    
    前台访问地址: localhost:80   (数字为端口号)
    后台访问地址: localhost:80/quiant/toLogin
    
    项目功能参考地址:http://quaint-aini.com
    
参考:

####杨青个人博客前端界面(版本一)

    https://www.yangqq.com/skin/871/index.html

####杨青个人博客前端界面(版本二)

    1. 后台功能参考：
    https://www.yangqq.com/jstt/web/898.html
    2. 前台页面参考：
    http://showtime.yangqq.com/

####项目记录,规划

**数据库的分析,基础表设计**

    --基本完成:
        quaint_user             用户表
        quaint_user_role
        quaint_role
        quaint_role_power
        quaint_power
        quaint_mail_code        邮箱验证码存储表
        quaint_mood             心情表
        quaint_article          文章表
        quaint_stay_message     留言表
        

**技术选型,用到那些技术**

    --基本完成:
        shiro
        javamail
    --后期扩展:
        logback
        redis

**前后台架构的基础搭建**

    --基本完成:

    --后期扩展:
		使用新版,或者改变旧版样式风格.

**简单实现后台登陆退出功能**

    --基本完成

    --后期扩展:
        单点登录
    
**心情小功能后台的基础完善 增删改查 分页**
    
    --基本完成:

    --后期扩展:
        管理员可以选择查看所有用户的心情(权限管理)

**前台心情显示**
    
    --基本完成:
        心情也包含文章了
    --后期扩展:
        前台根据用户查询心情,用户也可以管理自己的心情.
    
**用户登录 评论回复**
    
    --基本完成:
    	前台注册登录邮箱验证(企业邮箱已完成)
    	基础留言分页展示
		前台先判断是否subject中是否有用户登录
		留言前判断是否登陆
		基础留言发表
		后台留言管理
		用户头像默认为用户名的第一个字母或者汉字
		留言回复
    --后期扩展:
		个人信息修改
        可以考虑增加一个时间,判断是否有效
        覆盖验证码还没测试
        注册用户名,邮箱是否重复没有判断
        注册完之后拥有基础权限
		忘记密码,修改密码
		留言表情
		用户生日自动发邮件,节日自动或手动发邮件
    --开发中:
        上线前安全问题做好
        用户注册密码 md5加密 (密码+注册ip+注册时间+quaint) (紧急)
        后台登陆权限 控制普通用户登陆给与权限不足的提示. (半紧急,临时处理非quaint不能登陆后台)
        登陆失败7次 进行锁定30分钟 (待处理)
        连续失败10次 锁定ip 30分钟 (待处理)
**后台富文本编辑器的整合**
    
    --开发中:
    
**前台分页的处理**
    
    --基本完成:
		心情分页
		留言分页
	--开发中:
		
    
**前台博文内容展示**
    
    --开发中:
		考虑新博客，或者旧博客(这个之前可以先考虑上线)
    

    
-------------------------------------- 
   上面做完就暂时能上线了
--------------------------------------


