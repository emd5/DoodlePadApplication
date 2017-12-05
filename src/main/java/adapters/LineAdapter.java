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

    private Line line;
    private double thickness;
    private Color color;
    private boolean fill;

    public LineAdapter(Line line){
        this.line = line;
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
        graphics.setStroke(line.getColor());
        graphics.setLineWidth(line.getThickness());
        graphics.strokeLine(line.getX(),line.getY(),this.line.getX2(), this.line.getY2());

        //draws the line
        graphics.setStroke(line.getColor());

        graphics.setFill(line.getColor());
        graphics.strokeLine(getX(),getY(),line.getX2(),line.getY2());




    }
}
