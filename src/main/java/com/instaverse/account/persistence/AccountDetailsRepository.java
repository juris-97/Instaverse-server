package com.instaverse.account.persistence;

import com.instaverse.account.entity.AccountDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetailsEntity, String> {

    AccountDetailsEntity getAccountDetailsEntitiesByAccountName(String accountName);

}
