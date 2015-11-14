package hibernate;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Prilepishev Vadim on 11/11/2015
 */

@DynamicUpdate
@Table(appliesTo = "event")
public class EventTable {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="User_ID")
    private int user_id;

    @Column(name="Place_ID")
    private int place_id;

    @Column(name = "Event")
    private String event;

    public void setId(int id){
        this.id = id;
    }

    public void setUser_id(int user_id){
        this.user_id = user_id;
    }

    public void setPlace_id(int place_id){
        this.place_id = place_id;
    }

    public void setEvent(String event){
        this.event = event;
    }

    public int getId(){
        return id;
    }

    public int getUser_id(){
        return user_id;
    }

    public int getPlace_id(){
        return place_id;
    }

    public String getEvent(){
        return event;
    }

}
