package com.instaverse.account.mapper;

import com.instaverse.account.dto.AccountDetailsDTO;
import com.instaverse.account.entity.AccountDetailsEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountDetailEntityToDtoMapper {

    public static AccountDetailsDTO mapAccountDetailsEntityToDTO(AccountDetailsEntity entity) {
        return AccountDetailsDTO.builder()
                .accountName(entity.getAccountName())
                .description(entity.getDescription())
                .followers(entity.getFollowers())
                .following(entity.getFollowing())
                .postsCount(entity.getPostsCount())
                .build();
    }
}
