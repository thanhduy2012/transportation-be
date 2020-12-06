package com.ptit.transportationmanagement.web.rest;


import com.ptit.transportationmanagement.client.dto.account.CreateAccountRequest;
import com.ptit.transportationmanagement.client.dto.account.CreateAccountResponse;
import com.ptit.transportationmanagement.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountResource {

    private final Logger LOG = LoggerFactory.getLogger(AccountResource.class);

    private AccountService accountService;

    private AccountResource(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> getAll(@RequestBody CreateAccountRequest request) {
        try {

            CreateAccountResponse response = accountService.create(request);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error(this.getClass().getName(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
