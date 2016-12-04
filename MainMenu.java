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
	
		setBounds(100, 100, 240, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Play");
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Puzzle_Game g = new Puzzle_Game();
				g.setVisible(true);
				
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Select profile");
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				JFrame fr = new Select();
				fr.setVisible(true);
				
			}
		});
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnNewButton.setBounds(37, 20, 150, 45);
		getContentPane().add(btnNewButton);
		
		btnNewButton_1.setBounds(37, 78, 150, 45);
		getContentPane().add(btnNewButton_1);
		
		
		btnNewButton_2.setBounds(37, 188, 150, 45);
		getContentPane().add(btnNewButton_2);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		
	}
}
