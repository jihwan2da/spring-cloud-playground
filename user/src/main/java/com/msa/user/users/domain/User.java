package com.msa.user.users.domain;


import com.msa.user.users.domain.vo.Authority;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
@Getter
public class User {
    @Id
    private String id;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "authority")
    private Authority authority;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.authority = Authority.USER;
    }
}
