package com.crecard.repository;

import com.crecard.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    void deleteByCustomerId(long id);

	//void findById(long id);
}
