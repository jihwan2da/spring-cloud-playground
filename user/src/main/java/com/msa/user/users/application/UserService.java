package com.msa.user.users.application;

import com.msa.user.users.domain.User;
import com.msa.user.users.domain.service.UserCreatePolicy;
import com.msa.user.users.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import static com.msa.user.users.presentation.dto.UserRequest.*;
import static com.msa.user.users.presentation.dto.UserResponse.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserCreatePolicy userCreatePolicy;

    @Transactional
    public Mono<ResponseEntity<UserInfo>> signUp(Mono<SignUp> request) {
        return request
                .flatMap(it -> userCreatePolicy.validate(Mono.just(it)))
                .flatMap(it -> {
                    User user = User.builder()
                            .email(it.getEmail())
                            .password(it.getPassword())
                            .build();
                    return userRepository.save(user);
                })
                .map(UserInfo::from)
                .map(it -> ResponseEntity.status(HttpStatus.CREATED).body(it));
    }
}
