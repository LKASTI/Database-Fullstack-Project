package com.partytruckservice.repositories;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.partytruckservice.models.Item;
//import com.partytruckservice.models.*;
import com.partytruckservice.models.Package;

//import java.util.*;

@Repository
public class JdbcPackageRepository implements PackageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // add item to package
    @Override
    public int addItemToPackage(int itemID, int packageID, int quantity) {
        return jdbcTemplate.update(
                "INSERT INTO itemIncludesPackage (iID, pID, quantity) VALUES(?,?,?)",
                itemID, packageID, quantity);
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
    public int deletePackage(int packageID) {
        return jdbcTemplate.update(
                "DELETE Package WHERE packageID=?", packageID);
    }

    @Override
    public List<Item> getAllItemsInPackageList(int packageID) {
        return jdbcTemplate.query(
                "SELECT * FROM ITEM, itemIncludesPackage WHERE itemIncludesPackage.iID=ITEM.itemID AND itemIncludesPackage.pID=?",
                (rs, rowNum) -> 
                    new Item(
                        rs.getInt("itemID"),
                        rs.getString("name"),
                        rs.getString("manufacturer"),
                        rs.getFloat("price"),
                        rs.getInt("stock")
                    ),
                    packageID
        );
    }

    @Override
    public List<Package> getAllPresetPackages() {
        return jdbcTemplate.query(
            "SELECT * FROM package WHERE package.name LIKE 'p_%'",
            (rs, rowNum) -> 
                new Package(
                    rs.getString("name"),
                    rs.getInt("packageID"),
                    rs.getDouble("discount")
                )
        );
    }
    // @Override
    // public int updatePackageID(int packageID){
    //     return jdbcTemplate.update(
    //         "UPDATE PACKAGE SET packageID = ? WHERE packageID = ?",
    //         packageID
    //       );
    //  }
}