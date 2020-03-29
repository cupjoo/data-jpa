package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Getter
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    @Column(name="ITEM_ID")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

}
