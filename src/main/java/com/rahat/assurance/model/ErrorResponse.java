package com.rahat.assurance.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private Error error;

}
