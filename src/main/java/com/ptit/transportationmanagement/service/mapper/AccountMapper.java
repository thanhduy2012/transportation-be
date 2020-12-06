package com.ptit.transportationmanagement.service.mapper;

import com.ptit.transportationmanagement.domain.Account;
import com.ptit.transportationmanagement.domain.Driver;
import com.ptit.transportationmanagement.service.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface AccountMapper extends EntityMapper<AccountDTO, Account> {

}
