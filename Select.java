import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.util.*;
import javax.swing.JTextField;

public class Select {

	private JFrame frmpuzzle;
	private JTextField txtName;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select window = new Select();
					window.frmpuzzle.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Select() {
		initialize();
	}
	private void initialize() {
		frmpuzzle = new JFrame();
		frmpuzzle.setTitle("15_puzzle");
		
		frmpuzzle.setBounds(200, 200, 325, 300);
		frmpuzzle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmpuzzle.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmpuzzle.setVisible(false);
				Puzzle_Game g = new Puzzle_Game();
				g.setVisible(true);
			}
		});
		btnPlay.setBounds(10, 186, 96, 23);
		frmpuzzle.getContentPane().add(btnPlay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(10, 220, 287, 30);
		frmpuzzle.getContentPane().add(btnExit);
		
		JList prof_list = new JList();
		prof_list.setBounds(10, 41, 287, 106);
		frmpuzzle.getContentPane().add(prof_list);
		
		JLabel lblSelectProfile = new JLabel("Select profile:");
		lblSelectProfile.setBounds(10, 16, 143, 14);
		frmpuzzle.getContentPane().add(lblSelectProfile);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(105, 186, 103, 23);
		frmpuzzle.getContentPane().add(btnNew);
		
		JButton btnDel = new JButton("Delete");
		btnDel.setBounds(208, 186, 89, 23);
		frmpuzzle.getContentPane().add(btnDel);
		
		txtName = new JTextField();
		txtName.setBounds(52, 155, 245, 20);
		frmpuzzle.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 158, 46, 14);
		frmpuzzle.getContentPane().add(lblNewLabel);
	}
}
