package com.crecard.interfaces;

import com.crecard.model.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressService {
    public  Address addAddress(Address address);
    public Address updateAddress(long id, Address address);
    public Address removeAddress(long id);
    public Address getAddress(long id);
    public List<Address> getAllAddress();
}
