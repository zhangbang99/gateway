package com.cloud.gateway.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "service-user")
public interface UserService {

    @RequestMapping(value = "", method = RequestMethod.GET)
    String test();
}
