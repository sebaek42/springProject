package com.example.springProject.service.posts;


import com.example.springProject.domain.posts.PostsRepository;
import com.example.springProject.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository; // 여기 왜 @Autowired가 없을까? 생성자에서 주입되기 때문. 생성자는 어디있을까? @RequiredArgsConstructor에서 final로 선언된 애들만 생성자의 매개변수로 들어가도록 하는 생성자 만들어줌.

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
