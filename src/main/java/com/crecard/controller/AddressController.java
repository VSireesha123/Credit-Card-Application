package com.crecard.controller;

import com.crecard.model.Account;
import com.crecard.model.Address;
import com.crecard.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/getAllAddress")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @PutMapping("/updateAddress/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Address  updateAddress(@RequestBody Address address, @PathVariable("id") long id){
        return addressService.updateAddress(id,address);
    }

    @PostMapping("/addAddress")
    @ResponseStatus(HttpStatus.CREATED)
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @DeleteMapping("/removeAddress/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Address removeAddress(@PathVariable("id") long id){
        return addressService.removeAddress(id);
    }
    @GetMapping("/getAddress/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddress(@PathVariable("id") long id){return  addressService.getAddress(id);}
}
