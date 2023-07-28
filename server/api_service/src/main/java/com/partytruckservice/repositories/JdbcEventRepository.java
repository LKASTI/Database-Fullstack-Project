package com.partytruckservice.repositories;

import com.partytruckservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcEventRepository implements EventRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM event", Integer.class);
    }

    @Override
    public int save(dbEvent event){
        return jdbcTemplate.update(
            "INSERT INTO event (eventID, location, start_time, end_time, pID, cID) VALUES(?,?,?,?,?,?)",
            event.getEventID(), event.getLocation(), event.getStart_Time(), event.getEnd_Time(), event.getpID(), 
            event.getcID()
        );
    }
    
    @Override
    public int deleteById(int id){
        return jdbcTemplate.update(
            "DELETE item WHERE eventID = ?",
            id
        );
    }

    @Override
    public List<dbEvent> getAllEvents(){
        return jdbcTemplate.query(
            "SELECT * FROM event",
            (rs, rowNum) -> 
                new dbEvent(
                    rs.getInt("eventId"),
                    rs.getString("location"),
                    rs.getDate("start_time"),
                    rs.getDate("end_time"),
                    rs.getInt("pID"),
                    rs.getInt("cID")
                )
        );
    }

    @Override
    public int updateEventCustomer(int cID, int eventID){ 
        return jdbcTemplate.update(
            "UPDATE event SET cID = ? WHERE eventID = ?",
              cID, eventID
          );
        
    }
    
    @Override
    public int updateEventPackage(int pID, int eventID){
        return jdbcTemplate.update(
            "UPDATE event SET pID = ? WHERE eventID = ?",
              pID, eventID
          );
     }

}
