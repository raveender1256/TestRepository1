package example;		

//import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private WebDriver driver;		
		@Test				
		public void testEasy1() {	
			driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
		}
		@Test				
		public void testEasy2() {	
			//driver.get("http://demo.guru99.com/test/guru99home/");  
			String title = driver.getCurrentUrl();		 
			Assert.assertTrue(title.contains("http://demo.guru99.com/test/guru99home/")); 		
		}
		@BeforeTest
		public void beforeTest() {	
			 WebDriverManager.chromedriver().setup();	      
		      driver = new ChromeDriver();  
			//WebDriverManager.firefoxdriver().setup();	      
		      //driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	