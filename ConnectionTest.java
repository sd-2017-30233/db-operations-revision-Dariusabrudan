import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionTest {

	@Test
	public void test() {
		boolean output=DatabaseConn.connection();
		boolean expected=true;
		assertEquals(expected,output);
	}

}
