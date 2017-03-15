import static org.junit.Assert.*;

import org.junit.Test;

public class UpdateCourseTest {

	@Test
	public void test() {
		DatabaseConn.connection();
		boolean output1=DatabaseConn.updateCourse("Fizica", "Culea Florin", "2");
		boolean expected=true;
		assertEquals(expected,output1);
	}

}
