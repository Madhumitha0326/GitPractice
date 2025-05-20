package fire;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PrivacyPage;
import pages.QuotePrefacePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PerilClausePage;
import pages.PremisesDetailsPage;
import pages.PremiumSummaryPage;

public class StepDefinition{
	
	private PrivacyPage privacyPage;
	private LoginPage loginPage;
	private DashboardPage dashboardPage;
	private QuotePrefacePage quotePrefacePage;
	private PremisesDetailsPage premisesDetailsPage;
	private PerilClausePage perilClausePage;
	private PremiumSummaryPage premiumSummaryPage;
	
	private WebDriver driver;
	private String agentSQAwebsite = "https://10.100.7.74:9449/bsibdetariff/agent/";
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		privacyPage = new PrivacyPage(driver);
		dashboardPage = new DashboardPage(driver);
		quotePrefacePage = new QuotePrefacePage(driver);
		premisesDetailsPage = new PremisesDetailsPage(driver);
		perilClausePage = new PerilClausePage(driver);
		premiumSummaryPage = new PremiumSummaryPage(driver);
	}
	
	@Given("the user is on the login page {string} {string}")
	public void the_user_is_on_the_login_page(String Username, String Password) throws InvalidFormatException, IOException {
		
		driver.get(agentSQAwebsite);
		driver.manage().window().maximize();
		privacyPage.privacyWindow();
		loginPage.loginCreds(Username, Password);
	}
	
	@When("the user is on the dashboard page")
	public void the_user_is_on_the_dashboard_page() throws InterruptedException {
		dashboardPage.dashBoardPageElement();
	}
	
	@When("the user is on quote preface page {string} {string} {string}")
	public void the_user_is_on_quote_preface_page(String productName, String clientName, String inceptionDate) throws InterruptedException{
		quotePrefacePage.quotePrefacePageDetails(productName, clientName, inceptionDate);
	}
	
	@When("the user is on premises details page {string} {string} {string} {string} {string} {string} {string}")
	public void the_user_is_on_premises_details_page(String occupiedAs, String tradeOccCode, String occDesc, String constClass, String ratingType, String interestCode, String sumInsured) throws InterruptedException {
		premisesDetailsPage.premisesDetailsElements(occupiedAs, tradeOccCode, occDesc, constClass, ratingType, interestCode, sumInsured);
	}
	
	@When("the user is on the peril clause page")
	public void the_user_is_on_the_peril_clause_page() throws InterruptedException {
		perilClausePage.perilClauseElement();
	}
	
	@Then("the user is on the premium summary page")
	public void the_user_is_on_the_premium_summary_page() throws InterruptedException {
		String referenceNoMessage = premiumSummaryPage.premiumSummaryElement();
		String referenceNo = referenceNoMessage.split(":")[1].trim().split(" ")[0];
		System.out.println(referenceNo);
	}
	
//	@After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
	
}