package com.linkwe.controller;

import com.linkwe.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by lwz on 2018/1/24.
 * desc:
 */
@RestController
public class ComputeController {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/show", method = {RequestMethod.POST})
    public UserDTO show(@RequestParam("id") Long id){
        ServiceInstance instance = client.getLocalServiceInstance();
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setName("scott");
        dto.setBirthday(new Date());
        return dto;
    }
}
