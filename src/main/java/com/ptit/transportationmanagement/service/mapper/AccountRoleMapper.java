package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import com.ptit.transportationmanagement.service.dto.AccountRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface AccountRoleMapper extends EntityMapper<AccountRoleDTO, AccountRole> {

    @Mapping(source = "account.id", target = "id.accountId")
    @Mapping(source = "role.id", target = "id.roleId")
    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "role.id", target = "roleId")
    AccountRoleDTO toDto(AccountRole accountRole);

    @Mapping(source = "id.accountId", target = "account.id")
    @Mapping(source = "id.roleId", target = "role.id")
    AccountRole toEntity(AccountRoleDTO accountRoleDTO);

}
