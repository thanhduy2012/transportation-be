package com.ptit.transportationmanagement;

import com.ptit.transportationmanagement.domain.Account;
import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import com.ptit.transportationmanagement.domain.Role;
import com.ptit.transportationmanagement.repository.AccountRepository;
import com.ptit.transportationmanagement.repository.AccountRoleRepository;
import com.ptit.transportationmanagement.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication
@AllArgsConstructor
public class TransportationManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportationManagementApplication.class, args);
    }

    private AccountRepository accountRepository;
    private RoleRepository roleRepository;
    private AccountRoleRepository accountRoleRepository;
    private PasswordEncoder passwordEncoder;

//    @Bean
//    public CommandLineRunner runner(){
//        return args -> {
//            Role role = new Role()
//                    .setRoleName("ADMIN");
//            if(!roleRepository.findByRoleName(role.getRoleName()).isPresent()){
//                roleRepository.save(role);
//            }else{
//                role = roleRepository.findByRoleName(role.getRoleName()).get();
//            }
//
//            Account account = new Account()
//                    .setUserName("admin")
//                    .setPassword(passwordEncoder.encode("123"));
//            if(!accountRepository.findAccountByUserName(account.getUsername()).isPresent()){
//                accountRepository.save(account);
//            }else{
//                account = accountRepository.findAccountByUserName(account.getUsername()).get();
//            }
//
//            AccountRolePK pk = new AccountRolePK()
//                    .setAccountId(account.getId())
//                    .setRoleId(role.getId());
//            AccountRole accountRole = new AccountRole();
//            accountRole.setId(pk);
//            accountRoleRepository.save(accountRole);
//        };
//    }
}
