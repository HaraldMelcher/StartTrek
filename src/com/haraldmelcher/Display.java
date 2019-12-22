/*
 * Harald Melcher
 * 20.12.2019
 */
package com.haraldmelcher;


public class Display {
    public void drawQuandrant(Unit[][] quadrant) {
        System.out.println("+-0--1--2--3--4--5--6--7-+");
        for (int y=0; y<8; y++) {
            System.out.print(y);
            for (int x=0; x<8; x++)
                System.out.print(symbolOf(quadrant[x][y]));
            System.out.println(y);
        }
        System.out.println("+-0--1--2--3--4--5--6--7-+");
    }

    private String symbolOf(Unit unit) {
        if (unit == null)
            return "   ";
        if (unit instanceof Sun)
            return " * ";
        if (unit instanceof Klingon)
            return "###";
        if (unit instanceof Starbase)
            return ">!<";
        return "<*>";
    }
}
