import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class MainTest {

	@Test
	public void testMain() {
		Main runner = new Main();
		String[] a={"acbb","a"};
		assertEquals("a", runner.longestCommonPrefix(a));
	}

}
