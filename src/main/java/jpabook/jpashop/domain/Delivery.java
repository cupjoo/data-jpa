package jpabook.jpashop.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name="DELIVERY_ID")
    private Long id;

    private String city;
    private String street;
    private String zipcode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Builder
    public Delivery(String city, String street, String zipcode, DeliveryStatus status) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.status = status;
    }
}
