/*
 * Bharat Kulkarni
 * bsk524
 */

import javax.swing.JOptionPane;

public class Game {
	
	private boolean testing;
	private Code gameCode;
	private Board gameBoard;
	private int numGuesses;
	
	public Game (boolean testing, int guesses) {
		this.testing = testing;
		gameCode = new Code();
		gameBoard = new Board();
		numGuesses = guesses;
	}
	
	public void runGame() {
		gameCode.createSecretCode();
		
		if (testing) {
			gameCode.printSecretCode();
		}
		
		String guess = "";
		while (numGuesses > 0) {
			
			guess = JOptionPane.showInputDialog("<html>You have <font color=red>" + numGuesses + " </font>guesses left.\n"
					+ "What is your guess?\n"
					+ "Type in the characters (without spaces) and press enter. To view previous entries, enter 'History'\n"
					+ "Enter guess:");
			
			if (guess == null) {
				break;
			}
			
			if (guess.equals("History") || guess.equals("history")) {
				gameBoard.showHistory();
			}		
			
			else {
				boolean correct = gameCode.evaluateGuess(guess);
				
				if (!correct) {
					JOptionPane.showMessageDialog(null, "Invalid input! Please try again ... ");
				}
				
				else {
					numGuesses--;	
					String output = gameCode.handleInput();
					String coloredGuess = getColoredText(guess);
					guess = "<html>Guess: " + coloredGuess + "\n" + output;
					gameBoard.addToHistory(guess);
					JOptionPane.showMessageDialog(null, guess);
					
					if (gameCode.checkGameStatus()) {
						break;
					}
				}
			}			
		}
		
		if (guess != null)
		{
			endGame();
		}
	}
	
	private void endGame() {
		
		String answer = gameCode.getSecretCode();
		if (gameCode.checkGameStatus()) {
			JOptionPane.showMessageDialog(null, "<html>You guessed " + getColoredText(answer) + " <font color=black>correctly!\nYou win!");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "<html><font color=red>You've run out of guesses! The secret code is</font> " + getColoredText(answer));
		}
	}
	
	private String getColoredText (String input) {
		String output = "";
		
		for (int i = 0; i < 4; i++) {
			char c = input.charAt(i);
			
			if (c == 'R') {
				output += "<font color=red>" + c;
			}
			
			else if (c == 'O') {
				output += "<font color=orange>" + c;
			}
			
			else if (c == 'Y') {
				output += "<font color=#aaaa00>" + c;
			}
			
			else if (c == 'G') {
				output += "<font color=green>" + c;
			}
			
			else if (c == 'B') {
				output += "<font color=blue>" + c;
			}
			
			else if (c == 'P') {
				output += "<font color=purple>" + c;
			}
			
			else {
				output += c;
			}
		}
		return output;
	}
}