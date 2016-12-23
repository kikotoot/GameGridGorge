
package gamegridgorge;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Portals extends Game
{
    int turnTimer = 0;  
    Random RNG = new Random();
    Point human = new Point();
    Point comp = new Point();
    /*
    path level:
    
    0 = empty
    1 = end
    2 = portals
    
    player level:
    
    0 = nobody
    1 = human piece
    2 = comp piece
    3 = both pieces
    
    useful characters: ♙♟
    */
    
    Portals()
    {
        name = "Portals";
        bottomTranslation = new char[] {' ', '#', 'o'};
        topTranslation = new char[] {' ', '♙', '♟', '☯'};
        drawGrid = true;
        drawBorder = true;
        coverLevels = false;
        bottomLevel = new int[10][10];
        topLevel = new int[10][10];
        human = new Point();
        comp = new Point();
    }
    
    @Override
    public void clickTile(int x, int y, MouseEvent e)
    {
        if(turnTimer == 0)
        {
            turnTimer = 120;
            playerTurn();
        }
    }
    public void playerTurn()
    {
        int roll = RNG.nextInt(6);
        for(int i = roll; i >= 0; i--)
        {
            if(human.y % 2 == 1)
            {
                if(human.x + 1 < width)
                {
                    human.x++;
                }
                else
                {
                    human.y++;
                }
            }
            else
            {
                if(human.x - 1 >= 0)
                {
                    human.x--;
                }
                else
                {
                    human.y++;
                }
            }
        }
        if(roll == 6)
        {
            turnTimer = 1;
        }
        placePieces();
    }
    public void enemyTurn()
    {
        int roll = RNG.nextInt(6);
        for(int i = roll; i >= 0; i--)
        {
            if(comp.y % 2 == 1)
            {
                if(comp.x + 1 < width)
                {
                    comp.x++;
                }
                else
                {
                    comp.y++;
                }
            }
            else
            {
                if(comp.x - 1 >= 0)
                {
                    comp.x--;
                }
                else
                {
                    comp.y++;
                }
            }
        }
        if(roll == 6)
        {
            turnTimer = 61;
        }
        placePieces();
    }
    public void placePieces()
    {
        topLevel = new int[width][height];
        topLevel[human.x][human.y] = 1;
        if(topLevel[comp.x][comp.y] == 1)
            topLevel[comp.x][comp.y] = 3;
        else
            topLevel[comp.x][comp.y] = 2;
    }

    @Override
    public void win() 
    {
        
    }

    @Override
    public void lose() 
    {
        
    }
    
}
