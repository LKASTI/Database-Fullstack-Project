package com.partytruckservice.controllers;

import com.partytruckservice.models.Item;
import com.partytruckservice.repositories.JdbcItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

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
    public int create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String name = body.get("name");
        String manufacturer = body.get("manufacturer");
        int stock = Integer.parseInt(body.get("stock"));
        float price = Float.parseFloat(body.get("price"));
        Item item = new Item(id, name, manufacturer, price, stock);

        return jdbcItemRepository.save(item);
    }

    @PutMapping("/updateItemStock{stock}/{name}")
    public int updateItemStock(@PathVariable int stock, @PathVariable String name){
        return jdbcItemRepository.updateItemStock(name, stock);
    }

    @GetMapping("/getAllItems")
    public List<Item> getAllItems(){
        return jdbcItemRepository.getAllItems();
    }
}
