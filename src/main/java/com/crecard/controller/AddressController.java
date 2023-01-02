package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.model.Address;
import com.crecard.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping
    public List<Address> index(){
        return addressService.getAllAddress();
    }

    @PutMapping("/{id}")
    public Address  update(@RequestBody Address address, @PathVariable("id") long id){
        return addressService.updateAddress(id,address);
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable("id") long id){
        return addressService.removeAddress(id);
    }
    @GetMapping("/{id}")
    public Address show(@PathVariable("id") long id){return  addressService.getAddress(id);}
}
