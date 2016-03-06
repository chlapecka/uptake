package PageObjectModel;

//
// Author: Tom Chlapecka
//
// Page Object Model for the Uptake1 project.
//
//

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Pages {
	WebDriver driver;
	
	public static String title(WebDriver driver){
	    // Store title name in string variable.
	    String title = driver.getTitle();
		
	    //System.out.println("Title of the page is: " + title);
	    return title;
	}
	
	
	// Get the Unique title on the Uptake home page.
	public static String getHomePageName(WebDriver driver){
	    By homePageName = By.xpath(".//*[@id='content']/div[4]/div/main/div[2]/div/div/h1");
	    return driver.findElement(homePageName).getText();
	}
	
	// Back to previous web page.
	public static void back(WebDriver driver){
	    driver.navigate().back();
	}	
	
	//Click on the People element.
	public static WebDriver People(WebDriver driver){
	    driver.findElement(By.xpath("html/body/header/div/div[1]/div/ul/li[4]/a")).click();
	    return driver;
	}	
}
