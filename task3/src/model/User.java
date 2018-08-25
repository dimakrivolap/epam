package model;

import org.apache.log4j.Logger;
import service.UberManager;

import java.util.concurrent.TimeUnit;

public class User extends Thread {

    private final static Logger LOGGER = Logger.getLogger(User.class);

    private String userName;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
    private Taxi taxi;
    private UberManager manager;

    public User(String userName, Coordinates startCoordinates, Coordinates endCoordinates, UberManager uberManager) {
        this.userName = userName;
        this.startCoordinates = startCoordinates;
        this.endCoordinates = endCoordinates;
        this.manager = uberManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Coordinates getStartCoordinates() {
        return startCoordinates;
    }

    public void setStartCoordinates(Coordinates startCoordinates) {
        this.startCoordinates = startCoordinates;
    }

    public Coordinates getEndCoordinates() {
        return endCoordinates;
    }

    public void setEndCoordinates(Coordinates endCoordinates) {
        this.endCoordinates = endCoordinates;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", startCoordinates=" + startCoordinates +
                ", endCoordinates=" + endCoordinates +
                ", taxi=" + taxi +
                ", uberManager=" + manager +
                '}';
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("пользователь "+getUserName()+" вызывает такси");
            //manager.findTaxi(this);
            //manager.addUser(this);
            Taxi taxiNear = manager.getTaxi(this);
            taxiNear.runOrder(this);
            manager.deleteUser(this);
            //System.out.println(manager.getUsers());

            System.out.println(userName + " приехал");

            //waitTaxi();
            //Taxi taxi = manager.findTaxi(this);

        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
