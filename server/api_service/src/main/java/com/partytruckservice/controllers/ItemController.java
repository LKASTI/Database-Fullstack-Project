package com.partytruckservice.controllers;

import com.partytruckservice.item.models.Item;
import com.partytruckservice.repositories.JdbcItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {
    //create an item 
    //edit stock of item
    //list all items
    //get item by name

    @Autowired
    private JdbcItemRepository jdbcItemRepository;

    @PostMapping("/create")
    public Item create(@RequestBody Item item){
        return jdbcItemRepository.save(item);
    }

    @PutMapping("/updateItemStock{stock, name}")
    public Item updateItemStock(@PathVariable int stock, @PathVariable String name){
        return jdbcItemRepository.updateItemStock(stock, name);
    }

    @GetMapping
    public List<Item> findAll(){
        return jdbcItemRepository.findAll();
    }
}
