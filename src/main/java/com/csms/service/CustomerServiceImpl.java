package com.csms.service;

import com.csms.model.Customer;
import com.csms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> get() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(Integer id) {
        return customerRepository.findById(id).isPresent() ? customerRepository.findById(id).get() : null;
    }
}
