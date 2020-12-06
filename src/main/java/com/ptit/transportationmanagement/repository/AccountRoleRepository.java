package com.ptit.transportationmanagement.repository;

import com.ptit.transportationmanagement.domain.AccountRole;
import com.ptit.transportationmanagement.domain.AccountRolePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRoleRepository extends JpaRepository<AccountRole, AccountRolePK> {

    List<AccountRole> findAccountRoleByAccount_Id(Long id);
}
