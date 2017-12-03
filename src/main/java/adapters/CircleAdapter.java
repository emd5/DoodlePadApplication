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

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class CircleAdapter implements IShape{


    private Circle circle;

    public CircleAdapter(GraphicsContext drawCircle){

        circle = new Circle(circle.getRadius(), circle.getX(), circle.getY(),
            circle.getThickness(), circle.getColor(),circle.isFill());

        drawShape(drawCircle);
    }

    @Override
    public IShape setThickness(final double value){
        return setThickness(value);
    }

    @Override
    public IShape setColor(final Color value){
       return setColor(value);
    }

    @Override
    public IShape setFilled(final boolean value){
        return setFilled(value);
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

        SavedShapes savedShapes = new SavedShapes();

        savedShapes.add(new CircleAdapter(graphics));

    }
}
