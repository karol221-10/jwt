package de.ertantoker.tutorial.service;

import de.ertantoker.tutorial.exception.EntityNotFoundException;
import de.ertantoker.tutorial.repository.AccountRepository;
import de.ertantoker.tutorial.response.JWTTokenResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {

    private AccountRepository accountRepository;
    private JwtTokenService jwtTokenService;

    public AuthenticationService(AccountRepository accountRepository, JwtTokenService jwtTokenService) {
        this.accountRepository = accountRepository;
        this.jwtTokenService = jwtTokenService;
    }

    public JWTTokenResponse generateJWTToken(String username, String password) {
        return accountRepository.findOneByUsername(username)
                .filter(account -> Objects.equals(account.getPassword(), password))
                .map(account -> new JWTTokenResponse(jwtTokenService.generateToken(username)))
                .orElseThrow(EntityNotFoundException::new);
    }
}
