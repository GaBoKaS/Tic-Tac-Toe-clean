import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestReset {
		public Map test = new Map();
		public int errors = 0;
	@Test
	void test() {
		CountErrors();
		test.Reset();
		CountErrors();
		assertEquals(0, errors);
	}
	void CountErrors() {
		for(int i = 0; i<3; i++) {
			for(int u = 0; u<3; u++) {
				if (test.grid[i][u] != 0) errors++;
			}
		}
	}
}
