import static org.junit.Assert.*;

import org.junit.Test;

public class AddStudentTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.addStudent("11", "Filip Ancuta", "1995-09-10", "Stejarului nr 8");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
