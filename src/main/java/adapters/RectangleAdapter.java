/*
 *Liz Mahoney
 *12/2/17
 *RectangleAdapter.java
 */
package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

/**
 * The type Rectangle adapter.
 *
 * @author Liz Mahoney
 * @version 1.0
 */
public class RectangleAdapter implements IShape{

    private Rectangle rectangle;
    private double thickness;
    private Color color;
    private boolean fill;

    /**
     * Instantiates a new Rectangle adapter.
     *
     * @param rectangle the rectangle
     */
    public RectangleAdapter(Rectangle rectangle){
        this.rectangle = rectangle;
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

        graphics.setLineWidth(rectangle.getThickness());
        graphics.setStroke(getColor());
        graphics.strokeRect(getX(), getY(), this.rectangle.getWidth(), this
                .rectangle.getHeight());

        //draws the triangle
        if(getFilled()){
            graphics.setFill(rectangle.getColor());
            graphics.fillRect(rectangle.getX(), rectangle.getY(), this.rectangle.getWidth(),
                    this.rectangle.getHeight());
        }

    }
}
