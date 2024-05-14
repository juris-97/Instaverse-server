package com.instaverse.account.controller;

import com.instaverse.account.dto.AccountDetailsDTO;
import com.instaverse.account.entity.AccountDetailsEntity;
import com.instaverse.account.service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.instaverse.account.mapper.AccountDetailEntityToDtoMapper.mapAccountDetailsEntityToDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountDetailsController {

    private final AccountDetailsService accountDetailsService;

    @GetMapping("/details/{accountName}")
    public AccountDetailsDTO getAccountDetailsByAccountName(@PathVariable final String accountName) {
        AccountDetailsEntity accountDetailsEntity = this.accountDetailsService.getAccountDetailsByAccountName(accountName);
        return mapAccountDetailsEntityToDTO(accountDetailsEntity);
    }

    @PutMapping("/details/update/{accountName}")
    public AccountDetailsDTO updateAccountDetails(@PathVariable final String accountName,
                                     @RequestParam("newAccountName") String newAccountName,
                                     @RequestParam("newAccountDescription") String newAccountDescription) {
        return this.accountDetailsService.updateAccountDetails(accountName, newAccountName, newAccountDescription);
    }

}
