package com.ptit.transportationmanagement.service.dto;

import com.ptit.transportationmanagement.domain.Account;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AccountRoleDTO implements Serializable {

    private AccountRolePK id;

    private Long accountId;

    private Long roleId;

    private Integer status;
}
