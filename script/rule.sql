-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS "biz"."present_rule";
CREATE TABLE "biz"."rule" (
  "id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "course_id" varchar(32) COLLATE "pg_catalog"."default" NOT NULL,
  "subscribe_periods" int4,
  "free_sections" int4,
  "memo" varchar(255) COLLATE "pg_catalog"."default",
  "status" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "create_time" timestamp(6),
  "create_user" varchar(32) COLLATE "pg_catalog"."default",
  "update_time" timestamp(6),
  "update_user" varchar(32) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "biz"."rule"."course_id" IS '课程ID';
COMMENT ON COLUMN "biz"."rule"."subscribe_periods" IS '报名期数';
COMMENT ON COLUMN "biz"."rule"."free_sections" IS '赠送节数';
COMMENT ON COLUMN "biz"."rule"."memo" IS '备注';
COMMENT ON COLUMN "biz"."rule"."status" IS '状态';

-- ----------------------------
-- Indexes structure for table present_rule
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_RULE" ON "biz"."rule" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table present_rule
-- ----------------------------
ALTER TABLE "biz"."rule" ADD CONSTRAINT "rule_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Keys structure for table present_rule
-- ----------------------------
ALTER TABLE "biz"."rule" ADD CONSTRAINT "FK_TO_COURSE" FOREIGN KEY ("course_id") REFERENCES "mas"."course" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
