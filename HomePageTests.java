//
// Author: Tom Chlapecka
//
// Project Name:  Uptake1
// Package Names: PageObjectModel, TestCases
// Source Files:  PageObjectModel/Pages.java, TestCases/HomePageTests.java
//
// The purpose of this test is to verify the following:
// 1. Uptake home page launches successfully.
// 2. People element can be selected and the People page is launched.
// 3. Successfully navigating back to the uptake home page from the People page.
//
// NOTE: This test is for Firefox only. Additional browsers can be added if required.
//
// There is one issue that I came across concerning going back to the UPTAKE home page from the People page.
// Manually clicking on the UPTAKE logo on the People page did launch the home page successfully but trying to use
// driver.findelement with id, name, or xpath did not work. Clicking via xpath would have been ideal. I settled 
// for driver.navigate().back(). 
//
// My question to whomever is reading this is:
// How do you automate, via selenium, the clicking of the UPTAKE logo when on the People page other than 
// using navigate.back()?
//

package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjectModel.Pages;

public class HomePageTests {
	static WebDriver driver;
	static boolean   testPass = true;
	static String    homePageTitle = "Uptake – Analytics for the Industrial Internet";
	static String    peoplePageTitle = "People – Uptake";
	static String    title;

	public static void main(String[] args) {

		// Initialize Fire fox Driver, set a delay, and launch the uptake home page.
	    driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Store the uptake home page URL.
		String url = "http://uptake.com/";
		driver.get(url);
		
		//Storing URL in string variable
		String actualUrl = driver.getCurrentUrl();
		
		// Save current page title which should be the homePageTitle.
		title = Pages.title(driver);
			
		if(actualUrl.equals(url)){
			System.out.println("Verification Successful - UPTAKE page launched.");
		}else{
			System.out.println("Verification Failed - An incorrect web page opened.");
			//Print expect and actual results
			System.out.println("Actual Url is: " + actualUrl);
			System.out.println("Expected Url is: " + url);
			testPass = false;
		}
		
		// Verify that the home page title is correct.
		if (( title.equals(homePageTitle) && (testPass == true))){
			System.out.println("HOME PAGE TEST PASSED. Expected and Current Titles matched!!!");
		}else{
			System.out.println("Test Failed: Home Page www.uptake.com not reached");
			testPass = false;
		}
		
		// Click on the People element to launch the People page.
		if( testPass == true){
			//Launch the "People" page from the uptake home page.
			Pages.People(driver);
		    
		    // Store title name in string variable.
			title = Pages.title(driver);
			System.out.println("Title of the PEOPLE page is: " + title);

			// Verify that the People page is active.
			if(title.equals(peoplePageTitle)){
			
				System.out.println("PEOPLE PAGE TEST PASSED. People element clicked from home page.");
			
				//Go back to home page
				Pages.back(driver);
				//driver.navigate().back();
				
				// Store home page title name in string variable.
				title = Pages.title(driver);
				System.out.println(title);
				
				// Verify launching of home page from People page.
				if ( title.equals(homePageTitle) && (testPass == true)){
					System.out.println("PEOPLE PAGE to HOME PAGE TEST PASSED.");
				}else{
					System.out.println("PEOPLE PAGE to HOME PAGE TEST FAILED.");
					testPass = false;
				
				}
				
			}else{
				System.out.println("PEOPLE PAGE TEST FAILED. People element may have a problem.");
				testPass = false;
			}
			
	   }else{
			System.out.println("Test Failed: Error with the home page title.");
			testPass = false;
	   }
				
	   if( testPass == true){
		  System.out.println("All Tests Passed!");
	   }else{
		  System.out.println("FAILED!!");
	   }
		    
	  driver.quit();	
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

