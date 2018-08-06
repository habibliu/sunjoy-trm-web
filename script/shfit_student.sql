DROP TABLE IF EXISTS "biz"."shift_results";
CREATE TABLE "biz"."shift" (
"id" varchar(32) NOT NULL,
"train_date" date NOT NULL,
"train_time" varchar(16) NOT NULL,
"course_id" varchar(32) NOT NULL,
"coach_id" varchar(32) NOT NULL,
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
CREATE UNIQUE INDEX "IDX_PK_SHIFT" ON "biz"."shift" USING btree ("id");

ALTER TABLE "biz"."shift" ADD PRIMARY KEY ("id");

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
