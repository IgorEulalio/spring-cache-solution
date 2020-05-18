package com.study.springcacheapplication.entrypoint;

import com.study.springcacheapplication.CustomerDataProvider;
import com.study.springcacheapplication.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDataProvider customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String first_name) {

        if(!(first_name == null)){
            return ResponseEntity.ok().body(Arrays.asList(customerService.getCustomerByFirstName(first_name)));
        }
           return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/{id_customer}")
    public ResponseEntity<Customer> getCustomersById(@PathVariable String id_customer){

        Optional<Customer> customer = customerService.getCustomerById(id_customer);

        if(!customer.isPresent()){
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok().body(customer.get());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(201).build();
    }
}


