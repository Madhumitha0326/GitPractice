package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PerilClausePage {

	private WebDriver driver;
	
	private By nextButtonField = By.xpath("//button[contains(text(),'Next')]");
	
	public PerilClausePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void perilClauseElement() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		
		Thread.sleep(2000);
		WebElement nextButtonElement = wait.until(ExpectedConditions.elementToBeClickable(nextButtonField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
		Thread.sleep(1000);
		nextButtonElement.click();
		Thread.sleep(1000);
	}

}
