package com.instaverse.posts.service;

import com.instaverse.account.entity.AccountDetailsEntity;
import com.instaverse.account.persistence.AccountDetailsRepository;
import com.instaverse.account.service.AccountDetailsService;
import com.instaverse.posts.dto.PostDto;
import com.instaverse.posts.entity.PostEntity;
import com.instaverse.posts.persistance.PostsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.instaverse.posts.mapper.PostMapper.mapPostEntitiesToDto;
import static com.instaverse.posts.mapper.PostMapper.mapPostEntityToDto;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;
    private final AccountDetailsService accountDetailsService;
    private final AccountDetailsRepository accountDetailsRepository;


    public List<PostDto> getAllPosts() {
        List<PostEntity> postEntities = postsRepository.findAll();
        return mapPostEntitiesToDto(postEntities);
    }

    public PostDto savePost(PostDto postDto) {
        PostEntity newPost = PostEntity.builder()
                .filename(postDto.getFilename())
                .altName(postDto.getAltName())
                .file(postDto.getFileBytes())
                .build();
        PostEntity savedPost = this.postsRepository.save(newPost);
        AccountDetailsEntity account = this.accountDetailsService.getAccountDetails();
        int postsCount = account.getPostsCount();
        account.setPostsCount(postsCount + 1);
        this.accountDetailsRepository.save(account);
        return mapPostEntityToDto(savedPost);
    }

    public void deletePost(Long postId) {
        this.postsRepository.deleteById(postId);
        AccountDetailsEntity accountDetails = this.accountDetailsService.getAccountDetails();
        accountDetails.setPostsCount(accountDetails.getPostsCount() - 1);
        this.accountDetailsRepository.save(accountDetails);
    }

}
