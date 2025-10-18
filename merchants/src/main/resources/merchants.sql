CREATE TABLE `merchants` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchant name',
  `logo_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'merchant logo',
  `business_license_url` varchar(256) COLLATE utf8_bin NOT NULL COMMENT 'business license url',
  `phone` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'contact phone',
  `address` varchar(64) COLLATE utf8_bin NOT NULL COMMENT 'merchant address',
  `is_audit` BOOLEAN NOT NULL COMMENT 'whether passed the audit',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;