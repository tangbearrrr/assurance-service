package com.rahat.assurance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "customer")
public class Customer {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNo;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;
}
