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
    private static ReentrantLock lockOperation = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private Deque<User> users = new ArrayDeque<>();
    private Deque<Taxi> taxis = new ArrayDeque<>();

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


    public void deleteUser(User user) {
        users.remove(user);
        lockOperation.unlock();
    }

    public void addUser(User user) {
        lockOperation.lock();
        users.offer(user);
        lockOperation.unlock();
    }

    public void deleteTaxi(Taxi taxi) {
        taxis.remove(taxi);
        lockOperation.unlock();
    }

    public void addTaxi(Taxi taxi) {

        lockOperation.lock();
        taxis.offer(taxi);
        lockOperation.unlock();


    }

    public Deque<User> getUsers() {
        try {
            lockOperation.lock();
            return users;
        } finally {
            lockOperation.unlock();
        }
    }

    public Deque<Taxi> getTaxis() {
        try {
            lockOperation.lock();
            return taxis;
        } finally {
            lockOperation.unlock();
        }
    }


    public Taxi getTaxi(User user) {
        try {
            lockOperation.lock();

            Taxi taxiNear = taxis.getFirst();
            double distantion = Coordinates.getDistation(taxiNear.getLocation(), user.getStartCoordinates());
            for (Taxi taxi : taxis) {
                if (distantion > Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates())) {
                    distantion = Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates());
                    taxiNear = taxi;
                }
            }
            return taxiNear;
        } finally {
            //lockOperation.unlock();
        }
    }
}
