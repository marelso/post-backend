package com.example.demo;

import com.example.demo.domain.Post;
import com.example.demo.dto.PostCreationDto;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.factory.PostFactory;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    private final PostFactory factory;

    public Post create(PostCreationDto request) {
        return repository.save(factory.from(request));
    }

    public Post get(Integer reference) {
        return searchById(reference)
                .orElseThrow(() -> new RuntimeException("Nothing found here."));
    }

    public List<Post> list() {
        return repository.findAll();
    }

    public void delete(Integer reference) {
        repository.deleteById(reference);
    }

    public Post update(Integer reference, PostDto request) {
        var entity = get(reference);

        return repository.save(factory.from(entity, request));
    }

    public void updateStatus(Integer reference, Boolean status) {
        var entity = get(reference);

        entity.setStatus(status);

        repository.save(entity);
    }

    private Optional<Post> searchById(Integer id) {
        return repository.findById(id);
    }
}
