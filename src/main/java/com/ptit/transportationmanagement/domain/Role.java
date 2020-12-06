package com.ptit.transportationmanagement.domain;


import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@Accessors(chain = true)
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    private String description;

//    @ManyToMany
//    @JoinTable(
//            name = "account_table",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id")
//    )
    //private List<Account> accounts;

//    @OneToMany(mappedBy = "role")
//    private List<AccountRole> accountRoles;


    @Override
    public String getAuthority() {
        return "ROLE_" + roleName.toUpperCase().trim();
    }
}
