package service;
/**
 * UberManager. The class Thread-Safe singleton manages taxis and users.
 * <p>
 * 25 August 2018
 *
 * @version 1.0
 * @author Dmitry Krivolap
 * @see User
 * @see Taxi
 */

import exception.UberManagerException;
import model.Coordinates;
import model.Taxi;
import model.User;
import org.apache.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class UberManager {
    private static final Logger LOGGER = Logger.getLogger(UberManager.class);

    private static AtomicBoolean instanceCreated = new AtomicBoolean();
    private static UberManager instance;
    private static ReentrantLock lock = new ReentrantLock();
    private static final int QUANTITY = 5;
    private static final Semaphore semaphore = new Semaphore(QUANTITY, true);
    private Deque<User> users = new ArrayDeque<>();
    private Deque<Taxi> taxis = new ArrayDeque<>();

    private UberManager() {
    }

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
        lock.lock();
        users.offer(user);
        lock.unlock();
    }

    public void addTaxi(Taxi taxi) {
        lock.lock();
        taxis.offer(taxi);
        lock.unlock();
    }

    public void deleteUser(User user) {
        users.remove(user);
        lock.unlock();

    }

    public void deleteTaxi(Taxi taxi) {
        taxis.remove(taxi);
        lock.unlock();

    }

    public Deque<User> getUsers() {
        try {
            lock.lock();
            return users;
        } finally {
            lock.unlock();
        }
    }

    public Deque<Taxi> getTaxis() {
        try {
            lock.lock();
            return taxis;
        } finally {
            lock.unlock();
        }
    }


    public Taxi getTaxi(User user) throws UberManagerException {
        try {
            semaphore.acquire();
            lock.lock();
            Taxi taxiNear = getTaxiNear(user);
            LOGGER.info(user.getUserName() + " нашел такси :" + taxiNear.getNameTaxi());
            return taxiNear;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new UberManagerException();
        } finally {
            semaphore.release();
        }
    }

    private Taxi getTaxiNear(User user) {
        Taxi taxiNear = taxis.getFirst();
        double distantion = Coordinates.getDistation(taxiNear.getLocation(), user.getStartCoordinates());
        for (Taxi taxi : taxis) {
            if (distantion > Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates())) {
                distantion = Coordinates.getDistation(taxi.getLocation(), user.getStartCoordinates());
                taxiNear = taxi;
            }
        }
        return taxiNear;
    }
}
