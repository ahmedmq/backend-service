insert into items (item_no, branch_sys_no, year_sys_no, store_sys_no, item_sys_no,
                   unit_sys_no, unit_barcode_no,  item_name_a, item_name_e,
                   item_part_no, item_brand_name, item_color, item_size, item_image,
                   item_location, item_location2, maximum_quantity, minimum_quantity,
                   opening_quantity, item_quantity, item_label, date_last_purchase,
                   date_last_sold, vendor_last_purchase, last_purchase_currency_sys_no,
                   last_exchange_rate, invoice_no, freeze_printing,
                   freeze_printing_reason, freeze_item_sales, freeze_item_sales_reason,
                   free_item, free_starting_period, free_ending_period,
                   has_expiration_date, expiration_notify_days, purchase_price,
                   average_purchase_price, old_average_purchase_price,
                   opening_purchase_price, cost_price, sales_price, transportation_cost,
                   old_transportation_cost, item_profit, profit_percentage,
                   item_discount_amount, item_discount_percentage, discount_method,
                   private_sales_policy, notes, sales_price_margin, margin_type,
                   alternative_items, freeze_item_transfer, is_weighted_item, item_group,
                   vat_percentage, item_type, last_jrd_date, sales_price2, sales_price3)
values ('XYZ-001-RW',1,1,1,1234,1,'XYZ-001-RW','ITEM_NO_A','ITEM_NO_E',
        '','Brand XYZ','','',decode('013d7d16d7ad4fefb61bd95b765c8ceb', 'hex'),'Location-A','Location-B',100,20,10,0,'',now(),now(),'',0,0.0,1,false,'',false,'',
        false,current_date,current_date,false,0,90.0,0.00,0.00,0.00,0.00,110,0,0,0,2.0,0,0,0,false,'This is a dummy item',0,0,1347,false,
        false,5,8,0,current_date,105,0);

insert into items (item_no, branch_sys_no, year_sys_no, store_sys_no, item_sys_no,
                   unit_sys_no, unit_barcode_no, item_name_a, item_name_e,
                   item_part_no, item_brand_name, item_color, item_size, item_image,
                   item_location, item_location2, maximum_quantity, minimum_quantity,
                   opening_quantity, item_quantity, item_label, date_last_purchase,
                   date_last_sold, vendor_last_purchase, last_purchase_currency_sys_no,
                   last_exchange_rate, invoice_no, freeze_printing,
                   freeze_printing_reason, freeze_item_sales, freeze_item_sales_reason,
                   free_item, free_starting_period, free_ending_period,
                   has_expiration_date, expiration_notify_days, purchase_price,
                   average_purchase_price, old_average_purchase_price,
                   opening_purchase_price, cost_price, sales_price, transportation_cost,
                   old_transportation_cost, item_profit, profit_percentage,
                   item_discount_amount, item_discount_percentage, discount_method,
                   private_sales_policy, notes, sales_price_margin, margin_type,
                   alternative_items, freeze_item_transfer, is_weighted_item, item_group,
                   vat_percentage, item_type, last_jrd_date, sales_price2, sales_price3)
values ('XYZ-002-RW',1,1,1,1234,2,'XYZ-002-RW','ITEM_NO_A','ITEM_NO_E',
        '','Brand XYZ','','',decode('013d7d16d7ad4fefb61bd95b765c8ceb', 'hex'),'Location-A','Location-B',100,20,5,0,'',now(),now(),'',0,0.0,1,false,'',false,'',
        false,current_date,current_date,false,0,1100.0,0.00,0.00,0.00,0.00,1300,0,0,0,2.0,0,0,0,false,'This is a dummy item',0,0,1347,false,
        false,5,8,0,current_date,1250,0);