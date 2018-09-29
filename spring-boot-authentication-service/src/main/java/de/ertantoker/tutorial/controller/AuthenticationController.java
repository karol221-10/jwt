package de.ertantoker.tutorial.controller;

import de.ertantoker.tutorial.exception.EntityNotFoundException;
import de.ertantoker.tutorial.response.JWTTokenResponse;
import de.ertantoker.tutorial.request.AuthenticationRequest;
import de.ertantoker.tutorial.service.AuthenticationService;
import io.jsonwebtoken.SignatureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthenticationController {

    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<JWTTokenResponse> createCustomer(@RequestBody AuthenticationRequest request) {
        return new ResponseEntity<>(authenticationService.generateJWTToken(request.getUsername(), request.getPassword()), HttpStatus.OK);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handle(EntityNotFoundException ex) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
