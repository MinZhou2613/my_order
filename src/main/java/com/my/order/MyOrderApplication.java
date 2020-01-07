package com.my.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.order.mapper")
public class MyOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOrderApplication.class, args);
	}

}
