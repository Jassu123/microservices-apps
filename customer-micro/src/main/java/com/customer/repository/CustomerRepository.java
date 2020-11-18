package com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {
	
	@Query(value="select  count(*) from  customer  where  phone_no=?  and  password=?", nativeQuery=true)
	Integer  checkLogin(Long phoneNumber, String password);

}
