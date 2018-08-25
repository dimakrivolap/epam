package model;

import org.apache.log4j.Logger;
import service.UberManager;

public class Taxi {

    private final static Logger LOGGER = Logger.getLogger(User.class);
    private String nameTaxi;
    private Coordinates location;
    private UberManager manager;

    public Taxi(String nameTaxi, Coordinates location, UberManager uberManager) {
        this.nameTaxi = nameTaxi;
        this.location = location;
        this.manager = uberManager;
    }

    public String getNameTaxi() {
        return nameTaxi;
    }

    public void setNameTaxi(String nameTaxi) {
        this.nameTaxi = nameTaxi;
    }

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "nameTaxi='" + nameTaxi + '\'' +
                ", location=" + location +
                '}';
    }

    public void runOrder(User user) {
        System.out.println("Заказ выполняется: " + nameTaxi + " везет " + user.getUserName());
        //LOGGER.info("Заказ выполняется");
    }
}
