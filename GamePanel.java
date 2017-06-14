package cardGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * Creates a panel to display the card game and its element containers
 * @author Nick Ruiz
 * @version 1.0
 */
public class GamePanel extends JPanel{
	
	//Creates a Refresh button to refresh cards
	private JButton refresh;	
	//Creates and initializes 4 card images
	private JLabel card1 = new JLabel("");
	private JLabel card2 = new JLabel(""); 
	private JLabel card3 = new JLabel("");
	private JLabel card4 = new JLabel(""); 
	//Stores the card into an array
	private ArrayList<ImageIcon> deck = new ArrayList<>();
	//Creates a label to prompt user for input
	private JLabel promptMessage;
	//Creates and provides a text field for user input
	private JTextField userExpression;	
	//Creates a button to verify if the expression is equal to 24
	private JButton verify;	
	//Creates a constant variable for the winning result
	private final int ANSWER = 24;
	

	/**
	 * Creates a panel with a default layout and size
	 * 
	 */
	public GamePanel(){
		this.setBackground(getBackground());
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400, 200));
		
			
		/**
		 * Top Panel
		 */
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		topPanel.setBackground(Color.lightGray);
		this.refresh = new JButton("Refresh");
		this.refresh.addActionListener(new CardActionListener());
		
		//Adds components to the top panel
		topPanel.add(this.refresh);
			
		/**
		 * Center Panel
		 */
		for(int i = 1; i <= 52; i++){
			this.deck.add(new ImageIcon("image/card/" + i + ".png"));
		}
		for(int i = 0; i <= 12; i++){
			this.deck.get(i).setDescription( "" + (i + 1));
		}
		for(int i = 13; i <= 25; i++){
			this.deck.get(i).setDescription("" + (i - 12));
		}
		for(int i = 26; i <= 38; i++){
			this.deck.get(i).setDescription("" + (i - 25));
		}
		for(int i = 39; i <= 51; i++){
			this.deck.get(i).setDescription("" + (i - 38));
		}
		this.deck.trimToSize();
		
		JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerPanel.setBackground(Color.lightGray);
		Collections.shuffle(this.deck);
		
		this.card1 = new JLabel(this.deck.get(0));
		this.card2 = new JLabel(this.deck.get(1));
		this.card3 = new JLabel(this.deck.get(2));
		this.card4 = new JLabel(this.deck.get(3));
		
		//Adds components to the center panel
		centerPanel.add(this.card1);
		centerPanel.add(this.card2);
		centerPanel.add(this.card3);
		centerPanel.add(this.card4);
		
		/**
		 * Bottom Panel
		 */
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.lightGray);
		this.promptMessage = new JLabel("Enter an expression: ");
		this.userExpression = new JTextField(12);
		this.verify = new JButton("Verify");
		this.verify.addActionListener(new CardActionListener());
		
		//Adds components to the bottom panel
		bottomPanel.add(this.promptMessage);
		bottomPanel.add(this.userExpression);
		bottomPanel.add(this.verify);
		
		
		/**
		 *Sets Border layout for all three panels 
		 */ 
		this.add(topPanel, BorderLayout.NORTH);
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(bottomPanel, BorderLayout.SOUTH);
	}
	
		/**
		 * Creates an inner class action listener to 
		 * handle action performed by refresh and verify.
		 */
		public class CardActionListener implements ActionListener{

			public void actionPerformed(ActionEvent e) {
			
			Object source = e.getSource();
			
			if (source == refresh){
				Collections.shuffle(deck);
				// Update the Jlabels and card values
				card1.setIcon(deck.get(0));
				card2.setIcon(deck.get(1));
				card3.setIcon(deck.get(2));
				card4.setIcon(deck.get(3));
				
			}else if (source == verify){
				
				String text = userExpression.getText();
				StringTokenizer operand = new StringTokenizer(text, "+-*/()",false);
				ArrayList<String> postFix;
				ArrayList<String> userOperands = new ArrayList<String>();
				ArrayList<String> cardValues = new ArrayList<String>();
				Expression exp = new Expression(text);
				postFix = exp.infixToPostfix(text);
				int result = exp.evaluate(postFix);
				
				// Add operands to array
				while (operand.hasMoreTokens()){
					String str = operand.nextToken();
					userOperands.add(str);
				}
				userOperands.trimToSize();
				
				// Add card values to array
				for (int i = 0; i < 4; i++){
					String cardValue = deck.get(i).getDescription();
					cardValues.add(cardValue);
				}
				cardValues.trimToSize();
				
					//Check to see correct number of operands are entered
				if (userOperands.size() != 4){
					JOptionPane.showMessageDialog(null, "Not enough operands in your expression");
					
				}	// Check if all  numbers entered by user match the cards
				else if (!(userOperands.containsAll(cardValues))){
					JOptionPane.showMessageDialog(null, "The numbers in the expression don't match the numbers in the set");
				}
				else {
					// if user entered expression does not equal 24 display incorrect
					if (result != ANSWER){
						JOptionPane.showMessageDialog(null, "Incorrect, Please try again");
					}
					else {
						// if user entered expression does equal 24 display correct
						JOptionPane.showMessageDialog(null, "Correct!");
					}
				}				
			}	
		}	
	}
 }
