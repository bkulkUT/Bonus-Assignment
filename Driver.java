/*
 * Bharat Kulkarni
 * bsk524
 */

import javax.swing.JOptionPane;

public class Driver {
	final static int YES = 0;
	
	public static void main (String args[]) {
		
		int start = showIntro();
		while (true) {
			if (start == YES) {
				int guesses = getGuesses();
				
				if (guesses == -1) {
					JOptionPane.showMessageDialog(null, "Goodbye!");
					break;
				}
				
				Game myGame = new Game(false, guesses);
				myGame.runGame();
				start = JOptionPane.showConfirmDialog(null, "Do you want to play again?", null, JOptionPane.YES_NO_OPTION);	
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Goodbye!");
				break;
			}
		}	
	}
	
	public static int showIntro() {
		
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
									  );
		
		int answer = JOptionPane.showConfirmDialog(null, "Are you ready to play?", null, JOptionPane.YES_NO_OPTION);
		
		return answer;
	}
	
	public static int getGuesses() {
		
		while (true) {
			int result;
			String input = JOptionPane.showInputDialog(null, "Enter the number of guesses (between 5-12) that you want");
			
			if (input == null) {
				return -1;
			}
			
			else if (input.matches("[0123456789]+")) {
				try {
					result = Integer.parseInt(input);
				}
				
				catch (NumberFormatException nfe) {
					result = -1;
				}
				
				if (result >= 5 && result <= 12) {
					return result;
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Invalid input! Please try again ...");
				}
			}
	
			else {
				JOptionPane.showMessageDialog(null, "Invalid input! Please try again ...");
			}
		}
	}
}