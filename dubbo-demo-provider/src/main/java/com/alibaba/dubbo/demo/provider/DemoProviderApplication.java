package com.alibaba.dubbo.demo.provider;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProviderApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DemoProviderApplication.class);
		
		new CountDownLatch(1).await();;
	}

}