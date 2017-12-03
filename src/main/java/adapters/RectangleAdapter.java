package adapters;/*
 *Liz Mahoney
 *12/2/17
 *RectangleAdapter.java
 */

import drawing.IShape;
import drawing.SavedShapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;
import shapes.Shape;

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class RectangleAdapter implements IShape{


    private Rectangle rectangle;


    public RectangleAdapter(GraphicsContext graphicsContext){
       rectangle= new Rectangle(rectangle.getX(), rectangle.getY(),
              rectangle.getWidth(), rectangle.getHeight(),
               rectangle.getThickness(),rectangle.getColor(),
              rectangle.isFill() );
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
        return rectangle.getX();
    }

    @Override
    public double getY(){
        return rectangle.getY();
    }

    @Override
    public double getThickness(){
        return rectangle.getThickness();
    }

    @Override
    public Color getColor(){
        return rectangle.getColor();
    }

    @Override
    public boolean getFilled(){
        return rectangle.isFill();
    }

    @Override
    public void drawShape(final GraphicsContext graphics){
        SavedShapes savedShapes = new SavedShapes();
        savedShapes.add(new RectangleAdapter(graphics));

    }
}
