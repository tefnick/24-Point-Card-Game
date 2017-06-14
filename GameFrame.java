package cardGame;

import javax.swing.JFrame;


/**
 * Creates a JFrame that holds the Jpanels displaying the card game
 * @author Nick Ruiz
 * @version 1.0
 */

public class GameFrame extends JFrame {
	
	/**
	 * Creates a JFrame that holds the panels displaying the card game and buttons 
	 * @param title The title of the frame
	 */
	public GameFrame(String title){
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(500,300);
		this.getContentPane().add(new GamePanel());
		this.setResizable(false);
		this.pack();
		this.setVisible(true);		
	}	
}
