package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.poi.common.usermodel.PictureType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class PrivacyPage {
	
	private WebDriver driver;
	
	public PrivacyPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void privacyWindow() throws InvalidFormatException, IOException {
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshotDest = new File("screenshot.png");
        Files.copy(screenshot.toPath(), screenshotDest.toPath());

        // Create Word Document
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Screenshot from Selenium");

        // Add the screenshot to the Word document
        FileInputStream imgStream = new FileInputStream(screenshotDest);
        run.addPicture(imgStream, PictureType.PNG, "screenshot.png", 500, 300); // Adjust width/height if necessary

        // Save Word document
        FileOutputStream out = new FileOutputStream("screenshot_document.docx");
        document.write(out);
        out.close();

        // Clean up
        driver.quit();
        screenshotDest.delete();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
	}
		
}
