package testngpractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgPractice {
	
	
	@Test
	public void carTest()
	{
		System.out.println("CarTest");
	}
	
	@Test (groups = {"Runner"})
	public void bikeTest()
	{
		System.out.println("BikeTest");
	}
	
	@Test
	public void truckTest()
	{
		System.out.println("TruckTest");
	}
	
	@Test( groups = {"Runner"}, dataProvider = "provider")
	public void availability(String Availability, String Noavail)
	{
		System.out.println(Availability + " " + Noavail);
	}
	
	@DataProvider
	public Object[][] provider()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0] = "system";
		data[0][1] = "NoSystem";
		
		data[1][0] = "Bike";
		data[1][1] = "NoBike";
		
		data[2][0] = "Car";
		data[2][1] = "NoCar";
		
		return data;
	}

}
