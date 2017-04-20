package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by admin on 17/4/20.
 */
@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloServiceFallback")
    public String helloService(String name) {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/hello?name=" + name, String.class).getBody();
    }

    public String helloServiceFallback(String name) {
        return "hello "+name+" ,sorry, error!";
    }
}
