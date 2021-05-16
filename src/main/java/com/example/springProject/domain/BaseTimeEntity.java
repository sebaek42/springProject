package com.example.springProject.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA Entity 클래스들이 BaseTimeEntity를 상속할 경우 해당 클래스의 필드들도 칼럼으로 인식하게 됨 -> Post 엔티티 클래스가 얘를 상속하도록 하자
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 포함시킴. 활성화 시키려면 @EnableJpaAuditing 노테이션을 써줘야함. 모든곳에서 활성화시킬것이므로 Application클래스에 써줌
public abstract class BaseTimeEntity{ // 모든 엔티티의 상위 클래스가 되어 엔티티들의 createdDate, modifiedDate를 자동으로 관리하는 역할을 함

    @CreatedDate // Entity가 생성되어 저장될 때 자동으로 시간이 저장됨
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 entity의 값을 변경할 때 시간이 자동 저장됨
    private LocalDateTime modifiedDate;
}
