package com.msa.user.common.exception;

public class UserBusinessException extends RuntimeException {

    private final ErrorCode errorCode;

    public UserBusinessException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
