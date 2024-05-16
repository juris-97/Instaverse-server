package com.instaverse.account.controller;

import com.instaverse.account.dto.AccountDetailsDTO;
import com.instaverse.account.entity.AccountDetailsEntity;
import com.instaverse.account.service.AccountDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.instaverse.account.mapper.AccountDetailEntityToDtoMapper.mapAccountDetailsEntityToDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/account")
public class AccountDetailsController {

    private final AccountDetailsService accountDetailsService;

    @GetMapping("/details")
    public ResponseEntity<AccountDetailsDTO> getAccountDetailsByAccountName() {
        AccountDetailsEntity accountDetailsEntity = this.accountDetailsService.getAccountDetails();
        AccountDetailsDTO mappedAccountDetailsDTO = mapAccountDetailsEntityToDTO(accountDetailsEntity);
        return new ResponseEntity<>(mappedAccountDetailsDTO, HttpStatus.OK);
    }

    @PutMapping("/details/update")
    public ResponseEntity<AccountDetailsDTO> updateAccountDetails(@RequestBody AccountDetailsDTO accountDetailsDTO) {
        AccountDetailsDTO updatedAccountDetails = this.accountDetailsService.updateAccountDetails(accountDetailsDTO);
        return new ResponseEntity<>(updatedAccountDetails, HttpStatus.OK);
    }

}
