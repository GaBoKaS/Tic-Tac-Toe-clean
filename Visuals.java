import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Visuals extends JFrame {
	private static final long serialVersionUID = 1L;
	JButton btnResetGame = new JButton("Reset Game");
	protected JButton[] buttons = new JButton[9];
	protected JPanel contentPane;
	
	protected void GenerateButtons() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 429);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
	}
	void DisableButtons() {
		for ( int i = 0; i < 9; i++)
			buttons[i].setEnabled(false);
	}
	void EnableButtons() {
		for ( int i = 0; i < 9; i++)
			buttons[i].setEnabled(true);
	}
}
