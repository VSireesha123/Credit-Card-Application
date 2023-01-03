package com.crecard.service;

import com.crecard.execption.CustomException;
import com.crecard.execption.CustomerUserIdNotFoundException;
import com.crecard.interfaces.IAddressService;
import com.crecard.model.Address;
import com.crecard.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    @Autowired
    IAddressRepository addressRepository;
    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(long id, Address address) {
        Address address1  = getAddress(id);
        address1.setCity(address.getCity());
        address1.setArea(address.getArea());
        address1.setDoorNo(address.getDoorNo());
        address1.setDoorNo(address.getDoorNo());
        address1.setCustomerId(address.getCustomerId());
        address1.setPincode(address.getPincode());
        return addressRepository.save(address);
    }

    @Override
    public Address removeAddress(long id) {
        Address address= getAddress(id);
        addressRepository.deleteAddressById(id);
        return address;
    }

    @Override
    public Address getAddress(long id) {
        return addressRepository.findById(id).orElseThrow(() ->  new CustomException("No Address found with id:"+id));
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }
}
