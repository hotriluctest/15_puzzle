
import javax.swing.*;

import java.awt.event.*;
import java.util.*;
 
public class Puzzle_Game extends JFrame {
	
    private JPanel panel = new JPanel(new GridLayout(4, 4, 2, 2));
    private static Random generator = new Random();
    private int[][] num_array = new int[4][4];


    
    
    public static void main(String[] args) {
        JFrame app = new Puzzle_Game();
        app.setVisible(true);
    }
    
    
    public Puzzle_Game() {
        super("15_puzzle");
        setBounds(200, 200, 497, 394);
        setResizable(false);
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        initialize();
        getContentPane().setLayout(null);
        panel.setBounds(169, 11, 312, 322);
        panel.setBackground(new Color(128, 128, 128));
        container.add(panel);
        
        JButton btnNewButton = new JButton("New Game");// New_game_button
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel.removeAll();
        		container.repaint();
        		initialize();
        		repaintField();
        	}
        });
        btnNewButton.setBounds(31, 38, 106, 41);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Exit"); //Exit_button
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnNewButton_1.setBounds(31, 90, 106, 41);
        getContentPane().add(btnNewButton_1);
        
        
        
        repaintField();
    }
    
    
    public void initialize() {
        int[] invariants = new int[16];
 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                num_array[i][j] = 0;
                invariants[i*4 + j] = 0;
            }
        }
 
        for (int i = 1; i < 16; i++) {
            int k;
            int l;
            do {
                k = generator.nextInt(100)%4 ;
                l = generator.nextInt(100)%4 ;
            }
            while (num_array[k][l] != 0);
            num_array[k][l] = i;
            invariants[k*4+l] = i;
        }
 
        boolean change = true;
        int counter = 1;
        while (change) {
            change = false;
            for (int i = 0; i < 16; i++) {
                if (invariants[i] != i) {
                    for (int j = 0; j < 16; j++) {
                        if (invariants[j] == i) {
                            int temp = invariants[i];
                            invariants[i] = invariants[j];
                            invariants[j] = temp;
                            change = true;
                            counter++;
                            break;
                        }
                    }
                    break;
                }
            }
        }
 
        if (counter % 2 != 0) {
            int temp = num_array[0][0];
            num_array[0][0] = num_array[3][3];
            num_array[3][3] = temp;
        }
    }
 
    public void repaintField() {
        panel.removeAll();
 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                JButton button = new JButton(Integer.toString(num_array[i][j]));
                button.setFocusable(false);
                panel.add(button);
                if (num_array[i][j] == 0) {
                    button.setVisible(false);
                } else
                    button.addActionListener(new ClickListener());
            }
        }
 
        panel.validate();
    }
 
    public boolean checkWin() {
        boolean status = true;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j > 2)
                    break;
                if (num_array[i][j] != i * 4 + j + 1) {
                    status = false;
                }
            }
        }
        return status;
    }
 
  
 
 
 
    private class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            button.setVisible(false);
            String name = button.getText();
            change(Integer.parseInt(name));
        }
    }
   
 
    

 
    public void change(int num) {
        int i = 0, j = 0;
        for (int k = 0; k < 4; k++) {
            for (int l = 0; l < 4; l++) {
                if (num_array[k][l] == num) {
                    i = k;
                    j = l;
                }
            }
        }
        if (i > 0) {
            if (num_array[i - 1][j] == 0) {
                num_array[i - 1][j] = num;
                num_array[i][j] = 0;
            }
        }
        if (i < 3) {
            if (num_array[i + 1][j] == 0) {
                num_array[i + 1][j] = num;
                num_array[i][j] = 0;
            }
        }
        if (j > 0) {
            if (num_array[i][j - 1] == 0) {
                num_array[i][j - 1] = num;
                num_array[i][j] = 0;
            }
        }
        if (j < 3) {
            if (num_array[i][j + 1] == 0) {
                num_array[i][j + 1] = num;
                num_array[i][j] = 0;
            }
        }
        repaintField();
        if (checkWin()) {
            JOptionPane.showMessageDialog(null, "W", "Congratz", 1);
            initialize();
            repaintField();
            setVisible(false);
            setVisible(true);
        }
    }
 
  
}
