package com.zsl.eurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : zsl
 * @date : Created in 2020/4/19 4:14 下午
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaApplication.class, args);
    }
    /*1.网关问题，鉴权
    2。服务熔断，降级
    3。刷点微服务的题目
    4。分布式事务
    */
}
