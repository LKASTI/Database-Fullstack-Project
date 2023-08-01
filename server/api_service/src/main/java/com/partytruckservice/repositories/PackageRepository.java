package com.partytruckservice.repositories;

//import com.partytruckservice.models.Item;
import com.partytruckservice.models.Package;
//import java.util.*;

public interface PackageRepository {

    int addItemToPackage(int itemID, Package pack, int quantity);

    int removeItemFromPackage(int itemID, int packageID);

    int updatePackageID(int packageID);

    int save(Package pack);

    int deletePackage(Package pack);

    int getAllItemsInPackageList(int packageID); // should be a List<Item>

    int getAllPresetPackages(); // should be List<Package>
}
