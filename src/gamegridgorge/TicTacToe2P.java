package gamegridgorge;

import java.awt.event.MouseEvent;

/**
 *
 * @author Jacob, L
 */
public class TicTacToe2P extends Game {

    private boolean invalidMove = true;
    private int whoseTurn = 1;

    /*
        
        BottomLevel:
        0 = nothing
        1 = x
        2 = o
        
     */
    // setup a tictactoe board
    public TicTacToe2P() {
        width = 3;
        height = 3;
        name = "Tic Tac Toe";
        bottomLevel = new int[3][3];
        topLevel = new int[3][3];
        bottomTranslation = new char[]{' ', 'X', 'O'};
        topTranslation = new char[]{' '};
        drawGrid = true;
        drawBorder = false;
        coverLevels = false;
        inGame = true;
        //initialize boards with just the simple new array
    }

    // in main class have if statement if the person chose AI instead of two
    // player game
    // have two different loops (one has p1 turn p2 turn, other has ai turn, p2
    // turn)
    // AI goes first always
    

    // use just p2 in main class if AI is selected
    public void turnP1(int row, int column) {
        while (this.invalidMove) {
            if (this.bottomLevel[row][column] == 0) {
                this.bottomLevel[row][column] = 1;
                this.invalidMove = false;
            }
        }
        this.invalidMove = true;
    }

    public void turnP2(int row, int column) {
        while (this.invalidMove) {
            if (this.bottomLevel[row][column] == 0) {
                this.bottomLevel[row][column] = 2;
                this.invalidMove = false;
            }
        }
        this.invalidMove = true;
    }

   public void endCheck2P() {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (b == 0 && inGame) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a][b + 1]
                            && this.bottomLevel[a][b + 1] == this.bottomLevel[a][b + 2]
                            && this.bottomLevel[a][b] != 0) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        inGame = false;
                    }
                }
                if (a == 0 && inGame) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b]
                            && this.bottomLevel[a + 1][b] == this.bottomLevel[a + 2][b]
                            && this.bottomLevel[a][b] != 0) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        inGame = false;
                    }
                }
                if (a == 0 && b == 0 && inGame) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b + 1]
                            && this.bottomLevel[a + 1][b + 1] == this.bottomLevel[a + 2][b + 2]
                            && this.bottomLevel[a][b] != 0) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        inGame = false;
                    }
                }
                if (a == 0 && b == 2 && inGame) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b - 1]
                            && this.bottomLevel[a][b] == this.bottomLevel[a + 2][b - 2]
                            && this.bottomLevel[a][b] != 0) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        inGame = false;
                    }
                }
            }
        }
    }

   

    @Override
    public void clickTile(int x, int y, MouseEvent e) {
        if (inGame) {
            switch (whoseTurn) {
                case 1: {
                    turnP1(x, y);
                    whoseTurn = 2;
                }
                break;
                case 2: {
                    turnP2(x, y);
                    whoseTurn = 1;
                }
                break;
            }
            endCheck2P();
        } else {
            exit = true;
        }
    }

    @Override
    public void win() {

    }

    @Override
    public void lose() {

    }

}
