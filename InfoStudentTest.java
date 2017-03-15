import static org.junit.Assert.*;

import org.junit.Test;

public class InfoStudentTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.showInfoStudent("Elena Rodica");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
