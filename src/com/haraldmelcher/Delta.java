/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;

public class Delta {

    private final int dx;
    private final int dy;

    public Delta(int dx, int dy){

        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
