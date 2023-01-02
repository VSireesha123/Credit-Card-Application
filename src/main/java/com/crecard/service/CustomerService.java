package com.crecard.service;

import com.crecard.interfaces.ICustomerService;
import com.crecard.model.Customer;
import com.crecard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer removeCustomer(long customerId) {
        return customerRepository.deleteByCustomerId(customerId);
    }

    @Override
    public Customer updateCustomer(long customerId, Customer customer) {
        Customer customer1 = getCustomer(customerId);
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAccountId(customer.getAccountId());
        customer1.setDob(customer.getDob());
        customer1.setContactNo(customer.getContactNo());
        return customerRepository.save(customer1);
    }

    @Override
    public Customer getCustomer(long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return  customer.orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
