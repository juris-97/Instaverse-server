package com.instaverse.posts.mapper;

import com.instaverse.posts.dto.PostDto;
import com.instaverse.posts.entity.PostEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PostMapper {

    public static PostDto mapPostEntityToDto(PostEntity entity) {
        return PostDto.builder()
                .id(entity.getId())
                .fileBytes(entity.getFile())
                .filename(entity.getFilename())
                .altName(entity.getAltName())
                .build();
    }

    public static List<PostDto> mapPostEntitiesToDto(List<PostEntity> entities) {
        return entities.stream().map(PostMapper::mapPostEntityToDto).toList();
    }


}
