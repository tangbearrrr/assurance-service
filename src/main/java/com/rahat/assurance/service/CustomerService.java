package com.rahat.assurance.service;

import com.rahat.assurance.constant.ErrorCodeEnum;
import com.rahat.assurance.constant.StatusEnum;
import com.rahat.assurance.exception.RecordNotFoundException;
import com.rahat.assurance.exception.InvalidStatusException;
import com.rahat.assurance.model.Customer;
import com.rahat.assurance.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(ErrorCodeEnum.RECORD_NOT_FOUND.getMessage()));
    }

    public Customer create(Customer customer) {
        customer.setStatus(StatusEnum.PENDING.getMessage());
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

    public Customer updateStatus(String id, String status) {
        validateStatus(status);
        Customer customer = findById(id);
        customer.setStatus(status.toUpperCase());
        return customerRepository.save(customer);
    }

    private void validateStatus(String status) {
        if (!StatusEnum.APPROVE.getMessage().equalsIgnoreCase(status) && !StatusEnum.REJECT.getMessage().equalsIgnoreCase(status)) {
            throw new InvalidStatusException(ErrorCodeEnum.INVALID_STATUS.getMessage());
        }

    }
}
