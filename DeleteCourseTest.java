import static org.junit.Assert.*;

import org.junit.Test;

public class DeleteCourseTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.deleteCourse("Proiectare Software");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
