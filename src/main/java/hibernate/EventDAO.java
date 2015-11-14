package hibernate;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Prilepishev Vadim on 11/11/2015.
 */
public interface EventDAO {
     public void addEvent(EventTable eventTable) throws SQLException;
     public void deleteEvent(EventTable eventTable) throws SQLException;
     public EventTable getEventTable(int id) throws SQLException;
     public List<EventTable> getEventsTables() throws SQLException;

}
