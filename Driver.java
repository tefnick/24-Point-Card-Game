package cardGame;

/**
 * Creates a card game that displays 4 random cards asking player to 
 * enter a math expression using those 4 card values to try to get a result of "24".
 * @author Nick Ruiz
 * @version 1.0
 */

import javax.swing.JFrame;

public class Driver {
	/**
	 * Creates a GUI window for 24 point card game
	 */
	public static void main (String[] args){
		JFrame frame = new GameFrame("24-Point Card Game");
	}
}
