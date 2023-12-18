package com.bookspider.pilot.item.service;


import com.bookspider.pilot.item.domain.Item;
import com.bookspider.pilot.item.dto.CreateItemDto;
import com.bookspider.pilot.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Long createItem(CreateItemDto createItemDto) {
        Item newItem = Item.builder()
                .name(createItemDto.getName())
                .build();

        Item createdItem = itemRepository.save(newItem);
        return createdItem.getId();
    }

    public List<Item> getAllItem() {
        return itemRepository.findAll();
    }

}
