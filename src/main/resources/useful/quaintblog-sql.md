##quaint 表设计

-----------
-- **quaint_user 用户个人信息表**
-----------
CREATE TABLE quaint_user (
 user_id int NOT NULL AUTO_INCREMENT COMMENT '用户ID 自增',
 user_name varchar(32) NOT NULL COMMENT '用户名',
 user_pwd varchar(32) NOT NULL COMMENT '用户密码',
 user_email varchar(64) NOT NULL COMMENT '用户EMAIL地址',
 user_image_url varchar(255) COMMENT '用户头像存储路径',
 user_nick_name varchar(255) COMMENT '用户昵称',
 user_says varchar(255) COMMENT '用户语录,个性签名',
 user_phone varchar(12) COMMENT '用户手机号码',
 user_sex tinyint(3) COMMENT '用户性别 0女 1男',
 user_qq varchar(11) COMMENT '用户QQ号码',
 user_address varchar(255) COMMENT '用户地址',
 user_last_login_ip varchar(15) NOT NULL COMMENT '用户上一次登录IP地址',
 user_birthday date COMMENT '用户生日',
 user_description varchar(255) COMMENT '自我描述',
 user_school varchar(255) COMMENT '毕业学校',
 user_register_time datetime NOT NULL COMMENT '用户注册时间',
 user_register_ip varchar(15) NOT NULL COMMENT '用户注册时IP地址',
 user_lock tinyint(3) NOT NULL COMMENT '是否锁定，0为不锁定，1为锁定',
 user_freeze tinyint(3) NOT NULL COMMENT '是否冻结，0为不冻结，1为冻结',
 PRIMARY KEY (user_id)
)

------------------
-- **quaint_user_role 用户角色(中间表)** 	
------------------
CREATE TABLE quaint_user_role (
 ur_id int not null AUTO_INCREMENT comment '用户角色中间表主键id',
 user_id int NOT NULL COMMENT '用户ID 自增',
 role_id int not null comment '角色id',
 PRIMARY KEY (ur_id)
)
------------------
-- **quaint_role 角色表**  
------------------
CREATE TABLE quaint_role (
 role_id int not null AUTO_INCREMENT comment '角色id',
 role_name varchar(36) NOT NULL COMMENT '角色名称',
 role_desc varchar(255) DEFAULT NULL COMMENT '角色描述',
 create_time datetime DEFAULT NULL COMMENT '创建时间',
 update_time datetime DEFAULT NULL COMMENT '更新时间',
 PRIMARY KEY (role_id)
)

------------------
-- **quaint_role_power 角色与权限(中间表)** 
------------------
CREATE TABLE quaint_role_power (
 rp_id int not null AUTO_INCREMENT comment '用户角色中间表主键id',
 role_id int not null comment '角色id', 
 power_id int NOT NULL COMMENT '权限ID',
 PRIMARY KEY (rp_id)
)

------------------
-- **quaint_power 功能权限表**
------------------
CREATE TABLE quaint_power (
 power_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID,权限ID',
 power_name varchar(36) NOT NULL COMMENT '权限名称',
 power_desc varchar(255) DEFAULT NULL COMMENT '权限描述',
 power_url varchar(255) DEFAULT NULL COMMENT '权限访问路径',
 PRIMARY KEY (power_id)
)

------------------
-- **quaint_mood 心情说说表**
------------------
CREATE TABLE quaint_mood (
 mood_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID,心情说说ID',
 user_id int NOT NULL COMMENT '用户ID',
 user_name varchar(27) COMMENT '用户名',
 mood_time datetime NOT NULL COMMENT '发表时间',
 mood_ip varchar(36) COMMENT '发表ip',
 mood_content varchar(7777) NOT NULL COMMENT '说说内容',
 type_id int NOT NULL default 0 COMMENT '隐私id 0公开 1好友 2私人',
 PRIMARY KEY (mood_id)
)

------------------
-- **quaint_mail_code 邮件验证码对应关系表**
------------------
CREATE TABLE quaint_mail_code (
 mc_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID,邮件验证码ID',
 email_url varchar(27) NOT NULL COMMENT '邮箱地址',
 email_code varchar(10) NOT NULL COMMENT '邮箱验证码',
 create_time datetime NOT NULL COMMENT '生成时间',
 PRIMARY KEY (mc_id)
)

--------------------
--**quaint_stay_message 用户留言表**
--------------------
CREATE TABLE quaint_stay_message (
 s_id int NOT NULL AUTO_INCREMENT COMMENT '留言表自增ID',
 stay_id int NOT NULL COMMENT '用户ID 0为留言,其他id为回复留言id',
 stay_user_id int NOT NULL COMMENT '留言者ID',
 message_content varchar(255) NOT NULL COMMENT '留言内容',
 stay_user_ip varchar(15) NOT NULL COMMENT '留言用户的IP地址',
 message_stay_time datetime NOT NULL COMMENT '留言时间',
 place varchar(64) COMMENT '地区',
 PRIMARY KEY (s_id)
)

## ----------------下面是暂时没有用到的  参考使用----------------------
## ----------------下面是暂时没有用到的  参考使用----------------------
## ----------------下面是暂时没有用到的  参考使用----------------------



##前期功能分析

**用户个人信息表q** **等级表(中间)q**	**权限表q**
个人登录 注册(人人可以注册,拥有评论权限)  头像 等级 邮箱 qq 生日 		
个性签名统计 个性签名点赞 
发表文章权限需要申请  经管理员审核通过,可以发表
背景音乐需要申请

**博客内容表q** **心情说说表q**	**短消息表(私信表)q** 
发表可以设置  私密 好友 公开 可见	(好友发送短消息)		 标签云 搜索 
置顶博客		展示图片		内容 大文本 


**博客评论表q**	**留言表q**

**关注关联表q**  **好友关联表q**

编辑个人信息,编辑文章 标签 ,关注,好友,粉丝

**博客排名表(公开表排名)c**

精选博客轮播展示

##后期处理

**博客收藏表**

**博主资源分享表**

**音乐管理表**

**博客图片管理  相册??**


-------------------
--**quaint_friend 好友表**
-------------------
CREATE TABLE quaint_friend (
 f_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id int NOT NULL COMMENT '用户ID',
 friend_id int NOT NULL COMMENT '好友ID',
 PRIMARY KEY (f_id)
)


----------------------
--**quaint_user_attention 用户关注表**
----------------------
CREATE TABLE quaint_user_attention (
 a_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 user_id int NOT NULL COMMENT '用户ID',
 attention_id int NOT NULL COMMENT '关注ID',
 PRIMARY KEY (a_id)
) 


-----------------------
--**quaint_secret_message 用户私信表**
-----------------------
CREATE TABLE quaint_secret_message (
 secret_id int NOT NULL AUTO_INCREMENT COMMENT '自增私信ID',
 send_id int NOT NULL COMMENT '发信者ID',
 receive_id int NOT NULL COMMENT '收信者ID',
 message_topic varchar(32) NOT NULL COMMENT '私信标题',
 message_content varchar(255) NOT NULL COMMENT '私信内容',
 PRIMARY KEY (secret_id)
)


----------------------
--**quaint_blog_info 博客信息表(图片后期考虑在加)**
----------------------
CREATE TABLE quaint_blog_info (
 b_id int not null AUTO_INCREMENT COMMENT '博客信息表自增ID',
 blog_id int NOT NULL  COMMENT '博客ID 自增',
 user_id int NOT NULL COMMENT '用户ID',
 blog_keyword varchar(255) COMMENT '博客关键字',
 blog_description varchar(255) NOT NULL COMMENT '博客描述,缩略显示',
 blog_title varchar(128) NOT NULL COMMENT '博客标题',
 blog_content text not null comment '博客内容',
 blog_count int not null default 0 comment '热度,访问次数',
 PRIMARY KEY (b_id)
) 


----------------------------
--**quaint_user_comment 用户评论表**
----------------------------
CREATE TABLE quaint_user_comment (
 c_id int NOT NULL AUTO_INCREMENT COMMENT '评论自增ID号',
 user_id int NOT NULL COMMENT '收到评论的用户ID',
 commit_type int not null comment '评论的模块类型  1-心情 2-博客',
 bm_id int NOT NULL COMMENT '评论blogID或者moodID,根据类型判断',
 commit_id int NOT NULL COMMENT '评论内容的ID,不是回复的话为0,回复关联自身表c_id',
 commit_content varchar(255) NOT NULL COMMENT '评论内容',
 commit_user_id int NOT NULL COMMENT '评论者ID',
 commit_time datetime NOT NULL COMMENT '评论时间',
 commit_ip varchar(15) NOT NULL COMMENT '评论时的IP地址',
 PRIMARY KEY (c_id)
) 

------------------------
--**quaint_visitor 最近访客表**
------------------------
CREATE TABLE quaint_visitor (cde
 v_id int NOT NULL AUTO_INCREMENT COMMENT '访客记录ID',
 visitor_id int NOT NULL COMMENT '访客ID',
 visitor_time datetime NOT NULL COMMENT '来访时间',
 user_id int NOT NULL COMMENT '被访用户ID',
 visitor_ip varchar(15) NOT NULL COMMENT '访客IP地址',
 PRIMARY KEY (v_id)
)

 

-------------------------
--**quaint_mood 用户心情说说表**
-------------------------
CREATE TABLE quaint_mood (
 mood_id int NOT NULL AUTO_INCREMENT COMMENT '说说记录ID',
 user_id int NOT NULL COMMENT '用户ID',
 mood_time datetime NOT NULL DEFAULT 0 COMMENT '发布时间',
 mood_ip varchar(15) NOT NULL COMMENT '说说发布时的IP地址',
 mood_content varchar(255) NOT NULL COMMENT '说说内容',
 type_id tinyint(3) NOT NULL DEFAULT 1 COMMENT '隐私ID,1-公开 2-好友 3-自己',
 PRIMARY KEY (mood_id)
)



-------------------------
--photo_sort 相片分类表
-------------------------
CREATE TABLE photo_sort (
 sort_img_id mediumint(8) NOT NULL  AUTO_INCREMENT COMMENT '相册ID',
 sort_img_name varchar(20) NOT NULL COMMENT '相册名',
 sort_img_type varchar(20) NOT NULL COMMENT '展示方式 0->仅主人可见,1->输入密码即可查看,2->仅好友能查看,3->回答问题即可查看',
 img_password varchar(32) NOT NULL COMMENT '查看密码',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 img_sort_question varchar(255) NOT NULL COMMENT '访问问题',
 img_sort_answer varchar(128) NOT NULL COMMENT '访问问题的答案',
 type_id int(3) NOT NULL DEFAULT 1 COMMENT '默认1表示相册板块',
 top_pic_src mediumint(8) NOT NULL COMMENT '封面图片的路径',
 PRIMARY KEY (sort_img_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

-------------------------
--photos 相片表
-------------------------
CREATE TABLE photos (
 photo_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '相片ID',
 photo_name varchar(255) NOT NULL COMMENT '相片名称',
 photo_src varchar(255) NOT NULL COMMENT '图片路径',
 photo_description varchar(255) NOT NULL COMMENT '图片描述',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 sort_id mediumint(8) NOT NULL COMMENT '所属相册ID',
 upload_time int(13) NOT NULL COMMENT '图片上传时间',
 upload_ip varchar(15) NOT NULL COMMENT '图片操作上传IP地址',
 PRIMARY KEY (photo_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 


---------------------------
--article_sort 文章分类表
---------------------------
CREATE TABLE article_sort (
 sort_article_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '文章自增ID',
 user_id mediumint(8) NOT NULL COMMENT '该分类所属用户',
 sort_article_name varchar(60) NOT NULL COMMENT '分类名称',
 PRIMARY KEY (sort_article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;

 

----------------------------
--article 文章表
----------------------------
CREATE TABLE article (
 article_id smallint(5) NOT NULL AUTO_INCREMENT COMMENT '日志自增ID号',
 article_name varchar(128) NOT NULL COMMENT '文章名称',
 article_time int(13) NOT NULL COMMENT '发布时间',
 article_ip varchar(15) NOT NULL COMMENT '发布IP',
 article_click int(10) NOT NULL COMMENT '查看人数',
 sort_article_id mediumint(8) NOT NULL COMMENT '所属分类',
 user_id mediumint(8) NOT NULL COMMENT '所属用户ID',
 type_id tinyint(3) NOT NULL DEFAULT 1 COMMENT '栏目ID',
 article_type int(13) NOT NULL DEFAULT 1 COMMENT '文章的模式:0为私有，1为公开，2为仅好友查看',
 article_content text NOT NULL COMMENT '文章内容',
 article_up tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否置顶:0为否，1为是',
 article_support tinyint(3) NOT NULL DEFAULT 0 COMMENT '是否博主推荐:0为否，1为是',
 PRIMARY KEY (article_id)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ;


------------------------------
--phone_message 短信记录表
------------------------------
CREATE TABLE phone_message (
 phone_id mediumint(8) NOT NULL AUTO_INCREMENT COMMENT '自增ID号',
 phone_num varchar(12) NOT NULL COMMENT '用户手机号码',
 contents varchar(255) NOT NULL COMMENT '发送内容',
 send_time int(13) NOT NULL COMMENT '发送时间',
 user_id mediumint(8) NOT NULL COMMENT '用户ID',
 PRIMARY KEY (phone_id)
)