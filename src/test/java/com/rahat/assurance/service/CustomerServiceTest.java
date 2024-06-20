package com.rahat.assurance.service;

import com.rahat.assurance.exception.InvalidStatusException;
import com.rahat.assurance.model.Customer;
import com.rahat.assurance.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    Customer customer1;

    @BeforeEach
    void setup() {
        customerService = new CustomerService(customerRepository);

        customer1 = new Customer();
        customer1.setId("1");
        customer1.setFirstName("David");
        customer1.setLastName("Beckham");
        customer1.setAddress("England");
        customer1.setMobileNo("0970974971");
        customer1.setImageUrl("https://customer-assurance.s3.amazonaws.com/photos/1/driveuploadbot.jpg");
    }

    @Test
    void shouldReturnCustomerWhenGetCustomerById() {
        when(customerRepository.findById(anyString())).thenReturn(Optional.ofNullable(customer1));

        Customer result = customerService.findById("1");

        assertEquals(customer1, result);
    }

    @Test
    void shouldSaveCustomerSuccess() {
        when(customerRepository.save(any())).thenReturn(customer1);

        Customer result = customerService.create(customer1);

        assertEquals(customer1, result);
    }

    @Test
    void shouldUpdateCustomerSuccess() {
        Customer request = new Customer();
        customer1.setFirstName("Antony");
        customer1.setLastName("Beckham");
        customer1.setAddress("England");
        customer1.setMobileNo("0970974971");
        customer1.setImageUrl("https://customer-assurance.s3.amazonaws.com/photos/1/driveuploadbot.jpg");

        when(customerRepository.findById(anyString())).thenReturn(Optional.ofNullable(customer1));
        when(customerRepository.save(any())).thenReturn(request);

        Customer result = customerService.update("1", request);

        assertEquals(request, result);
    }

    @Test
    void shouldDeleteCustomer() {
        when(customerRepository.findById(anyString())).thenReturn(Optional.ofNullable(customer1));

        customerService.delete("1");

        verify(customerRepository).deleteById(anyString());
    }

    @Test
    void shouldUpdateStatusApproveSuccess() {

        Customer expect = new Customer();
        expect.setStatus("APPROVE");

        when(customerRepository.findById(anyString())).thenReturn(Optional.ofNullable(customer1));
        when(customerRepository.save(any())).thenReturn(expect);
        Customer result = customerService.updateStatus("1", "approve");

        assertEquals(expect.getStatus(), result.getStatus());
    }

    @Test
    void shouldUpdateStatusRejectSuccess() {

        Customer expect = new Customer();
        expect.setStatus("REJECT");

        when(customerRepository.findById(anyString())).thenReturn(Optional.ofNullable(customer1));
        when(customerRepository.save(any())).thenReturn(expect);
        Customer result = customerService.updateStatus("1", "reject");

        assertEquals(expect.getStatus(), result.getStatus());
    }

    @Test
    void shouldUpdateStatusFail() {
        assertThrows(InvalidStatusException.class, () -> customerService.updateStatus("1", "abc"));
    }
}
