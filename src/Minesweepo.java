
import java.awt.image.BufferedImage;
import java.util.Random;


public class Minesweepo 
{
    static int width = 1, height = 1;
    static private int[][] mineLevel;
    static private int[][] blockLevel;
    static Random RNG = new Random();
    
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
                blockLevel[x][y] = 0;
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
                    m++;
                }
            }
            //go over the board and add the numbers
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
        BufferedImage board = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }
}
