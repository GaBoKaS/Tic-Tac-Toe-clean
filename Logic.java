public class Logic {
	Map map = new Map();
	int Turn;
	short Player = 1;
	short Winner = 0;
	public Logic() {
		Turn = 0;
	}
	public void Move(int i, int u) {
		if(map.grid[i][u] == 0)
		map.Change(i, u, Player);
		TurnPassed();
	}
	public void TurnPassed() {
		Turn++;
		if(Player == 1) Player = 2;
		else Player = 1;
	}
	public void CheckGameStatus() {
		if(Turn == 9 || (PlayerWon(1)!=0 || PlayerWon(2)!=0))
			Won();
	}
	public void Won() {
		if(PlayerWon(1) == 1) Winner = 1;
		else if(PlayerWon(2) == 1) Winner = 2;
	}
	public void Reset() {
		map.Reset();
		Turn = 0;
		Player = 1;
	}
	public int PlayerWon(int P) {
		int line = 0, column = 0;
		for (int i = 0; i < 3; i++) {
			line = 0; column = 0;
			for (int u = 0; u < 3; u++) {
				if(map.grid[i][u] == P) line++;
				if(map.grid[u][i] == P) column++;
			}
			if(line == 3 || column == 3) return P;
			if(map.grid[0][0] == P && map.grid[1][1] == P && map.grid[2][2] == P) return P;
			if(map.grid[0][2] == P && map.grid[1][1] == P && map.grid[2][0] == P) return P;
		}
		return 0;
	}
}
