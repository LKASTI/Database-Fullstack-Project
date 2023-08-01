package com.partytruckservice.controllers;

import com.partytruckservice.models.Package;
import com.partytruckservice.repositories.JdbcPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
// read packages
// delete packages maybe
// addItemToPackage( int packageID)
// remove item from package
// get items in package
@RestController
@CrossOrigin
@RequestMapping("/Package")
public class packageController {
    @Autowired
    private JdbcPackageRepository jdbcPackageRepository;
    
    //create package(Package pack)
    @PostMapping("/create")
    public int create(@RequestBody Map<String, String> body){
        int packageID = Integer.parseInt(body.get("packageID"));
        String name = body.get("name");
        double discount = Integer.parseInt(body.get("discount"));
      
        Package pack = new Package(name, packageID, discount);

        return jdbcPackageRepository.save(pack);
    }

    // updatePackageID(int packageID)
    @PutMapping("/updatePackage{name}/{packageID}/{discount}")
    public int updatePackage(@PathVariable String name, @PathVariable int packageID, @PathVariable int discount){
        return jdbcPackageRepository.updatePackage(name, packageID, discount);
    }

    @GetMapping("/getAllPresetPackages")
    public List<Package> getAllPresetPackages(){
        return jdbcPackageRepository.getAllPresetPackages();
    }

    @GetMapping("/getAllItemsInPackageList")
    public List<Item> getAllItemsInPackageList(@PathVariable int packageID){
        return jdbcPackageRepository.getAllItemsInPackageList(packageID);
    }

    //  addItemToPackage(int itemID, Package pack, int quantity)
    @PutMapping("/addItemToPackage{itemID}/{pack}/{quantity}")
    public int updatePackage(@PathVariable int itemID, @PathVariable int packageID, @PathVariable int quantity){
        return jdbcPackageRepository.addItemToPackage(itemID, packageID, quantity);
    }
}