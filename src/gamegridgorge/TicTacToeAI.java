package gamegridgorge;

import java.awt.event.MouseEvent;

/**
 *
 * @author
 */
public class TicTacToeAI extends Game {

    private int moveCount = 0;
    private boolean tie = true;
    private boolean invalidMove = true;
    private boolean full = false;
    private boolean tied = false;
    private boolean gameOver = false;
    private boolean won = false;
    private int turnCountAI = 0;
    private int whoseTurn = 1;

    /*
        
        BottomLevel:
        0 = nothing
        1 = x
        2 = o
        
     */
    // setup a tictactoe board
    public TicTacToeAI() {
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
    public void turnAI() {
        if (this.turnCountAI == 0) {
            this.bottomLevel[0][0] = 1;
            this.turnCountAI++;
        }
        if (this.turnCountAI > 0) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (this.bottomLevel[i][j] == 2) {
                        if (i == 0 && j == 1) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[2][0] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k == 1 && l == 0) {
                                                    this.bottomLevel[2][2] = 1;
                                                    this.turnCountAI++;
                                                } else {
                                                    this.bottomLevel[1][0] = 1;
                                                    this.gameOver = true;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m == 1 && n == 1) {
                                                                    this.bottomLevel[2][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 0 && j == 2) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[2][2] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 1 && l != 1) {
                                                    this.bottomLevel[1][1] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[2][0] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 0) {
                                                                    this.bottomLevel[1][0] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[2][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 1 && j == 0) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[0][2] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 0 && l != 1) {
                                                    this.bottomLevel[0][1] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[2][2] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 1) {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[1][2] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 1 && j == 1) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[2][0] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 1 && l != 0) {
                                                    this.bottomLevel[1][0] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[1][2] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m == 0 && n == 1) {
                                                                    this.bottomLevel[2][1] = 1;
                                                                    this.turnCountAI++;
                                                                } else if (m == 2 && n == 1) {
                                                                    this.bottomLevel[0][1] = 1;
                                                                    this.turnCountAI++;
                                                                } else {
                                                                    this.bottomLevel[0][1] = 1;
                                                                    this.turnCountAI++;
                                                                }
                                                            } else {
                                                                for (int o = 0; o < 3; i++) {
                                                                    for (int p = 0; p < 3; j++) {
                                                                        if (this.bottomLevel[o][p] == ' ') {
                                                                            if (this.turnCountAI == 4) {
                                                                                this.bottomLevel[o][p] = 1;
                                                                                this.tie = true;
                                                                                // tie
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 1 && j == 2) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[0][2] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 0 && l != 1) {
                                                    this.bottomLevel[0][1] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[2][0] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 1) {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[1][0] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 2 && j == 0) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[0][2] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 0 && l != 1) {
                                                    this.bottomLevel[0][1] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[2][2] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 1) {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[1][2] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 2 && j == 1) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[2][0] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 1 && l != 0) {
                                                    this.bottomLevel[1][0] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[0][2] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 1) {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[0][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (i == 2 && j == 2) {
                            if (this.turnCountAI == 1) {
                                this.bottomLevel[0][2] = 1;
                                this.turnCountAI++;
                            } else {
                                for (int k = 0; k < 3; i++) {
                                    for (int l = 0; l < 3; j++) {
                                        if (this.bottomLevel[k][l] == 2 && k != i && l != j) {
                                            if (this.turnCountAI == 2) {
                                                if (k != 0 && l != 1) {
                                                    this.bottomLevel[0][1] = 1;
                                                    this.gameOver = true;
                                                    // game over
                                                } else {
                                                    this.bottomLevel[2][0] = 1;
                                                    this.turnCountAI++;
                                                }
                                            } else if (!this.gameOver) {
                                                for (int m = 0; m < 3; i++) {
                                                    for (int n = 0; n < 3; j++) {
                                                        if (this.bottomLevel[m][n] == 2 && m != k && n != l) {
                                                            if (this.turnCountAI == 3) {
                                                                if (m != 1 && n != 1) {
                                                                    this.bottomLevel[1][1] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                } else {
                                                                    this.bottomLevel[1][0] = 1;
                                                                    this.gameOver = true;
                                                                    // game over
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // use just p2 in main class if AI is selected
    public void turnP1(int row, int column) {
        while (this.invalidMove) {
            if (this.bottomLevel[row][column] == ' ') {
                this.bottomLevel[row][column] = 1;
                this.invalidMove = false;
            }
        }
        this.invalidMove = true;
    }

    public void turnP2(int row, int column) {
        while (this.invalidMove) {
            if (this.bottomLevel[row][column] == ' ') {
                this.bottomLevel[row][column] = 2;
                this.invalidMove = false;
            }
        }
        this.invalidMove = true;
    }

    public void endCheck2P() {
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                if (b == 0 && !this.won) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a][b + 1]
                            && this.bottomLevel[a][b + 1] == this.bottomLevel[a][b + 2]) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        this.won = true;
                    }
                }
                if (a == 0 && !this.won) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b]
                            && this.bottomLevel[a + 1][b] == this.bottomLevel[a + 2][b]) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        this.won = true;
                    }
                }
                if (a == 0 && b == 0 && !this.won) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b + 1]
                            && this.bottomLevel[a + 1][b + 1] == this.bottomLevel[a + 2][b + 2]) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        this.won = true;
                    }
                }
                if (a == 0 && b == 2 && !this.won) {
                    if (this.bottomLevel[a][b] == this.bottomLevel[a + 1][b - 1]
                            && this.bottomLevel[a][b] == this.bottomLevel[a + 2][b - 2]) {
                        // make a draw string
                        System.out.println("Player " + this.bottomLevel[a][b] + " Wins!");
                        this.won = true;
                    }
                }
            }
        }
    }

    // use after each turn if playing AI
    public void endCheckAI() {
        if (this.gameOver) {
            // maybe make this a draw string
            System.out.println("The AI won hooray!");
            inGame = false;
        }
        if (tie) {
            // make this one a draw string too
            System.out.println("You tied the AI, nice!");
            inGame = false;
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
                    turnAI();
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
