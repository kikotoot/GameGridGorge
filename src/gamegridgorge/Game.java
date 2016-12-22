
package gamegridgorge;

import java.awt.event.MouseEvent;


/**
 *
 * @author L
 */
public abstract class Game
{
    protected String name;
    protected int width = 1, height = 1;
    protected int[][] topLevel;
    protected int[][] bottomLevel;
    protected char[] topTranslation;
    protected char[] bottomTranslation;
    protected boolean inGame = false, exit = false;
    protected boolean drawGrid, drawBorder;
    public abstract void clickTile(int x, int y, MouseEvent e);
    public abstract void win();
    public abstract void lose();
    public boolean getDrawGrid()
    {
        return drawGrid;
    }
    public boolean getDrawBorder()
    {
        return drawBorder;
    }
    public String getName()
    {
        return name;
    }
}
