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
 power_name varchar(36) NOT NULL COMMENT '权限描述',
 PRIMARY KEY (power_id)
)

------------------
-- **quaint_mood 心情说说表**
------------------
CREATE TABLE quaint_mood (
 mood_id int NOT NULL AUTO_INCREMENT COMMENT '自增ID,心情说说ID',
 user_id int NOT NULL COMMENT '自增ID,心情说说ID',
 mood_time datetime NOT NULL COMMENT '发表时间',
 mood_ip varchar(36) NOT NULL COMMENT '发表ip',
 mood_content varchar(255) NOT NULL COMMENT '说说内容',
 type_id int NOT NULL default 0 COMMENT '隐私id 0公开 1好友 2私人',
 PRIMARY KEY (mood_id)
)


