package com.projectx.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Index;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotNull;
import com.projectx.utils.StringArrayConverter;
import com.projectx.utils.MediaLinksLimit;
import java.util.UUID;

@Entity
@Table(name = "posts", indexes = {
        @Index(name = "idx_user_id", columnList = "userId")
})
public class Post {

    @Id
    private String id;

    @Column(name = "userId", nullable = false)
    @NotNull
    private String userId;

    private String title;
    private String caption;
    private String description;

    @Column(name = "media_links", columnDefinition = "TEXT")
    @Convert(converter = StringArrayConverter.class)
    @MediaLinksLimit(max = 10) // Custom validation annotation
    private String[] media;

    @PrePersist
    public void generateId() {
        this.id = UUID.randomUUID().toString();
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getMedia() {
        return media;
    }

    public void setMedia(String[] media) {
        this.media = media;
    }
}
