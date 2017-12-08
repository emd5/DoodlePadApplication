/*
 *Liz Mahoney
 *12/2/17
 *TriangleAdapter.java
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

/**
 * The type Triangle adapter.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class TriangleAdapter implements IShape{

    private Triangle triangle;
    private double thickness;
    private Color color;
    private boolean fill;

    /**
     * Instantiates a new Triangle adapter.
     *
     * @param triangle the triangle
     */
    public TriangleAdapter(Triangle triangle){
        this.triangle = triangle;

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
        return triangle.getX();
    }

    @Override
    public double getY(){
        return triangle.getY();
    }

    @Override
    public double getThickness(){
        return triangle.getThickness();
    }

    @Override
    public Color getColor(){
        return triangle.getColor();
    }

    @Override
    public boolean getFilled(){
        return triangle.isFill();
    }

    @Override
    public void drawShape(final GraphicsContext graphics){
        double xpoints[] = {getX(), (getX() / 2), getX() - getY()};
        double ypoints[] = {getY(), (getY() / 2), getY() / 2 + getX()};
        int npoints = 3;

        graphics.setLineWidth(getThickness());
        graphics.setStroke(getColor());
        graphics.strokePolygon(xpoints, ypoints, npoints);

        //draws the triangle
        if(getFilled()){
            graphics.setFill(getColor());
            graphics.fillPolygon(xpoints, ypoints, npoints);
        }
    }
}
