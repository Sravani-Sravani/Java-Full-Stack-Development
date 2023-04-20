package Skilling1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class JunitTesting {

	@Test
	public void DBConnection()
	{
		assertNotNull(Question2.getConnection());
	}
	@Test
	public void updation()
	{
		assertEquals("Success",Question2.Update());
	}
}
