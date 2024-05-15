package com.instaverse.account.controller;

import com.instaverse.account.dto.AccountDetailsDTO;
import com.instaverse.account.entity.AccountDetailsEntity;
import com.instaverse.account.service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.instaverse.account.mapper.AccountDetailEntityToDtoMapper.mapAccountDetailsEntityToDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountDetailsController {

    private final AccountDetailsService accountDetailsService;

    @GetMapping("/details")
    public AccountDetailsDTO getAccountDetailsByAccountName() {
        AccountDetailsEntity accountDetailsEntity = this.accountDetailsService.getAccountDetails();
        return mapAccountDetailsEntityToDTO(accountDetailsEntity);
    }

    @PutMapping("/details/update")
    public AccountDetailsDTO updateAccountDetails(@RequestBody AccountDetailsDTO accountDetailsDTO) {
        return this.accountDetailsService.updateAccountDetails(accountDetailsDTO);
    }

}
