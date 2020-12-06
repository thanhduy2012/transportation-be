package com.ptit.transportationmanagement.service;

import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import com.ptit.transportationmanagement.repository.AccountRoleRepository;
import com.ptit.transportationmanagement.service.dto.AccountRoleDTO;
import com.ptit.transportationmanagement.service.mapper.AccountRoleMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AccountRoleService {
    private final Logger LOG = LoggerFactory.getLogger(AccountRoleService.class);

    AccountRoleRepository accountRoleRepository ;
    AccountRoleMapper accountRoleMapper;


    public List<AccountRoleDTO> createAccountRole(List<AccountRoleDTO> idRoles,Long accountId){

        List<AccountRoleDTO> lstResponse = new ArrayList<>();

        idRoles.stream().forEach(item -> {
            AccountRolePK pk = new AccountRolePK().setRoleId(accountId).setAccountId(accountId).setRoleId(item.getRoleId());

            AccountRoleDTO accountRoleDTO = new AccountRoleDTO().setId(pk).setAccountId(accountId).setRoleId(item.getRoleId()).setStatus(item.getStatus());



            AccountRole accountRole = accountRoleMapper.toEntity(accountRoleDTO);

            AccountRole save = accountRoleRepository.save(accountRole);

            AccountRoleDTO accRolResponse = accountRoleMapper.toDto(save);
            lstResponse.add(accRolResponse);
        });

        return lstResponse;
    }

}
