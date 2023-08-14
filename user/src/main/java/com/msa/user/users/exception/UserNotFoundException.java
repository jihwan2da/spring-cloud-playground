package com.msa.user.users.exception;

import com.msa.user.common.exception.ErrorCode;
import com.msa.user.common.exception.UserBusinessException;

public class UserNotFoundException extends UserBusinessException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
