import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class MainTest {

	@Test
	public void testMain() {
		Main runner = new Main();
		String input = "1.1.1.1";
		String output = "1[.]1[.]1[.]1";
		// assertArrayEquals(output, runner.decompressRLElist(input));
		 assertEquals(output, runner.defangIPaddr(input));
	}

}
