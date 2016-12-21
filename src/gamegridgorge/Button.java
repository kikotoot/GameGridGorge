
package gamegridgorge;

import java.awt.Rectangle;

/**
 *
 * @author L
 */
public class Button 
{
    Rectangle area;
    String text;
    char command;
    
    Button(Rectangle area, String text, char command)
    {
        this.text = text;
        this.area = area;
        this.command = command;
    }
    public boolean collides(int x, int y)
    {
        return Game_Math.Collides2dPoint(x, y, area);
    }
    public boolean collides(double x, double y)
    {
        return Game_Math.Collides2dPoint(x, y, area);
    }
}
