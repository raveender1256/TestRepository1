package example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
//import java.util.List;
import java.util.concurrent.TimeUnit; // implicitly waiting

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait; // explicitly waiting

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test01 {

	public WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void BeforeTest() {
		// System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		WebDriverManager.chromedriver().setup();
		// FirefoxOptions FFOption = new FirefoxOptions();
		// FFOption.setCapability("marionette", true);
		driver = new ChromeDriver();		
		// for implicitly waiting for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // for
		//explicit wait WebDriverWait expliWait = new WebDriverWait(driver,10);
		System.out.println("BeforeTest method executed and launched the chromebrowser sucesssfully");
	}

	// Test1:
	@Test
	public void Test01() {

		baseUrl = "http://www.gmail.com";
		String tagName = "";
		driver.get(baseUrl);

		// for implicitly waiting for 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		tagName = driver.findElement(By.id("identifierId")).getTagName();
		System.out.println(tagName);

		driver.get("http://www.popuptest.com/popuptest2.html");
		//driver.quit(); // using QUIT all windows will close

		//driver.close();
		// System.exit(0);
	}

	// Test2:
	@Test
	public void Test02() {
		driver.get("http://demo.guru99.com/selenium/deprecated.html");
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("Deprecated")).click();
		//driver.close(); 
	}
	// Test3:

	@Test
	public void Test03() throws InterruptedException {
		driver.get("http://jsbin.com/usidix/1");
		Thread.sleep(3000);
		// driver.findElement(By.linkText("Go!")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/input[1]")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	// Test4: implicit wait & Explicit wait
	@Test
	public void Test04() throws InterruptedException {
		driver.get("http://book.theautomatedtester.co.uk/");
		Thread.sleep(3000);
		  // for explicit wait
		@SuppressWarnings("unused")
		WebDriverWait expliWait = new WebDriverWait(driver, 10);
		expliWait.until(ExpectedConditions.titleContains(driver.getTitle()));
		System.out.println(driver.getTitle());
	}

	// Test5: find element AND find elements
	@Test
	public void Test05() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/ajax.html");
		System.out.println(driver.getTitle());
		// expliWait.until(ExpectedConditions.titleContains(driver.getTitle()));
		  // for explicit wait
		@SuppressWarnings("unused")
		WebDriverWait expliWait = new WebDriverWait(driver, 10);
		expliWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Demo Site")));

		driver.findElement(By.id("no")).click();
		Thread.sleep(3000);
		// input[@id='buttoncheck']
		driver.findElement(By.xpath("//input[@id='buttoncheck']"));

		driver.findElement(By.id("yes")).click();
		driver.findElement(By.xpath("//input[@id='buttoncheck']"));
		Thread.sleep(3000);

		List<WebElement> elements = driver.findElements(By.name("name"));

		System.out.println("number of elements: " + elements.size());

		for (int i = 0; i < elements.size(); i++) {

			System.out.println(elements.get(i).getAttribute("id"));
			System.out.println(elements.get(i).getAttribute("value"));
		}
	}

	// Test6 :
	@Test
    public void Test06(){
	
	  driver.get("http://demo.guru99.com/test/login.html"); //input[@id='email']	  
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("wrong@gmail.com");
	  driver.findElement(By.xpath("//input[@id='email']")).clear();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abcd@gmail.com");	  
	  driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("wrongpwd");
	  driver.findElement(By.xpath("//input[@id='passwd']")).clear();
	  driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("abcdefghlkjl");
	 
	 //1. by clicking the SignIN button //---
	 driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click(); 	
	
	 //2. by submitting the SignIN button
	 	//--driver.findElement(By.xpath("//p[@class='submit']//span[1]")).submit();	 
	 //3. by using submit method on Username field webelement
	  	//--driver.findElement(By.xpath("//input[@id='passwd']")).submit(); 	
	 //4. by using submit method on password field webelement
	 	//--- driver.findElement(By.xpath("//input[@id='email']")).submit();	  
	}

	// test7:
	 @Test
     public void Test07() throws InterruptedException{
	  driver.get("http://demo.guru99.com/test/radio.html"); Thread.sleep(3000);
	 driver.findElement(By.xpath("//div[text()='Option1']")).click();
	  Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='vfb-7-2']")).click();
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@id='vfb-7-3']")).click();
	 
	 
	 if(driver.findElement(By.xpath("//div[text()='Option1']")).isSelected()) {
	  System.out.println("Option1 selected"); } else
	  if(driver.findElement(By.xpath("//input[@id='vfb-7-2']")).isSelected()) {
	  System.out.println("Option2 selected"); } else
	  if(driver.findElement(By.xpath("//input[@id='vfb-7-3']")).isSelected()){
	  System.out.println("Option3 selected");
	  
	  }
	  
	 
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='vfb-6-0']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@id='vfb-6-1']")).click();
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//input[@id='vfb-6-2']")).click();
	  
	  
	  List<WebElement> ChkboxElements =
	  driver.findElements(By.cssSelector("input[type=checkbox]"));
	  System.out.println("Number of checkboxes: "+ ChkboxElements.size()); for(int
	  i = 0;i< ChkboxElements.size();i++) {
	  
	  if(driver.findElement(By.xpath("//input[@id='vfb-6-"+i+"']")).isSelected()) {
	  System.out.println("CheckBox"+i+" Checked"); } else {
	  System.out.println("CheckBox"+i+" Not Checked"); } }
	 }

	// Test8:

	 @Test
     public void Test08() throws InterruptedException{
	  driver.get("http://demo.guru99.com/test/radio.html#"); Thread.sleep(3000);
	  //-- driver.findElement(By.cssSelector("img[src=\"/logo.png\"]")).click();
	  //or
	  driver.findElement(By.cssSelector("img[alt=\"Guru99 Demo Sites\"]")).click();
	  Thread.sleep(3000);
	  System.out.println(driver.findElement(By.cssSelector("img[src=\"/logo.png\"]"
	  )).getAttribute("alt"));
	 }

	// Test9: Selecting LOV

	 @Test
     public void Test09() throws InterruptedException{
	  driver.get("http://demo.guru99.com/test/newtours/register.php");
	  Thread.sleep(3000); 
	  Select webEcountry = new Select(driver.findElement(By.name("country")));
	  webEcountry.selectByVisibleText("INDIA"); Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='submit']")).click();
	  Thread.sleep(3000);
	  if(driver.findElement(By.xpath("//b[contains(text(),'Dear')]")).isDisplayed()
	  ) { System.out.println("Pass"); System.out.println(driver.findElement(By.
	  xpath("//font[contains(text(),'Thank you for registering. ')]")).getText());
	  }
	 }

	// test10:

	 @Test
     public void Test10(){
	  driver.get("http://jsbin.com/osebed/2");
	 
	 Select multiSelect = new Select(driver.findElement(By.id("fruits")));
	 multiSelect.selectByVisibleText("Banana");
	multiSelect.selectByValue("apple"); multiSelect.selectByIndex(3);
	 System.out.println("selected 3 options");
	 
	if(multiSelect.isMultiple()) { multiSelect.deselectAll();
	  System.out.println("deleselected all"); }
	 }

	// Test11:
	 @Test
     public void Test11(){
	  driver.get("http://demo.guru99.com/test/link.html");
	  
	  System.out.println(driver.findElement(By.linkText("click here")).getAttribute
	 ("href"));
	 System.out.println(driver.findElements(By.linkText("click here")).size());
	  driver.findElement(By.linkText("click here")).click();
	 }

	@AfterTest
	public void AfterTest() {
		// Thread.sleep(3000);
		System.out.println("Reached Teardown to close the browser");
		driver.close();
		driver.quit();
	}

}