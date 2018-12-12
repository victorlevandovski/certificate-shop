CREATE TABLE `tbl_certificate` (
                                 `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
                                 `certificate_id_id` char(36) NOT NULL DEFAULT '',
                                 `account_id_id` char(36) NOT NULL DEFAULT '',
                                 `title` varchar(255) NOT NULL DEFAULT '',
                                 `description` varchar(255) DEFAULT NULL,
                                 `price_amount` decimal(10,2) NOT NULL,
                                 `price_currency_code` char(3) NOT NULL DEFAULT '',
                                 `electronic_delivery_available` tinyint(1) NOT NULL,
                                 `postal_delivery_available` tinyint(1) NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;