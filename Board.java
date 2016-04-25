/*
 * Bharat Kulkarni
 * bsk524
 */
package bonus;

import javax.swing.JOptionPane;

public class Board {
	
	private String history;
	
	public Board () {
		history = "";
	}
	
	public void addToHistory (String record) {
		history += record + "\n";
	}
	
	public void showHistory() {
		JOptionPane.showMessageDialog(null, history);
	}
}