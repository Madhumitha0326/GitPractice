package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	private WebDriver driver;
	
	private By transaction = By.xpath("//ul[@id=\"sideMenuElement\"]/li[4]/a");
	private By fireSelect = By.xpath("//div[@class='row'][1]/div[contains(@ng-if, 'isFireAllowed')]/a");
	private By newBusiness = By.xpath("//div[@id=\"MainMenuElement\"]/div/v-accordion/v-pane[1]/v-pane-header");
	private By fireModuleSelect = By.xpath("//div[@id=\"MainMenuElement\"]/div/v-accordion/v-pane[1]/v-pane-content/div/div/div/form/div/div/div[1]/ul/li[1]");
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void dashBoardPageElement() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		WebElement transactionselection = wait.until(ExpectedConditions.elementToBeClickable(transaction));
		Thread.sleep(1000);
		transactionselection.click();
		
		WebElement fireselection = wait.until(ExpectedConditions.visibilityOfElementLocated(fireSelect));
		fireselection.click();
		
		driver.findElement(newBusiness).click();
		driver.findElement(fireModuleSelect).click();

	}

}
