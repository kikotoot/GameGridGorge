
package gamegridgorge;

import java.io.IOException;
import javax.swing.JFrame;




/**
 *
 * @author L along with __
 */
public class GameGridGorge 
{
    public static boolean killswitch = false;
    public static JFrame window;
    public static void main(String[] args) throws IOException, InterruptedException
    {
        
        int windowWidth, windowHeight;
        window = new JFrame();
        window.setTitle("No Game Selected");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        SeePanel panel1 = new SeePanel();
        panel1.frameHeightMin = window.getHeight();
        panel1.frameWidthMin = window.getWidth();
        Thread.sleep(2);
        
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        Thread.sleep(2);
        
        panel1.setSize(800, 600);
        panel1.repaint();
        window.setContentPane(panel1);
        panel1.requestFocus();
        Thread.sleep(2);
        panel1.addKeyListener(panel1);
        Thread.sleep(1);
        panel1.addMouseMotionListener(panel1);
        Thread.sleep(1);
        panel1.addMouseListener(panel1);
        Thread.sleep(2);
        
        
        windowWidth = window.getWidth();
        windowHeight = window.getHeight();
        panel1.frameWidth = windowWidth;
        panel1.frameHeight = windowHeight - panel1.frameHeightMin;
        panel1.startup();
        Thread.sleep(2);
        
        
        while(!killswitch)
        {
            windowWidth = window.getWidth();
            windowHeight = window.getHeight();
            panel1.setSize(windowWidth, windowHeight);
            panel1.frameWidth = windowWidth;
            panel1.frameHeight = windowHeight - panel1.frameHeightMin;
            panel1.run();
            panel1.repaint();
            Thread.sleep(panel1.framerate);
            
        }
    }
}
