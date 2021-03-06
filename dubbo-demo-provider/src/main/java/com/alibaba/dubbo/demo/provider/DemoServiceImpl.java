package com.alibaba.dubbo.demo.provider;

import java.util.Date;
import java.util.Random;

import com.alibaba.dubbo.demo.AbstractDemoService;
import com.alibaba.dubbo.demo.BaseException;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.DemoException;
import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;

@Service("demoService")
public class DemoServiceImpl extends AbstractDemoService {

	@Override
    public String sayHello(String name) {
        try {
			Thread.sleep(10*60*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "Hello '" + name + "' form provider: " + RpcContext.getContext().getLocalAddress() + " @ " + new Date().toString();
    }

	@Override
	public String sayHello2(int seconds) {
		synchronized(this){
			if(seconds >= 5 && seconds <= 10){
				throw new DemoException("the sleep time is too long for " + seconds + " seconds");
			}
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "Wait " + seconds + " seconds for response from provider: " + RpcContext.getContext().getLocalAddress() + " @ " + new Date().toString();
		}

	}

	@Override
	public String sayHello3() {
		try {
			int i = new Random().nextInt(2) * 1000;
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new BaseException("the sleep time is too long, more than 10 seconds");
	}

	@Override
	public String sayHello4() {
		try {
			int i = new Random().nextInt(2) * 1000;
			Thread.sleep(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new DemoException("current timestamp:" + System.currentTimeMillis());
	}
}