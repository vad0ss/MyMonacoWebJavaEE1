
/**
 * Created by Prilepishev Vadim on 11/10/2015
 */
public class Main {


    public static void main(String[] args) {

        if (Menu.connectMenu() == "standart") {
             JDBCStandartFabricConnect.getConnection();
             Menu.connectStatus();
             Menu.queryTypeMenu();
             Menu.connectStatus();
             } else {
              MenuHibernate.queryTypeMenu();
        }
    }
}