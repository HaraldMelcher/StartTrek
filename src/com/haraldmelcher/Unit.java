/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;

public abstract class Unit {
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
