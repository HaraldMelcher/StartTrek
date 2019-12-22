/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;

import java.util.Random;

public class Position {

    private int x;
    private int y;

    private static Random random = new Random();

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public static Position random() {
        return new Position(random.nextInt(64), random.nextInt(64));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = sanitize(x);
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = sanitize(y);
    }

    public Position add(Delta delta) {
        return new Position(x+delta.getDx(), y+delta.getDy());
    }

    @Override
    public int hashCode() {
        return getX() + getY() * 64;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Position))
            return false;

        Position other = (Position) obj;
        return getX() == other.getX() && getY() == other.getY();
    }

    @Override
    public String toString() {
        return "Quadrant(" + getX() / 8 + ", " + getY() / 8 + ") Sector(" + getX() % 8 + ", " + getX() % 8 + ")";
    }

    private int sanitize(int val) {
        while (val < 0)
            val += 64;
        while (val >= 64)
            val -= 64;
        return val;
    }

}
