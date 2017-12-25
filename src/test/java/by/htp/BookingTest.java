package by.htp;

import org.testng.annotations.Test;

import by.htp.steps.Steps;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BookingTest {

	private Steps steps;
	private final String SEARCH_PLACE = "Минск";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

	@Test(description = "Positive Booking Search", enabled=false)
	public void positiveBookingSearch() {
		steps.fillSearchForm(SEARCH_PLACE);
		steps.verifySearchResults();
	}
	
	@Test(description = "Check Default Presets", enabled=false)
	public void checkDefaultPresets() {
		steps.checkDefaultPresets();
	}
	
	@Test(description = "Possibility to check Worktrip checkbox", enabled=false)
	public void checkWorktrip() {
		steps.checkWorktrip();
	}
	
	@Test(description = "Date departure automatically set", enabled=false)
	public void checkDepartureAutomaticallySet() {
		steps.checkDepartureAutomaticallySet(SEARCH_PLACE);
	}
	
	@Test(description = "Check empty search link", enabled=true)
	public void checkEmptySearchLink() {
		steps.checkEmptySearchLink();
	}

}
