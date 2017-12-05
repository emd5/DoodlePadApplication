package adapters;/*
 *Liz Mahoney
 *12/2/17
 *TriangleAdapter.java
 */

import drawing.IShape;
import drawing.SavedShapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Shape;
import shapes.Triangle;


/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class TriangleAdapter implements IShape{

    private Triangle triangle;
    private double thickness;
    private Color color;
    private boolean fill;

    public TriangleAdapter(Triangle triangle){
        this.triangle = triangle;

    }

    @Override
    public IShape setThickness(final double value){
        this.thickness= value;
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
        double xpoints[] = {getX(), getX()+145, getX()+25, getX()+145, getX()+25};
        double ypoints[] = {getY(), getY()+25, getY()+145, getY()+145, getY()+25};
        int npoints = 3;

        graphics.setLineWidth(triangle.getThickness());

        //draws the triangle
        if(triangle.isFill()){
            graphics.setFill(triangle.getColor());
            graphics.fillPolygon(xpoints,ypoints,npoints);
        }
        else{
            graphics.setStroke(triangle.getColor());
            graphics.strokePolygon(xpoints,ypoints,npoints);
        }




    }
}
