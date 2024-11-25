package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RevenueCalculatorPage {

	WebDriver driver;

	public RevenueCalculatorPage(WebDriver driver) {
		this.driver = driver;
	}

	By slider = By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]");

	public void scrollDown() throws InterruptedException {
		// Scrolling web page to the slider element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0, 300)");
		Thread.sleep(2000);
	}

	public void sliderAdjustment() throws InterruptedException {
		// Adjusting slider value to the 823
		WebElement Slider = driver.findElement(slider);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, -26, 0).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementsByClassName(\"MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op\")[0].style.color='red'");
		Thread.sleep(2000);
	}

}
