package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.client.dto.account.CreateAccountRequest;
import com.ptit.transportationmanagement.client.dto.account.CreateAccountResponse;
import com.ptit.transportationmanagement.domain.Account;
import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import com.ptit.transportationmanagement.repository.AccountRepository;
import com.ptit.transportationmanagement.repository.AccountRoleRepository;
import com.ptit.transportationmanagement.service.dto.AccountDTO;
import com.ptit.transportationmanagement.service.dto.AccountRoleDTO;
import com.ptit.transportationmanagement.service.mapper.AccountMapper;
import com.ptit.transportationmanagement.service.mapper.AccountRoleMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AccountService {

    private final Logger LOG = LoggerFactory.getLogger(AccountService.class);

    private final AccountRepository accountRepository;

    private final AccountRoleRepository accountRoleRepository;

    private final AccountRoleService accountRoleService;

    private PasswordEncoder passwordEncoder;

    private AccountRoleMapper accountRoleMapper;

    private final AccountMapper accountMapper;

    public CreateAccountResponse create(CreateAccountRequest request) throws Exception {
        CreateAccountResponse response = new CreateAccountResponse();

        if(request == null){
            throw new Exception("request create account null !!!");
        }
        if(request.getAccount().getPassword() == null){
            throw new Exception("password not null !!!");
        }
        if(request.getAccount().getRoles() == null){
            throw  new Exception("list role of account not null !!!");
        }
        if(findAccountByUsername(request.getAccount().getUsername())!=null){
            throw  new Exception("username existed !!!");
        }

        request.getAccount().setPassword(passwordEncoder.encode(request.getAccount().getPassword()));

        Account account = accountMapper.toEntity(request.getAccount());
        Account saved = accountRepository.save(account);

        List<AccountRoleDTO> accountRole = accountRoleService.createAccountRole(request.getAccount().getRoles(), saved.getId());


        AccountDTO accountDTO = accountMapper.toDto(saved);


        accountDTO.setRoles(accountRole);

        response.setAccount(accountDTO);

        return response;
    }

    public AccountDTO findAccountByUsername(String username){
        Optional<Account> accountByUsername = accountRepository.findAccountByUsername(username);
        Account account = !(accountByUsername.isPresent())? null : accountByUsername.get();
        AccountDTO accountDTO = null;
        if(account != null){
            List<AccountRole> lstAccountRole = accountRoleRepository.findAccountRoleByAccount_Id(account.getId());
            List<AccountRoleDTO> accountRoleDTOS = accountRoleMapper.toDto(lstAccountRole);

            accountDTO = accountMapper.toDto(account);

            accountDTO.setRoles(accountRoleDTOS);
        }


        return accountDTO;
    }




}
