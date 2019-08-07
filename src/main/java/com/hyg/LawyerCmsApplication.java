package com.hyg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.**.mapper")
@SpringBootApplication
public class LawyerCmsApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(LawyerCmsApplication.class, args);
	}
}