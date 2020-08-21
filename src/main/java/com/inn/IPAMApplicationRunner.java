package com.inn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;
import com.inn.core.generic.exceptions.RestExceptionHandler;
import com.inn.product.namemanagement.rest.ICustomNumberSubPartMetaDataRest;
import com.inn.product.um.user.rest.UserRest;


@EnableFeignClients
@SpringBootApplication
@RestController
@RequestMapping(path = "app")
public class IPAMApplicationRunner implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(IPAMApplicationRunner.class);
	}

	@Autowired(required = false)
	ICustomNumberSubPartMetaDataRest sub;
	
	@Autowired(required = false)
	UserRest userRest;
	
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Spring Boot Application Started");
		
	}
	
	@GetMapping(value = "namingTest")
	public String namingTest() {
		
		return new GsonBuilder().setPrettyPrinting().create().toJson(sub.findSubpartByRuleName("p"));
	}
	
	
	@GetMapping(value = "umTest")
	public String umTest() {
		
		 return new GsonBuilder().setPrettyPrinting().create().toJson(userRest.findByUserName("nitin.pal"));
	}
}
