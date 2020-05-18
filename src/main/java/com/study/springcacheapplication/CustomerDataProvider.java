package com.study.springcacheapplication;

import com.study.springcacheapplication.model.Customer;
import com.study.springcacheapplication.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class CustomerDataProvider {

    @Autowired
    private CustomerRepository repository;

    public CustomerDataProvider(CustomerRepository repository) {
        this.repository = repository;
    }

    public void addCustomer(Customer customer){
        repository.save(customer);
    }

    public List<Customer> getCustomerByLastName(String lastName){
        return repository.findByLastName(lastName);
    }

    public List<Customer> getCustomers(){
        return repository.findAll();
    }

}
