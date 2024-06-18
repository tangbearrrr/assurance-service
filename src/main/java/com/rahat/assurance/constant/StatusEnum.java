package com.rahat.assurance.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum {

    APPROVE("APPROVE"),
    REJECT("REJECT"),
    PENDING("PENDING");

    private final String message;
}
