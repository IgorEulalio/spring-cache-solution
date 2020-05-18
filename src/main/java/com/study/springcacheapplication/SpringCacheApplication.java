package com.study.springcacheapplication;

import com.study.springcacheapplication.model.Customer;
import com.study.springcacheapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCacheApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringCacheApplication.class, args);
	}
}
