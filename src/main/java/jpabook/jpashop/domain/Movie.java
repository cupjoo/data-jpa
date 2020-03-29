package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Builder
@Getter
@Entity
public class Movie extends Item {

    private String director;
    private String actor;
}
