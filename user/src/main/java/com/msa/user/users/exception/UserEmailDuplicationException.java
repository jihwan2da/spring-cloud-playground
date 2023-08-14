package com.msa.user.users.exception;

import com.msa.user.common.exception.ErrorCode;
import com.msa.user.common.exception.UserBusinessException;

public class UserEmailDuplicationException extends UserBusinessException {
    public UserEmailDuplicationException() {
        super(ErrorCode.USER_EMAIL_DUPLICATE);
    }
}
