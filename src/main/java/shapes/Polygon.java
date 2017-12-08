package shapes;/*
 *Liz Mahoney
 *12/7/17
 *Polygon.java
 */

import javafx.scene.paint.Color;

/**
 * The type Polygon.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class Polygon extends Shape{

    private int nPoints;

    public Polygon(final double x, final double y, int nPoints, final double thickness,
                   final Color color, final boolean fill){
        super(x, y, thickness, color, fill);

        this.nPoints = nPoints;

    }

    public int getNpoints(){
        return nPoints;
    }

    public String toString(){
        return "Polygon [points=" + nPoints + " " + super.toString() + "]";
    }

}
