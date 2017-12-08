package adapters;/*
 *Liz Mahoney
 *12/7/17
 *PolygonAdapter.java
 */

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Polygon;

/**
 * The type Polygon adapter.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class PolygonAdapter implements IShape{

    public static final int POINT_100 = 100;
    public static final int POINT_125 = 125;
    public static final int POINT_50 = 50;
    public static final int POINT_25 = 25;
    public static final int POINT_75 = 75;
    private Polygon polygon;
    private double thickness;
    private Color color;
    private boolean fill;

    /**
     * Instantiates a new Polygon adapter.
     *
     * @param polygon the polygon
     */
    public PolygonAdapter(Polygon polygon){
        this.polygon = polygon;
    }

    @Override
    public IShape setThickness(final double value){

        this.thickness = value;
        return this;
    }

    @Override
    public IShape setColor(final Color value){
        this.color = value;
        return this;
    }

    @Override
    public IShape setFilled(final boolean value){
        this.fill = value;
        return this;
    }

    @Override
    public double getX(){
        return polygon.getX();
    }

    @Override
    public double getY(){
        return polygon.getY();
    }

    @Override
    public double getThickness(){
        return polygon.getThickness();
    }

    @Override
    public Color getColor(){
        return polygon.getColor();
    }

    @Override
    public boolean getFilled(){
        return polygon.isFill();
    }

    @Override
    public void drawShape(final GraphicsContext graphics){

        double[] x = {getX(), getX() + POINT_100, getX() + POINT_125, getX() + POINT_100, getX(), getX() - POINT_50};
        double[] y = {getY(), getY(), getY() + POINT_50, getY() + POINT_75, getY() + POINT_75,
                getY() +
                        POINT_25};

        graphics.setStroke(getColor());
        graphics.strokePolygon(x, y, this.polygon.getNpoints());
        graphics.setLineWidth(getThickness());

        if(getFilled()){
            graphics.setFill(getColor());
            graphics.fillPolygon(x, y, this.polygon.getNpoints());
        }


    }
}
