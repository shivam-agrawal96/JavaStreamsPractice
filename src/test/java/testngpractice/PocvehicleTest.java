package testngpractice;

import org.junit.Assert;
import org.testng.annotations.Test;

public class PocvehicleTest {
	
	@Test
	public void pocBike()
	{
		System.out.println("POC Bike");
	}
	
	@Test (groups = {"Runner"})
	public void pocCar()
	{
		System.out.println("POC Car");
	}
	
	@Test
	public void failureeee()
	{
		Assert.assertTrue(false);
	}

}
