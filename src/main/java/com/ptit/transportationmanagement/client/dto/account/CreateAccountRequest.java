package com.ptit.transportationmanagement.client.dto.account;

import com.ptit.transportationmanagement.service.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest {
    private AccountDTO account;
}
