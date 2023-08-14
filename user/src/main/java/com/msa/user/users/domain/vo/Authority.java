package com.msa.user.users.domain.vo;

import lombok.Getter;

@Getter
public enum Authority {
    USER("ROLE_USER");

    private final String role;

    Authority(String role) {
        this.role = role;
    }
}
