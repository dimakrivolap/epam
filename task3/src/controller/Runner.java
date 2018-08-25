package controller;

import model.Coordinates;
import model.Taxi;
import model.User;
import org.omg.PortableServer.THREAD_POLICY_ID;
import service.UberManager;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        UberManager manager = UberManager.getInstance();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            Taxi taxi = new Taxi("taxi" + i, Coordinates.getRandomCoordinates(), manager);
            manager.addTaxi(taxi);

        }
        for (int i = 0; i < 20; i++) {
            User user = new User("user" + i, Coordinates.getRandomCoordinates(), Coordinates.getRandomCoordinates(), manager);
            manager.addUser(user);
        }


        for (User user : manager.getUsers()) {
            user.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        }
        catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println(manager.getUsers());
        System.out.println("end");

    }
}
