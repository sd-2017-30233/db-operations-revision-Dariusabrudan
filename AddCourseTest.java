import static org.junit.Assert.*;

import org.junit.Test;

public class AddCourseTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.addCourse("5", "Proiectare Software", "Dinsoreanu Mihaela", "3");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
