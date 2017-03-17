package com.alibaba.dubbo.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.demo.DemoService;

@RestController
@RequestMapping("/dubbo")
public class WebController {

	@Autowired
	private DemoService demoService;
	
    @RequestMapping("/home")
    public String home(@RequestParam(name="wait", defaultValue="1") int seconds) {
    	return demoService.sayHello(seconds);
    }
}
