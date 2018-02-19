package com.alibaba.dubbo.demo.provider;

import java.util.concurrent.CountDownLatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(ProviderApplication.class);
		new CountDownLatch(1).await();
	}

}