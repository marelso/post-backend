package com.example.demo.dto.factory;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostCreationDto;
import com.example.demo.dto.PostDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostFactory {
    public Post from(PostCreationDto request) {
        var entity = new Post();

        entity.setHeadline(request.getHeadline());
        entity.setDescription(request.getDescription());
        entity.setContent(request.getContent());
        entity.setPreviewImage(request.getPreviewImage());
        entity.setBannerImage(request.getBannerImage());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public Post from(PostDto request) {
        var entity = new Post();

        entity.setId(request.getReference());
        entity.setHeadline(request.getHeadline());
        entity.setDescription(request.getDescription());
        entity.setContent(request.getContent());
        entity.setPreviewImage(request.getPreviewImage());
        entity.setBannerImage(request.getBannerImage());
        entity.setStatus(request.getStatus());
        entity.setCreatedAt(request.getCreatedAt());

        return entity;
    }

    public Post from(Post entity, PostDto dto) {
        entity.setHeadline(entity.getHeadline());
        entity.setDescription(entity.getDescription());
        entity.setContent(entity.getContent());
        entity.setPreviewImage(entity.getPreviewImage());
        entity.setBannerImage(entity.getBannerImage());
        entity.setStatus(entity.getStatus());

        return entity;
    }

    public List<PostDto> from(List<Post> posts) {
        return posts.stream().map(this::from)
                .collect(Collectors.toList());
    }

    private PostDto from(Post entity) {
        var dto = new PostDto();

        dto.setReference(entity.getId());
        dto.setHeadline(entity.getHeadline());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setPreviewImage(entity.getPreviewImage());
        dto.setBannerImage(entity.getBannerImage());
        dto.setStatus(entity.getStatus());
        dto.setCreatedAt(entity.getCreatedAt());

        return dto;
    }
}
