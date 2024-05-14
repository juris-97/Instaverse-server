package com.instaverse.posts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class PostEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;
    private String altName;
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 1000000, columnDefinition="bytea")
    private byte[] file;
}
