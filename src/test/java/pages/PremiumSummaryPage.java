package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PremiumSummaryPage {

	private WebDriver driver;
	
	private By premiumOptionField = By.xpath("//label[contains(@ng-model,'TarPrem1')]");
	private By saveButtonField = By.xpath("//button[contains(@ng-disabled, 'disableSaveButton')]");
	private By productSwitchField = By.id("popup_cancel");
	private By referenceNoField = By.id("popup_message");
	
	public PremiumSummaryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String premiumSummaryElement() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement premiumOptionElement = driver.findElement(premiumOptionField);
		premiumOptionElement.click();
		
		WebElement saveButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(saveButtonField));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);", saveButtonElement);
		saveButtonElement.click();
		
		WebElement productSwitchElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productSwitchField));
		productSwitchElement.click();
		
		WebElement referenceNoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(referenceNoField));
		String referenceNoMessage = referenceNoElement.getText();
		
		return referenceNoMessage;
	}

}
