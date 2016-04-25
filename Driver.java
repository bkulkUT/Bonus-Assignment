/*
 * Bharat Kulkarni
 * bsk524
 */
package bonus;

import javax.swing.JOptionPane;

public class Driver {
	public static void main (String args[]) {
		
		boolean start = showIntro();

		if (start) {
			Game myGame = new Game(true);
			myGame.runGame();
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Goodbye!");
		}
	}
	
	public static boolean showIntro() {
		
		JOptionPane.showMessageDialog(null, "Welcome to Mastermind. Here are the rules.\n\n"
											+ "This is a text version of the classic board game Mastermind.\n"
											+ "The computer will think of a secret code. The code consists of 4 colored pegs.\n"
											+ "The pegs may be one of six colors: blue, green, orange, purple, red, or yellow. A color may appear "
											+ "more than once in the code.\nYou try to guess what colored pegs are in the code and what order they are "
											+ "in. After you make a valid guess the result (feedback) will be displayed.\n"
											+ "The result consists of a black peg for each peg you have guessed exactly correct (color and position) "
											+ "in your guess. For each peg in the guess that is the correct color, but is out of position, you get "
											+ "a white peg.\nFor each peg, which is fully incorrect, you get no feedback.\n"
											+ "Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.\n"
											+ "When entering guesses you only need to enter the first character of each color as a capital letter.\n\n"
											+ "You have 12 guesses to figure out the secret code or you lose the game");
		
		int answer = JOptionPane.showConfirmDialog(null, "Are you ready to play? (Y/N)", null, JOptionPane.YES_NO_OPTION);
		
		if (answer == 0) 
			return true;
		
		return false;
	}
}





















