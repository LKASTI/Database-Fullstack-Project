package com.partytruckservice.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.Package;
import com.partytruckservice.repositories.JdbcPackageRepository;
// delete packages maybe
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
        double discount = Double.parseDouble(body.get("discount"));
      
        Package pack = new Package(name, packageID, discount);

        return jdbcPackageRepository.save(pack);
    }
    
    //get preset packages
    @GetMapping("/getAllPresetPackages")
    public List<Package> getAllPresetPackages(){
        return jdbcPackageRepository.getAllPresetPackages();
    }

    //get items in package
    @GetMapping("/getAllItemsInPackageList")
    public List<Item> getAllItemsInPackageList(@PathVariable int packageID){
        return jdbcPackageRepository.getAllItemsInPackageList(packageID);
    }

    //  addItemToPackage(int itemID, Package pack, int quantity)
    @PutMapping("/addItemToPackage{itemID}/{packageID}/{quantity}")
    public int addItemToPackage(@PathVariable int itemID, @PathVariable int packageID, @PathVariable int quantity){
        return jdbcPackageRepository.addItemToPackage(itemID, packageID, quantity);
    }

    // remove item from package
    @PutMapping("/removeItemFromPackage{itemID}/{packageID}")
    public int removeItemFromPackage(@PathVariable int itemID, @PathVariable int packageID){
        return jdbcPackageRepository.removeItemFromPackage(itemID, packageID);
    }
    
    //remove package
    @PutMapping("/deletePackage{packageID}")
    public int deletePackage(@PathVariable int packageID){
        return jdbcPackageRepository.deletePackage(packageID);
    }
}