package model;

import exception.UberManagerException;
import org.apache.log4j.Logger;
import service.UberManager;

public class User extends Thread {

    private static final Logger LOGGER = Logger.getLogger(User.class);

    private String userName;
    private Coordinates startCoordinates;
    private Coordinates endCoordinates;
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


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", startCoordinates=" + startCoordinates +
                ", endCoordinates=" + endCoordinates +
                ", uberManager=" + manager +
                '}';
    }

    @Override
    public void run() {
        try {
            LOGGER.info("пользователь " + getUserName() + " вызывает такси");
            Taxi taxiNear = manager.getTaxi(this);
            taxiNear.runOrder(this);
            manager.deleteUser(this);
            LOGGER.info(taxiNear.getNameTaxi() + " подвёз " + userName);
        } catch (UberManagerException e) {
            LOGGER.error("UberManagerException");
            Thread.currentThread().interrupt();
        }

    }
}
