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
  check_in_nights_num    integer            null,
  check_out_nights_num   integer            null,
  month_time             TIMESTAMP          null,
  created_at             timestamp          null,
  updated_at             timestamp          null,
  constraint PK_TOMATO_CRM_DISTRIBUTION_ORDER_ primary key (id)

);
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."id" IS '编号';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."crm_inn_id" IS 'crm客栈id';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."pms_inn_id" IS 'pms客栈id';

COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_num" IS '当月入住的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_price" IS '当月入住订单的总金额';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_num" IS '当月离店的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_price" IS '当月离店的订单总金额';

COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_nights_num" IS '当月入住订单间夜数';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_nights_num" IS '当月离店订单间夜数';

COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."month_time" IS '当月时间';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."created_at" IS '创建时间';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."updated_at" IS '更新时间';



--------------------------------统计信用住的订单-----------------------------------------

---客栈代销渠道月订单统计表
drop SEQUENCE  if exists tomato_crm_xyz_order_seq;
create SEQUENCE tomato_crm_xyz_order_seq start 100;
drop table if exists tomato_crm_xyz_order;
create TABLE tomato_crm_xyz_order
(
  id                     integer            not null DEFAULT nextval('tomato_crm_xyz_order_seq'::regclass),
  crm_inn_id             integer            null,
  pms_inn_id             integer            null,
  check_in_order_num     integer            null,
  check_in_order_price   DOUBLE PRECISION   null,
  check_out_order_num    integer            null,
  check_out_order_price  DOUBLE PRECISION   null,
  check_in_nights_num    integer            null,
  check_out_nights_num   integer            null,
  month_time             TIMESTAMP          null,
  created_at             timestamp          null,
  updated_at             timestamp          null,
  constraint PK_TOMATO_CRM_DISTRIBUTION_ORDER_ primary key (id)

);
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."id" IS '编号';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."crm_inn_id" IS 'crm客栈id';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."pms_inn_id" IS 'pms客栈id';

COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_in_order_num" IS '当月入住的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_in_order_price" IS '当月入住订单的总金额';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_out_order_num" IS '当月离店的订单数量';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_out_order_price" IS '当月离店的订单总金额';

COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_in_nights_num" IS '当月入住订单间夜数';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."check_out_nights_num" IS '当月离店订单间夜数';

COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."month_time" IS '当月时间';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."created_at" IS '创建时间';
COMMENT ON COLUMN "public"."tomato_crm_xyz_order"."updated_at" IS '更新时间';
