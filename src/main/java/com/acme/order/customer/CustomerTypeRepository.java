package com.acme.order.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Long> {
	  @Query("select u from User u where u.name = TAki")
	  CustomerType findByEmailAddress(String emailAddress);
}
