package hibernate;

import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Prilepishev Vadim on 11/11/2015
 */
public class EventDAOImpl implements EventDAO {

    public void addEvent(EventTable eventTable) throws SQLException {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(eventTable);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteEvent(EventTable eventTable) throws SQLException {
        Session session;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(eventTable);
        session.getTransaction().commit();
        session.close();
    }

    public EventTable getEventTable(int id) throws SQLException {
        EventTable result = null;

        Session session = null;

        session = HibernateUtil.getSessionFactory().openSession();
        result = (EventTable) session.load(EventTable.class,id);
        session.close();

        return result;
    }

    public List<EventTable> getEventsTables() throws SQLException {
        List<EventTable> events = null;

        Session session = null;

        session = HibernateUtil.getSessionFactory().openSession();
        events = session.createCriteria(EventTable.class).list();
        session.close();

        return events;
    }
}
