import hibernate.EventDAO;
import hibernate.EventTable;
import hibernate.Factory;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Prilepishev Vadim on 11/11/2015.
 */
public class MenuHibernate {

    private static final String ADD_EVENT_TEXT = "1. Добавить событие.";
    private static final String SELECT_ALL_EVENT_TEXT = "2. Показать все события";
    private static final String DELETE_EVENT_TEXT = "3. Удалить событие.";
    private static final String ENTER_EVENT_ID = "Введите ID события";


    static Scanner userInput = new Scanner(System.in);
    static Scanner userQueryInput = new Scanner(System.in);

    public static Factory factory = Factory.getInstance();
    public static EventDAO eventDAO = factory.getEventDAO();

    public static void queryTypeMenu(){
        int queryType;

        System.out.println(ADD_EVENT_TEXT);
        System.out.println(SELECT_ALL_EVENT_TEXT);
        System.out.println(DELETE_EVENT_TEXT);
        queryType = userInput.nextInt();

        if(queryType == 1) addEventMenu();
        if(queryType == 2) selectAllMenu();
        if(queryType == 3) deleteEventWhereIdMenu();
    }

    public static void addEventMenu() {
        int user_id, place_id;
        String event_val;

        System.out.println("Введите ИД пользователя.");
        user_id = userQueryInput.nextInt();

        System.out.println("Введите ИД места.");
        place_id = userQueryInput.nextInt();

        System.out.println("Введите событие.");
        event_val = userQueryInput.next();

        EventTable eventTable = new EventTable();
        eventTable.setUser_id(user_id);
        eventTable.setPlace_id(place_id);
        eventTable.setEvent(event_val);

        try {
            eventDAO.addEvent(eventTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectAllMenu() {
        List<EventTable> events = null;
        try {
            events = eventDAO.getEventsTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(EventTable eventTable : events){
            System.out.println("ID: " +eventTable.getId()+
                               " User ID: " +eventTable.getUser_id()+
                               " Place ID:" +eventTable.getPlace_id()+
                               " Event: " +eventTable.getEvent());
        }

    }

    public static void deleteEventWhereIdMenu() {
        int id;
        System.out.println(ENTER_EVENT_ID);
        id = userQueryInput.nextInt();
        EventTable eventTable = new EventTable();
        eventTable.setId(id);

        try {
            eventDAO.deleteEvent(eventTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
