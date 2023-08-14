package com.msa.user.users.domain.service;

import com.msa.user.users.exception.UserEmailDuplicationException;
import com.msa.user.users.infra.repository.UserRepository;
import com.msa.user.users.presentation.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserCreatePolicy {
    private final UserRepository userRepository;

    public Mono<UserRequest.SignUp> validate(Mono<UserRequest.SignUp> request) {
        return request.flatMap(it ->
                userRepository.findByEmail(it.getEmail())
                        .flatMap(existingUser -> Mono.<UserRequest.SignUp>error(new UserEmailDuplicationException()))
                        .switchIfEmpty(Mono.just(it))
        );
    }

}
