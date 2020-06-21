package com.zsl.address;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : zsl
 * @date : Created in 2020/4/20 9:29 上午
 */
@EnableEurekaClient
@EnableTransactionManagement
@EnableCaching //开启缓存注解
@EnableSwagger2
@MapperScan("com.zsl.address.mapper")//参考博文 http://www.mybatis.org/mybatis-3/zh/index.html
@SpringBootApplication(scanBasePackages = "com.zsl.address")
@ServletComponentScan(basePackages = "com.zsl.address.filter") //扫描自定义的过滤器
public class AddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressApplication.class, args);
    }
}
