package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.Package_;

import java.util.*;

public interface PackageRepository {

    int addItemToPackage(int itemID, Package_ pack, int quantity);

    int removeItemFromPackage(int itemID, int packageID);

    int save(Package_ pack);

    int deletePackage(Package_ pack);

    int getAllItemsInPackageList(Package_ pack); // should be a List<Item>

    int getAllPresetPackages(Package_ pack); // should be List<PACKAGE>
}
