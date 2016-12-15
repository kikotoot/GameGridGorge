
package gamegridgorge;

import java.awt.Color;

/**
 *
 * @author L
 */
public class Colours
{
    final Color BLACK = new Color(0, 0, 0);
    final Color WHITE = new Color(255, 255, 255);
    public Color Shadow(int alpha)
    {
        Color c = new Color(0, 0, 0, alpha);
        return c;
    }
    
    
    private int hue = 0;
    private int r, g, b;
    double hueSpeed = 90;
    public Color HueShift()
    {
        r = (int)(Math.sin(hue / hueSpeed) * 127) + 127;
        g = (int)(Math.sin((hue + 170) / hueSpeed) * 127) + 127;
        b = (int)(Math.sin((hue + 340) / hueSpeed) * 127) + 127;
        
        Color c = new Color(r, g, b);
        if(hue >= 510)
        {
            hue = 0;
        }
        else
        {
            hue++;
        }
        return c;
    }
    public Color HueShift2()
    {
        //red
        if(hue < 255)
            r = hue;
        else
            r = 510 - hue;
        //green
        if(hue < 85)
            g = hue + 170;
        else if(hue < 340)
            g = 340 - hue;
        else
            g = hue - 340;
        //blue
        if(hue < 170)
            b = 170 - hue;
        else if(hue < 425)
            b = hue - 170;
        else
            b = 680 - hue;
        Color c = new Color(r, g, b);
        if(hue >= 510)
        {
            hue = 0;
        }
        else
        {
            hue++;
        }
        return c;
    }
}
