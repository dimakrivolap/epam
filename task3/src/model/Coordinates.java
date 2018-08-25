package model;

import java.util.Random;

public class Coordinates {
    private double x;
    private double y;

    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates getRandomCoordinates() {
        Random r = new Random();
        return new Coordinates(r.nextDouble(), r.nextDouble());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static double getDistation(Coordinates c1, Coordinates c2) {
        return Math.hypot(c1.x - c2.x, c1.y - c2.y);
    }


}
