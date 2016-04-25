/*
 * Bharat Kulkarni
 * bsk524
 */
package bonus;

import javax.swing.JOptionPane;

public class Game {
	
	private boolean testing;
	private Code gameCode;
	private Board gameBoard;
	private int numGuesses;
	
	public Game (boolean testing) {
		this.testing = testing;
		gameCode = new Code();
		gameBoard = new Board();
		numGuesses = 12;
	}
	
	public void runGame() {
		gameCode.createSecretCode();
		
		if (testing) {
			gameCode.printSecretCode();
		}
		
		while (numGuesses > 0) {
			
			String guess = JOptionPane.showInputDialog("You have " + numGuesses + " guesses left.\n"
					+ "What is your guess?\n"
					+ "(Type in the characters and press enter. To view previous entries, enter 'History')\n"
					+ "Enter guess:");
			
			if (guess.equals("History")) {
				gameBoard.showHistory();
			}		
			
			else {
				boolean correct = gameCode.evaluateGuess(guess);
				
				if (!correct) {
					JOptionPane.showMessageDialog(null, "Invalid input! Please try again ... ");
				}
				
				else {
					String output = gameCode.handleInput();
					guess = "Guess: " + guess + "\n" + output;
					gameBoard.addToHistory(guess);
					JOptionPane.showMessageDialog(null, guess);
					
					if (gameCode.checkGameStatus()) {
						break;
					}
					numGuesses--;	
				}
			}			
		}
		
		System.out.println("Outside of the while-loop in runGame ... !");
	}
}








