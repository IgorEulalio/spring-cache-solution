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

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerDataProvider customerService;

    @GetMapping()
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam(required = false) String last_name,
                                                       @RequestParam(required = false) String first_name) {

        if(!(last_name == null)){
            return ResponseEntity.ok().body(customerService.getCustomerByLastName(last_name));
        }

        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer) {
        customerService.addCustomer(customer);
        return ResponseEntity.status(201).build();
    }
}


