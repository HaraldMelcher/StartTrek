/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarTrek {

    private Galaxy galaxy = new Galaxy("Voyager");
    private Display display = new Display();

    BufferedReader inputLineReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() {
        boolean gameRunning = true;

        do {
            System.out.print("\nCommand: ");
            String inputLine = "";

            try {
                inputLine = inputLineReader.readLine();
            } catch (IOException e) {
                System.out.println("There was an error in your input - please try something different");
            }
            String[] inputParts = inputLine.toLowerCase().split(" ");
            String command = inputParts[0];

            switch (command) {
                case "exi": gameRunning = false; break;
                case "srs": shortRangeScan(); break;
                case "nav": navigate(inputParts); break;
                default:    System.out.println("I don't understand "+command); break;
            }
        }while(gameRunning);
    }

    private void navigate(String[] inputParts) {
        int distance = 2;

        Delta delta = deltaFromCompas(inputParts[1]);
        galaxy.moveShip(delta, distance);
    }

    private Delta deltaFromCompas(String compasDirection) {
        int dx=0;
        int dy=0;

        switch(compasDirection) {
            case "n": dy = -1; break;
            case "e": dx = 1; break;
            case "s": dy = 1; break;
            case "w": dx = -1; break;
        }
        return new Delta(dx,dy);
    }

    private void shortRangeScan() {
        Unit[][] scanOfCurrentQuadrant = galaxy.getShortRangeScan();
        System.out.println("Short Range Scan (srs):");
        display.drawQuandrant(scanOfCurrentQuadrant);
    }
}
