package com.bwj.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@SuperBuilder
@Getter
@Table(name = "m_posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 10)
    private String title;

    @Column(nullable = false,length = 200)
    private String content;

    @Column(nullable = false,length = 10)
    private String author;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;



    public static Post create(String title,
                              String content,
                              String author) {
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
