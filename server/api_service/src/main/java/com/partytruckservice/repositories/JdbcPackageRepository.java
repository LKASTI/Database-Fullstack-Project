package com.partytruckservice.repositories;

//import com.partytruckservice.models.*;
import com.partytruckservice.models.Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

//import java.util.*;

@Repository
public class JdbcPackageRepository implements PackageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // add item to package
    @Override
    public int addItemToPackage(int itemID, Package pack, int quantity) {
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
    public int save(Package pack) {

        return jdbcTemplate.update(
                "INSERT INTO Package (packageID, name, discount) VALUES(?,?,?)",
                pack.getPackageID(), pack.getName(), pack.getDiscount());
    }

    @Override
    public int deletePackage(Package pack) {
        return jdbcTemplate.update(
                "DELETE Package WHERE packageID=?", pack.getPackageID());
    }

    @Override
    public int getAllItemsInPackageList(int packageID) {
        return jdbcTemplate.query(
                "SELECT ITEM.name FROM ITEM, itemIncludesPackage WHERE itemIncludesPackage.iID=ITEM.itemID AND itemIncludesPackage.pID=?",
                packageID);
    }

    @Override
    public int getAllPresetPackages() {
        return jdbcTemplate.query(
                "SELECT Package.name FROM Package WHERE Package.packageID=?",
                "p_*"); // the p_* is the identifier in the database for what is a preset package.
    }
    @Override
    public int updatePackage(int packageID){
        return jdbcTemplate.update(
            "UPDATE PACKAGE SET packageID = ? WHERE packageID = ?",
              pID
          );
     }
}
