package com.crecard.controller;

import com.crecard.model.Address;
import com.crecard.model.Customer;
import com.crecard.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomersController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> index(){
        return customerService.getAllCustomers();
    }

    @PutMapping("/updateCustomer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer  update(@RequestBody Customer customer, @PathVariable("id") long id){
        return customerService.updateCustomer(id,customer);
    }

    @PostMapping("/addCustomer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer create(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/removeCustomer/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer removeCustomer(@PathVariable("id") long id){
        Customer customer = customerService.removeCustomer(id);
        return customer;
    }

    @GetMapping("/getCustomer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer show(@PathVariable("id") long id){return  customerService.getCustomer(id);}
}
