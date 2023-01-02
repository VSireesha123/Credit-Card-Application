package com.crecard.repository;

import com.crecard.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
    Address deleteAddressById(long id);
}
