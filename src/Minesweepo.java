
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Minesweepo 
{
    static int width = 1, height = 1;
    static private int[][] mineLevel;
    static private int[][] blockLevel;
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
    1 = affirmed reveal
    2 = edge of scan
    */
    
    public static void clickTile(int x, int y)
    {
        switch(mineLevel[x][y])
        {
            case 0:
            {
                int[][] toReveal = new int[width][height];
                
            }//fill reveal
            break;
            case 9:
            {
                for(int curX = 0; curX < width; curX++)
                {
                    for(int curY = 0; curY < height; curY++)
                    {
                        if(blockLevel[curX][curY] == 0)
                            blockLevel[curX][curY] = mineLevel[curX][curY] == 9?1:0;
                        else if(blockLevel[curX][curY] == 2)
                            if(mineLevel[curX][curY] == 9)
                                blockLevel[curX][curY] = 3;
                            else
                                blockLevel[curX][curY] = 4;
                    }
                }
            }
            break;
            default:
            {
                blockLevel[x][y] = 1;
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
            mineLevel = new int[w][h];
            blockLevel = new int[w][h];
            for(int m = 0; m < minesMax;)
            {
                int tempX = RNG.nextInt(w);
                int tempY = RNG.nextInt(h);
                if(mineLevel[tempX][tempY] != 9)
                {
                    mineLevel[tempX][tempY] = 9;
                    m++;
                }
            }
            for(int curX = 0; curX < width; curX++)
            {
                for(int curY = 0; curY < height; curY++)
                {
                    mineLevel[curX][curY] = getAdjacentMines(curX, curY);
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
            return mineLevel[x][y] == 9;
        else
            return false;
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
                if(blockLevel[curX][curY] != 0)
                {
                    switch(mineLevel[curX][curY])
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
                switch(blockLevel[curX][curY])
                {
                    //draw each specific thing
                }
            }
        }
        return boardView;
    }
}
