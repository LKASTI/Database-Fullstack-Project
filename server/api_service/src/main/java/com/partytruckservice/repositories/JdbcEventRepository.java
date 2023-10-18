package com.partytruckservice.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.partytruckservice.models.dbEvent;

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
                    rs.getString("start_time"),
                    rs.getString("end_time"),
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

     @Override
     public boolean eventTimeConflict(String start_time, String end_time)
     {

            List<dbEvent> temp = jdbcTemplate.query(
            "SELECT * FROM event e WHERE ('"+start_time+"' BETWEEN e.start_time AND e.end_time)"
                                    + " OR ('"+end_time+"' BETWEEN e.start_time AND e.end_time)"
                                    + " OR (e.start_time BETWEEN '" + start_time+ "' AND '" + end_time+ "')"
                                    ,
            (rs, rowNum) -> 
                new dbEvent(
                    rs.getInt("eventID"),
                    rs.getString("location"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getInt("pID"),
                    rs.getInt("cID")
                )
            );

        if(temp.isEmpty())
            return false;
        else 
            return true;
                   
     }

     @Override
     public List<dbEvent> getEventForCustomer(int cID)
     {

         List<dbEvent> temp = jdbcTemplate.query(
              "SELECT * FROM event e WHERE cID = " + cID + ";",
            (rs, rowNum) -> 
                new dbEvent(
                    rs.getInt("eventID"),
                    rs.getString("location"),
                    rs.getString("start_time"),
                    rs.getString("end_time"),
                    rs.getInt("pID"),
                    rs.getInt("cID")
                )
            );

            return temp;


     }

}
