package com.example.client;

import org.springframework.stereotype.Component;

/**
 * Created by admin on 17/4/20.
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    @Override
    public String hello(String name) {
        return "hello " + name + " ,sorry, error!";
    }
}
