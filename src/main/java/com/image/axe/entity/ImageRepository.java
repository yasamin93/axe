package com.image.axe.entity;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository {
    void saveImage(Image image);
}
