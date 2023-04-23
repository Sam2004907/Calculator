import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
//Imports all the necessary java scripts for the GUI

public class User_interface implements ActionListener { // Adds the even listener for buttons and other GUI parts
	
			//Frame + Textfield's
			JFrame frame; // Creates the Calculator GUI Frame
			JTextField textfield; // Creates the number bar for the calculator
			JTextField calculation;
			
			//Buttons
			JButton[] numberButtons = new JButton[10]; // An array to add all the number buttons
			JButton[] functionButtons = new JButton[14]; // Array to hold all the operator buttons 
			JButton addButton, subButton, multButton, divButton, sqrtButton, negButton, piButton, decButton;
			JButton equButton, acButton, delButton, percentButton, powerButton, ansButton;
			
			
			//Panel
			JPanel panel;
			
			//Font
			Font textFont = new Font("consolas", Font.PLAIN, 30);
			Font buttonFont = new Font("Arial", Font.PLAIN, 19);
			
			//Declared double values
			double num1=0,num2=0,result=0, ans=0, pi=3.142; // Number default values
			char operator; //ADD, SUB, DIV etc 
			boolean entered = false; // Boolean for Num2 value
			
			
			User_interface(){ // Constructor for the Graphical Interface
				
				//Frame Design
				frame = new JFrame();
				frame.setTitle("Calculator");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the frame on exit
				frame.setResizable(false); // Creates the frame with aspect ratio.
				frame.setSize(375, 650); // Width, Height
				frame.setLayout(null);
				
				ImageIcon image = new ImageIcon("Logo.png"); // Creates image icon for the JFrame.
				frame.setIconImage(image.getImage()); // Sets image icon of frame.
				frame.getContentPane().setBackground(new Color (0x47595c)); // Changes background colour.
				
				
				//TextField settings
				textfield = new JTextField(); // Creates new instance of the JTextField.
				textfield.setBackground(new Color (0x121212));
				textfield.setBounds(0,100, 359, 100); // (x Position, y Position, Width, Height) 
				textfield.setFont(textFont); // Sets the font
				textfield.setForeground(new Color (0xffffff));
				textfield.setEditable(false); //Boolean to allow the text field to be edited by the user.
				textfield.setBorder(null); // Removes TextField border.
				textfield.setHorizontalAlignment(JTextField.RIGHT); // Places all text on the right of the TextField and all new Characters move from right to left.
				
				
				calculation = new JTextField();
				calculation.setBackground(new Color (0x121212));
				calculation.setBounds(0,0, 359, 100); // (x Position, y Position, Width, Height) TODO Play around for a nice size. 
				calculation.setFont(textFont);
				calculation.setForeground(Color.ORANGE);
				calculation.setEditable(false); //Boolean to allow the text field to be edited by the user.
				calculation.setBorder(null); // Removes TextField border.
				calculation.setHorizontalAlignment(JTextField.RIGHT); // Places all text on the right of the TextField and all new Characters move from right to left.
			
				//Add buttons to JFrame
				addButton = new JButton("+");
				subButton = new JButton("-");
				multButton = new JButton("×");
				divButton = new JButton("÷");
				decButton = new JButton(".");
				equButton = new JButton("=");
				acButton = new JButton("AC");
				delButton = new JButton("C");
				sqrtButton = new JButton("√");
				negButton = new JButton("+/-");
				percentButton = new JButton("%");
				powerButton = new JButton("^");
				piButton = new JButton("π");
				ansButton = new JButton("ANS");
				
				// Button Customisation
				/*
				 * Adds Button background and foreground colour.
				 * Also removes button borders.
				 */
				
				addButton.setBackground(new Color(0x3f4c4f));
				addButton.setForeground(new Color(0x85ca8b));
				addButton.setBorderPainted(false);
				
				
				subButton.setBackground(new Color(0x3f4c4f));
				subButton.setForeground(new Color(0x85ca8b));
				subButton.setBorderPainted(false);
				
				
				multButton.setBackground(new Color(0x3f4c4f));
				multButton.setForeground(new Color(0x85ca8b));
				multButton.setBorderPainted(false);
				
				
				divButton.setBackground(new Color(0x3f4c4f));
				divButton.setForeground(new Color(0x85ca8b));
				divButton.setBorderPainted(false);
				
				decButton.setBackground(new Color(0x3f4c4f));
				decButton.setForeground(new Color(0x85ca8b));
				decButton.setBorderPainted(false);
				
				
				equButton.setBackground(new Color(0x2d7156));
				equButton.setForeground(Color.WHITE); // Special Button needs a different colour.
				equButton.setBorderPainted(false);
				
				acButton.setBackground(new Color(0x3f4c4f));
				acButton.setForeground(Color.RED); // Special Button needs a different colour.
				acButton.setBorderPainted(false);
				
				delButton.setBackground(new Color(0x3f4c4f));
				delButton.setForeground(new Color(0x85ca8b));
				delButton.setBorderPainted(false);
				
				sqrtButton.setBackground(new Color(0x3f4c4f));
				sqrtButton.setForeground(new Color(0x85ca8b));
				sqrtButton.setBorderPainted(false);
				
				piButton.setBackground(new Color(0x3f4c4f));
				piButton.setForeground(new Color(0x85ca8b));
				piButton.setBorderPainted(false);
				
				negButton.setBackground(new Color(0x3f4c4f));
				negButton.setForeground(new Color(0x85ca8b));
				negButton.setBorderPainted(false);
				
				percentButton.setBackground(new Color(0x3f4c4f));
				percentButton.setForeground(new Color(0x85ca8b));
				percentButton.setBorderPainted(false);
				
				powerButton.setBackground(new Color(0x3f4c4f));
				powerButton.setForeground(new Color(0x85ca8b));
				powerButton.setBorderPainted(false);
				
				ansButton.setBackground(new Color(0x3f4c4f));
				ansButton.setForeground(new Color(0x85ca8b));
				ansButton.setBorderPainted(false);
				
				
				//Adding the buttons to the Array
				functionButtons[0] = addButton;
				functionButtons[1] = subButton;
				functionButtons[2] = multButton;
				functionButtons[3] = divButton;
				functionButtons[4] = decButton;
				functionButtons[5] = equButton;
				functionButtons[6] = acButton;
				functionButtons[7] = sqrtButton;
				functionButtons[8] = negButton;
				functionButtons[9] = delButton;
				functionButtons[10] = percentButton;
				functionButtons[11] = powerButton;
				functionButtons[12] = piButton;
				functionButtons[13] = ansButton;
				
			
				
				
				// Editing the buttons
				//Loops through all 14 operator buttons saving unnecessary code. 
				for(int i =0;i<14;i++) {
					functionButtons[i].addActionListener(this);
					functionButtons[i].setFont(buttonFont);
					functionButtons[i].setFocusable(false);
				}
				
				for(int i =0;i<10;i++) {
					// Implements all the number buttons to the calculator up to the 10th index.
					numberButtons[i] = new JButton(String.valueOf(i));
					numberButtons[i].addActionListener(this);
					numberButtons[i].setFont(buttonFont);
					numberButtons[i].setFocusable(false);
					numberButtons[i].setBackground(null);
					numberButtons[i].setForeground(Color.WHITE);
					numberButtons[i].setBorderPainted(false);
		
				}

				 
				panel = new JPanel(); // Creates new instance of the JPanel
				panel.setBackground(null); // Removes Panel background colour.
				panel.setBounds(5,207,355,400); // X, Y, Width, Height
				panel.setLayout(new GridLayout(6,4,20,20)); // Rows and Columns = 4 x 4, space between the buttons = 5 pixels.
				panel.setBackground(new Color(0x47595c)); // Shows the grid layout and area only for testing. 
				
				
				// Adding number buttons to the grid
				// Places them in column and row order
				
				//Row 1
				panel.add(sqrtButton);
				panel.add(negButton);
				panel.add(delButton);
				panel.add(acButton);
				
				//Row 2
				panel.add(piButton);
				panel.add(percentButton);
				panel.add(powerButton);
				panel.add(divButton);
				
				//Row 3
				panel.add(numberButtons[7]);
				panel.add(numberButtons[8]);
				panel.add(numberButtons[9]);
				panel.add(multButton);
				
				//Row 4
				panel.add(numberButtons[4]);
				panel.add(numberButtons[5]);
				panel.add(numberButtons[6]);
				panel.add(addButton);
				
				//Row 5
				panel.add(numberButtons[1]);
				panel.add(numberButtons[2]);
				panel.add(numberButtons[3]);
				panel.add(subButton);
				
				//Row 6
				panel.add(decButton);
				panel.add(numberButtons[0]);
				panel.add(equButton);
				panel.add(ansButton);
				
				
				
				//Final Frame design elements 
				// Adds key features to the  JFrame
				frame.add(panel);
				frame.add(textfield);
				frame.add(calculation);
				frame.setVisible(true);
			}
			
			
			public static void main(String[] args) {
				User_interface graphics = new User_interface(); // Instance of the GUI
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				// Action perform method
				for(int i=0;i<10;i++) {
					if(e.getSource() == numberButtons[i]) {
						textfield.setText(textfield.getText().concat(String.valueOf(i)));
						entered = true;
					}
				}
				if(e.getSource() == decButton) {
					textfield.setText(textfield.getText().concat("."));
				}
				
				// Brackets
				
				/*
				 * The bracket functions do not currently work but can be implemented in the future.
				 *  if(e.getSource() == bracketLButton) {
					textfield.setText(textfield.getText().concat("("));
				}
				 * if(e.getSource() == bracketRButton) {
					textfield.setText(textfield.getText().concat(")"));
				}
				 */
				
				
				// Operators
				
				// Addition
				if(e.getSource() == addButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '+'; // Calls function from Calculation Class
					textfield.setText("");	// Sets the textfield empty for Number 2 input			
				}
				
				// Subtraction
				if(e.getSource() == subButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '-'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input
				}
				
				// Multiplication
				if(e.getSource() == multButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '×'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input
				}
				
				// Division
				if(e.getSource() == divButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '÷'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input
				}
				
				// Percentage
				if(e.getSource()==percentButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '%'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input 
				}
				
				// Power of
				if(e.getSource()==powerButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '^'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input
				}
				
				// Square Root
				if(e.getSource()==sqrtButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '√'; // Calls function from Calculation Class
					textfield.setText(""); // Sets the textfield empty for Number 2 input
					entered = false; // Communicates to the equals button that there is no Number 2 value
				}
				
				// Negative
				if(e.getSource()==negButton) {
					num1 = Double.parseDouble(textfield.getText());
					num1= num1 * -1;
					textfield.setText(Double.toString(num1)); // Sets the textfield to the Number 1 value
					entered = false; // Communicates to the equals button that there is no Number 2 value
				}
				
				// Pi
				if(e.getSource()==piButton) {
					textfield.setText(String.valueOf(pi));
				}
				
				
				// Equals
				if(e.getSource()==equButton) {
					if  (entered == false) {
						calculation.setText("");
						textfield.setText("");
						result= Calculations.Calculate(num1, num2, pi, operator);
						String string1 = Double.toString(num1);
						String Output = (string1 + operator);
						textfield.setText(String.valueOf(result));
						calculation.setText(Output);
						ans = result; // Sets the answer value to result
						//pi = result; // Sets the Pi button value to the r
					} else{
						num2=Double.parseDouble(textfield.getText());
						result= Calculations.Calculate(num1, num2, pi, operator);
						String string1 = Double.toString(num1);
						String string2 = Double.toString(num2);
						String Output = (string1 + operator + string2);
						textfield.setText(String.valueOf(result));
						calculation.setText(Output);
						ans=result;	
						
					}
				}
				
				// All Clear
				if(e.getSource()==acButton) {
					textfield.setText("");
					calculation.setText("");
					num1=0;
					num2=0;
					result=0;
					// Clears both Textfields to empty.
				}
				
				// Delete
				if(e.getSource()==delButton) {
					String string = textfield.getText();
					textfield.setText("");
					for(int i=0;i<string.length()-1;i++) {
						textfield.setText(textfield.getText()+string.charAt(i));
						// Removes 1 Character at a time from the textfield
					}
				}
				if(e.getSource()==delButton) {
					String string = calculation.getText();
					calculation.setText("");
					for(int i=0;i<string.length()-1;i++) {
						calculation.setText(calculation.getText()+string.charAt(i));
						// Removes 1 Character at a time from the textfield
					}
				}
				
				// Answer 
				if(e.getSource()==ansButton) {
					textfield.setText(String.valueOf(ans));
					// Stores the previous answer in the ANS button on the GUI
				}
		}
}


