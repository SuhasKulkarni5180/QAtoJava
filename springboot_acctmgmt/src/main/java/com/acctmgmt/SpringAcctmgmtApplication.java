package com.acctmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.acctmgmt")
public class SpringAcctmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAcctmgmtApplication.class, args);
	}

}
