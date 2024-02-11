package seleniumStreamsPracticeProject;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PaginationHandling {
	
	@Test
	public void getPricing()
	{
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<String> PriceList;
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr/th[1]")).click();
		do
		{
		List<WebElement> OLI = driver.findElements(By.xpath("//tr/td[1]"));
		PriceList = OLI.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		PriceList.forEach(a->System.out.println(a));
		if (PriceList.size()<1)
		{
			driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
		} 
		}while(PriceList.size()<1);
		
//		driver.quit();
	}

	private static String getPrice(WebElement s) {
		// TODO Auto-generated method stub
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
