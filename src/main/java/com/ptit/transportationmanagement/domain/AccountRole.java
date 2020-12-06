package com.ptit.transportationmanagement.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
@Data
@Accessors(chain = true)
public class AccountRole {

    @EmbeddedId
    private AccountRolePK id;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id", insertable = false, updatable = false)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role;

    private Integer status;


}
