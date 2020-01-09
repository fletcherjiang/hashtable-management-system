package com.longyx.admin.biz;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@RestController
@MapperScan({"com.longyx.admin.biz.mapper"})
@EnableFeignClients(basePackages = "com.longyx.admin.api.feign.client")
@ComponentScan(basePackages = {"com.longyx"})
@EnableSwagger2Doc
public class CloudAdminBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAdminBizApplication.class, args);
    }

    @GetMapping("/app1")
    public Object user(Authentication authentication) {
        return authentication.getPrincipal();
    }

    @GetMapping("/app2")
    public Object user2() {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
