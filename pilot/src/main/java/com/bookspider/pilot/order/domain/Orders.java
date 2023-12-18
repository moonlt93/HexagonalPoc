package com.bookspider.pilot.order.domain;

import com.bookspider.pilot.member.domain.Member;
import com.bookspider.pilot.orderitem.domain.OrderItem;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "Orders")
@NoArgsConstructor
public class Orders {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    @OneToOne
    private Member orderer;

    @Builder
    public Orders(Long id, List<OrderItem> items, Member orderer) {
        this.id = id;
        this.items = items;
        this.orderer = orderer;
    }
}