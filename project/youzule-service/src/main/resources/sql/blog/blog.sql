DROP DATABASE IF EXISTS `blog`;
#数据库blog
CREATE DATABASE `blog`  
DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE blog;
#菜单表
DROP TABLE IF EXISTS menu;
CREATE TABLE menu (
	code INT(2) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '菜单编码',
	name VARCHAR(20) COMMENT '菜单名称',
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR(20) COMMENT '创建人'
);
#二级菜单表
DROP TABLE IF EXISTS sub_menu;
CREATE TABLE sub_menu (
	code INT(2) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '编号',
	name VARCHAR(20) COMMENT '名称',
	menu_code INT(2) COMMENT '上级菜单',
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR(20) COMMENT '创建人'
);
#专题表
DROP TABLE IF EXISTS subject;
CREATE TABLE subject (
	code INT(2) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '编号',
	name VARCHAR(20) COMMENT '名称',
	sub_menu_code INT(2) COMMENT '二级菜单编号',
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR(20) COMMENT '创建人'
);
#关键字表
DROP TABLE IF EXISTS key_word;
CREATE TABLE key_word (
	code INT(5) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '编号',
	name VARCHAR(20) COMMENT '名称',
	subject_code INT(2) COMMENT '所属专题编号',
	create_time DATETIME COMMENT '创建时间',
	create_user VARCHAR (20) COMMENT '创建人'
);
#文档表
DROP TABLE IF EXISTS document;
CREATE TABLE document (
	code INT(8) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '文档编码',
	title VARCHAR(32) COMMENT '文档标题',
	author VARCHAR(20) COMMENT '作者',
	type VARCHAR(10) COMMENT '文档类型:原创、转载',
	create_time DATETIME COMMENT '文档创建时间',
	create_user VARCHAR (20) COMMENT '创建人',
	subject_code INT(2) COMMENT '文档所属主题编号',
	content_markdown MEDIUMTEXT COMMENT '文档内容，markdown格式',
	content_html MEDIUMTEXT COMMENT '文档内容，html格式',
	content MEDIUMTEXT COMMENT '文档内容,纯内容文本格式',
	views INT(11) COMMENT '浏览次数'
);
#文档评论表
DROP TABLE IF EXISTS comment;
CREATE TABLE comment (
	code INT(8) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '评论编码',
	document_code INT(8) COMMENT '所属文档',
	name VARCHAR(32) COMMENT '评论人姓名',
	email VARCHAR(32) COMMENT '评论人邮箱',
	ip VARCHAR(16) COMMENT '评论人ip',
	content MEDIUMTEXT COMMENT '评论内容',
	create_time DATETIME COMMENT '时间'
);
#subject增加字段 document_count
ALTER TABLE `subject` ADD COLUMN document_count INT(11) DEFAULT 0;

#创建mq消息表
DROP TABLE IF EXISTS mq_message;
CREATE TABLE mq_message (
	code INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '编号',
	id VARCHAR(36) UNIQUE COMMENT 'id',
	queue_name VARCHAR(20) COMMENT '队列名字',
	body TEXT COMMENT '内容',
	time DATETIME COMMENT '时间'
) COMMENT 'mq消息表';
#请求表
DROP TABLE IF EXISTS request;
CREATE TABLE request (
	code INT(11) PRIMARY KEY AUTO_INCREMENT UNIQUE COMMENT '编号',
	id VARCHAR(36) UNIQUE COMMENT 'id',
	servlet_path VARCHAR(64) COMMENT '请求接口',
	request_time DATETIME COMMENT '请求时间',
	ip VARCHAR(16) COMMENT 'ip地址',
	country VARCHAR(32) COMMENT '国家',
	area VARCHAR(16) COMMENT '地区',
	region VARCHAR(16) COMMENT '',
	city VARCHAR(16) COMMENT '城市',
	county VARCHAR(10) COMMENT '',
	isp VARCHAR(10) COMMENT '运营商',
	country_id VARCHAR(10) COMMENT '国家id',
	area_id VARCHAR(10) COMMENT '省id',
	region_id VARCHAR(10) COMMENT '地区id',
	city_id VARCHAR(10) COMMENT '城市id',
	county_id VARCHAR(10) COMMENT '',
	isp_id VARCHAR(10) COMMENT '运营商id',
	response_time DATETIME COMMENT '响应时间',
	elapsed_time VARCHAR(16) COMMENT '耗时'
)COMMENT '请求信息表';

#创建uuid32位函数
/*DELIMITER //
CREATE FUNCTION uuid32()
returns VARCHAR(32)
BEGIN 
	declare uuid varchar(32);
	SELECT replace((SELECT uuid()),'-','') into uuid; 
RETURN uuid;
END//
DELIMITER ;*/