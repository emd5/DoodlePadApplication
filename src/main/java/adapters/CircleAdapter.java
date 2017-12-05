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
 *
 * Your program will make direct use of the SavedShapes class to store shapes that
 are added to the user interface. Our goal is to use the existing shape classes seen
 above, but to make them compatible with our SavedShapes class.

 Instead create an adapter class for each of the four classes: Oval, Rectangle,
 Line and Triangle.

 Your adapter class will store an instance of one of the shape classes and
 implement the IShape interface.

 This directly follows our use of the Adapter pattern in class.


 * This adapter class will store an instance of one Circle class
 * and implement the IShape interface
 * @author Liz Mahoney
 * @version 1.0
 */

public class CircleAdapter implements IShape{

    private Circle circle;
    private double thickness;
    private boolean fill;
    private Color color;

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

        graphics.setStroke(circle.getColor());

        if(circle.isFill()){
            graphics.setFill(circle.getColor());
            graphics.fillOval(getX(), getY(), this.circle.getRadius(), this.circle.getRadius());

        }
        else{

            graphics.setLineWidth(circle.getThickness());
            graphics.strokeOval(circle.getX(), circle.getY(), this.circle.getRadius(), this.circle.getRadius());
        }
    }
}
