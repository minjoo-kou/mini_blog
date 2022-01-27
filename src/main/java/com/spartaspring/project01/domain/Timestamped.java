package com.spartaspring.project01.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 상속했을 때, 멤버변수를 컬럼으로 인식하게 합니다.
@EntityListeners(AuditingEntityListener.class) // 생성/수정 시간을 자동으로 반영하도록 설정
//new X, abstract : (추상) 직접 구현 안 되고 상속으로만 쓸 수 있다
public abstract class Timestamped {

    @CreatedDate // 생성일자임을 나타냅니다.
    //LocalDateTime : 시간을 나타내는 자바 자료형 중 하나
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자임을 나타냅니다.
    private LocalDateTime modifiedAt;
}