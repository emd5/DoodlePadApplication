package adapters;/*
 *Liz Mahoney
 *12/1/17
 *CircleAdapter.java
 */

import drawing.IShape;


import drawing.SavedShapes;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import shapes.Circle;
import shapes.Shape;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Circle adapter.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class CircleAdapter implements IShape{

    private Circle circle;
    private double thickness;
    private boolean fill;
    private Color color;

    /**
     * Instantiates a new Circle adapter.
     *
     * @param circle the circle
     */
    public CircleAdapter(Circle circle){
        this.circle =circle;

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

        return circle.getX();
    }

    @Override
    public double getY(){
        return circle.getY();
    }

    @Override
    public double getThickness(){
        return circle.getThickness();
    }

    @Override
    public Color getColor(){
        return circle.getColor();
    }

    @Override
    public boolean getFilled(){
        return circle.isFill();
    }

    @Override
    public void drawShape(final GraphicsContext graphics){

        graphics.setStroke(getColor());
        graphics.setLineWidth(getThickness());
        graphics.strokeOval(getX(), getY(), this.circle.getRadius(),
                this.circle.getRadius());

        if(getFilled()){
            graphics.setFill(getColor());
            graphics.fillOval(getX(), getY(), this.circle.getRadius(), this.circle.getRadius());

        }

    }
}
