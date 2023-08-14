package com.msa.user.users.presentation.dto;

import com.msa.user.users.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserResponse {

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    public static class UserInfo {
        private String id;
        private String email;
        private String role;

        public static UserInfo from(User user) {
            return new UserInfo(
                    user.getId(),
                    user.getEmail(),
                    user.getAuthority().getRole()
            );
        }
    }
}
