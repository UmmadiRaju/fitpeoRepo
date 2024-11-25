package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class ValidateSliderValue {
	WebDriver driver;

	public ValidateSliderValue(WebDriver driver) {
		this.driver = driver;
	}
	
	By slider = By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]");

	public void updateTextFieldValue() throws InterruptedException {
		WebElement TextField = driver.findElement(By.xpath("//input[contains(@id, ':r')]"));
		WebElement Slider = driver.findElement(slider);
		Thread.sleep(2000);
		//Clearing slider to zero position
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, -150, 0).perform();
		Thread.sleep(2000);
		//Updating the new value in the text field
		TextField.sendKeys("560");
		Thread.sleep(2000);
		//Clearing slider again to zero position
		action.dragAndDropBy(Slider, -150, 0).perform();
		Thread.sleep(2000);
		//updated the new value in the text field
		TextField.sendKeys("820");
		Thread.sleep(2000);
	}
}


