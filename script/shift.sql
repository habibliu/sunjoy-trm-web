/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.224.102-postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 100004
 Source Host           : 192.168.224.102:5432
 Source Catalog        : trm-db
 Source Schema         : biz

 Target Server Type    : PostgreSQL
 Target Server Version : 100004
 File Encoding         : 65001

 Date: 13/08/2018 01:33:12
*/


-- ----------------------------
-- Table structure for shift
-- ----------------------------
DROP TABLE IF EXISTS "biz"."shift";
CREATE TABLE "biz"."shift" (
  "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "train_date" date NOT NULL,
  "train_time" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "course_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "coach_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "venue_id" varchar(32) COLLATE "pg_catalog"."default",
  "normal_count" int4 default 0,
  "leave_count" int4 default 0,
  "absent_count" int4 default 0,
  "total_count" int4 default 0,
  "status" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "create_user" varchar(32) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_user" varchar(32) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "biz"."shift" OWNER TO "postgres";
COMMENT ON COLUMN "biz"."shift"."train_date" IS '训练日期';
COMMENT ON COLUMN "biz"."shift"."train_time" IS '训练时间';
COMMENT ON COLUMN "biz"."shift"."course_id" IS '课程ID';
COMMENT ON COLUMN "biz"."shift"."coach_id" IS '教练ID';
COMMENT ON COLUMN "biz"."shift"."venue_id" IS '训练场地';
COMMENT ON COLUMN "biz"."shift"."normal_count" IS '正常人数';
COMMENT ON COLUMN "biz"."shift"."leave_count" IS '请假人数';
COMMENT ON COLUMN "biz"."shift"."absent_count" IS '旷课人数';
COMMENT ON COLUMN "biz"."shift"."total_count" IS '应到人数';

-- ----------------------------
-- Indexes structure for table shift
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_SHIFT" ON "biz"."shift" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table shift
-- ----------------------------
ALTER TABLE "biz"."shift" ADD CONSTRAINT "shift_results_pkey" PRIMARY KEY ("id");
