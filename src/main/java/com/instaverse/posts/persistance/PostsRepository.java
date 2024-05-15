package com.instaverse.posts.persistance;

import com.instaverse.posts.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostsRepository extends JpaRepository<PostEntity, Long> {
}
