ALTER TABLE `stock`
ADD COLUMN `stock_title`  varchar(255) NULL AFTER `modified_by`,
ADD COLUMN `stock_info_url`  varchar(255) NULL AFTER `stock_title`,
ADD COLUMN `stock_info_time`  varchar(255) NULL AFTER `stock_info_url`;

