package com.example.photogallery;

import android.media.Image;

import java.io.Serializable;

public class Resource implements Serializable {
    private int galleryImageId;
    private String title;

    public Resource(int galleryImageId, String title) {
        this.galleryImageId = galleryImageId;
        this.title = title;
    }

    public int getGalleryImageId() {
        return galleryImageId;
    }

    public String getTitle() {
        return title;
    }
}
