package com.ptit.transportationmanagement.service.dto;

import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private List<AccountRoleDTO> roles;
}
