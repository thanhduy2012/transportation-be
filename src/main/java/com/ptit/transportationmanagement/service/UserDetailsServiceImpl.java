package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.domain.Account;
import com.ptit.transportationmanagement.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        System.out.println("Getting user from db");
        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(username);


        if (!optionalAccount.isPresent())
            throw new UsernameNotFoundException("username not found");
        Account account = optionalAccount.get();
        account.getAccountRoles().forEach(el -> el.getRole());
        return optionalAccount.get();
    }
}
