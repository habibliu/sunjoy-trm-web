/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.224.102-postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 100004
 Source Host           : 192.168.224.102:5432
 Source Catalog        : trm-db
 Source Schema         : bas

 Target Server Type    : PostgreSQL
 Target Server Version : 100004
 File Encoding         : 65001

 Date: 25/07/2018 00:44:20
*/


-- ----------------------------
-- Table structure for dictionary
-- ----------------------------
DROP TABLE IF EXISTS "bas"."dictionary";
CREATE TABLE "bas"."dictionary" (
  "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "type_code" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "type_name" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "item_code" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "item_name" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "seq" int4,
  "status" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "create_user" varchar(32) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_user" varchar(32) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "bas"."dictionary" OWNER TO "postgres";
COMMENT ON COLUMN "bas"."dictionary"."type_code" IS '数据字典分类编号';
COMMENT ON COLUMN "bas"."dictionary"."type_name" IS '数据字典分类名称';
COMMENT ON COLUMN "bas"."dictionary"."item_code" IS '项目编号';
COMMENT ON COLUMN "bas"."dictionary"."item_name" IS '项目名称';
COMMENT ON COLUMN "bas"."dictionary"."seq" IS '序号,用于排序';

-- ----------------------------
-- Indexes structure for table dictionary
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_DICTIONARY" ON "bas"."dictionary" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE UNIQUE INDEX "IDX_UNIQ_1" ON "bas"."dictionary" USING btree (
  "type_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "item_code" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table dictionary
-- ----------------------------
ALTER TABLE "bas"."dictionary" ADD CONSTRAINT "dictionary_id_key" UNIQUE ("id");

-- ----------------------------
-- Primary Key structure for table dictionary
-- ----------------------------
ALTER TABLE "bas"."dictionary" ADD CONSTRAINT "dictionary_pkey" PRIMARY KEY ("id");
