package service;

import model.Coordinates;
import model.Taxi;
import model.User;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UberManager {
    private final static int QUANTITY = 5;
    private final Semaphore semaphore = new Semaphore(QUANTITY, true);
    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static UberManager instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private Deque<User> users = new ArrayDeque<>();

    public static UberManager getInstance() {
        if (!instanceCreated.get()) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new UberManager();
                    instanceCreated.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }


    public void addUser(User user) {
        users.offer(user);
    }

    public Taxi getTaxi(User user) {
        Taxi taxiNear;
        double distantion = 100;

        for (User user: users) {
            if (distantion > Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates())) {
                distantion = Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates());
                taxiNear = user;
            }
        }
    }
}
