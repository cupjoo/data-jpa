package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@Entity
public class Delivery extends BaseEntity {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @OneToOne(mappedBy = "DELIVERY")
    private Delivery delivery;
}
