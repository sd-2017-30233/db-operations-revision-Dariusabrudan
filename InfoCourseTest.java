import static org.junit.Assert.*;

import org.junit.Test;

public class InfoCourseTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.showInfoCourse("Electrotehnica");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
