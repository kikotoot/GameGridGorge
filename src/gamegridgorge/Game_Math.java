
package gamegridgorge;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author L
 */
public class Game_Math 
{
    //collisions
    public static boolean Collides2dPoint(int ax,int ay,int bx1,int by1,int bx2,int by2)
    {
        return (ax < bx2 && ax > bx1 && ay < by2 && ay > by1);
    }
    public static boolean Collides2d(int ax1,int ay1,int ax2,int ay2,int bx1,int by1,int bx2,int by2)
    {
        return ((ax2 > bx1 && ax1 < bx2)&&(ay2 > by1 && ay1 < by2));
    }
    public static boolean Collides3d(int ax1,int ay1,int az1,int ax2,int ay2,int az2,int bx1,int by1,int bz1,int bx2,int by2,int bz2)
    {
        return ((ax2 > bx1 && ax1 < bx2)&&(ay2 > by1 && ay1 < by2)&&(az2 > bz1 && az1 < bz2));
    }
    public static boolean Collides2dPoint(double ax,double ay,double bx1,double by1,double bx2,double by2)
    {
        return (ax < bx2 && ax > bx1 && ay < by2 && ay > by1);
    }
    public static boolean Collides2d(double ax1,double ay1,double ax2,double ay2,double bx1,double by1,double bx2,double by2)
    {
        return ((ax2 > bx1 && ax1 < bx2)&&(ay2 > by1 && ay1 < by2));
    }
    public static boolean Collides3d(double ax1,double ay1,double az1,double ax2,double ay2,double az2,double bx1,double by1,double bz1,double bx2,double by2,double bz2)
    {
        return ((ax2 > bx1 && ax1 < bx2)&&(ay2 > by1 && ay1 < by2)&&(az2 > bz1 && az1 < bz2));
    }
    public static boolean Collides2dPoint(double ax,double ay,Rectangle b)
    {
        return (ax < b.x + b.width && ax > b.x && ay < b.y + b.height && ay > b.y);
    }
    public static boolean Collides2d(Rectangle a, Rectangle b)
    {
        return ((a.x + a.width > b.x && a.x < b.x + b.width)&&(a.y + a.height > b.y && a.y < b.y + b.height));
    }
    public static boolean Collides2dPoint(Point a,Rectangle b)
    {
        return (a.x < b.x + b.width && a.x > b.x && a.y < b.y + b.height && a.y > b.y);
    }
    //within
    public static int getMultipleWithinHigh(int x, int min, int max)
    {
        int range = max - min;
        x = x % range + max - x;
        return x;
    }
    public static int getMultipleWithinLow(int x, int min, int max)
    {
        int range = max - min;
        x = (int)(x % range) + min;
        return x;
    }
    public static double getMultipleWithinHigh(double x, double min, double max)
    {
        double range = max - min;
        x = x % range + max - x;
        return x;
    }
    public static double getMultipleWithinLow(double x, double min, double max)
    {
        double range = max - min;
        x = x % range + min;
        return x;
    }
    
    //limits
    
    public static int limit(int x, int limit)
    {
        limit = Math.abs(limit);
        if(x > limit)
            x = limit;
        if (x < -limit)
            x = -limit;
        return x;
    }
    public static double limit(double x, double limit)
    {
        limit = Math.abs(limit);
        if(x > limit)
            x = limit;
        if (x < -limit)
            x = -limit;
        return x;
    }
    
    //+-
    public static int getSign(int i)
    {
        if(i >= 0)
            return 1;
        return -1;
    }
    public static int getSign(double i)
    {
        if(i >= 0)
            return 1;
        return -1;
    }
    
}
