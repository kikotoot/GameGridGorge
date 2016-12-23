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

// check tic tac toe for backup code
public class TicTacToeSet extends JPanel implements KeyListener, MouseMotionListener {

	private char[][] playerPosition = new char[3][3];
	private int moveCount = 0;
	private boolean tie = true;
	private boolean invalidMove = true;
	private boolean full = false;
	private boolean tied = false;
	private boolean gameOver = false;
	private boolean won = false;
	private int turnCountAI = 0;
	BufferedImage imgBuffer = new BufferedImage(450, 525, BufferedImage.TYPE_INT_ARGB);
	Graphics g = imgBuffer.getGraphics();
	BufferedImage imgBackground;
	BufferedImage[] imgPlayerX = new BufferedImage[5];
	BufferedImage[] imgPlayerO = new BufferedImage[4];

	public TicTacToeSet() throws IOException {

		URL fileURL = getClass().getResource("tic tac toe board.jpg");
		imgBackground = ImageIO.read(fileURL);

		fileURL = getClass().getResource("X.jpg");
		for (int i = 0; i <= 4; i++) {
			imgPlayerX[i] = ImageIO.read(fileURL);
		}

		fileURL = getClass().getResource("O.png");
		for (int i = 0; i <= 3; i++) {
			imgPlayerO[i] = ImageIO.read(fileURL);
		}

	}

	// setup a tictactoe board
	public TicTacToeSet(String startGame) {
		// fill in rows
		for (int i = 0; i < 3; i++) {
			// fill in columns
			for (int j = 0; j < 3; j++) {
				this.playerPosition[i][j] = ' ';
			}
		}
	}

	public void drawGrid() {
		g.drawImage(imgBackground, 0, 0, 450, 525, null);
		// check where moves were made and draw game pieces there
		int timesXPlayed = 0;
		int timesOPlayed = 0;
		// runs through rows
		for (int i = 0; i < 3; i++) {
			// runs through columns
			for (int j = 0; j < 3; j++) {
				if (this.playerPosition[i][j] == 'X') {
					g.drawImage(this.imgPlayerX[timesXPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
					timesXPlayed++;
				} else if (this.playerPosition[i][j] == 'O') {
					g.drawImage(this.imgPlayerO[timesOPlayed], 10 + 90 * (i + 1), 50 + 90 * (j + 1), 175, 175, null);
					timesOPlayed++;
				}
			}
		}
	}

	// in main class have if statement if the person chose AI instead of two
	// player game
	// have two different loops (one has p1 turn p2 turn, other has ai turn, p2
	// turn)
	// AI goes first always
	public void turnAI() {
		if (this.turnCountAI == 0) {
			this.playerPosition[0][0] = 'X';
			this.turnCountAI++;
		}
		if (this.turnCountAI > 0) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (this.playerPosition[i][j] == 'O') {
						if (i == 0 && j == 1) {
							if (this.turnCountAI == 1) {
								this.playerPosition[2][0] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k == 1 && l == 0) {
													this.playerPosition[2][2] = 'X';
													this.turnCountAI++;
												} else {
													this.playerPosition[1][0] = 'X';
													this.gameOver = true;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m == 1 && n == 1) {
																	this.playerPosition[2][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[1][1] = 'X';
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
								this.playerPosition[2][2] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 1 && l != 1) {
													this.playerPosition[1][1] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[2][0] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 0) {
																	this.playerPosition[1][0] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[2][1] = 'X';
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
								this.playerPosition[0][2] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 0 && l != 1) {
													this.playerPosition[0][1] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[2][2] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 1) {
																	this.playerPosition[1][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[1][2] = 'X';
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
								this.playerPosition[2][0] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 1 && l != 0) {
													this.playerPosition[1][0] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[1][2] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m == 0 && n == 1) {
																	this.playerPosition[2][1] = 'X';
																	this.turnCountAI++;
																} else if (m == 2 && n == 1) {
																	this.playerPosition[0][1] = 'X';
																	this.turnCountAI++;
																} else {
																	this.playerPosition[0][1] = 'X';
																	this.turnCountAI++;
																}
															} else {
																for (int o = 0; o < 3; i++) {
																	for (int p = 0; p < 3; j++) {
																		if (this.playerPosition[o][p] == ' ') {
																			if (this.turnCountAI == 4) {
																				this.playerPosition[o][p] = 'X';
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
								this.playerPosition[0][2] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 0 && l != 1) {
													this.playerPosition[0][1] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[2][0] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 1) {
																	this.playerPosition[1][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[1][0] = 'X';
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
								this.playerPosition[0][2] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 0 && l != 1) {
													this.playerPosition[0][1] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[2][2] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 1) {
																	this.playerPosition[1][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[1][2] = 'X';
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
								this.playerPosition[2][0] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 1 && l != 0) {
													this.playerPosition[1][0] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[0][2] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 1) {
																	this.playerPosition[1][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[0][1] = 'X';
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
								this.playerPosition[0][2] = 'X';
								this.turnCountAI++;
							} else {
								for (int k = 0; k < 3; i++) {
									for (int l = 0; l < 3; j++) {
										if (this.playerPosition[k][l] == 'O' && k != i && l != j) {
											if (this.turnCountAI == 2) {
												if (k != 0 && l != 1) {
													this.playerPosition[0][1] = 'X';
													this.gameOver = true;
													// game over
												} else {
													this.playerPosition[2][0] = 'X';
													this.turnCountAI++;
												}
											} else if (!this.gameOver) {
												for (int m = 0; m < 3; i++) {
													for (int n = 0; n < 3; j++) {
														if (this.playerPosition[m][n] == 'O' && m != k && n != l) {
															if (this.turnCountAI == 3) {
																if (m != 1 && n != 1) {
																	this.playerPosition[1][1] = 'X';
																	this.gameOver = true;
																	// game over
																} else {
																	this.playerPosition[1][0] = 'X';
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
			if (this.playerPosition[row][column] == ' ') {
				this.playerPosition[row][column] = 'X';
				this.invalidMove = false;
			}
		}
		this.invalidMove = true;
	}

	public void turnP2(int row, int column) {
		while (this.invalidMove) {
			if (this.playerPosition[row][column] == ' ') {
				this.playerPosition[row][column] = 'O';
				this.invalidMove = false;
			}
		}
		this.invalidMove = true;
	}

	public void endCheck2P() {
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				if (b == 0 && !this.won) {
					if (this.playerPosition[a][b] == this.playerPosition[a][b + 1]
							&& this.playerPosition[a][b + 1] == this.playerPosition[a][b + 2]) {
						// make a draw string
						System.out.println("Player " + this.playerPosition[a][b] + " Wins!");
						this.won = true;
					}
				}
				if (a == 0 && !this.won) {
					if (this.playerPosition[a][b] == this.playerPosition[a + 1][b]
							&& this.playerPosition[a + 1][b] == this.playerPosition[a + 2][b]) {
						// make a draw string
						System.out.println("Player " + this.playerPosition[a][b] + " Wins!");
						this.won = true;
					}
				}
				if (a == 0 && b == 0 && !this.won) {
					if (this.playerPosition[a][b] == this.playerPosition[a + 1][b + 1]
							&& this.playerPosition[a + 1][b + 1] == this.playerPosition[a + 2][b + 2]) {
						// make a draw string
						System.out.println("Player " + this.playerPosition[a][b] + " Wins!");
						this.won = true;
					}
				}
				if (a == 0 && b == 2 && !this.won) {
					if (this.playerPosition[a][b] == this.playerPosition[a + 1][b - 1]
							&& this.playerPosition[a][b] == this.playerPosition[a + 2][b - 2]) {
						// make a draw string
						System.out.println("Player " + this.playerPosition[a][b] + " Wins!");
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
		}
		if (tie) {
			// make this one a draw string too
			System.out.println("You tied the AI, nice!");
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
