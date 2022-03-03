package com.atguigu.srb.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.atguigu.srb","com.atguigu.common"})
@Slf4j
public class ServiceCoreApplication {

    public static void main(String[] args) {


        try{
            log.info("core核心程序启动....");
            SpringApplication.run(ServiceCoreApplication.class,args);
            log.info("core核心程序启动成功");
        }catch (Exception e){
            log.info("core核心程序启动失败");
            e.printStackTrace();
        }
    }
}
