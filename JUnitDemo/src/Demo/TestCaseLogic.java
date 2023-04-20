package Demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCaseLogic {

	@Test
	public void test1()
	{
		assertEquals(0,EndUser.findeven(3));
	}
	@Test
	public void test2()
	{
		assertEquals(1,EndUser.findeven(4));
	}
	@Test
	public void test3()
	{
		assertTrue(EndUser.findodd(5));
	}
	@Test
	public void test4()
	{
		assertTrue(EndUser.findodd(7));
	}
	@Test
	public void test5()
	{
		assertNotNull(EndUser.getConnection());
	}
	@Test
	public void test6()
	{
		assertTrue(EndUser.getDBConnection());
	}

	@Test
	public void test7()
	{
		assertEquals("Success",EndUser.insertrecord());
	}
	@Test
	public void test8()
	{
		assertEquals(1,EndUser.insertrow());
	}

}

