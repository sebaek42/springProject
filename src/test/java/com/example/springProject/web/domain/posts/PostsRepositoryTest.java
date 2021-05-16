package com.example.springProject.web.domain.posts;


import com.example.springProject.domain.posts.Posts;
import com.example.springProject.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired PostsRepository postsRepository;

    @After // JUnit4 에선 이 노테이션이고 JUnit5 에선 @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void save_load() {
        String title = "test title";
        String content = "test contents";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("sebaek@naver.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
