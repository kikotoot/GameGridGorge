
package gamegridgorge;


/**
 *
 * @author L
 */
public abstract class Game
{
    protected static int[][] topLevel;
    protected static int[][] bottomLevel;
    protected static char[] topTranslation;
    protected static char[] bottomTranslation;
    public abstract void clickTile(int x, int y);
}
