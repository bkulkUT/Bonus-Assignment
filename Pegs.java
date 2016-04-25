/*
 * Bharat Kulkarni
 * bsk524
 */
package bonus;

import java.util.ArrayList;

public class Pegs {
	private int whitePegs = 0;
	private int blackPegs = 0;
	
	public String createPegs(char[] userInput, char[] secretCode) {
		String result;
	    ArrayList<Character> countedOnce = new ArrayList<Character>();
		whitePegs = 0;
		blackPegs = 0;
		
		for (int k = 0; k < 4; k++) {
			if (userInput[k] == secretCode[k]) {
				blackPegs++;
			}
		}
		
	    for (char eachColor : secretCode) {
	        for (int j = 0; j < 4; j++) {
	            if (eachColor == userInput[j] && !countedOnce.contains(userInput[j])) {
		          countedOnce.add(userInput[j]);
		          whitePegs++;
		          break;
		        }		
	        }
	    }
	    whitePegs -= blackPegs;
	    
	    if (blackPegs == 4) {
	    	return result = "Result: " + blackPegs + " black pegs!";
	    }
	    
		return result = "Result: " + whitePegs + " white pegs and " + blackPegs + " black pegs";
	}
	
	public int getWhitePegs() {
		
		return whitePegs;
	}
	
	public int getBlackPegs() {
		
		return blackPegs;
	}
}





