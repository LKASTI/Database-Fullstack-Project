package com.partytruckservice.repositories;

import com.partytruckservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class JdbcPackageRepository implements PackageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // add item to package
    @Override
    public int addItemToPackage(int itemID, PACKAGE pack, int quantity) {
        return jdbcTemplate.update(
                "INSERT INTO itemIncludesPackage (iID, pID, quantity) VALUES(?,?,?)",
                itemID, pack.getPackageID(), quantity);
    }

    // remove item from package
    @Override
    public int removeItemFromPackage(int itemID, int packageID) {
        return jdbcTemplate.update(
                "DELETE itemIncludesPackage WHERE iID=? AND pID=?",
                itemID, packageID);
    }

    @Override
    public int save(PACKAGE pack) {
        return jdbcTemplate.update(
                "INSERT INTO PACKAGE (packageID, name, discount) VALUES(?,?,?)",
                pack.getPackageID(), pack.getName(), pack.getDiscount());
    }

    @Override
    public int deletePackage(PACKAGE pack) {
        return jdbcTemplate.update(
                "DELETE PACKAGE WHERE packageID=?", pack.getPackageID());
    }

    @Override
    public int getAllItemsInPackageList(PACKAGE pack) {
        return jdbcTemplate.update(
                "SELECT ITEM.name FROM ITEM, itemIncludesPackage WHERE itemIncludesPackage.iID=ITEM.itemID AND itemIncludesPackage.pID=?",
                pack.getPackageID());
    }

    @Override
    public int getAllPresetPackages(PACKAGE pack) {
        return jdbcTemplate.update(
                "SELECT PACKAGE.name FROM PACKAGE WHERE PACKAGE.packageID=?",
                "p_*"); // the p_* is the identifier in the database for what is a preset package.
    }
}
