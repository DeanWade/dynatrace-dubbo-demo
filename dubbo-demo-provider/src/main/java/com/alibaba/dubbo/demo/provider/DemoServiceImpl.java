package com.alibaba.dubbo.demo.provider;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.DemoException;
import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Override
    public String sayHello(String name) {
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "Hello " + name + ", responded form provider: " + RpcContext.getContext().getLocalAddress() + " @ " + new Date().toString();
    }

	@Override
	public synchronized String sayHello(int seconds) {
		if(seconds > 10){
			throw new DemoException("the sleep time is too long, more than 10 seconds");
		}
        try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "Wait " + seconds + " seconds to response by provider: " + RpcContext.getContext().getLocalAddress() + " @ " + new Date().toString();
	}
}