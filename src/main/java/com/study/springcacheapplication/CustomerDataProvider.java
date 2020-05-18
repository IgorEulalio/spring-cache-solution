package com.study.springcacheapplication;

import com.study.springcacheapplication.model.Customer;
import com.study.springcacheapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDataProvider {

    @Autowired
    private CustomerRepository repository;

    public CustomerDataProvider(CustomerRepository repository) {
        this.repository = repository;
    }

    @Caching(evict = {
            @CacheEvict(value="customer", allEntries=true),
            @CacheEvict(value="customers", allEntries=true)})
    public void addCustomer(Customer customer){
        repository.save(customer);
    }

    @Cacheable(value = "customer")
    public Customer getCustomerByFirstName(String firstName){
        return repository.findByFirstName(firstName);
    }

    @Cacheable(value = "customer")
    public Optional<Customer> getCustomerById(String id){
        return repository.findById(id);
    }

    @Cacheable(value = "customers")
    public List<Customer> getCustomers(){
        return repository.findAll();
    }

}
