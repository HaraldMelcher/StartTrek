/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;

import java.util.ArrayList;
import java.util.List;

public class Galaxy {
    private final int sunCount = 30;
    private final int klingonCount = 17;
    private final int starbaseCount = 3;

    Ship ship;
    private List<Unit> units = new ArrayList<>();

    public Galaxy(String shipName) {
        placeShip(shipName);
        placeSuns();
        placeKlingons();
        placeStarbases();
    }

    public Unit[][] getShortRangeScan() {
        Position shipPosition = ship.getPosition();

        int quadrantX = shipPosition.getX()/8;
        int quadrantY = shipPosition.getY()/8;

        Unit[][] scan = new Unit[8][8];
        for (int x=0; x<8; x++) {
            for (int y =0; y<8; y++) {
                Position scanPosition = new Position(quadrantX*8+x,quadrantY*8+y);
                scan[x][y]= unitAt(scanPosition);
            }
        }
        return scan;
    }

    public void moveShip(Delta delta, int distance) {
        moveUnit(ship, delta, distance);
    }

    private void moveUnit(Unit unit, Delta delta, int distance) {
        for (int d=0; d<distance; d++) {
            Position oldPos = unit.getPosition();
            Position newPos = oldPos.add(delta);
            Unit obstacle = unitAt(newPos);
            if (obstacle != null) {
                System.out.println("You have hit a "+obstacle);
                break;
            }
            unit.setPosition(newPos);
        }
    }

    private void placeKlingons() {
        for (int k=0; k<klingonCount; k++)
            placeUnit(new Klingon());
    }

    private void placeStarbases() {
        for (int sb=0; sb<starbaseCount; sb++)
            placeUnit(new Starbase());
    }

    private void placeShip(String shipName) {
        ship = new Ship(shipName);
        placeUnit(ship);
    }

    private void placeSuns() {
        for (int s = 0; s < sunCount; s++)
            placeUnit(new Sun());
    }

    private void placeUnit(Unit unit) {
        Position position;

        do {
            position = Position.random();
        } while (!placeUnitAt(unit, position));
    }

    private boolean placeUnitAt(Unit unit, Position position) {
        if (unitAt(position) != null)
            return false;

        unit.setPosition(position);
        units.add(unit);
        return true;
    }

    private Unit unitAt(Position position) {
        for (Unit other : units)
            if (other.getPosition().equals(position))
                return other;
        return null;
    }


}
