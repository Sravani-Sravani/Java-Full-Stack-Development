import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TestCase {

	@Test
	void test1() throws SQLException 
	{
		assertEquals("SUCCESS",logicclass.insertrecord());
	}

}
