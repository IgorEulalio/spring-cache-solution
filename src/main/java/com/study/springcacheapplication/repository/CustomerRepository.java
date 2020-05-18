package com.study.springcacheapplication.repository;

import java.util.List;

import com.study.springcacheapplication.model.Customer;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findAll();

    @Cacheable("customers")
    public List<Customer> findByLastName(String lastName);

    @Cacheable("customers")
    public List<Customer> findByFirstName(String firstName);
}