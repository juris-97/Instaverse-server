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

    public AccountDetailsEntity getAccountDetails() {
        return this.accountDetailsRepository.findAll().get(0);
    }

    public AccountDetailsDTO updateAccountDetails(AccountDetailsDTO newAccountDetails) {
        AccountDetailsEntity accountDetails = this.getAccountDetails();
        if (Strings.isNotEmpty(newAccountDetails.getAccountName())) {
            accountDetails.setAccountName(newAccountDetails.getAccountName());
        }
        if (Strings.isNotEmpty(newAccountDetails.getDescription())) {
            accountDetails.setDescription(newAccountDetails.getDescription());
        }
        AccountDetailsEntity accountDetailsEntity = this.accountDetailsRepository.save(accountDetails);
        return mapAccountDetailsEntityToDTO(accountDetailsEntity);
    }

}
