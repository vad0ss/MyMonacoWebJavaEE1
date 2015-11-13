import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 11/10/2015.
 */
public class StandartPreparedStatement {

    static PreparedStatement preparedStatement = null;
    public static final String addEventQuery = "INSERT INTO event(User_ID,Place_ID,Event) VALUES(?,?,?)";
    public static final String selectEventAll = "SELECT * FROM event";
    public static final String deleteEventWhereId = "DELETE FROM event WHERE ID = ?";

    public static void addEvent(int user_id,int place_id, String event_val){
        try {
            preparedStatement = JDBCStandartFabricConnect.connect.prepareStatement(addEventQuery);
            preparedStatement.setInt(1,user_id);
            preparedStatement.setInt(2,place_id);
            preparedStatement.setString(3,event_val);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.err.println(JDBCStandartFabricConnect.CONNECT_ERROR_MESSAGE);
        }

    }

   public static void selectEventAll(){
       try {
           preparedStatement = JDBCStandartFabricConnect.connect.prepareStatement(selectEventAll);
           ResultSet resultSelect = preparedStatement.executeQuery();

           while (resultSelect.next()) {
               int id = resultSelect.getInt("ID");
               int user_id = resultSelect.getInt("User_ID");
               int place_id = resultSelect.getInt("Place_ID");
               String event = resultSelect.getString("Event");

               System.out.println("ID: " + id + ", User ID: " + user_id + ",Place ID:" + place_id + ",Event " + event);
           }

       } catch (SQLException e) {
           System.err.println(JDBCStandartFabricConnect.CONNECT_ERROR_MESSAGE);
       }

   }

   public static void deleteEventWhereId(int id){
       try {
           preparedStatement = JDBCStandartFabricConnect.connect.prepareStatement(deleteEventWhereId);
           preparedStatement.setInt(1,id);
           preparedStatement.execute();
       } catch (SQLException e) {
           System.err.println(JDBCStandartFabricConnect.CONNECT_ERROR_MESSAGE);
       }
   }
}