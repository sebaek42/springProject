package com.example.springProject.domain.posts;


import com.example.springProject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭함
public class Posts extends BaseTimeEntity { // 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고도 함. JPA사용하면 DB데이터에 작업할 경우 실제 쿼리를 날리기 보다 이 Entity 클래스의 수정을 통해(??) 작업할 수 있음

    @Id // 해당 필드의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄. strategy = GenerationType.IDENTITY는 auto_increment옵션
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라고 해당 클래스의 필드는 모두 칼럼이 됨. 사용하는 이유? 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용함.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
// Setter 메소드가 없다는 특이점
// 자바빈 규약을 생각하며 무작정 게터 세터 생성하는 경우가 있는데 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어 차우 기능 변경시 복잡해져
// 그래서 Entity클래스에서는 절대 Setter메소드를 만들지 않아.
// 근데 Setter가 없는 상황에서 어떻게 값을 채워서 DB에 삽입할까?
// 생성자를 통해 최종값을 채운 후 DB에 삽입하는구조. 중간에 값 변경이 필요한 경우는 해당 이벤트에 맞는 public메소드를 호출하여 변경
// 이 책에선 생성자 대신 @Builder를 통해 제공되는 빌더 클래스를 사용함. 생성자나 빌더나 생성 시점에 값을 채워준다는 역할은 같다. 다만 생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 없다
