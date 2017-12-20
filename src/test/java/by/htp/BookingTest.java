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

	@Test(description = "Positive Booking Search")
	public void positiveBookingSearch() {
		steps.positiveSearch(SEARCH_PLACE);
	}

}
