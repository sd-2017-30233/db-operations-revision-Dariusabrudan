import static org.junit.Assert.*;

import org.junit.Test;

public class StudentsEnrolledTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.showStudentsEnrolled("Electrotehnica");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
