package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    
    int count();

    int save(Item item);

    int updateItemStock(String name, int stock);

    int deleteById(int id);

    List<Item> findAll();

    // List<Item> findByName(String name);

    // Optional<Item> findById(int id);

    // String getNameById(int id);
}
