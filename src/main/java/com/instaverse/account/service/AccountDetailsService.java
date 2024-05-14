package com.instaverse.account.service;

import com.instaverse.account.dto.AccountDetailsDTO;
import com.instaverse.account.entity.AccountDetailsEntity;
import com.instaverse.account.persistence.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import static com.instaverse.account.mapper.AccountDetailEntityToDtoMapper.mapAccountDetailsEntityToDTO;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountDetailsService {

    private final AccountDetailsRepository accountDetailsRepository;

    public AccountDetailsEntity getAccountDetailsByAccountName(String accountName) {
        return this.accountDetailsRepository.getAccountDetailsEntitiesByAccountName(accountName);
    }

    public AccountDetailsDTO updateAccountDetails(String accountName, String newAccountName, String newAccountDescription) {
        AccountDetailsEntity accountDetails = this.accountDetailsRepository.getAccountDetailsEntitiesByAccountName(accountName);
        if (Strings.isNotEmpty(accountName)) {
            accountDetails.setAccountName(newAccountName);
        }
        if (Strings.isNotEmpty(newAccountDescription)) {
            accountDetails.setDescription(newAccountDescription);
        }
        AccountDetailsEntity accountDetailsEntity = this.accountDetailsRepository.save(accountDetails);
        return mapAccountDetailsEntityToDTO(accountDetailsEntity);
    }

}
