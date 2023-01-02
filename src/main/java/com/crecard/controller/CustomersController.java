package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Customer;
import com.crecard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<Customer> index(){
        return customerService.getAllCustomers();
    }

    @PutMapping("/{id}")
    public Customer  update(@RequestBody Customer customer, @PathVariable("id") long id){
        return customerService.updateCustomer(id,customer);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable("id") long id){
        return customerService.removeCustomer(id);
    }

    @GetMapping("/{id}")
    public Customer show(@PathVariable("id") long id){return  customerService.getCustomer(id);}
}
