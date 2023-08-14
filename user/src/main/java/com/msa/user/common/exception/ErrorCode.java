package com.msa.user.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_EMAIL_DUPLICATE(400, "AUTH-001", "중복된 이메일 입니다."),
    USER_NOT_FOUND(400, "USER-002", "회원을 찾을 수 없습니다.");

    private final int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
