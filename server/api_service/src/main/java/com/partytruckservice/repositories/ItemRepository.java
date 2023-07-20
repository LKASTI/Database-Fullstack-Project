package com.partytruckservice.ItemRepository;

import com.partytruckservice.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    
    int count();

    int save(Item item);

    int updateItemStock(Item item);

    int deleteById(in id);

    List<Item> findAll();

    List<Item> findByName(String name);

    // Optional<Item> findById(int id);

    String getNameById(int id);
}
