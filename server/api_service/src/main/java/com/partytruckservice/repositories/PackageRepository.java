package com.partytruckservice.repositories;

import java.util.List;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.Package;

//import java.util.*;

public interface PackageRepository {

    int addItemToPackage(int itemID, int packageID, int quantity);

    int removeItemFromPackage(int itemID, int packageID);

    // int updatePackageID(int packageID);

    int save(Package pack);

    int deletePackage(int packageID);

    List<Item> getAllItemsInPackageList(int packageID); // should be a List<Item>

    List<Package> getAllPresetPackages(); // should be List<Package>
}