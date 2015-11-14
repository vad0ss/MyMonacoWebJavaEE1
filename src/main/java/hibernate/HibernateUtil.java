package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by User on 11/11/2015.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() { };

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        //configuration.configure("/src/main/resources/hibernate.cfg.xml");

        //ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
}
