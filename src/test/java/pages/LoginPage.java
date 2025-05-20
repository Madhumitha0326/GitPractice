package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private By usernameField = By.id("userNameId");
	private By passwordField = By.id("passwordId");
	private By signInField = By.id("SIGN_IN");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginCreds(String username, String password) {
		
		WebElement usernameElement = driver.findElement(usernameField);
		usernameElement.sendKeys(username);
		
		WebElement passwordElement = driver.findElement(passwordField);
		passwordElement.sendKeys(password);
		
		WebElement signInElement = driver.findElement(signInField);
		signInElement.click();
	}

}
