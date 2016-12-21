
package gamegridgorge;

import java.awt.Color;

/**
 *
 * @author L
 */
public class Colours
{
    final Color BACKGROUND = new Color(0, 0, 0);
    final Color FILLER = new Color(255, 255, 255);
    public Color Shadow(int alpha)
    {
        Color c = new Color(0, 0, 0, alpha);
        return c;
    }
    
    
    private double hue = 0;
    private int r, g, b;
    double hueSpeed = 1;
    public Color HueShift()
    {
        r = (int)(Math.sin(hue / 90.0) * 127) + 127;
        g = (int)(Math.sin((hue + 170) / 90.0) * 127) + 127;
        b = (int)(Math.sin((hue + 340) / 90.0) * 127) + 127;
        
        Color c = new Color(r, g, b);
        if(hue >= 510)
        {
            hue = 0;
        }
        else
        {
            hue += hueSpeed;
        }
        return c;
    }
    private int hue2 = 0;
    public Color HueShift2()
    {
        //red
        if(hue < 255)
            r = hue2;
        else
            r = 510 - hue2;
        //green
        if(hue < 85)
            g = hue2 + 170;
        else if(hue2 < 340)
            g = 340 - hue2;
        else
            g = hue2 - 340;
        //blue
        if(hue < 170)
            b = 170 - hue2;
        else if(hue < 425)
            b = hue2 - 170;
        else
            b = 680 - hue2;
        Color c = new Color(r, g, b);
        if(hue2 >= 510)
        {
            hue2 = 0;
        }
        else
        {
            hue2++;
        }
        return c;
    }
}
