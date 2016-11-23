import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame  {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			JFrame f1 = new MainMenu();
			f1.setVisible(true);
		};
	

	/**
	 * Create the application.
	 */
	public MainMenu() {
		super("15_puzzle");
	
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Puzzle_Game g = new Puzzle_Game();
				g.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(160, 42, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chose");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_1.setBounds(170, 76, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(160, 110, 89, 23);
		getContentPane().add(btnNewButton_2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		
	}
}
