package com.bookspider.pilot.item.controller;

import com.bookspider.pilot.item.domain.Item;
import com.bookspider.pilot.item.dto.CreateItemDto;
import com.bookspider.pilot.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item")
    public Long createItem(@RequestBody CreateItemDto createItemDto) {
        return itemService.createItem(createItemDto);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItem();
    }
}
