/*
Navicat PGSQL Data Transfer

Source Server         : 192.168.226.253-postgresql
Source Server Version : 100400
Source Host           : 192.168.226.253:5432
Source Database       : trm-db
Source Schema         : sec

Target Server Type    : PGSQL
Target Server Version : 100400
File Encoding         : 65001

Date: 2018-06-22 18:53:33
*/


-- ----------------------------
-- Table structure for "sec"."menu"
-- ----------------------------
DROP TABLE "sec"."menu";
CREATE TABLE "sec"."menu" (
"id" varchar(32) NOT NULL,
"url" varchar(64) DEFAULT NULL::character varying,
"path" varchar(64) DEFAULT NULL::character varying,
"component" varchar(64) DEFAULT NULL::character varying,
"name" varchar(64) DEFAULT NULL::character varying,
"icon_cls" varchar(64) DEFAULT NULL::character varying,
"keepalive" int2,
"require_auth" int2,
"parent_id" varchar(32) DEFAULT NULL::character varying,
"enabled" int2 DEFAULT 1,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO "sec"."menu" VALUES ('1', '/', null, null, '所有', null, null, null, null, '1', null, null, null, null);
INSERT INTO "sec"."menu" VALUES ('2', '/', '/home', 'Home', '组织管理', 'fa fa-user-circle-o', null, '1', '1', '1', null, null, null, null);
INSERT INTO "sec"."menu" VALUES ('3', '/', '/home', 'Home', '安全管理', 'fa fa-address-card-o', null, '1', '1', '1', null, null, null, null);
INSERT INTO "sec"."menu" VALUES ('4', '/', '/home', 'Home', '基础资料', 'fa fa-money', null, '1', '1', '1', null, null, null, null);
INSERT INTO "sec"."menu" VALUES ('5', '/', '/home', 'Home', '业务管理', 'fa fa-bar-chart', null, '1', '1', '1', null, null, null, null);
INSERT INTO "sec"."menu" VALUES ('6', '/', '/home', 'Home', '分析报表', 'fa fa-windows', null, '1', '1', '1', null, null, null, null);

-- ----------------------------
-- Table structure for "sec"."menu_role"
-- ----------------------------
DROP TABLE "sec"."menu_role";
CREATE TABLE "sec"."menu_role" (
"id" varchar(32) NOT NULL,
"mid" varchar(32) DEFAULT NULL::character varying,
"rid" varchar(32) DEFAULT NULL::character varying,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO "sec"."menu_role" VALUES ('0000000000000000000000000000000', '1', '0000000000000000000000000000000', null, null, null, null);

-- ----------------------------
-- Table structure for "sec"."role"
-- ----------------------------
DROP TABLE "sec"."role";
CREATE TABLE "sec"."role" (
"id" varchar(32) NOT NULL,
"name" varchar(64) DEFAULT NULL::character varying,
"name_zh" varchar(64) DEFAULT NULL::character varying,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO "sec"."role" VALUES ('0000000000000000000000000000000', 'ROLE_administrator', '系统管理员', null, null, null, null);

-- ----------------------------
-- Table structure for "sec"."user"
-- ----------------------------
DROP TABLE "sec"."user";
CREATE TABLE "sec"."user" (
"id" varchar(32) NOT NULL,
"ref_id" varchar(32) DEFAULT NULL::character varying,
"ref_name" varchar(32) DEFAULT NULL::character varying,
"telephone" varchar(20) DEFAULT NULL::character varying,
"address" varchar(64) DEFAULT NULL::character varying,
"enabled" int2 DEFAULT 1,
"username" varchar(32) DEFAULT NULL::character varying,
"password" varchar(64) DEFAULT NULL::character varying,
"remark" varchar(255) DEFAULT NULL::character varying,
"user_face" varchar(255) DEFAULT NULL::character varying,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "sec"."user"."ref_id" IS '关联人员ID';
COMMENT ON COLUMN "sec"."user"."ref_name" IS '关联人员姓名';
COMMENT ON COLUMN "sec"."user"."telephone" IS '手机号码';
COMMENT ON COLUMN "sec"."user"."address" IS '联系地址';
COMMENT ON COLUMN "sec"."user"."enabled" IS '是否启用';
COMMENT ON COLUMN "sec"."user"."username" IS '帐户名';
COMMENT ON COLUMN "sec"."user"."password" IS '帐户密码';
COMMENT ON COLUMN "sec"."user"."user_face" IS '人脸图像地址';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "sec"."user" VALUES ('0000000000000000000000000000000', null, '系统管理员', '18568887789', '深圳坂田', '1', 'admin', '$2a$10$DL.Pkc.DzwpFp49WgC71Luo4iq8oPaVnqlKr9Bq9YHIZxqt0kcyQa', null, 'http://bpic.588ku.com/element_pic/01/40/00/64573ce2edc0728.jpg', '2018-06-07 10:58:17', 'admin', null, null);

-- ----------------------------
-- Table structure for "sec"."user_role"
-- ----------------------------
DROP TABLE "sec"."user_role";
CREATE TABLE "sec"."user_role" (
"id" varchar(32) NOT NULL,
"hrid" varchar(32) NOT NULL,
"rid" varchar(32) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO "sec"."user_role" VALUES ('0000000000000000000000000000000', '0000000000000000000000000000000', '0000000000000000000000000000000', null, null, null, null);

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table "sec"."menu"
-- ----------------------------
ALTER TABLE "sec"."menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "sec"."menu_role"
-- ----------------------------
ALTER TABLE "sec"."menu_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "sec"."role"
-- ----------------------------
ALTER TABLE "sec"."role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "sec"."user"
-- ----------------------------
ALTER TABLE "sec"."user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "sec"."user_role"
-- ----------------------------
ALTER TABLE "sec"."user_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "sec"."menu"
-- ----------------------------
ALTER TABLE "sec"."menu" ADD FOREIGN KEY ("parent_id") REFERENCES "sec"."menu" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "sec"."menu_role"
-- ----------------------------
ALTER TABLE "sec"."menu_role" ADD FOREIGN KEY ("mid") REFERENCES "sec"."menu" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "sec"."menu_role" ADD FOREIGN KEY ("rid") REFERENCES "sec"."role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "sec"."user_role"
-- ----------------------------
ALTER TABLE "sec"."user_role" ADD FOREIGN KEY ("hrid") REFERENCES "sec"."user" ("id") ON DELETE CASCADE ON UPDATE NO ACTION;
ALTER TABLE "sec"."user_role" ADD FOREIGN KEY ("rid") REFERENCES "sec"."role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
