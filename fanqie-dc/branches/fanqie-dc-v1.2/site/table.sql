---客栈代销渠道月订单统计表
drop SEQUENCE  if exists tomato_crm_distribution_order_seq;
create SEQUENCE tomato_crm_distribution_order_seq start 100;
drop table if exists tomato_crm_distribution_order;
create TABLE tomato_crm_distribution_order
(
  id                     integer            not null DEFAULT nextval('tomato_crm_distribution_order_seq'::regclass),
  crm_inn_id             integer            null,
  pms_inn_id             integer            null,
  check_in_order_num     integer            null,
  check_in_order_price   DOUBLE PRECISION   null,
  check_out_order_num    integer            null,
  check_out_order_price  DOUBLE PRECISION   null,
  month_time             TIMESTAMP          null,
  created_at             timestamp          null,
  updated_at             timestamp          null,
  constraint PK_TOMATO_CRM_DISTRIBUTION_ORDER_ primary key (id)

);
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."id" IS '编号';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."crm_inn_id" IS 'crm客栈id';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."pms_inn_id" IS 'pms客栈id';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_num" IS '订单入住数';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_price" IS '订单入住总金额';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_num" IS '订单离店数';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_price" IS '订单离店总金额';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."month_time" IS '当月时间';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."created_at" IS '创建时间';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."updated_at" IS '更新时间';



--------------------------------------------------------------------------------
------------------------------CRM-V4.0-代销版------------------------------------
--------------------------------------------------------------------------------

COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_num" IS '当月入住的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_price" IS '当月入住订单的总金额';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_num" IS '当月离店的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_price" IS '当月离店的订单总金额';

alter table tomato_crm_distribution_order add COLUMN check_in_nights_num integer;
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_nights_num" IS '当月入住订单间夜数';
alter table tomato_crm_distribution_order add COLUMN check_out_nights_num integer;
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_nights_num" IS '当月离店订单间夜数';
