package com.example.springProject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> { // 이렇게 단순히 인터페이스 생성 후 JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") // 제공되는 기본메소드가 있긴한데 이렇게 쿼리 만들어서 쓸수도있음을 보임
    List<Posts> findAllDesc();
}
