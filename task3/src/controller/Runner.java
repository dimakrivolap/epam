package controller;
/**
 * Runner.
 * <p>
 * 25 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 */

import model.Coordinates;
import model.Taxi;
import model.User;
import service.UberManager;

public class Runner {
    public static void main(String[] args) {
        UberManager manager = UberManager.getInstance();
        for (int i = 0; i < 5; i++) {
            Taxi taxi = new Taxi("taxi" + i, Coordinates.getRandomCoordinates());
            manager.addTaxi(taxi);
        }
        for (int i = 0; i < 20; i++) {
            User user = new User("user" + i, Coordinates.getRandomCoordinates(), Coordinates.getRandomCoordinates(), manager);
            manager.addUser(user);
        }
        for (User user : manager.getUsers()) {
            user.start();
        }
    }
}
