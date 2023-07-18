package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PIMStepDefinitions {
	WebDriver driver;

	@Given("^I want to Navigate to OrangeHrm$")
	public void navigateToOrangeHrm() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\krish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
	}

	@Given("^Validate with valid Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
	public void validateCredentials(String username, String password) {
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@When("^Sucessfully login to Homepage$")
	public void loginToHomepage() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	@When("^Click on PIM function$")
	public void clickPIMFunction() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
	}

	@When("Select Employee information with Valid  id {string}")
	public void select_Employee_information_with_Valid_id(String employeeId) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(
				"div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']"))
				.sendKeys(employeeId);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("^Successfully see the records of input Employee$")
	public void verifyEmployeeRecords() throws InterruptedException {
		Thread.sleep(1000);
		String recordText = driver.findElement(By.xpath("//span[text()='No Records Found']")).getText();
		System.out.println("Employee Record: " + recordText);
	}
}
