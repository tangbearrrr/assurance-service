package com.rahat.assurance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "customer")
public class Customer {

    @Id
    private String id;

    @JsonProperty(value = "first_name")
    private String firstName;

    @JsonProperty(value = "last_name")
    private String lastName;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "mobile_no")
    private String mobileNo;

    @JsonProperty(value = "image_url")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;

    @JsonProperty(value = "status")
    private String status;
}
