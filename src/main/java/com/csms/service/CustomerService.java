package com.csms.service;

import com.csms.model.Customer;

import java.util.List;

public interface CustomerService {
    public void save(Customer customer);

    public  List<Customer> get();

    public Customer get(Integer id);
}
