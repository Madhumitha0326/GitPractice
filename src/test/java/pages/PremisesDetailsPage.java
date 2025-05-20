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

public class PremisesDetailsPage {
	
	private WebDriver driver;
	
	private By occupiedAsField = By.id("TRADE_ID");
	private By tradeOccCodeField = By.id("FIRE_BUSI_CODE");
	private By occDescField = By.xpath("//input[contains(@ng-model, 'riskfactordet.occupation')]");
	private By constClassField = By.id("CONST_CLASS");
	private By ratingTypeField = By.xpath("//select[contains(@ng-model, 'riskfactordet.ratingTypeId')]");
	private By permanentAddrField = By.id("RDO_ADDRESS1");
	private By addInterestField = By.xpath("//button[contains(text(), 'Add Interest')]");
	private By searchInterestCodeField = By.id("TXT_DATA");
	private By searchButtonField = By.id("CUSTOM_SEARCH");
	private By interestSelectField = By.xpath("//div[contains(@class, 'piamSearchGrid')]/div[1]/div[1]/div[2]/div");
	private By interestDialogBoxField = By.xpath("//div[@class='modal-dialog']");
	private By sumInsuredField = By.id("31INTEREST_GRID_SI1");
	private By computePremiumField = By.xpath("//button[contains(@ng-click, 'compute')]");
	private By addRiskField = By.xpath("//button[contains(text(), 'Add Risk')]");
	private By addRiskSuccessField = By.id("popup_ok");
	private By nextButtonField = By.xpath("//button[contains(text(), 'Next')]");
	private By loadingSymbolField = By.xpath("//div[@id='page-blocker']/div/img");
	
	
	public PremisesDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void premisesDetailsElements(String occupiedAs, String tradeOccCode, String occDesc, String constClass, String ratingType, String interestCode, String sumInsured) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		WebElement occupiedAsElement = wait.until(ExpectedConditions.elementToBeClickable(occupiedAsField));
		Select occupiedAsSelect = new Select(occupiedAsElement);
		occupiedAsSelect.selectByContainsVisibleText(occupiedAs);
		
		WebElement tradeOccCodeElement = wait.until(ExpectedConditions.elementToBeClickable(tradeOccCodeField));
		Select tradeOccCodeSelect = new Select(tradeOccCodeElement);
		tradeOccCodeSelect.selectByContainsVisibleText(tradeOccCode);
		
		WebElement occDescEnter = driver.findElement(occDescField);
		occDescEnter.sendKeys(occDesc);
		
		WebElement constClassElement = wait.until(ExpectedConditions.elementToBeClickable(constClassField));
		Select constClassSelect = new Select(constClassElement);
		constClassSelect.selectByContainsVisibleText(constClass);
		
		WebElement ratingTypeElement = wait.until(ExpectedConditions.elementToBeClickable(ratingTypeField));
		Select ratingTypeSelect = new Select(ratingTypeElement);
		ratingTypeSelect.selectByContainsVisibleText(ratingType);
		
		WebElement permAddr = driver.findElement(permanentAddrField);
		permAddr.click();
		
		WebElement addInterestElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addInterestField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addInterestElement);
		Thread.sleep(1000);
		addInterestElement.click();
	
		WebElement searchInterestCodeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInterestCodeField));
		searchInterestCodeElement.sendKeys(interestCode);
		
		WebElement searchButtonElement = driver.findElement(searchButtonField);
		searchButtonElement.click();
		
		WebElement interestSelectElement = driver.findElement(interestSelectField);
		Actions a = new Actions(driver);
		a.doubleClick(interestSelectElement).build().perform();
		
		Boolean interestDialogBoxElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(interestDialogBoxField));
		interestDialogBoxElement.compareTo(true);
		
		WebElement sumInsuredElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sumInsuredField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sumInsuredElement);
		Thread.sleep(1000);
		sumInsuredElement.clear();
		sumInsuredElement.sendKeys(sumInsured);
		
		WebElement computePremiumElement = wait.until(ExpectedConditions.visibilityOfElementLocated(computePremiumField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", computePremiumElement);
		Thread.sleep(1000);
		computePremiumElement.click();
		Thread.sleep(5000);
		
		Boolean loadingSymbolElement = wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingSymbolField));
		loadingSymbolElement.compareTo(true);

		WebElement addRiskElement = wait.until(ExpectedConditions.elementToBeClickable(addRiskField));
		Thread.sleep(2000);
		addRiskElement.click();
		
		WebElement addRiskSuccessElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addRiskSuccessField));
		addRiskSuccessElement.click();
		
		WebElement nextButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButtonField));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButtonElement);
		Thread.sleep(1000);
		nextButtonElement.click();
	}
}
