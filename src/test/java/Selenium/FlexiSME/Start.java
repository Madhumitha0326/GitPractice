package Selenium.FlexiSME;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Start {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.get("https://nsureuat.berjayasompo.com.my/nsure/agent/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userNameId")).sendKeys("10001338");
		driver.findElement(By.id("passwordId")).sendKeys("Bsi0987654321!");
		driver.findElement(By.id("SIGN_IN")).click();
		WebElement transaction = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='sideMenuElement']/li[3]")));
		transaction.click();
		WebElement covernoteSearch = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'CN/Ref/Appl. No. ')]/following-sibling::div//input")));
		covernoteSearch.sendKeys("FA003489");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Actions a = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		WebElement record = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='ui-grid-canvas']/div"))));
		a.doubleClick(record);
		WebElement crossSellingAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'CROSS_SELLING')]")));
		Boolean crossSellingAlertAvailable = crossSellingAlert.isDisplayed();
		if(crossSellingAlertAvailable) {
			driver.findElement(By.id("popup_ok"));
		}
		else {
			driver.quit();
		}
	}

}
