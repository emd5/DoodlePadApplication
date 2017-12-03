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


/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class TriangleAdapter implements IShape{

    private Shape triangle;

    public TriangleAdapter(GraphicsContext graphicsContext){

        triangle = new Shape(triangle.getX(), triangle.getY(),
            triangle.getThickness(), triangle.getColor(), triangle.isFill());

        drawShape(graphicsContext);
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
        SavedShapes savedShapes = new SavedShapes();
        savedShapes.add(new TriangleAdapter(graphics));
    }
}
