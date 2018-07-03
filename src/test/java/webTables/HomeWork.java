package webTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {

	static WebDriver driver;
	int rowsCount;
	int colsCount;
	List<String> Id = new ArrayList<>();
	List<String> EverythingElse = new ArrayList<>();
	Map<String,String> map = new HashMap<>();

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get(
				"https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8");

		rowsCount = driver.findElements(By.xpath("//div[@id='viewDiv']/table/tbody/tr")).size();
		colsCount = driver.findElements(By.xpath("//div[@id='viewDiv']/table/thead/tr/th")).size();

	}

	@Test
	public void homeWork1() {

	
		for (int rowNum = 1; rowNum <= rowsCount; rowNum++) {
			for (int col = 1; col <= 1; col++) {
				String xpath = "//div[@id='viewDiv']/table/tbody/tr[" + rowNum + "]/td[" + col + "]";

				String storage = driver.findElement(By.xpath(xpath)).getText();
			//	Id.add(Integer.valueOf(storage));
				Id.add(storage);
				
			

			}

		}
		System.out.println(Id);
	
	}
		
	
	@Test
		public void homeWork2() {

		
			for (int rowNum = 1; rowNum <= rowsCount; rowNum++) {
				String storage ="";
				for (int col = 2; col <= colsCount; col++) {
					String xpath = "//div[@id='viewDiv']/table/tbody/tr[" + rowNum + "]/td[" + col + "]";

			storage += driver.findElement(By.xpath(xpath)).getText()+" ";
					EverythingElse.add(storage);

				}

			}
			
			System.out.println(EverythingElse);
			
	}

	@Test
	public void homeWork3() {
	
		
			
		Map<String,String> map = new HashMap<>();

	for (int i = 0; i < Id.size(); i++) {
		
		map.put(Id.get(i), EverythingElse.get(i));
		
	}
	System.out.println(map);
		
	}
		
	}
	

