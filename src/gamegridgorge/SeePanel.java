
package gamegridgorge;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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
    boolean inGame = false;
    
    
    Colours c = new Colours();
    Game game;
    SeePanel()
    {
        
    }
    
    public void startup()
    {
        //get which game the person wants to play
        //set this as game
        gameFontSize = 40;
        xTrans = 70;
        yTrans = 70;
        if(true)
        {
            game = new Minesweepo();
            GameGridGorge.window.setTitle("Minecraft");
            ((Minesweepo)game).newBoard(10, 10, 10);
            inGame = true;
        }
        if(false)
        {
            //temp
            game = new TicTacToe();
            GameGridGorge.window.setTitle("TicTacToe");
        }
    }
    
    public void run()
    {
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(c.BLACK);
        g.fillRect(0, 0, frameWidth, frameHeight);
        if(inGame)
        {
            g.setFont(new Font("Consolas", Font.PLAIN, gameFontSize));
            Color hue = c.HueShift();
            for(int xOn = 0; xOn < game.width; xOn++)
            {
                for(int yOn = 0; yOn < game.height; yOn++)
                {
                    g.setColor(c.WHITE);
                    g.drawString("" + game.bottomTranslation[game.bottomLevel[xOn][yOn]], xOn * gameFontSize + xTrans, yOn * gameFontSize + yTrans);
                    g.setColor(hue);
                    g.drawString("" + game.topTranslation[game.topLevel[xOn][yOn]], xOn * gameFontSize + xTrans, yOn * gameFontSize + yTrans);
                }
            }
            g.setColor(hue);
            int mX = (int)((mouseX - xTrans) / gameFontSize) * gameFontSize + xTrans;
            int mY = (int)((mouseY - yTrans) / gameFontSize) * gameFontSize + yTrans;
            g.drawLine(mX + 20, mY, mX - 20, mY);
            g.drawLine(mX, mY + 20, mX, mY - 20);
        }
        //draw a lower layer of characters depending on the game's lower translation array
        //draw an upper layer of inversely coloured characters the same way
        //draw UI
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
        game.clickTile((int)((mouseX - xTrans) / gameFontSize), (int)((mouseY - yTrans) / gameFontSize), e);
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
