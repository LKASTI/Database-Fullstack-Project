package com.partytruckservice.repositories;

import java.util.List;

import com.partytruckservice.models.Item;

public interface ItemRepository {
    
    Integer count();

    int save(Item item);

    int updateItemStock(String name, int stock);

    int deleteById(int id);

    List<Item> getAllItems();

    // List<Item> findByName(String name);

    // Optional<Item> findById(int id);

    // String getNameById(int id);
}
