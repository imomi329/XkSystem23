package com.xk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * https://www.cnblogs.com/xifengxiaoma/p/11116330.html
 * https://github.com/shuzheng/zheng
 */
@SpringBootApplication
//@ComponentScan({"com.xk.**.dao.mapper"})
@MapperScan(basePackages = { "com.xk.**.dao.mapper" }) // 掃描該包下相應的 class ，主要是 MyBatis 持久化類
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(com.xk.BaseApplication.class, args);
    }

}
