package com.rahat.assurance.controller;

import com.rahat.assurance.model.Customer;
import com.rahat.assurance.model.SuccessResponse;
import com.rahat.assurance.service.CustomerService;
import com.rahat.assurance.service.S3Service;
import jakarta.validation.Valid;
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
    public ResponseEntity<SuccessResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .data(customerService.findById(id))
                .build());
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> register(@Valid @RequestBody Customer request) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .data(customerService.create(request))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse> update(@Valid @RequestBody Customer request, @PathVariable String id) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .data(customerService.update(id, request))
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse> delete(@PathVariable String id) {
        customerService.delete(id);
        return ResponseEntity.ok(SuccessResponse.builder()
                .data("Success")
                .build());
    }

    @PostMapping("/{id}/photos")
    public ResponseEntity<SuccessResponse> uploadPhoto(@PathVariable String id,
                                                       @RequestParam(value = "file") MultipartFile file) {
        return ResponseEntity.ok((SuccessResponse.builder()
                .data(s3Service.uploadFileToS3(id, file))
                .build()));
    }

    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<SuccessResponse> updateStatus(@PathVariable String id, @PathVariable String status) {
        return ResponseEntity.ok(SuccessResponse.builder()
                .data(customerService.updateStatus(id, status))
                .build());
    }
}
