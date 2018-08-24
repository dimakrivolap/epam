package model;

import org.apache.log4j.Logger;

public class Taxi {

    private final static Logger LOGGER = Logger.getLogger(User.class);
    private String nameTaxi;
    private Coordinates location;

    public Taxi(String nameTaxi, Coordinates location) {
        this.nameTaxi = nameTaxi;
        this.location = location;
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
        LOGGER.info("Заказ выполняется");
    }
}
