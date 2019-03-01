##Quaint 自我提升
-------------------------------------------------

搜索目录:

	**编译器IDE**
	
	1. eclipse
	2. idea
	3. VSCode
	
	**API文档**
	
	1. swagger 	
	
	**项目管理工具**
	
	1. maven
	2. git
	
	**前端JS框架**
	
	1. angularJs
	2. vue/iView/element
	3. editor.md
	
	**后端Java框架**
	
	1. springboot
	2. mybatis
	
	**数据库SQL**
	
	1. sqlserver/ddl
	2. redis
	
	**安全框架**

	1. shiro

	**前后端分离**
	
	1. Jenkins 
 
		

-------------------------------------------------

##---------------------Git----------------------------
**/git**
1. 简介

2. 常用功能
    
    git clone url                   从远程仓库克隆项目
    
    git pull                        从远程仓库更新代码
    
    git add .                       将所有代码提交到本地
    
    git commit -m "第一次提交"        提交本地代码的说明
    
    git push                        提交代码到远程服务器,只提交本地commit过的代码
    
    

##---------------------Shiro----------------------------
**/shiro**

1. 简介

	Apache Shiro是一个强大且易用的Java安全框架,执行身份验证、授权、密码和会话管理。使用Shiro的易于理解的API,您可以快速、轻松地获得任何应用程序,从最小的移动应用程序到最大的网络和企业应用程序。 

##---------------------Mybatis----------------------------
**/mybatis**



##---------------------Editor.md----------------------------
**/editor.md**

1. 简介

	MdEditor扩展了Markdown的功能（如表格、脚注、内嵌HTML等等），以使让Markdown转换成更多的格式，和更丰富的展示效果，这些功能原初的Markdown尚不具备。		
	MdEditor源于Pandao的JavaScript开源项目，开源地址Editor.md，并在MIT开源协议的许可范围内进行了优化，以适应广大用户群体的需求。向优秀的markdown开源编辑器原作者Pandao致敬。

2. 开源地址

	https://github.com/pandao/editor.md


##---------------------SpringBoot----------------------------
**/springboot**

1. 简介

	spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。通过这种方式，Spring Boot致力于在蓬勃发展的快速应用开发领域(rapid application development)成为领导者。

##---------------------SqlServer----------------------------
**/sqlserver**
	
	**/sqlserver/ddl**

	1. 创建表
	
		CREATE TABLE temp_name(
			username nvarchar(510),
			idCard nvarchar(510),
			examCardID nvarchar(510),
			totalNum int ,
			openTime int,
			kkk int
		)

	2. 修改表字段属性
	
		ALTER TABLE **tablename** alter column **columnname** int

	3. 添加一个字段
	
		ALTER TABLE table_name ADD colum_name tinyint not null default 1 ;
					   名字			  列名		类型		不为空	默认值


##---------------------Swagger----------------------------
**/swagger**
	
1. 简介

	Swagger 是一个规范和完整的框架,用于生成、描述、调用和可视化 RESTful 风格的 Web 服务。总体目标是使客户端和文件系统作为服务器以同样的速度来更新。文件的方法,参数和模型紧密集成到服务器端的代码,允许API来始终保持同步。Swagger 让部署管理和使用功能强大的API从未如此简单。

2. 

##---------------------AngularJS----------------------------
**/angularJS**	

##---------------------Vue----------------------------
**/vue**

1. 简介

	是一套构建用户界面的 渐进式框架。与其他重量级框架不同的是，Vue 采用自底向上增量开发的设计。Vue 的核心库只关注视图层，并且非常容易学习，非常容易与其它库或已有项目整合。另一方面，Vue 完全有能力驱动采用单文件组件和 Vue 生态系统支持的库开发的复杂单页应用。	

2. 安装教程
	
	--先安装notejs
	
	--然后通过npm安装vue

	大家都知道国内直接使用 npm 的官方镜像是非常慢的，这里推荐使用淘宝 NPM 镜像。
	淘宝 NPM 镜像是一个完整 npmjs.org 镜像，你可以用此代替官方版本(只读)，同步频率目前为 10分钟 一次以保证尽量与官方服务同步。
	你可以使用淘宝定制的 cnpm (gzip 压缩支持) 命令行工具代替默认的 npm:

	--淘宝镜像

	$ npm install -g cnpm --registry=https://registry.npm.taobao.org

	--这样就可以使用 cnpm 命令来安装模块了：

	$ cnpm install [name]

	--安装vue  带-g
	
	$ cnpm install vue -g

	--全局安装 vue-cli

	$ cnpm install --global vue-cli

    --快速删除 node_modules
        cnpm install rimraf -g   命令行语句，速度会更快
        rimraf node_modules

	--**创建一个基于 webpack 模板的新项目**

	$ vue init webpack my-project
		(这里需要进行一些配置，默认回车即可,最后一个npm可以选择no,其他默认yes)

	--**进入项目，安装并运行： (最后出现的地址为项目访问地址)**
	
	$ cd my-project
	$ cnpm install
	$ cnpm run dev
	 DONE  Compiled successfully in 4388ms
	
	> Listening at http://localhost:8080

3. 开始使用vue

	--VSCode配置启动Vue项目
	Ctrl + Shit + X打开插件扩展窗口进行插件扩展
	1. vetur插件的安装
	
		该插件是vue文件基本语法的高亮插件，在插件窗口中输入vetur点击安装插件就行，装好后点击文件->首选项->设置 打开设置界面，(点击右上角的 "{}" ) 然后在设置界面右侧添加配置 覆盖默认配置(写在{}内部)
		
		"emmet.syntaxProfiles": {
		  "vue-html": "html",
		  "vue": "html"
		}

	2. eslint插件的安装

		eslint智能错误检测插件，在具体开发中作用很大，能够及时的帮我们发现错误。至于安装，同样打开插件扩展窗口输入eslint点击安装插件，装好后也需要进行配置，在同vetur插件一样的地方进行配置

		"eslint.validate": [			--这里有问题的话  就先暂时别配置了
		        "javascript",
		        "javascriptreact",
		        "html",
		        "vue"
		    ],
		 
		 "eslint.options": {
		        "plugins": ["html"]
		}
	
	3. 创建一个文件夹,打开终端,按照上面创建项目的步骤创建

		$ vue init webpack my-project
		(这里需要进行一些配置，默认回车即可,最后一个npm可以选择no,其他默认yes)
		
		$ cd my-project
		$ cnpm install
		$ cnpm run dev
		 DONE  Compiled successfully in 4388ms
		
		> Listening at http://localhost:8080
	
	
	**/iView**
		
		1. 简介

			iView 是一套基于 Vue.js 的开源 UI 组件库，主要服务于 PC 界面的中后台产品。

	**/element**

		1. 简介

			Element，一套为开发者、设计师和产品经理准备的基于 Vue 2.0 的桌面端组件库

##---------------------Maven----------------------------
**/maven**

1. setting配置

	1. maven仓库地址:
	<localRepository>d:/.m2/repository</localRepository>
	2. 阿里maven私服:
	<mirror>
      <id>AliMaven</id>  
      <name>aliyun maven</name>
      <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
      <mirrorOf>central</mirrorOf>        
	 </mirror>
	3. jdk默认版本(在<profiles>节点内配置):
	<profile>
    <id>jdk-1.8</id>
    <activation>
        <activeByDefault>true</activeByDefault>
        <jdk>1.8</jdk>
    </activation>
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>
    </properties>
	</profile>	
	4. Eclipse -->windows -->properties -->maven -->UserSetting --> (填写maven setting文件的路径)
	5. 创建项目: 对应含义
	Group_Id     .   Artifact_Id
	com.quaint   .    project
##---------------------Eclipse----------------------------
**/eclipse**

1. 快捷键

	ctrl+L 			-------搜索指定行

	ctrl+H			-------search搜索文件内内容 

	ctrl+shif+R		-------搜索对应文件

	ctrl+E			-------所有已经打开的文件

##---------------------Idea----------------------------
**/idea**

1. 快捷键
	
	alt+shift+R		-------文件重命名

##---------------------VSCode----------------------------
**/vscode**

1. 快捷键

	ctrl+shift+X		-------安装插件
	ctrl+shift+Y		-------打开控制台
	alt+shift+A	 or ctrl+/	or ctrl+k 然后+c		-------多行注释
	
				
##---------------------Redis----------------------------
**/redis**

1. 	启动
	
	cmd先找到redis目录
	然后执行
	redis-server.exe redis.windows.conf