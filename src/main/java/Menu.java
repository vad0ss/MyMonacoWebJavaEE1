import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by Prilepishev Vadim on 11/10/2015.
 */
public class Menu {

    private static final String STANDART_CONNECTION_TEXT = "1. Стандартное соединение";
    private static final String HIBERNATE_CONNECTION_TEXT = "2. Hibernate";
    private static final String ADD_EVENT_TEXT = "1. Добавить событие.";
    private static final String SELECT_ALL_EVENT_TEXT = "2. Показать все события";
    private static final String DELETE_EVENT_TEXT = "3. Удалить событие.";
    private static final String CLOSE_CONNECTION_TEXT = "4. Закрыть соединение.";
    private static final String ENTER_EVENT_ID = "Введите ID события";


    static Scanner userInput = new Scanner(System.in);
    static Scanner userQueryInput = new Scanner(System.in);

    public static String connectMenu() {

        int connectionType;
        System.out.println(STANDART_CONNECTION_TEXT);
        System.out.println(HIBERNATE_CONNECTION_TEXT);
        connectionType = userInput.nextInt();

        if(connectionType == 1) return "standart";
        else return "hibernate";
    }

    public static void connectStatus() {
        try {
            if(!JDBCStandartFabricConnect.connect.isClosed()) {
                System.out.println(JDBCStandartFabricConnect.checkConnection(JDBCStandartFabricConnect.connect));
            } else {
                System.out.println(JDBCStandartFabricConnect.checkConnection(JDBCStandartFabricConnect.connect));
            }
        } catch (SQLException e) {
            System.err.println(JDBCStandartFabricConnect.CONNECT_ERROR_MESSAGE);
        }

    }

    public static void queryTypeMenu(){
        int queryType;

        System.out.println(ADD_EVENT_TEXT);
        System.out.println(SELECT_ALL_EVENT_TEXT);
        System.out.println(DELETE_EVENT_TEXT);
        System.out.println(CLOSE_CONNECTION_TEXT);
        queryType = userInput.nextInt();

        if(queryType == 1) addEventMenu();
        if(queryType == 2) selectAllMenu();
        if(queryType == 3) deleteEventWhereIdMenu();
        if(queryType == 4) try {
            JDBCStandartFabricConnect.connect.close();
        } catch (SQLException e) {
            System.err.println(JDBCStandartFabricConnect.CONNECT_ERROR_MESSAGE);
        }
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

        StandartPreparedStatement.addEvent(user_id,place_id,event_val);
    }

    public static void selectAllMenu() {
          StandartPreparedStatement.selectEventAll();
    }

    public static void deleteEventWhereIdMenu() {
        int id;
        System.out.println(ENTER_EVENT_ID);
        id = userQueryInput.nextInt();
        StandartPreparedStatement.deleteEventWhereId(id);
    }

}
