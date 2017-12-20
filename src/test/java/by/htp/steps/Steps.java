package by.htp.steps;

import org.openqa.selenium.WebDriver;

import by.htp.driver.DriverSingleton;
import by.htp.pages.MainPage;

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

		public void positiveSearch(String place)
		{
			MainPage mp = new MainPage(driver);
			mp.openPage();
			mp.fillSearchForm(place);
			mp.clickOnCheckPriceButton();
			mp.verifySearchResults();
		}

	}


