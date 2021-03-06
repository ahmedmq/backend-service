create table if not exists items
(
    item_no                      varchar(20),
    branch_sys_no                integer,
    year_sys_no                  integer default -1,
    store_sys_no                 integer,
    item_sys_no                  integer,
    unit_sys_no                  integer,
    unit_barcode_no              varchar(20),
    item_name_a                  varchar(45),
    item_name_e                  varchar(45),
    item_part_no                 varchar(20),
    item_brand_name              varchar(20),
    item_color                   varchar(10),
    item_size                    varchar(10),
    item_image                   bytea,
    item_location                varchar(10),
    item_location2               varchar(10),
    maximum_quantity             decimal(5, 2),
    minimum_quantity             decimal(5, 2),
    opening_quantity             decimal(5, 2),
    item_quantity                decimal(5, 2),
    item_label                   varchar(10),
    date_last_purchase           date,
    date_last_sold               date,
    vendor_last_purchase         varchar(15),
    last_purchase_currency_sys_no integer,
    last_exchange_rate           decimal(5, 2),
    invoice_no                   integer,
    freeze_printing              boolean,
    freeze_printing_reason       varchar(50),
    freeze_item_sales            boolean,
    freeze_item_sales_reason     varchar(50),
    free_item                    boolean,
    free_starting_period         date,
    free_ending_period           date,
    has_expiration_date          boolean,
    expiration_notify_days       integer,
    purchase_price               numeric,
    average_purchase_price       numeric,
    old_average_purchase_price   numeric,
    opening_purchase_price       numeric,
    cost_price                   numeric,
    sales_price                  numeric,
    transportation_cost          numeric,
    old_transportation_cost      numeric,
    item_profit                  numeric,
    profit_percentage            decimal(5, 2),
    item_discount_amount         numeric,
    item_discount_percentage     decimal(5, 2),
    discount_method              smallint,
    private_sales_policy         boolean,
    notes                        varchar(200),
    sales_price_margin           numeric,
    margin_type                  integer,
    alternative_items            varchar(1024),
    freeze_item_transfer         boolean,
    is_weighted_item             boolean,
    item_group                   integer,
    vat_percentage               decimal(5, 2),
    item_type                    smallint,
    last_jrd_date                date,
    sales_price2                 numeric,
    sales_price3                 numeric,
    constraint item_id_pkey primary key (item_no)
);

create sequence if not exists hibernate_sequence start with 1 increment by 1;
