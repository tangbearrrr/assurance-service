package com.rahat.assurance.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    RECORD_NOT_FOUND(1001,"Record not found"),
    INVALID_STATUS(1002,"Status must be approve or reject");

    private final int code;
    private final String message;
}
