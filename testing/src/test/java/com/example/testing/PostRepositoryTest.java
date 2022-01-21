package com.example.testing;

import com.example.testing.jpa.controller.Posts;
import com.example.testing.jpa.controller.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save(){
        //given
        String title = "Test title";
        String content = "Test content";

        //when
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("song")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        Assertions.assertEquals(posts.getTitle(), title);
        Assertions.assertEquals(posts.getContent(), content);
    }
}
