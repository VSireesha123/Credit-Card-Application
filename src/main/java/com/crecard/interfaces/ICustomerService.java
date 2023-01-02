package com.crecard.interfaces;

import com.crecard.model.Customer;

import java.util.List;

public interface ICustomerService {
    public Customer addCustomer(Customer customer);
    public Customer removeCustomer (long customerId);
    public Customer updateCustomer(long customerId,Customer customer);
    public Customer getCustomer(long customerId);
    public List<Customer> getAllCustomers();

}
