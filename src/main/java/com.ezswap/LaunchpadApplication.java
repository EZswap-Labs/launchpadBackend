package com.ezswap;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableAsync
public class LaunchpadApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(LaunchpadApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args)  {
        System.out.println("启动成功");
    }
//
//  @Bean
//  public ApplicationRunner applicationRunner() {
//    return applicationArguments -> {
//      long startTime = System.currentTimeMillis();
//      System.out.println(Thread.currentThread().getName() + "：开始调用异步业务");
//
//      long endTime = System.currentTimeMillis();
//      System.out.println(Thread.currentThread().getName() + "：调用异步业务结束，耗时：" + (endTime - startTime));
//    };
//  }
}
