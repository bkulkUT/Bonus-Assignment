/*
 * Bharat Kulkarni
 * bsk524
 */
package bonus;

import java.util.Arrays;

public class Code {
	
	private final char[] colors = new char[6];
	private char[] secretCode = new char[4];
	private String secretCode_string = "";
	private char[] userGuess = new char[4];
	private Pegs myPegs = new Pegs();
	private boolean wonGame = false;
	
	public Code() {
		colors[0] = 'R';
		colors[1] = 'O';
		colors[2] = 'Y';
		colors[3] = 'G';
		colors[4] = 'B';
		colors[5] = 'P';
	}
	
	public void createSecretCode () {
		
		for (int i = 0; i < secretCode.length; i++) {
			int random = (int) (Math.random() * 5);
			secretCode[i] = colors[random];
			secretCode_string += secretCode[i] + " ";
		}
	}
	
	public boolean evaluateGuess(String guess) {
				
		if (guess.length() != 4) {
			return false;
		}
		
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) != 'R' && guess.charAt(i) != 'O' && guess.charAt(i) != 'Y' && guess.charAt(i) != 'G' && guess.charAt(i) != 'B' && guess.charAt(i) != 'P') {
				return false;
			}
			
			else {
				userGuess[i] = guess.charAt(i);
				System.out.print(userGuess[i] + " ");
			}
		}
		
		System.out.print("\n");
		
		return true;
	}
	
	public String handleInput() {
		String outputResult = myPegs.createPegs(userGuess, secretCode);
		
		if (myPegs.getBlackPegs() == 4) {
			wonGame = true;
		}
		
		return outputResult;
	}
	
	public boolean checkGameStatus() {
		
		return wonGame;
	}

	public void printSecretCode() {
		
//		String code = "";
//		for (int i = 0; i < secretCode.length; i++) {
//			code += secretCode[i] + " ";
//		}
//		System.out.println("The secret code is ... " + code);
		System.out.println("The secret code is ... " + secretCode_string);

	}
	
	public String getSecretCode() {
		
		return secretCode_string;
	}

		
}



















