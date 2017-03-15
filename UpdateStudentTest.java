import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateStudentTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.updateStudent("Filip Ancuta", "Alina Ancuta", "Plopilor nr 88");
		boolean expected=true;
		assertEquals(expected,output1);
	}	
}
