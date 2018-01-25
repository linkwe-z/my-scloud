package com.linkwe.service;/**
 * Created by Administrator on 2018/1/17.
 */

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther lwz
 * @date 2018/1/17
 * desc: SchedualServiceHiHystric需要实现SchedualServiceHi 接口，并注入到Ioc容器中
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi{

    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry "+name;
    }
}
