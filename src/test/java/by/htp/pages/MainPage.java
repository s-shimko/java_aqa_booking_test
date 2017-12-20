package by.htp.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

	private final String BASE_URL = "https://www.booking.com/";
	private final String CHOOSE_MINSK = "Минск, Минская область, Беларусь";

	@FindBy(xpath = ".//div[@class='sb-searchbox__row u-clearfix ']//input[@id='ss']")
	private WebElement autocompleteSearch;

	@FindBy(xpath = "(.//div[@data-placeholder='Дата заезда'])[1]/../..")
	private WebElement datePickerArrival;

	@FindBy(xpath = "(.//td[@data-id='1514678400000']/span)[1]")
	private WebElement datePickerDay;

	@FindBy(css = "")
	private WebElement dateDeparture;

	@FindBy(css = "select#no_rooms")
	private WebElement rooms;

	@FindBy(css = "select#group_adults")
	private WebElement adults;

	@FindBy(css = "select#group_children")
	private WebElement children;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement workTrip;

	@FindBy(css = "div.sb-searchbox__row.u-clearfix span.sb-submit-helper")
	private WebElement buttonCheckPrice;

	@FindBy(xpath = ".//b[@class='price_font_display_two']")
	private List<WebElement> searchResultPrices;
	
	@FindBy(xpath = ".//li[@data-label='"+ CHOOSE_MINSK +"']")
	private WebElement chooseMinsk;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void clickOnCheckPriceButton() {
		buttonCheckPrice.submit();
	}

	public void fillSearchForm(String place) {
		autocompleteSearch.sendKeys(place);
		chooseMinsk.click();
		datePickerArrival.click();

		if (driver instanceof JavascriptExecutor) {
			((JavascriptExecutor) driver)
					.executeScript("$('td[data-id=\"1514678400000\"]').find('span').eq(0).mouseover().click();");
		} else {
			throw new IllegalStateException("This driver does not support JavaScript!");
		}
	}

	public void verifySearchResults() {
		List<WebElement> list = searchResultPrices;

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
	}
}
