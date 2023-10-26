package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PostCreationDto {
    private String headline;
    private String description;
    private String content;
    private String previewImage;
    private String bannerImage;
    private Boolean status;
    private Date createdAt;
}
