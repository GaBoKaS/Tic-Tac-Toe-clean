import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Play extends JFrame {
	JButton btnResetGame = new JButton("Reset Game");
	Logic logic = new Logic();
	private JButton[] buttons = new JButton[9];
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Play frame = new Play();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Play() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 9; i++) {
					buttons[i].setText("");
				}
				Win();
				logic.Reset();
				EnableButtons();
			}
		});
		btnResetGame.setBounds(10, 351, 329, 38);
		contentPane.add(btnResetGame);
		
		buttons[0] = new JButton("One");
		buttons[1] = new JButton("Two");
		buttons[2] = new JButton("three");
		buttons[3] = new JButton("Four");
		buttons[4] = new JButton("Five");
		buttons[5] = new JButton("Six");
		buttons[6] = new JButton("Seven");
		buttons[7] = new JButton("Eight");
		buttons[8] = new JButton("Nine");
		
		buttons[0].setBounds(10, 5, 100, 100);
		buttons[1].setBounds(125, 5, 100, 100);
		buttons[2].setBounds(240, 5, 100, 100);
		buttons[3].setBounds(10, 116, 100, 100);
		buttons[4].setBounds(125, 116, 100, 100);
		buttons[5].setBounds(240, 116, 100, 100);
		buttons[6].setBounds(10, 227, 100, 100);
		buttons[7].setBounds(125, 227, 100, 100);
		buttons[8].setBounds(240, 227, 100, 100);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setFont(new Font("Tahoma", Font.PLAIN, 40));
			contentPane.add(buttons[i]);
			final int u = i;
			buttons[i].addActionListener(new ActionListener() {
			   	public void actionPerformed(ActionEvent e) {
			   		int a, b;
					if(u<3) {a = 0; b = u;}
					else if (u>=3 && u<6) {a = 1; b = u-3;}
					else {a = 2; b = u-6;}
					logic.Move(a, b);
					String Player;
					if(logic.map.grid[a][b] == 1) Player = "X";
					else Player = "O";
					buttons[u].setText(Player);
					if(logic.PlayerWon(1)!=0 || logic.PlayerWon(2)!=0)
						DisableButtons();
				}
				});
				buttons[i].setText("");
		}
	}
	void DisableButtons() {
		for ( int i = 0; i < 9; i++)
			buttons[i].setEnabled(false);
	}
	void EnableButtons() {
		for ( int i = 0; i < 9; i++)
			buttons[i].setEnabled(true);
	}
	void Win() {
		if(logic.PlayerWon(1) == 1) btnResetGame.setText("Player X Won");
		else if(logic.PlayerWon(2) == 2) btnResetGame.setText("Player O Won");
		else btnResetGame.setText("Reset Game");
		
	}
}
