
package gamegridgorge;

import java.awt.event.MouseEvent;

/**
 *
 * @author
 */
public class TicTacToe extends Game
{
    private int[][] bottomLevel = new int[3][3];
    private int moveCount = 0;
    private boolean tie = true;
    private boolean invalidMove = true;
    private boolean full = false;
    private int turnCountAI = 0;

    TicTacToe()
    {

    }

    //setup a tictactoe board
    public TicTacToe(String startGame){
            //fill in rows
            for(int i = 0; i < 3; i++){
                    //fill in columns
                    for(int j = 0; j < 3; j++){
                            bottomLevel[i][j] = ' ';
                    }
            }
    }


    @Override
    public void clickTile(int x, int y, MouseEvent e) 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void win() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void lose() 
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
