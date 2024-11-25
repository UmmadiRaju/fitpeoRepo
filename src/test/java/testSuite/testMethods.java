package testSuite;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import objects.RevenueCalculatorPage;
import objects.SelectingCPTCodes;
import objects.ValidateSliderValue;

public class testMethods {
	WebDriver driver;
	HomePage Home;
	RevenueCalculatorPage calculator;
	SelectingCPTCodes TotalRecurringReimbursement;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.fitpeo.com/");
	}

	@Test(priority = 1)
	public void validatingLauchedURL() {
		Home = new HomePage(driver);
		Home.VerificationHomeTitle();
	}

	@Test(priority = 2)
	public void revenueCalculatorClickOperation() throws InterruptedException {
		Home = new HomePage(driver);
		Home.clickRevenueCalculator();
		Home.verificationOfExpectedURL();
	}

	@Test(priority = 3)
	public void adjustmentSlider() throws InterruptedException {
		calculator = new RevenueCalculatorPage(driver);
		calculator.scrollDown();
	}

	@Test(priority = 4)
	public void sliderAdjustment() throws InterruptedException {
		calculator = new RevenueCalculatorPage(driver);
		calculator.sliderAdjustment();
	}

	@Test(priority = 5)
	public void verifyingTextFieldValue() throws InterruptedException {
		ValidateSliderValue page = new ValidateSliderValue(driver);
		page.updateTextFieldValue();
	}

	@Test(priority = 6)
	public void selectCPTCodes() throws InterruptedException {
		SelectingCPTCodes page = new SelectingCPTCodes(driver);
		page.scrollDown();
		page.selectCPT99091();
		page.selectCPT99453();
		page.selectCPT99454();
		page.selectCPT99474();
	}

	@Test(priority = 7)
	public void validateTotalRecurringReimbursement() {
		TotalRecurringReimbursement = new SelectingCPTCodes(driver);
		TotalRecurringReimbursement.validateTotalRecurringReimbursement();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
