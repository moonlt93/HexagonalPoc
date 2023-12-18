package com.bookspider.pilot.order.repository;

import com.bookspider.pilot.order.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders, Long> {

    @Query("select o from Orders o left join fetch o.items")
    List<Orders> findAllOrderWithItemList();
}
