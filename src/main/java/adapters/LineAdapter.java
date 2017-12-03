package adapters;/*
 *Liz Mahoney
 *12/2/17
 *LineAdapter.java
 */

import drawing.IShape;
import drawing.SavedShapes;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;
import shapes.Shape;

/**
 * @author Liz Mahoney
 * @version 1.0
 */
public class LineAdapter implements IShape{

    Line line;


    public LineAdapter(GraphicsContext graphicsContext){
        line = new Line(line.getX(), line.getY(), line.getX2(),
                line.getY2(), line.getThickness(), line.getColor(),
                line.isFill());

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
        return line.getX();
    }

    @Override
    public double getY(){
        return line.getY();
    }

    @Override
    public double getThickness(){
        return line.getThickness();
    }

    @Override
    public Color getColor(){
        return line.getColor();
    }

    @Override
    public boolean getFilled(){
        return line.isFill();
    }
    @Override
    public void drawShape(final GraphicsContext graphics){
        SavedShapes savedShapes = new SavedShapes();
        savedShapes.add(new LineAdapter(graphics));
    }
}
