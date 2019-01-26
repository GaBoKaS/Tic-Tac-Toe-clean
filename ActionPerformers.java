import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionPerformers extends Visuals {
	private static final long serialVersionUID = 1L;
	
	Logic logic = new Logic();
	
	void CreateActionPerformers() {
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
	void Win() {
		if(logic.PlayerWon(1) == 1) btnResetGame.setText("Player X Won");
		else if(logic.PlayerWon(2) == 2) btnResetGame.setText("Player O Won");
		else btnResetGame.setText("Reset Game");
		
	}
}
