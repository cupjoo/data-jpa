package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    private Long itemId;
    private int orderPrice;
    private int count;
}