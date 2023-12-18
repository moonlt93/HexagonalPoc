package com.bookspider.pilot.item.repository;


import com.bookspider.pilot.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
