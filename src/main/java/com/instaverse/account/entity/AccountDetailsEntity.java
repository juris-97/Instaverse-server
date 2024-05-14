package com.instaverse.account.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_details")
public class AccountDetailsEntity {
    @Id
    private Long id;
    private String accountName;
    private String description;
    private int followers;
    private int following;
    private int postsCount;
}
