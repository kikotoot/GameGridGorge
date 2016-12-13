
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Minesweepo 
{
    static int width = 1, height = 1;
    static private int[][] mineLevel;
    static private int[][] blockLevel;
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
    */
    
    public static void clickTile(int x, int y)
    {
        switch(mineLevel[x][y])
        {
            case 0:
            {
            }//fill reveal
            break;
            case 9:
            {
            }//reveal all and end game
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
    public BufferedImage getBoard()
    {
        BufferedImage boardView = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics g = new boardView.getGraphics();
        return boardView;
    }
}
