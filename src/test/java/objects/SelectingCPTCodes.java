package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SelectingCPTCodes {
	WebDriver driver;

	public SelectingCPTCodes(WebDriver driver) {
		this.driver = driver;
	}
	
	By selectCPT99091 = By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/label/span[1]");
	By selectCPT99453 = By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/label/span[1]");
	By selectCPT99454 = By.xpath("/html/body/div[2]/div[1]/div[2]/div[3]/label/span[1]");
	By selectCPT99474 = By.xpath("/html/body/div[2]/div[1]/div[2]/div[8]/label/span[1]");
	By RecurringReimbursementValue = By.xpath("/html/body/div[2]/div[1]/div[1]/div[1]/div/div[3]/p[2]");
	
	public void scrollDown() throws InterruptedException {
		// Scrolling web page to the CPT selections
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 800)");
		Thread.sleep(2000);
	}
	
	public void selectCPT99091() throws InterruptedException{
		//Selecting on the CPT-99091 check box
		driver.findElement(selectCPT99091).click();
		Thread.sleep(2000);
	}
	
	public void selectCPT99453() throws InterruptedException{
		//Selecting on the CPT-99453 check box
		driver.findElement(selectCPT99453).click();
		Thread.sleep(2000);
	}
	
    public void selectCPT99454() throws InterruptedException{
    	//Selecting on the CPT-99454 check box
    	driver.findElement(selectCPT99454).click();
    	Thread.sleep(2000);
	}
    
    public void selectCPT99474() throws InterruptedException{
    	//Selecting on the CPT-99474 check box
    	driver.findElement(selectCPT99474).click();
    	Thread.sleep(2000);
	}
    
    public void validateTotalRecurringReimbursement() {
    	//Validating Total Recurring Reimbursement
    	WebElement element = driver.findElement(RecurringReimbursementValue);
    	String ActualResult = element.getText();
    	System.out.println(ActualResult);
    	String ExpectedResult = "$110700";
    	Assert.assertEquals(ActualResult, ExpectedResult, "The Actual Value is not matched with Expected Value");
    }

}
