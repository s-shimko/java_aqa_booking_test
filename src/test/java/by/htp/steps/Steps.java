package by.htp.steps;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import by.htp.driver.DriverSingleton;
import by.htp.pages.MainPage;
import by.htp.pages.ResultPage;

	public class Steps
	{
		private WebDriver driver;

		public void initBrowser()
		{
			driver = DriverSingleton.getDriver();
		}

		public void closeDriver()
		{
			DriverSingleton.closeDriver();
		}

		public void fillSearchForm(String place)
		{
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.fillSearchForm(place);
			mp.clickOnCheckPriceButton();
		}
		
		public void verifySearchResults() {
			ResultPage rp = new ResultPage(driver);
			rp.verifySearchResults();
		}
		
		public void checkDefaultPresets() {
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.checkDefaultPresets();
		}

		public void checkWorktrip() {
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.checkWorktrip();
		}

		public void checkDepartureAutomaticallySet(String place) {
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.fillSearchForm(place);
			mp.checkDepartureText();			
		}

		public void checkEmptySearchLink() {
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.clickOnCheckPriceButton();
			mp.checkEmptySearchLink();
		}

	}


