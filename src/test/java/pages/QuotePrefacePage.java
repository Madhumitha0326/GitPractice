package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuotePrefacePage {
		
	private WebDriver driver;
	
	private By productTypeField = By.id("DD_productTypeId");
	private By inceptionDateField = By.id("VEH_INCEPTION_DATE");
//	private By inceptionDateCalField = By.xpath("//div[@id='VEH_POC_INCEPTION_DATE']/span/button");
//	private By inceptionDateTodayField = By.xpath("//div[@class='datepicker-days']/table/tfoot/tr[1]/th[@class='today']");
	private By incDateSelAlertField = By.id("popup_container");
	private By inceptionAlertMessageField = By.id("popup_message");
	private By inceptionAlertOkField = By.id("popup_ok");
	private By clientSearchButtonField = By.xpath("//button[contains(@ng-click,'fnShowMotorSearchPopup')]");
	private By clientSearchField = By.xpath("//div[@class='modal-dialog']/div/div[2]/div/div/fieldset/div/div[1]/div/div/div/select");
	private By clientNameField = By.id("TXT_DATA");
	private By specificClientSearchField = By.id("CUSTOM_SEARCH");
	private By clientSelectField = By.xpath("//div[@ui-grid='motorSearchGrid']/div/div/div[2]/div");
	private By nextButtonField = By.xpath("//div[@class='text-center']/div/button[@type='submit']");
	private By clientSearchialogBoxField = By.className("modal-dialog");
	
	public QuotePrefacePage(WebDriver driver) {
		this.driver = driver;
	}	
	
	public void quotePrefacePageDetails(String productName, String clientName, String inceptionDate) throws InterruptedException {
		
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
		WebElement fireProductElement = wait.until(ExpectedConditions.presenceOfElementLocated(productTypeField));
		Select fireProduct = new Select(fireProductElement);
		Thread.sleep(1000);
		fireProduct.selectByVisibleText(productName);
		
		WebElement inceptionDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(inceptionDateField));
		inceptionDateElement.sendKeys(inceptionDate);

		WebElement body = driver.findElement(By.xpath("//span[contains(text(), 'Preface')]"));
		body.click();
		
		try {
			Boolean inceptionDateAlert = driver.findElement(incDateSelAlertField).isDisplayed();
			if (inceptionDateAlert == true) {
				WebElement inceptionAlertMessageElement = driver.findElement(inceptionAlertMessageField);
				String inceptionDateAlertMessage = inceptionAlertMessageElement.getText();
				System.out.println(inceptionDateAlertMessage);
				WebElement inceptionAlertOkElement = driver.findElement(inceptionAlertOkField);
				inceptionAlertOkElement.click();
				driver.quit();
			}
		}catch(Exception error) {
			System.err.println("An error occurred: " + error.getMessage());
		}
				
//		else {
//			WebElement inceptionDateCalElement = driver.findElement(inceptionDateCalField);
//			inceptionDateCalElement.click();
//			WebElement inceptionDateTodayElement = driver.findElement(inceptionDateTodayField);
//			inceptionDateTodayElement.click();
//		}
		
		WebElement clientSearchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(clientSearchButtonField));
		clientSearchButtonElement.click();	
		
		WebElement clientSearchElement = wait.until(ExpectedConditions.elementToBeClickable(clientSearchField));
		Select clientNameSearch = new Select(clientSearchElement);
		clientNameSearch.selectByVisibleText("CLIENT NAME");
		
		WebElement clientNameElement = driver.findElement(clientNameField);
		clientNameElement.sendKeys(clientName);
		
		WebElement specificClientSearchElement = driver.findElement(specificClientSearchField);
		specificClientSearchElement.click();
		
		WebElement clientSelectElement = driver.findElement(clientSelectField);
		Actions a = new Actions(driver);
		a.doubleClick(clientSelectElement).build().perform();
		
		Boolean clientSearchDialogBoxElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(clientSearchialogBoxField));
		clientSearchDialogBoxElement.compareTo(true);
		
		WebElement nextButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButtonField));
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
		Thread.sleep(1000);
		nextButtonElement.click();
		
	}

}
