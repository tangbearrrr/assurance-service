package com.rahat.assurance.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    RECORD_NOT_FOUND("Record not found");

    private final String message;
}
