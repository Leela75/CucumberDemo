package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Definition {
	
	WebDriver driver;
	
	@Given("Enter Login page")
	public void enter_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\LeelaKS\\Desktop\\SDET Training\\chromedriver.exe");
		  driver= new ChromeDriver();
		   
		  driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@When("Enter the valid username")
	public void enter_the_valid_username() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}
	@When("Enter the valid password")
	public void enter_the_valid_password() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	}
	@When("Submit")
	public void submit() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("btnLogin")).click();
	}
	@SuppressWarnings("deprecation")
	@Then("Login is success -> Welcome page")
	public void login_is_success_welcome_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		String actual = driver.findElement(By.id("welcome")).getText();
	    String expected = "Welcome Fabiola";
	    Assert.assertEquals(expected, actual);
	    //driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[10]/ul/li[3]/a")).click();
	    System.out.println("Sucessfully logged in");
	    driver.findElement(By.id("welcome")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
	    System.out.println("successfully logged out");
	    //driver.close();
	    driver.quit();
	}

}
