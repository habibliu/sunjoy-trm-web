/*
Navicat PGSQL Data Transfer

Source Server         : 192.168.226.253-postgresql
Source Server Version : 100400
Source Host           : 192.168.226.253:5432
Source Database       : trm-db
Source Schema         : mas

Target Server Type    : PGSQL
Target Server Version : 100400
File Encoding         : 65001

Date: 2018-06-22 18:53:17
*/


-- ----------------------------
-- Table structure for mas_coach
-- ----------------------------
CREATE TABLE IF NOT EXISTS mas_coach (
id varchar(32) NOT NULL,
code varchar(16) NOT NULL comment '学员编号',
name varchar(32) NOT NULL comment '学员姓名',
sex int（1） DEFAULT 0 comment '学员性别',
height int（3）comment '身高',
phone varchar(16) comment '学员电话',
birth_date date comment '出年日期';,
address varchar(128) comment '住址',
image varchar(32) comment '头像照',
status varchar(16) NOT NULL comment '状态',
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教练档案表';


-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO mas_coach VALUES ('f3d952a7261b446e8d515f46405069d8', 'MHwmK8XnL', 'TkBtwpJ', '1', '122', 'cgWL74oW9', '2015-04-11', '7HU6Z', 'zGBDoTRAf', 'VALID', null, null, null, null);

-- ----------------------------
-- Table structure for mas_course
-- ----------------------------
CREATE TABLE IF NOT EXISTS mas_course (
id varchar(32) NOT NULL,
name varchar(32) NOT NULL comment '课程名',
grade int(2) comment '级别',
phase int(2) comment '阶段',
age_grade_start int(2) comment '年龄范围开始';,
age_grade_end int(2) comment '年龄范围结束',
number_per_term int(2) comment '每期节数',
price_per_term int(6) comment '每期单价',
memo varchar(255) comment '备注',
status varchar(16) NOT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程档案表';
-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for mas_student
-- ----------------------------
CREATE TABLE IF NOT EXISTS mas_student (
id varchar(32) NOT NULL,
code varchar(16) NOT NULL,
name varchar(32) NOT NULL,
sex int(1) DEFAULT 0 comment '学员性别',
height int(3),
phone varchar(16) comment '学员电话',
birth_date date comment '出生日期',
school varchar(32),
address varchar(128),
image varchar(32),
parent_name varchar(32),
parent_sex int（1） DEFAULT 0 comment '家长性别',
parent_phone varchar(16),
parent_wx varchar(32),
status varchar(16) NOT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员档案表';
-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO mas_student VALUES ('49b6c03b6bf3455b99011d53bfc6a08b', 'werqwerq', 'dfqafe', '1', '156', '23423423', '2010-01-06', null, 'qwerqwerqwe', null, 'werqwerq', '1', '3241234', 'erqwerq', 'VALID', null, null, null, null);
INSERT INTO mas_student VALUES ('afab4a7c4d064bdf919dc0cfcbce5ff8', '079Ld', '0dQCzBfRa', '1', '143', 'oR0EPYv', '2011-04-01', 'U5EvTgj03', 'FjTNeSKTi', 'Of8IKWGUj', 'aaRGkqyK1Y', '0', 'Ac8zsj', '0OpwUGr', 'VALID', '2018-06-20 10:21:41', 'Habib', null, null);

-- ----------------------------
-- Table structure for mas_venue
-- ----------------------------
CREATE TABLE IF NOT EXISTS  mas_venue (
id varchar(32) NOT NULL,
name varchar(32) NOT NULL comment '场地名称',
expire_date date comment '到期日期',
principal varchar(32) comment '负责人',
phone varchar(16) comment '负责人电话',
address varchar(128) comment '地址',
memo varchar(256),
status varchar(16) NOT NULL,
create_time timestamp(6),
create_user varchar(32),
update_time timestamp(6),
update_user varchar(32),
PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='场地档案表';

-- ----------------------------
-- Records of venue
-- ----------------------------

