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
    public String home(@RequestParam(name="name", defaultValue="dt") String name) {
		return demoService.sayHello(name);
    }

	@RequestMapping("/home2")
	public String home2(@RequestParam(name="wait", defaultValue="1") int seconds) { return demoService.sayHello2(seconds); }

	@RequestMapping("/home3")
	public String home3() {
		return demoService.sayHello3();
	}

	@RequestMapping("/home4")
	public String home4() {
		return demoService.sayHello4();
	}
}
