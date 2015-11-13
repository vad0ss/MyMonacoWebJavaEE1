package hibernate;

/**
 * Created by User on 11/11/2015.
 */
public class Factory {
    public static Factory instance = new Factory();
    public EventDAO eventDAO;

    private Factory(){ };

    public static Factory getInstance(){
       return Factory.instance;
    }

    public EventDAO getEventDAO(){
        if(eventDAO == null) eventDAO = new EventDAOImpl();
        return eventDAO;
    }

}
