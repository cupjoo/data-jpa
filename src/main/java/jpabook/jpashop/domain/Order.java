package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Order {

    @Id @GeneratedValue
    private Long id;
    private Long memberId;
    private LocalDate orderDate;
}
