public class Map {
	int grid[][] = new int[3][3];
	public Map() {
		Reset();
	}
	public void Reset() {
		for(int i = 0; i<3; i++) {
			for(int u = 0; u<3; u++) {
				grid[i][u]=0;
			}
		}
	}
	public void Change(int i, int u, int value) {
		grid[i][u] = value;
	}
}