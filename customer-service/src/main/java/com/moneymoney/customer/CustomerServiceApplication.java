package com.moneymoney.customer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.moneymoney.customer.bean.Customer;

@SpringBootApplication
@Configuration
public class CustomerServiceApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(CustomerServiceApplication.class);

	public static void main(String[] args) {
	
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	//RestTemplate  restTemplate = new RestTemplate();
	
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   // Do any additional configuration here
	   return builder.build();
	}
	/*@Autowired
	public static RestTemplate restTemplate;*/
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			ResponseEntity<Customer[]> customers= restTemplate.getForEntity("http://localhost:8002/getCustomer", Customer[].class);
			Customer[] cust = customers.getBody();
			for (Customer customer2 : cust) {
				System.out.println(cust.toString());
				System.out.println(customer2.toString());
			}
			/*ResponseEntity<List<Customer>> customers = restTemplate.exchange("http://localhost:8002/getCustomer",HttpMethod.GET, null, new ParameterizedTypeReference<List<Customer>>() {
            });
			List<Customer> customer = customers.getBody();
			System.out.println("customers" +customers.toString());
			for (Customer customer2 : customer) {
				System.out.println(customer.toString());
				System.out.println(customer2.toString());
			}*/
		};
	}
	
	/*public static void getCustomer()
	{
		String uri = "http://localhost:8002/getCustomer";
		Customer customer = restTemplate.getForObject(uri, Customer.class);
		log.info(customer.toString());
		System.out.println("Customer : "+customer.toString());
	}*/
}
