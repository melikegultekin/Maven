package org.apache.log4j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver.Timeouts;
import org.apache.log4j.Logger;
import java.util.concurrent.TimeUnit;
public class Logger {
	
	public WebDriver driver;
    public static Logger logger = Logger.getLogger(Logger.class);
    public static String url = "https://www.kitapyurdu.com/";
    
    public void setUp() {
    	logger.info("Test ba�lat�ld�.");
        System.setProperty("webdriver.chrome.driver", "C:/selenium-driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
     
    }
    
	@Test
    public void loginTest() {
        driver.navigate().to(url);
        logger.info("Test Edilecek Sayfa : " + driver.getTitle());
        driver.findElement(By.id("search-input")).sendKeys("roman");
        driver.findElement(By.cssSelector("#product-577905")).click();
        driver.findElement(By.cssSelector("#search > span")).click();
        String a = driver.findElement(By.id("cart-items")).getText();
        String b =driver.findElement(By.id("button-cart")).getText();
        Assert.assertEquals(a,b, "De�erler e�it de�il");
        driver.findElement(By.cssSelector("#button-cart > span")).click();
        driver.findElement(By.id("cart-item")).sendKeys("#button-cart > span");
        driver.findElement(By.cssSelector("#cart > div.heading > div:nth-child(2) > h4")).click();
        driver.findElement(By.cssSelector("#js-cart")).click();
        driver.findElement(By.cssSelector("#cart_module")).click();
    	String element = "Sepetiniz g�ncellendi";
    	String mesaj = driver.findElement(By.cssSelector("#swal-toast > div > div")).getText();//gelen mesaj
    	Assert.assertEquals(mesaj, element, "kontrol ba�ar�s�z");
        driver.findElement(By.cssSelector("#cart_module > div.cart-info > table > tbody > tr > td.remove > a > i")).click();
        String element1="sepetiniz bo�";
        String mesaj1 = driver.findElement(By.cssSelector("#cart-items-empty")).getText();
        Assert.assertEquals(mesaj1, element1, "kontrol ba�ar�s�z");
        
       
    }
    
    @BeforeTest  
	public void  BeforeTest() {     
	System.out.println( "test �ncesi" );  
	}     
	@AfterTest  
	public void  afterTest() {   
	driver.quit();  
	System.out.println( "testten sonra" );  
	}  
}