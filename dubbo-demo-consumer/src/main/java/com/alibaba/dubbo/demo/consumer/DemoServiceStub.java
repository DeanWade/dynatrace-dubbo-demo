package com.alibaba.dubbo.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.DemoService;

@Service("demoServiceStub")
public class DemoServiceStub implements DemoService{

	@Autowired
	@Qualifier("demoService")
	private DemoService remote;
	 
	@Override
	public String sayHello(String name) {
		return remote.sayHello(name);
	}

	@Override
	public String sayHello2(int seconds) { return remote.sayHello2(seconds); }

	@Override
	public String sayHello3() { return remote.sayHello3(); }

}
