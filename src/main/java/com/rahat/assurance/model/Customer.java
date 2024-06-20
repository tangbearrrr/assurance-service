package com.rahat.assurance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "customer")
public class Customer {

    @Id
    private String id;

    @NotNull(message = "First Name is required")
    @NotBlank(message = "First Name must not be empty")
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotNull(message = "Last Name is required")
    @NotBlank(message = "Last Name must not be empty")
    @JsonProperty(value = "last_name")
    private String lastName;

    @NotNull(message = "Address is required")
    @NotBlank(message = "Address must not be empty")
    @JsonProperty(value = "address")
    private String address;

    @NotNull(message = "Mobile Number is required")
    @NotBlank(message = "Mobile Number must not be empty")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid Mobile Number")
    @JsonProperty(value = "mobile_no")
    private String mobileNo;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email must not be empty")
    @Email(message = "Invalid email")
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "image_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;

    @JsonProperty(value = "status")
    private String status;
}
