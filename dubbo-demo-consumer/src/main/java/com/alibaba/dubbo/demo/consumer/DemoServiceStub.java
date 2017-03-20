package com.alibaba.dubbo.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.DemoService;

@Service("demoServiceStub")
public class DemoServiceStub implements DemoService{

	@Autowired
	@Qualifier("demoService")
	private DemoService stub;
	 
	@Override
	public String sayHello(String name) {
		return stub.sayHello(name);
	}

	@Override
	public String sayHello(int seconds) {
		String result = stub.sayHello(seconds);
		return result;
	}

}
