
package gamegridgorge;

import java.awt.event.MouseEvent;

/**
 *
 * @author
 */
public class TicTacToe extends Game
{
    private char[][] bottomBoard = new char[3][3];
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
                            bottomBoard[i][j] = ' ';
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
                            if(bottomBoard[i][j] == 'X'){
                                    g.drawImage(imgPlayerX[timesXPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
                                    timesXPlayed++;
                            }
                            else if(bottomBoard[i][j] == 'O'){
                                    g.drawImage(imgPlayerO[timesOPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
                                    timesOPlayed++;
                            }
                    }
            }
    }

    @Override
    public void clickTile(int x, int y, MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void win() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
