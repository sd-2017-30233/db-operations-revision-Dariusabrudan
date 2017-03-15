import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteStudentTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.deleteStudent("Filip Ancuta");
		boolean expected=true;
		assertEquals(expected,output1);
	}
}

