
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
    3-9 = numbers(1-6)
    
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
        bottomTranslation = new char[] {' ', '#', 'o', '1', '2', '3', '4', '5', '6', 'R', 'O', 'L', ':'};
        topTranslation = new char[] {' ', '|', '<', 'K'};
        drawGrid = true;
        drawBorder = true;
        coverLevels = false;
        human = new Point();
        comp = new Point();
    }
    
    public void newBoard(int w, int h)
    {
        width = w;
        height = h + 1;
        bottomLevel = new int[w][h + 1];
        topLevel = new int[w][h + 1];
        bottomLevel[w - 1][h - 1] = 1;
        bottomLevel[0][h] = 9;
        bottomLevel[1][h] = 10;
        bottomLevel[2][h] = 11;
        bottomLevel[3][h] = 11;
        bottomLevel[4][h] = 12;
        int portalsMax = w * h / 10;
        for(int p = 0; p < portalsMax;)
            {
                int tempX = RNG.nextInt(w);
                int tempY = RNG.nextInt(h);
                if(bottomLevel[tempX][tempY] != 2 && (tempX != 0 || tempY != 0) && (tempX != width - 1 || tempY != height - 1 - 1))
                {
                    bottomLevel[tempX][tempY] = 2;
                    p++;
                }
            }
        placePieces();
        inGame = true;
    }
    @Override
    public void clickTile(int x, int y, MouseEvent e)
    {
        if(inGame)
        {
            if(turnTimer == 0 && y == height - 1)
            {
                turnTimer = 120;
                playerTurn();
            }
        }
        else
            exit = true;
    }
    public void playerTurn()
    {
        int roll = RNG.nextInt(6);
        bottomLevel[5][height - 1] = roll + 3;
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
                    if(human.y != 9)
                        human.y++;
                    else
                        win();
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
        placePieces();
    }
    public void enemyTurn()
    {
        int roll = RNG.nextInt(6);
        bottomLevel[5][height - 1] = roll + 3;
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
                    if(comp.y != 9)
                        comp.y++;
                    else
                        lose();
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
    public void teleport()
    {
        boolean done = false;
        if(turnTimer == 30 && bottomLevel[comp.x][comp.y] == 2)
        {
            int pOn = width * height - 1 / 10;
            for(int xOn = 0; xOn < width; xOn++)
            {
                for(int yOn = 0; yOn < height - 1; yOn++)
                {
                    if(bottomLevel[xOn][yOn] == 2)
                    {
                        pOn--;
                        if(!done && RNG.nextInt(pOn + 1) == 0)
                        {
                            //teleport the comp
                            comp.x = xOn;
                            comp.y = yOn;
                            done = true;
                        }
                    }
                }
            }
            placePieces();
        }
        if(turnTimer == 90 && bottomLevel[human.x][human.y] == 2)
        {
            int pOn = width * height - 1 / 10;
            for(int xOn = 0; xOn < width; xOn++)
            {
                for(int yOn = 0; yOn < height - 1; yOn++)
                {
                    if(bottomLevel[xOn][yOn] == 2)
                    {
                        pOn--;
                        if(!done && RNG.nextInt(pOn + 1) == 0)
                        {
                            //teleport player
                            human.x = xOn;
                            human.y = yOn;
                            done = true;
                        }
                    }
                }
            }
            placePieces();
        }
    }

    @Override
    public void win() 
    {
        inGame = false;
        System.out.println("you win");
    }

    @Override
    public void lose() 
    {
        inGame = false;
        System.out.println("you dont win");
    }
    
}
