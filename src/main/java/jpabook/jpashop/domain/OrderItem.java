package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @Column(name="ORDER_ID")
    private Long orderId;

    @Column(name="ITEM_ID")
    private Long itemId;

    private int orderPrice;

    private int count;

    @Builder
    public OrderItem(Long itemId, int orderPrice, int count) {
        this.itemId = itemId;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
