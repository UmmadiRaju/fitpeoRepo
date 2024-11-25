package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By revenueCalculator = By.linkText("Revenue Calculator");
	
	public void VerificationHomeTitle() {
		//Validating the expected Title after launching the specified URL
		String ActualTitle = driver.getTitle();
		Assert.assertEquals("Remote Patient Monitoring (RPM) - fitpeo.com",ActualTitle, "Opps!, Title is mismatched");
	}
	
	public void clickRevenueCalculator() throws InterruptedException {
		//Clicking on the Revenue Calculator link
		driver.findElement(revenueCalculator).click();
		Thread.sleep(2000);
	}
	
	public void verificationOfExpectedURL() throws InterruptedException {
		//Validating the expected URL
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.fitpeo.com/revenue-calculator";
		Assert.assertEquals(actualURL,expectedURL, "The Actual URL is not matched with Expected URL");
		Thread.sleep(2000);
	}
}
