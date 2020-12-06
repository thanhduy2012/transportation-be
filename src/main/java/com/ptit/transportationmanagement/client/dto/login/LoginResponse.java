package com.ptit.transportationmanagement.client.dto.login;

import com.ptit.transportationmanagement.service.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;
    private AccountDTO account;
}
