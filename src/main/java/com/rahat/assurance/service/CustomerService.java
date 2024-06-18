package com.rahat.assurance.service;

import com.rahat.assurance.model.Customer;
import com.rahat.assurance.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final S3Service s3Service;

    public Customer findById(String id) {
        return customerRepository.findById(id)
                .orElseThrow();
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(String id, Customer customer) {
        findById(id);
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public void delete(String id) {
        findById(id);
        customerRepository.deleteById(id);
    }
}
