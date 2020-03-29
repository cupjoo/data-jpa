package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name="ORDER_ITEM_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;

    private int orderPrice;
    private int count;

    @Builder
    public OrderItem(Order order, Item item, int orderPrice, int count) {
        this.order = order;
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }
}
