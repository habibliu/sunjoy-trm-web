CREATE TABLE "biz"."registion" (
"id" varchar(32) NOT NULL,
"regist_date" date NOT NULL,
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
COMMENT ON COLUMN "biz"."registion"."regist_date" IS '登记日期';
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