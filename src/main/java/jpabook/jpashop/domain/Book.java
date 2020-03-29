package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;

@Builder
@Getter
@Entity
public class Book extends Item {

    private String author;
    private String isbn;
}
