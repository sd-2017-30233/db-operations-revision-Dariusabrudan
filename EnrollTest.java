import static org.junit.Assert.*;

import org.junit.Test;

public class EnrollTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.enroll("10", "5", "2", "2014-03-05");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
