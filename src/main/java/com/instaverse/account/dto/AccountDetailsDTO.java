package com.instaverse.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDetailsDTO {
    private String accountName;
    private String description;
    private int followers;
    private int following;
    private int postsCount;
}
