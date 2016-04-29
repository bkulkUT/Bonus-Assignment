/*
 * Bharat Kulkarni
 * bsk524
 */

import javax.swing.JOptionPane;

public class Board {
	
	private String history;
	
	public Board () {
		history = "";
	}
	
	public void addToHistory (String record) {
		history += record + "\n\n";
	}
	
	public void showHistory() {
		JOptionPane.showMessageDialog(null, history);
	}
}