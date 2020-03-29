package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Builder
@Getter
@NoArgsConstructor
@Entity
public class Album extends Item {

    private String artist;
}
