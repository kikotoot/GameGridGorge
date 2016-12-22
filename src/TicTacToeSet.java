import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TicTacToeSet extends JPanel implements KeyListener, MouseMotionListener {

	private char[][] playerPosition = new char[3][3];
	private int moveCount = 0;
	private boolean tie = true;
	private boolean invalidMove = true;
	private boolean full = false;
	private int turnCountAI = 0;
	BufferedImage imgBuffer = new BufferedImage(450, 525, BufferedImage.TYPE_INT_ARGB);
	Graphics g = imgBuffer.getGraphics();
	BufferedImage imgBackground;
	BufferedImage[] imgPlayerX = new BufferedImage[5];
	BufferedImage[] imgPlayerO = new BufferedImage[4];
	
	public TicTacToeSet() throws IOException{
		
		URL fileURL = getClass().getResource("tic tac toe board.jpg"); 
		imgBackground = ImageIO.read(fileURL);
		
		fileURL = getClass().getResource("X.jpg");
		for(int i = 0; i <= 4; i++){
			imgPlayerX[i] = ImageIO.read(fileURL);
		}
		
		fileURL = getClass().getResource("O.png"); 
		for(int i = 0; i <= 3; i++){
			imgPlayerO[i] = ImageIO.read(fileURL);
		}
		
	}
	
	//setup a tictactoe board
	public TicTacToeSet(String startGame){
		//fill in rows
		for(int i = 0; i < 3; i++){
			//fill in columns
			for(int j = 0; j < 3; j++){
				playerPosition[i][j] = ' ';
			}
		}
	}
	
	public void drawGrid (){
		g.drawImage(imgBackground, 0, 0, 450, 525, null);
		//check where moves were made and draw game pieces there
		int timesXPlayed = 0;
		int timesOPlayed = 0;
		//runs through rows
		for(int i = 0; i < 3; i++){
			//runs through columns
			for(int j = 0; j < 3; j++){
				if(playerPosition[i][j] == 'X'){
					g.drawImage(imgPlayerX[timesXPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
					timesXPlayed++;
				}
				else if(playerPosition[i][j] == 'O'){
					g.drawImage(imgPlayerO[timesOPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
					timesOPlayed++;
				}
			}
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
