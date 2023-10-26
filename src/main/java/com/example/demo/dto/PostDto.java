package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Getter
@Setter
public class PostDto {
    private Integer reference;
    private String headline;
    private String description;
    private String content;
    private String previewImage;
    private String bannerImage;
    private Boolean status;
    private Date createdAt;
}
