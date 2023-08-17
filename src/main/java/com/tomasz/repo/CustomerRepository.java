package com.tomasz.repo;

import com.tomasz.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

//  Customer findByEmail(String email);
  List<Customer> findByEmail(String email);
}
