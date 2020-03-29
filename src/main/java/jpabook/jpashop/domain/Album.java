package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Builder
@Getter
@Entity
public class Album extends Item {

    private String artist;
}
