package com.acme;

import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.customer.Customer;
import com.acme.order.customer.CustomerRepository;
import com.acme.order.customer.CustomerType;
import com.acme.order.customer.CustomerTypeRepository;
import com.acme.order.pizza.OrderRepository;
import com.acme.order.pizza.PizzaOrder;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;
import com.beust.jcommander.internal.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JpaTutorialApplication.class)
public class JpaTutorialApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerTypeRepository customerTypeRepository;
	
	@Autowired
	private PizzaOrderService pizzaOrderService;
	
	@Test
	public void contextLoads() {
		CustomerType customerType1 = new CustomerType(null, "TAki");
		CustomerType customerType2 = new CustomerType(null, "Inyy");
		CustomerType customerType3 = new CustomerType(null, "asda");
		customerTypeRepository.save(Lists.newArrayList(customerType1, customerType2, customerType3));
		
		Customer customer1 = new Customer(null, "Jerry", "jerry@lopata.pl", "jaracza 74", customerType1);
		Customer customer2 = new Customer(null, "Łukasz", "lukas@pro.pl", "jaracza 77", customerType2);
		Customer customer3 = new Customer(null, "Paweł", "paweł@dada.pl", "szafa 75", customerType3);
		customerRepository.save(Lists.newArrayList(customer1, customer2, customer3));
		
		PizzaOrder order1 = new PizzaOrder(customer1, PizzaType.LARGE);
		PizzaOrder order2 = new PizzaOrder(customer2, PizzaType.NORMAL);
		PizzaOrder order3 = new PizzaOrder(customer3, PizzaType.BIG);
		pizzaOrderService.createOrder(customer1, PizzaType.LARGE);
	}

}
