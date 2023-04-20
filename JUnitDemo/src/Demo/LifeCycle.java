package Demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycle 
{

	@BeforeClass
	public static void beforeclassmethod()
	{
		System.out.println("Before Class");
	}
	
	@Before
	public void beforemethod()
	{
		System.out.println("Before Testcase");
	}
	@Test
	public void test() {
		System.out.println("Test Case");
	}
	
	@After
	public void aftermethod()
	{
		System.out.println("After Method");
	}
	
	@AfterClass
	
	public static void afterclass()
	{
		System.out.println("After Class");
	}
	

}
