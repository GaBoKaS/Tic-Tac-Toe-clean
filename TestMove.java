import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestMove {

	@Test
	void test() {
		Logic test = new Logic();
		int a, b;
		a = 1;
		b = 1;
		test.Player = 1;
		test.Move(a,b);
		int errors = 0;
		for(int i = 0; i<3; i++)
			for (int u = 0; u<3; u++)
				if(test.map.grid[i][u] != 0) errors++;
				else if (test.map.grid[i][u] == 2) errors++;
		errors--; //Numinusuojama nes vienas kintamasis turi bûti lygus 1
		if (test.Player != 2) errors++;
		assertEquals(0,errors);
	}

}
/* public void Move(int i, int u) {
		if(map.grid[i][u] == 0)
		map.Change(i, u, Player);
		TurnPassed();
	}
*/