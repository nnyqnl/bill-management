package com.doudou.bill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.doudou.bill.orm.dao")
public class BillManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillManagementApplication.class, args);
	}
}
