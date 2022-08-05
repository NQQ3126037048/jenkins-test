package com.nqq.maven.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Nie QiQiang
 * @className TestApp
 * @deprecated  测试类
 * @Date 2022/7/15 14:00
 */
@EnableAsync
@SpringBootApplication
public class TestApp {

    public static void main(String[] args) {
        SpringApplication.run(TestApp.class, args);
        System.out.println("项目启动成功······");
    }
}
