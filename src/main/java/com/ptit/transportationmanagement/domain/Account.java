package com.ptit.transportationmanagement.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "account")
@Data
@Accessors(chain = true)
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

//    @ManyToMany(mappedBy = "accounts", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    private Set<Role> roles;
    @OneToMany(mappedBy = "account")
    private List<AccountRole> accountRoles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return accountRoles.stream().map(
                el -> el.getRole()
        ).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
