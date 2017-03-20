package com.alibaba.dubbo.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.demo.DemoService;

@RestController
@RequestMapping("/dubbo")
public class WebController {

	@Autowired
	@Qualifier("demoServiceStub")
	private DemoService demoService;
	
    @RequestMapping("/home")
    public String home(@RequestParam(name="wait", defaultValue="1") int seconds) {
    	String result = demoService.sayHello(seconds);
    	return result;
    }
    
    @RequestMapping("/home2")
    public String home2(@RequestParam(name="name", defaultValue="dt") String name) {
//    	name = UUID.randomUUID().toString();
    	String result = demoService.sayHello(name);
    	return result;
    }
}
