
package gamegridgorge;

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
    int framerate = 16;
    int frameWidth = 1, frameHeight = 1;
    int frameWidthMin = 0, frameHeightMin = 0;
    
    Colours c = new Colours();
    Game game;
    SeePanel()
    {
        
    }
    
    public void startup()
    {
        //get which game the person wants to play
        //set this as game
        if(true)
        {
            game = new Minesweepo();
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
        
    }

    @Override
    public void mouseMoved(MouseEvent e) 
    {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
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
