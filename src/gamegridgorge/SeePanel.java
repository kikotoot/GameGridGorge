
package gamegridgorge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author L
 */
public class SeePanel extends JPanel implements KeyListener, MouseMotionListener, MouseListener
{
    int framerate = 16, gameFontSize;
    int frameWidth = 1, frameHeight = 1;
    int frameWidthMin = 0, frameHeightMin = 0;
    int xTrans, yTrans;
    int mouseX = 0, mouseY = 0;
    boolean gameLoaded = false;
    
    ArrayList<Button> buttons = new ArrayList();
    char command = ' ';
    
    Colours c = new Colours();
    Game game;
    /*
    all games should extend the "game" class. 
    any methods added to the subclass should have a check for that the "command" variable is equal to that of the subclass, then a downcast to use the variable
    variables from the game superclass should be initialized in the subclass' constructer 
    */
    SeePanel()
    {
        
    }
    
    public void startup()
    {
        //put code needed to be run once upon startup here
        gameFontSize = 30;
        addButton(40, 40, "Minesweeper", '☼');
        addButton(40, 90, "Portals", 'o');;
        addButton(40, 140, "tic", 'x');
        xTrans = 70;
        yTrans = 70;
        gameLoaded = false;
        GameGridGorge.window.setTitle("No Game Selected");
    }
    private void addButton(int x, int y, String label, char cmd)
    {
        buttons.add(new Button(new Rectangle(x, y, label.length() * gameFontSize * 3 / 5, gameFontSize + 10), label, cmd));
    }
    public void run()
    {
        if(!gameLoaded)
        {
            //get a game to play
            switch(command)
            {
                case '☼':
                {
                    game = new Minesweeper();
                    initGame(20, 70, 70);
                    ((Minesweeper)game).newBoard(30, 20, 50);
                    gameLoaded = true;
                }
                break;
                case 'x':
                {
                    //appendix code
                    game = new TicTacToe();
                    initGame(60, 70, 70);
                    //any initialization, espescially that of the grid (will be drawn after gameLoaded becomes true)
                    gameLoaded = true;
                }
                break;
                case 'o':
                {
                    game = new Portals();
                    initGame(30, 70, 70);
                    ((Portals)game).newBoard(10, 10);
                    gameLoaded = true;
                }
                break;
            }
        }
        else
        {
            switch(command)
            {
                //game specific run commands
                case 'o':
                {
                    if(((Portals)game).turnTimer == 90 || ((Portals)game).turnTimer == 30)
                        ((Portals)game).teleport();
                    if(((Portals)game).turnTimer == 60)
                        ((Portals)game).enemyTurn();
                    if(((Portals)game).turnTimer > 0)
                        ((Portals)game).turnTimer--;
                }
                break;
                case 'x':
                {
                    //((TicTacToe)game).turnAI();
                }
                break;
            }
            if(game.exit)
            {
                command = ' ';
                gameFontSize = 30;
                xTrans = 70;
                yTrans = 70;
                gameLoaded = false;
                GameGridGorge.window.setTitle("No Game Selected");
            }
        }
    }
    private void initGame(int fontSize, int xT, int yT)
    {
        gameFontSize = fontSize;
        xTrans = xT;
        yTrans = yT;
        GameGridGorge.window.setTitle(game.getName());
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(c.BACKGROUND);
        g.fillRect(0, 0, frameWidth, frameHeight);
        g.setFont(new Font("Consolas", Font.PLAIN, gameFontSize));
        Color hue = c.HueShift();
            
        if(gameLoaded)
        {
            for(int xOn = 0; xOn < game.width; xOn++)
            {
                for(int yOn = 0; yOn < game.height; yOn++)
                {
                    g.setColor(c.FILLER);
                    g.drawString("" + game.bottomTranslation[game.bottomLevel[xOn][yOn]], xOn * gameFontSize + xTrans + gameFontSize / 4, (yOn + 1) * gameFontSize + yTrans - gameFontSize / 4);
                    if(game.topTranslation[game.topLevel[xOn][yOn]] != ' ')
                    {
                        if(game.getCoverLevels())
                            g.fillRect(xOn * gameFontSize + xTrans, yOn * gameFontSize + yTrans, gameFontSize, gameFontSize);
                        g.setColor(hue);
                        g.drawString("" + game.topTranslation[game.topLevel[xOn][yOn]], xOn * gameFontSize + xTrans + gameFontSize / 4, (yOn + 1) * gameFontSize + yTrans - gameFontSize / 4);
                    }
                }
            }
            g.setColor(hue);
            if(game.getDrawBorder())
            {
                g.drawRect(xTrans, yTrans, game.width * gameFontSize, game.height * gameFontSize);
            }
            if(game.getDrawGrid())
            {
                for(int xOn = 0; xOn < game.width; xOn++)
                {
                    g.setColor(hue);
                    g.drawLine(xTrans + xOn * gameFontSize, yTrans, xTrans + xOn * gameFontSize, yTrans + game.height * gameFontSize);

                }
                for(int yOn = 0; yOn < game.height; yOn++)
                {
                    g.setColor(hue);
                    g.drawLine(xTrans, yTrans + yOn * gameFontSize, xTrans + game.width * gameFontSize, yTrans + yOn * gameFontSize);
                }
            }
//            draws a cross where the mouse is calculated to be
//            int mX = (int)((mouseX - xTrans) / gameFontSize) * gameFontSize + xTrans;
//            int mY = (int)((mouseY - yTrans) / gameFontSize) * gameFontSize + yTrans;
//            g.drawLine(mX + 20, mY, mX - 20, mY);
//            g.drawLine(mX, mY + 20, mX, mY - 20);
        }
        else
        {
            Button tempButton;
            for(int bOn = 0; bOn < buttons.size(); bOn++)
            {
                tempButton = buttons.get(bOn);
                g.setColor(c.FILLER);
                g.fillRect(tempButton.area.x, tempButton.area.y, tempButton.area.width, tempButton.area.height);
                g.setColor(hue);
                g.drawRect(tempButton.area.x, tempButton.area.y, tempButton.area.width, tempButton.area.height);
                g.setColor(hue);
                g.drawString(tempButton.text, tempButton.area.x + gameFontSize / 4, tempButton.area.y + gameFontSize);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }

    @Override
    public void keyPressed(KeyEvent e) 
    {
        
    }

    @Override
    public void keyReleased(KeyEvent e) 
    {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        if(gameLoaded)
            game.clickTile((int)((mouseX - xTrans) / gameFontSize), (int)((mouseY - yTrans) / gameFontSize), e);
        else
        {
            for(int bOn = 0; bOn < buttons.size(); bOn++)
            {
                if(buttons.get(bOn).collides(e.getX(), e.getY()))
                    command = buttons.get(bOn).command;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        
    }
    
}
