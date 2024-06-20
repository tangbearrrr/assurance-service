package com.rahat.assurance.controller;

import com.rahat.assurance.model.Customer;
import com.rahat.assurance.service.CustomerService;
import com.rahat.assurance.service.S3Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    MockMvc mvc;

    Customer customer1;

    @Mock
    private S3Service s3Service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(customerController).build();

        customer1 = new Customer();
        customer1.setFirstName("Antony");
        customer1.setLastName("Beckham");
        customer1.setAddress("England");
        customer1.setMobileNo("0970974971");
        customer1.setImageUrl("https://customer-assurance.s3.amazonaws.com/photos/1/driveuploadbot.jpg");
    }

    @Test
    void shouldReturnCustomerById() throws Exception {
        String url = "/api/v1/customers/1";

        mvc.perform(get(url))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateCustomerSuccess() throws Exception {
        String url = "/api/v1/customers";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"first_name\" : \"Rahat\",\n" +
                                "    \"last_name\" : \"Sarawasee\",\n" +
                                "    \"address\" : \"44/20 Nimitmai 12\",\n" +
                                "    \"mobile_no\" : \"0970974974\",\n" +
                                "    \"email\" : \"spz8th@gmail.com\",\n" +
                                "    \"image_url\" : \"https://customer-assurance.s3.amazonaws.com/photos/driveuploadbot.jpg\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateCustomerSuccess() throws Exception {
        String url = "/api/v1/customers/1";

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"first_name\" : \"Rahat\",\n" +
                                "    \"last_name\" : \"Sarawasee\",\n" +
                                "    \"address\" : \"44/20 Nimitmai 12\",\n" +
                                "    \"mobile_no\" : \"0970974974\",\n" +
                                "    \"email\" : \"spz8th@gmail.com\",\n" +
                                "    \"image_url\" : \"https://customer-assurance.s3.amazonaws.com/photos/driveuploadbot.jpg\"\n" +
                                "}"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldDeleteCustomerSuccess() throws Exception {
        String url = "/api/v1/customers/1";

        mvc.perform(delete(url))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUploadPhotoSuccess() throws Exception {
        String url = "/api/v1/customers/1/photos";

        MockMultipartFile file = new MockMultipartFile("file", "filename.png", null, "test".getBytes());

        mvc.perform(multipart(url).file(file).param("file", "filename.png"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldUpdateStatusSuccess() throws Exception {
        String url = "/api/v1/customers/1/status/approve";

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void shouldCreateCustomerFail() throws Exception {
        String url = "/api/v1/customers";

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"firstName\" : \"\",\n" +
                                "    \"lastName\" : \"\",\n" +
                                "    \"address\" : \"\",\n" +
                                "    \"mobileNo\" : \"\",\n" +
                                "    \"imageUrl\" : \"\"\n" +
                                "}"))
                .andExpect(status().isBadRequest());
    }
}
