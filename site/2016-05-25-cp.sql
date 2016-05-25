

CREATE TABLE "public"."compare_price_conf" (
"id" varchar(64) COLLATE "default" NOT NULL,
"ota_id" varchar(20) COLLATE "default",
"ota_code" varchar(20) COLLATE "default",
"percentage" int2,
"account" varchar(50) COLLATE "default",
"password" varchar(50) COLLATE "default",
"created_date" timestamp(6),
"update_date" timestamp(6),
"compare_default" bool,
"spider_day" int2
)
WITH (OIDS=FALSE);
COMMENT ON COLUMN "public"."compare_price_conf"."percentage" IS '百分比';
COMMENT ON COLUMN "public"."compare_price_conf"."compare_default" IS '是否默认 t  f';


CREATE TABLE "public"."compare_price_date" (
"id" varchar(64) COLLATE "default" NOT NULL,
"inn_id" int4,
"room_type_name" varchar(50) COLLATE "default",
"oms_room_type_id" varchar(64) COLLATE "default",
"selling_date" date,
"selling_price" numeric,
"ota_inn_id" varchar(64) COLLATE "default" DEFAULT NULL::character varying,
"ota_room_type_id" varchar(64) COLLATE "default" DEFAULT NULL::character varying,
"ota_code" varchar(10) COLLATE "default",
"inn_name" varchar(50) COLLATE "default",
"ota_selling_price" numeric,
"oat_inn_name" varchar(50) COLLATE "default",
"deleted" int2,
"created_date" timestamp(6),
"updated_date" timestamp(6),
"price_enum" varchar(50) COLLATE "default" DEFAULT NULL::character varying
)
WITH (OIDS=FALSE);


-- ----------------------------
ALTER TABLE "public"."compare_price_conf" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table compare_price_date
-- ----------------------------
CREATE INDEX "compare_price_date_inn_id_oms_room_type_id_ota_room_type_id_idx" ON "public"."compare_price_date" USING btree (inn_id, oms_room_type_id, ota_room_type_id);

-- ----------------------------
-- Primary Key structure for table compare_price_date
-- ----------------------------
ALTER TABLE "public"."compare_price_date" ADD PRIMARY KEY ("id");


INSERT INTO "public"."compare_price_conf" ("id", "ota_id", "ota_code", "percentage", "account", "password", "created_date", "update_date", "compare_default", "spider_day")
VALUES ('1', '102', 'QUNAR', '15', 'DX', 'dx43646', '2016-05-20 11:12:30', '2016-05-20 11:12:32', 't', '7');

