package com.msa.user.security.service;

import com.msa.user.security.jwt.JwtUserAdapter;
import com.msa.user.users.exception.UserNotFoundException;
import com.msa.user.users.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return userRepository.findByEmail(username)
                .switchIfEmpty(Mono.error(new UserNotFoundException()))
                .map(JwtUserAdapter::new);
    }
}
