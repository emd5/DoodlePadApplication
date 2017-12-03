package drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public interface IShape
{
    //method chaining
    public IShape setThickness(double value);
    public IShape setColor(Color value);
    public IShape setFilled(boolean value);

    //getters return location and setting for drawing an instance of a shape
    // (canvas)
    public double getX();
    public double getY();
    public double getThickness();
    public Color getColor();
    public boolean getFilled();

    //draw the shape
    public void drawShape(GraphicsContext graphics);
}
