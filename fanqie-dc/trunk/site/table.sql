--------------------------------------------------------------------------------
------------------------------CRM-V4.0-������------------------------------------
--------------------------------------------------------------------------------
------------����ͳ��---------------------------

---��ջ���������¶���ͳ�Ʊ�
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
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."id" IS '���';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."crm_inn_id" IS 'crm��ջid';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."pms_inn_id" IS 'pms��ջid';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_num" IS '������ס��';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_in_order_price" IS '������ס�ܽ��';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_num" IS '���������';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."check_out_order_price" IS '��������ܽ��';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."month_time" IS '����ʱ��';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."created_at" IS '����ʱ��';
COMMENT ON COLUMN "public"."tomato_crm_distribution_order"."updated_at" IS '����ʱ��';
