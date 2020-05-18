package com.study.springcacheapplication.repository;

import java.util.List;

import com.study.springcacheapplication.model.Customer;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Cacheable(value = "customer", key = "#firstName")
    public Customer findByFirstName(String firstName);
    @Cacheable(value = "customer", key = "#lastName")
    public List<Customer> findByLastName(String lastName);

}