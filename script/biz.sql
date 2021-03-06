CREATE TABLE "biz"."registion" (
"id" varchar(32) NOT NULL,
"register_date" date NOT NULL,
"course_id" varchar(32) NOT NULL,
"student_id" varchar(32) NOT NULL,
"periods" int4,
"total_sections" int4,
"attach_sections"	int4,
"total_fee" int4,
"payoff" int4,
"payment_mode"	varchar(16),
"payment_date"	date,
"memo"	varchar(256),
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "biz"."registion"."register_date" IS '登记日期';
COMMENT ON COLUMN "biz"."registion"."course_id" IS '课程ID';
COMMENT ON COLUMN "biz"."registion"."student_id" IS '学员ID';
COMMENT ON COLUMN "biz"."registion"."periods" IS '报读期数';
COMMENT ON COLUMN "biz"."registion"."total_sections" IS '总节数';
COMMENT ON COLUMN "biz"."registion"."attach_sections" IS '赠送节数';
COMMENT ON COLUMN "biz"."registion"."total_fee" IS '总费用';
COMMENT ON COLUMN "biz"."registion"."payoff" IS '是否已支付';
COMMENT ON COLUMN "biz"."registion"."payment_mode" IS '支付方式:CASH,WX,ZHB,EPAY';
COMMENT ON COLUMN "biz"."registion"."payment_date" IS '支付日期';
COMMENT ON COLUMN "biz"."registion"."memo" IS '备注';

CREATE UNIQUE INDEX "IDX_PK_REGISTION" ON "biz"."registion" USING btree ("id");

ALTER TABLE "biz"."registion" ADD PRIMARY KEY ("id");

DROP TABLE IF EXISTS "biz"."shift";
CREATE TABLE "biz"."shift" (
"id" varchar(32) NOT NULL,
"train_date" date NOT NULL,
"train_time" varchar(16) NOT NULL,
"course_id" varchar(32) NOT NULL,
"coach_id" varchar(32) NOT NULL,
"venue_id" varchar(32) NOT NULL,
"student_count" int4,
"status" varchar(16) NOT NULL,
"create_time" timestamp(6),
"create_user" varchar(32),
"update_time" timestamp(6),
"update_user" varchar(32)
)
WITH (OIDS=FALSE)

;
COMMENT ON COLUMN "biz"."shift"."train_date" IS '训练日期';
COMMENT ON COLUMN "biz"."shift"."course_id" IS '课程ID';
COMMENT ON COLUMN "biz"."shift"."train_time" IS '训练时间';
COMMENT ON COLUMN "biz"."shift"."coach_id" IS '教练ID';
COMMENT ON COLUMN "biz"."shift"."venue_id" IS '场地ID';
COMMENT ON COLUMN "biz"."shift"."student_count" IS '学员数量';

CREATE UNIQUE INDEX "IDX_PK_SHIFT" ON "biz"."shift" USING btree ("id");

ALTER TABLE "biz"."shift" ADD PRIMARY KEY ("id");


-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS "biz"."rule";
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

-- ----------------------------
-- Table structure for rule
-- ----------------------------
DROP TABLE IF EXISTS "biz"."shift_student";
CREATE TABLE "biz"."shift_student" (
  "id" varchar(32)  NOT NULL,
  "student_id" varchar(32)  NOT NULL,
  "shift_id" varchar(32)  NOT NULL,
  "checking_in" varchar(16)
)
;
COMMENT ON COLUMN "biz"."shift_student"."student_id" IS '学员ID';
COMMENT ON COLUMN "biz"."shift_student"."shift_id" IS '排班ID';
COMMENT ON COLUMN "biz"."shift_student"."checking_in" IS '考勤';

-- ----------------------------
-- Indexes structure for table present_rule
-- ----------------------------
CREATE UNIQUE INDEX "IDX_PK_SHIFT_STUDENT" ON "biz"."shift_student" USING btree (
  "id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table shift_student
-- ----------------------------
ALTER TABLE "biz"."shift_student" ADD CONSTRAINT "shift_student_pkey" PRIMARY KEY ("id");
-- ----------------------------
-- Foreign Keys structure for table shift_student
-- ----------------------------
ALTER TABLE "biz"."shift_student" ADD CONSTRAINT "FK_TO_STUDENT" FOREIGN KEY ("student_id") REFERENCES "mas"."student" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table shift_student
-- ----------------------------
ALTER TABLE "biz"."shift_student" ADD CONSTRAINT "FK_TO_SHIFT" FOREIGN KEY ("shift_id") REFERENCES "biz"."shift" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

