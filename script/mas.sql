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
-- Table structure for "mas"."coach"
-- ----------------------------
DROP TABLE "mas"."coach";
CREATE TABLE "mas"."coach" (
"id" varchar(32) NOT NULL,
"code" varchar(16) NOT NULL,
"name" varchar(32) NOT NULL,
"sex" int2 DEFAULT 0,
"height" int4,
"phone" varchar(16),
"birth_date" date,
"address" varchar(128),
"image" varchar(32),
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "mas"."coach"."sex" IS '学员性别';
COMMENT ON COLUMN "mas"."coach"."phone" IS '学员电话';
COMMENT ON COLUMN "mas"."coach"."birth_date" IS '出年日期';

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO "mas"."coach" VALUES ('f3d952a7261b446e8d515f46405069d8', 'MHwmK8XnL', 'TkBtwpJ', '1', '122', 'cgWL74oW9', '2015-04-11', '7HU6Z', 'zGBDoTRAf', 'VALID', null, null, null, null);

-- ----------------------------
-- Table structure for "mas"."course"
-- ----------------------------
DROP TABLE "mas"."course";
CREATE TABLE "mas"."course" (
"id" varchar(32) NOT NULL,
"name" varchar(32) NOT NULL,
"level" int4,
"phase" int4,
"age_grade_start" int4,
"age_grade_end" int4,
"number_per_term" int4,
"price_per_term" int4,
"memo" varchar(255),
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "mas"."course"."name" IS '课程名';
COMMENT ON COLUMN "mas"."course"."level" IS '级别';
COMMENT ON COLUMN "mas"."course"."phase" IS '阶段';
COMMENT ON COLUMN "mas"."course"."age_grade_start" IS '年龄范围开始';
COMMENT ON COLUMN "mas"."course"."age_grade_end" IS '年龄范围结束';
COMMENT ON COLUMN "mas"."course"."number_per_term" IS '每期节数';
COMMENT ON COLUMN "mas"."course"."price_per_term" IS '每期单价';
COMMENT ON COLUMN "mas"."course"."memo" IS '备注';

-- ----------------------------
-- Records of course
-- ----------------------------

-- ----------------------------
-- Table structure for "mas"."student"
-- ----------------------------
DROP TABLE "mas"."student";
CREATE TABLE "mas"."student" (
"id" varchar(32) NOT NULL,
"code" varchar(16) NOT NULL,
"name" varchar(32) NOT NULL,
"sex" int2 DEFAULT 0,
"height" int4,
"phone" varchar(16),
"birth_date" date,
"school" varchar(32),
"address" varchar(128),
"image" varchar(32),
"parent_name" varchar(32),
"parent_sex" int2 DEFAULT 0,
"parent_phone" varchar(16),
"parent_wx" varchar(32),
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "mas"."student"."sex" IS '学员性别';
COMMENT ON COLUMN "mas"."student"."phone" IS '学员电话';
COMMENT ON COLUMN "mas"."student"."birth_date" IS '出年日期';
COMMENT ON COLUMN "mas"."student"."parent_sex" IS '家长性别';

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO "mas"."student" VALUES ('49b6c03b6bf3455b99011d53bfc6a08b', 'werqwerq', 'dfqafe', '1', '156', '23423423', '2010-01-06', null, 'qwerqwerqwe', null, 'werqwerq', '1', '3241234', 'erqwerq', 'VALID', null, null, null, null);
INSERT INTO "mas"."student" VALUES ('afab4a7c4d064bdf919dc0cfcbce5ff8', '079Ld', '0dQCzBfRa', '1', '143', 'oR0EPYv', '2011-04-01', 'U5EvTgj03', 'FjTNeSKTi', 'Of8IKWGUj', 'aaRGkqyK1Y', '0', 'Ac8zsj', '0OpwUGr', 'VALID', '2018-06-20 10:21:41', 'Habib', null, null);

-- ----------------------------
-- Table structure for "mas"."venue"
-- ----------------------------
DROP TABLE "mas"."venue";
CREATE TABLE "mas"."venue" (
"id" varchar(32) NOT NULL,
"name" varchar(32) NOT NULL,
"expire_date" date,
"principal" varchar(32),
"phone" varchar(16),
"address" varchar(128),
"memo" varchar(256),
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "mas"."venue"."name" IS '场地名称';
COMMENT ON COLUMN "mas"."venue"."expire_date" IS '到期日期';
COMMENT ON COLUMN "mas"."venue"."principal" IS '负责人';
COMMENT ON COLUMN "mas"."venue"."phone" IS '负责人电话';
COMMENT ON COLUMN "mas"."venue"."address" IS '地址';

-- ----------------------------
-- Records of venue
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table coach
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_COACH" ON "mas"."coach" USING btree ("id");

-- ----------------------------
-- Uniques structure for table "mas"."coach"
-- ----------------------------
ALTER TABLE "mas"."coach" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table "mas"."coach"
-- ----------------------------
ALTER TABLE "mas"."coach" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table "mas"."course"
-- ----------------------------
ALTER TABLE "mas"."course" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table "mas"."course"
-- ----------------------------
ALTER TABLE "mas"."course" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table student
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_COURSE" ON "mas"."student" USING btree ("id");
CREATE UNIQUE INDEX "IDX_PK_STUDENT" ON "mas"."student" USING btree ("id");

-- ----------------------------
-- Uniques structure for table "mas"."student"
-- ----------------------------
ALTER TABLE "mas"."student" ADD UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table "mas"."student"
-- ----------------------------
ALTER TABLE "mas"."student" ADD PRIMARY KEY ("id");
