package com.partytruckservice.repositories;

import com.partytruckservice.models.Item;
import com.partytruckservice.models.PACKAGE;

import java.util.*;

public interface PackageRepository {

    int addItemToPackage(int itemID, PACKAGE pack, int quantity);

    int removeItemFromPackage(int itemID, int packageID);

    int save(PACKAGE pack);

    int deletePackage(PACKAGE pack);

    int getAllItemsInPackageList(PACKAGE pack); // should be a List<Item>

    int getAllPresetPackages(PACKAGE pack); // should be List<PACKAGE>
}
