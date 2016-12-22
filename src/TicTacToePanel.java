import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class TicTacToePanel {

	public static void main(String[] args)throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		// declare and initialize a JFrame
		JFrame myFrame = new JFrame();

		// make our frame visible
		// configure frame settings
		myFrame.setTitle("Tic Tac Toe"); 
		myFrame.setSize(450, 525); 
		myFrame.setResizable(false); 
		
		//terminates program when you close the window
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//set where the frame will appear
		myFrame.setLocationRelativeTo(null); 
		
		// then make frame appear
		myFrame.setVisible(true); 
		
		TicTacToeSet tttGameBoard = new TicTacToeSet();

		// customize panel
		tttGameBoard.setSize(450, 525);

		// put the panel inside the frame
		myFrame.setContentPane(tttGameBoard);

		// enable mouse motion listener
		tttGameBoard.addMouseMotionListener(tttGameBoard);

		// the loop runs at about 60 fps
		//while (tttGameBoard.getTie() && !tttGameBoard.getFull()) {
		//filler
		while(true){
			tttGameBoard.drawGrid(); 
			Thread.sleep(16); 
			//TODO add all game playing methods
		}
	}

}
