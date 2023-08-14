package com.msa.user.users.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SignUp {
        private String email;
        private String password;
    }
}
