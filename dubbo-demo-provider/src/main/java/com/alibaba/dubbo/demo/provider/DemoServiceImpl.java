package com.alibaba.dubbo.demo.provider;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
    	return doSayHello(name);
    }
    
	private String doSayHello(String name){
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress() + " @ " + new Date().toString();
	}
}