
package gamegridgorge;

import java.awt.event.MouseEvent;


/**
 *
 * @author L
 */
public abstract class Game
{
    protected int width = 1, height = 1;
    protected int[][] topLevel;
    protected int[][] bottomLevel;
    protected char[] topTranslation;
    protected char[] bottomTranslation;
    protected boolean inGame = false;
    public abstract void clickTile(int x, int y, MouseEvent e);
}
