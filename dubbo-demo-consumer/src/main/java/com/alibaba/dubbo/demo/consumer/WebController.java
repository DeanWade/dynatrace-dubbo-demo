package com.alibaba.dubbo.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.demo.DemoService;

@RestController
public class WebController {

	@Autowired
	private DemoService demoService;
	
    @RequestMapping("/")
    public String home(@RequestParam(name="name", defaultValue="dubbo") String name) {
    	return this.demoService.sayHello(name);
    }
}
