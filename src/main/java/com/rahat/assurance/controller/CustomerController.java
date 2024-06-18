package com.rahat.assurance.controller;

import com.rahat.assurance.model.Customer;
import com.rahat.assurance.service.CustomerService;
import com.rahat.assurance.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RequestMapping("/api/v1/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    private final S3Service s3Service;


    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable String id) {
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> register(@RequestBody Customer request) {
        return ResponseEntity.ok(customerService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@RequestBody Customer request, @PathVariable String id) {
        return ResponseEntity.ok(customerService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/photos")
    public ResponseEntity<String> uploadPhoto(@PathVariable String id,
                                              @RequestParam(value = "file") MultipartFile file) {
        return ResponseEntity.ok(s3Service.uploadFileToS3(id, file));
    }
}
