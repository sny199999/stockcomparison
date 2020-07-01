package com.dyh.stockcomparison.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MyBatisConfig配置类
 * @Description TODO
 * @Date 2019/8/25 17:34
 * @Created by dyh
 */
@Configuration
@MapperScan("com.dyh.stockcomparison.mbg.mapper")
public class MyBatisConfig {
}
