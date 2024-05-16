package com.instaverse.posts.controller;

import com.instaverse.posts.dto.PostDto;
import com.instaverse.posts.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/posts")
public class PostsController {

    private final PostsService postsService;

    @PostMapping("/save")
    public ResponseEntity<PostDto> savePost(@RequestParam("file") MultipartFile file,
                                           @RequestParam("filename") String fileName,
                                           @RequestParam("altName") String altName) throws IOException {
        PostDto postDto = PostDto.builder()
                .fileBytes(file.getBytes())
                .filename(fileName)
                .altName(altName)
                .build();
        return new ResponseEntity<>(this.postsService.savePost(postDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId) {
        this.postsService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(this.postsService.getAllPosts(), HttpStatus.OK);
    }
}
