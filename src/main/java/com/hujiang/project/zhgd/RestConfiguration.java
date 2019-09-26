package com.hujiang.project.zhgd;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-23 16:01
 **/
@Configuration
public class RestConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

