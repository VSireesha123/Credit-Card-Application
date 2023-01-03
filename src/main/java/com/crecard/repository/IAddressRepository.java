package com.crecard.repository;

import com.crecard.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAddressRepository extends JpaRepository<Address,Long> {
    void deleteAddressById(long id);
}
