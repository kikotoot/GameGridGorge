
package gamegridgorge;


import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author L
 */
public class Minesweepo extends Game
{
    static Random RNG = new Random();
    BufferedImage boardView = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = (Graphics2D)boardView.getGraphics();
    /*
    mine level:
    
    0 = empty
    1-8 = how many adjacent mines
    9 = mine
    
    block level:
    
    0 = blocked
    1 = unblocked
    2 = flag
    3 =  correctly guessed mine; only used at end of game
    4 =  incorrectly guessed mine; only used at end of game
    
    revealing tiles:
    
    0 = do not reveal
    1 = empty and reveal
    2 = numbered and reveal
    */
    
    Minesweepo()
    {
        bottomTranslation = new char[] {' ', '1', '2', '3', '4', '5', '6', '7', '8', '*'};
        topTranslation = new char[] {'█', ' ', '◙'};
    }
    
    @Override
    public void clickTile(int x, int y, MouseEvent e)
    {
        switch(bottomLevel[x][y])
        {
            case 0:
            {
                int[][] toReveal = new int[width][height];
                toReveal[x][y] = 1;
                int distanceToEdge = 30;//TEMP
                for(int i = 0; i < distanceToEdge; i++)
                {
                    for(int xOn = 0; xOn < width; xOn++)
                    {
                        for(int yOn = 0; yOn < height; yOn++)
                        {
                            if(toReveal[x][y] == 1)
                            {
                                toReveal[x - 1][y - 1] = safeEmptyCheck(x - 1, y - 1)?2:1;
                                toReveal[x][y - 1] = safeEmptyCheck(x, y - 1)?2:1;
                                toReveal[x + 1][y - 1] = safeEmptyCheck(x + 1, y - 1)?2:1;
                                toReveal[x - 1][y] = safeEmptyCheck(x - 1, y)?2:1;
                                toReveal[x + 1][y] = safeEmptyCheck(x + 1, y)?2:1;
                                toReveal[x - 1][y + 1] = safeEmptyCheck(x - 1, y + 1)?2:1;
                                toReveal[x][y + 1] = safeEmptyCheck(x, y + 1)?2:1;
                                toReveal[x + 1][y + 1] = safeEmptyCheck(x + 1, y + 1)?2:1;
                            }
                        }
                    }
                }
            }
            break;
            case 9:
            {
                for(int curX = 0; curX < width; curX++)
                {
                    for(int curY = 0; curY < height; curY++)
                    {
                        if(topLevel[curX][curY] == 0)
                            topLevel[curX][curY] = bottomLevel[curX][curY] == 9?1:0;
                        else if(topLevel[curX][curY] == 2)
                            if(bottomLevel[curX][curY] == 9)
                                topLevel[curX][curY] = 3;
                            else
                                topLevel[curX][curY] = 4;
                    }
                }
            }
            break;
            default:
            {
                topLevel[x][y] = 1;
            }
            break;
        }
        
    }
    public void newBoard(int w, int h, int minesMax)
    {
        if(w * h > minesMax)
        {
            width = w;
            height = h;
            bottomLevel = new int[w][h];
            topLevel = new int[w][h];
            for(int m = 0; m < minesMax;)
            {
                int tempX = RNG.nextInt(w);
                int tempY = RNG.nextInt(h);
                if(bottomLevel[tempX][tempY] != 9)
                {
                    bottomLevel[tempX][tempY] = 9;
                    m++;
                }
            }
            for(int curX = 0; curX < width; curX++)
            {
                for(int curY = 0; curY < height; curY++)
                {
                    bottomLevel[curX][curY] = getAdjacentMines(curX, curY);
                }
            }
        }
        else
        {
            System.out.println("TOO MANY MINES");
        }
    }
    private int getAdjacentMines(int x, int y)
    {
        int minesFound = 0;
        minesFound += safeMineCheck(x - 1, y - 1)?1:0;
        minesFound += safeMineCheck(x - 1, y)?1:0;
        minesFound += safeMineCheck(x - 1, y + 1)?1:0;
        minesFound += safeMineCheck(x, y - 1)?1:0;
        minesFound += safeMineCheck(x, y - 1)?1:0;
        minesFound += safeMineCheck(x + 1, y - 1)?1:0;
        minesFound += safeMineCheck(x + 1, y)?1:0;
        minesFound += safeMineCheck(x + 1, y + 1)?1:0;
        return minesFound;
    }
    private boolean safeMineCheck(int x, int y)
    {
        if(x > 0 && x < width && y > 0 && y < height)
            return bottomLevel[x][y] == 9;
        else
            return false;
    }
    private boolean safeEmptyCheck(int x, int y)
    {
        if(x > 0 && x < width && y > 0 && y < height)
            return bottomLevel[x][y] != 0;
        else
            return false;
    }
    private boolean safeEdgeCheck(int x, int y)
    {
        return x > 0 && x < width && y > 0 && y < height;
    }
    public BufferedImage getBoard()//this should probably be replaced with something in the main class
    {
        boardView = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D)boardView.getGraphics();
        //draw things
        for(int curX = 0; curX < width; curX++)
        {
            for(int curY = 0; curY < height; curY++)
            {
                if(topLevel[curX][curY] != 0)
                {
                    switch(bottomLevel[curX][curY])
                    {
                        case 9:
                        {
                            //draw mine
                        }
                        break;
                        case 0:
                        {}
                        break;
                        default:
                        {
                            //draw the number
                        }
                        break;
                    }
                }
                switch(topLevel[curX][curY])
                {
                    //draw each specific thing
                }
            }
        }
        return boardView;
    }
}
