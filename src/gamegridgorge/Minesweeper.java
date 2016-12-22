
package gamegridgorge;


import java.awt.event.MouseEvent;
import java.util.Random;

/**
 *
 * @author L
 */
public class Minesweeper extends Game
{
    static Random RNG = new Random();
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
    
    Minesweeper()
    {
        name = "Minesweeper";
        bottomTranslation = new char[] {' ', '1', '2', '3', '4', '5', '6', '7', '8', '☼'};
        topTranslation = new char[] {'#', ' ', 'F', 'O', 'X'};
        drawGrid = false;
        drawBorder = true;
    }
    
    @Override
    public void clickTile(int x, int y, MouseEvent e)
    {
        if(inGame)
        {
            if(safeEdgeCheck(x, y))
            {
                if(e.getButton() == 1)
                {
                    if(topLevel[x][y] == 0)
                    {
                        switch(bottomLevel[x][y])
                        {
                            case 0:
                            {
                                int[][] toReveal = new int[width][height];
                                toReveal[x][y] = safeEmptyCheck(x, y)?2:1;
                                int distanceToEdge = 30;//TEMP
                                for(int i = 0; i < distanceToEdge; i++)
                                {
                                    for(int xOn = 0; xOn < width; xOn++)
                                    {
                                        for(int yOn = 0; yOn < height; yOn++)
                                        {
                                            if(toReveal[xOn][yOn] == 1)
                                            {
                                                if(safeRevealCheck(xOn - 1, yOn - 1))
                                                    toReveal[xOn - 1][yOn - 1] = safeEmptyCheck(xOn - 1, yOn - 1)?2:1;
                                                if(safeRevealCheck(xOn, yOn - 1))
                                                    toReveal[xOn][yOn - 1] = safeEmptyCheck(xOn, yOn - 1)?2:1;
                                                if(safeRevealCheck(xOn + 1, yOn - 1))
                                                    toReveal[xOn + 1][yOn - 1] = safeEmptyCheck(xOn + 1, yOn - 1)?2:1;
                                                if(safeRevealCheck(xOn - 1, yOn))
                                                    toReveal[xOn - 1][yOn] = safeEmptyCheck(xOn - 1, yOn)?2:1;
                                                if(safeRevealCheck(xOn + 1, yOn))
                                                    toReveal[xOn + 1][yOn] = safeEmptyCheck(xOn + 1, yOn)?2:1;
                                                if(safeRevealCheck(xOn - 1, yOn + 1))
                                                    toReveal[xOn - 1][yOn + 1] = safeEmptyCheck(xOn - 1, yOn + 1)?2:1;
                                                if(safeRevealCheck(xOn, yOn + 1))
                                                    toReveal[xOn][yOn + 1] = safeEmptyCheck(xOn, yOn + 1)?2:1;
                                                if(safeRevealCheck(xOn + 1, yOn + 1))
                                                    toReveal[xOn + 1][yOn + 1] = safeEmptyCheck(xOn + 1, yOn + 1)?2:1;
                                            }
                                        }
                                    }
                                }
                                //reveal found tiles
                                for(int xOn = 0; xOn < width; xOn++)
                                {
                                    for(int yOn = 0; yOn < height; yOn++)
                                    {
                                        if(toReveal[xOn][yOn] != 0)
                                            topLevel[xOn][yOn] = 1;
                                    }
                                }
                            }
                            break;
                            case 9:
                            {
                                lose();
                            }
                            break;
                            default:
                            {
                                topLevel[x][y] = 1;
                            }
                            break;
                        }
                        if(checkWin())
                        {
                            win();
                        }
                    }
                }
                else if(e.getButton() == 3)
                {
                    switch(topLevel[x][y])
                    {
                        case 0:
                        {
                            topLevel[x][y] = 2;
                        }
                        break;
                        case 2:
                        {
                            topLevel[x][y] = 0;
                        }
                        break;
                    }
                }
            }
        }
        else
        {
            exit = true;
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
                    if(bottomLevel[curX][curY] != 9)
                        bottomLevel[curX][curY] = getAdjacentMines(curX, curY);
                }
            }
            inGame = true;
        }
        else
        {
            System.out.println("TOO MANY MINES");
        }
    }
    private boolean checkWin()
    {
        for(int xOn = 0; xOn < width; xOn++)
        {
            for(int yOn = 0; yOn < height; yOn++)
            {
                if(bottomLevel[xOn][yOn] == 9 && topLevel[xOn][yOn] == 1)
                {
                    return false;
                }
                if(bottomLevel[xOn][yOn] != 9 && topLevel[xOn][yOn] == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }
    private int getAdjacentMines(int x, int y)
    {
        int minesFound = 0;
        minesFound += safeMineCheck(x - 1, y - 1)?1:0;
        minesFound += safeMineCheck(x - 1, y)?1:0;
        minesFound += safeMineCheck(x - 1, y + 1)?1:0;
        minesFound += safeMineCheck(x, y - 1)?1:0;
        minesFound += safeMineCheck(x, y + 1)?1:0;
        minesFound += safeMineCheck(x + 1, y - 1)?1:0;
        minesFound += safeMineCheck(x + 1, y)?1:0;
        minesFound += safeMineCheck(x + 1, y + 1)?1:0;
        return minesFound;
    }
    private boolean safeMineCheck(int x, int y)
    {
        if(x >= 0 && x < width && y >= 0 && y < height)
            return bottomLevel[x][y] == 9;
        else
            return false;
    }
    private boolean safeEmptyCheck(int x, int y)
    {
        if(x >= 0 && x < width && y >= 0 && y < height)
            return bottomLevel[x][y] != 0;
        else
            return false;
    }
    private boolean safeRevealCheck(int x, int y)
    {
        if(safeEdgeCheck(x, y))
            return topLevel[x][y] != 2;
        return false;
    }
    private boolean safeEdgeCheck(int x, int y)
    {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    @Override
    public void win() 
    {
        System.out.println("you win");
        for(int curX = 0; curX < width; curX++)
        {
            for(int curY = 0; curY < height; curY++)
            {
                if(bottomLevel[curX][curY] == 9)
                    topLevel[curX][curY] = 3;
            }
        }
        inGame = false;
    }

    @Override
    public void lose() 
    {
        System.out.println("you lose");
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
        inGame = false;
    }
}
