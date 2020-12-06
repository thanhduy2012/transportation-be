package com.ptit.transportationmanagement.web.rest;

import com.ptit.transportationmanagement.client.dto.login.LoginRequest;
import com.ptit.transportationmanagement.client.dto.login.LoginResponse;
import com.ptit.transportationmanagement.repository.AccountRepository;
import com.ptit.transportationmanagement.service.AccountService;
import com.ptit.transportationmanagement.service.JwtService;
import com.ptit.transportationmanagement.service.dto.AccountDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthResource {

    private AuthenticationManager authenticationManager;

    private AccountService accountService;

    @RequestMapping
    public ResponseEntity<?> auth(@RequestBody LoginRequest loginRequest) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(loginRequest.getAccount().getUsername(), loginRequest.getAccount().getPassword(), Collections.emptyList());
            Authentication result = authenticationManager.authenticate(auth);
            String token = JwtService.generateToken(result);

            AccountDTO accountResponse = accountService.findAccountByUsername(loginRequest.getAccount().getUsername());

            LoginResponse response = new LoginResponse();
            response.setAccount(accountResponse);
            response.setToken(token);

            return ResponseEntity.ok(response);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(Collections.singletonMap("error", "sai thong tin"));
        } catch (Throwable t) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", t.getMessage()));
        }
    }
}
