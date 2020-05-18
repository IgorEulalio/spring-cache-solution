package com.study.springcacheapplication.repository;

import java.util.List;
import java.util.Optional;

import com.study.springcacheapplication.model.Customer;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findAll();

    public Customer findByFirstName(String firstName);

    public Optional<Customer> findById(String id);
}
