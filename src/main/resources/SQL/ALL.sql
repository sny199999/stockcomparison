
# K线数据每一天
CREATE TABLE `sub_kd` (
  `id` int(40) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL COMMENT '日期',
  `current_Amount` varchar(30) DEFAULT NULL COMMENT '当前价格',
  `volume` varchar(50) DEFAULT NULL COMMENT '成交量',
  `turnover` varchar(50) DEFAULT NULL COMMENT '成交金额',
  `st_id` int(6) DEFAULT NULL COMMENT 'K线每天对应的主表id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
#
CREATE TABLE `dfcf_eastmoney` (
                                  `id` int(12) NOT NULL AUTO_INCREMENT,
                                  `f2` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '最新价',
                                  `f3` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '涨跌幅',
                                  `f4` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '涨跌金额',
                                  `f5` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '成交量手',
                                  `f12` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '股票代码',
                                  `f14` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '股票名称',
                                  `date` datetime DEFAULT NULL COMMENT '第一次创建时间',
                                  `utdate` datetime DEFAULT NULL COMMENT '修改时间',
                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
CREATE TABLE `Statistical_dfday` (
  `id` int(10) NOT NULL,
  `five` double(12,2) DEFAULT NULL COMMENT '5',
  `ten` double(12,2) DEFAULT NULL COMMENT '10tian ',
  `fifteen` double(12,2) DEFAULT NULL COMMENT '15天',
  `twenty` double(12,2) DEFAULT NULL,
  `df_id` int(10) DEFAULT NULL COMMENT 'df关联id',
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `df_id` (`df_id`),
  CONSTRAINT `Statistical_dfday_ibfk_1` FOREIGN KEY (`df_id`) REFERENCES `dfcf_eastmoney` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;






