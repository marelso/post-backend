package com.example.demo.controller;

import com.example.demo.PostService;
import com.example.demo.dto.PostDto;
import com.example.demo.dto.factory.PostFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService service;
    private final PostFactory factory;

    @GetMapping
    private Page<PostDto> get(@ApiIgnore Pageable pageable) {
        return service.list(pageable).map(factory::from);
    }

    @GetMapping("/{id}")
    private PostDto get(@PathVariable Integer id) {
        return factory.from(service.get(id));
    }
}
