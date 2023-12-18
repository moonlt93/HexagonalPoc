package com.bookspider.pilot.item.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "item_mast")
@RequiredArgsConstructor
@Getter
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Builder
    public Item(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
