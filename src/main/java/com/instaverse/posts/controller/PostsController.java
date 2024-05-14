package com.instaverse.posts.controller;

import com.instaverse.posts.dto.PostDto;
import com.instaverse.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/save/{accountName}")
    public PostDto savePost(@PathVariable("accountName") String accountName,
                            @RequestParam("file") MultipartFile file,
                            @RequestParam("filename") String fileName,
                            @RequestParam("altName") String altName) throws IOException {
        PostDto postDto = PostDto.builder()
                .fileBytes(file.getBytes())
                .filename(fileName)
                .altName(altName)
                .build();
        return this.postsService.savePost(postDto, accountName);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        return this.postsService.getAllPosts();
    }
}
