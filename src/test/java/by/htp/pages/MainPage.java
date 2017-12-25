package by.htp.pages;

import static org.testng.Assert.assertEquals;

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

	@FindBy(xpath = "//*[@id=\"frm\"]/div[3]/div/div[1]/div[2]/div/div/div[1]/div/div[2]")
	private WebElement dateDeparture;

	@FindBy(css = "select#no_rooms")
	private WebElement rooms;
	
	@FindBy(xpath = ".//select[@id='no_rooms']//option[@selected]")
	private WebElement roomsDefaultValue;

	@FindBy(css = "select#group_adults")
	private WebElement adults;
	
	@FindBy(xpath = ".//select[@id='group_adults']//option[@selected]")
	private WebElement adultsDefaultValue;

	@FindBy(css = "select#group_children")
	private WebElement children;
	
	@FindBy(xpath = "//select[@id='group_children']//option[@selected]")
	private WebElement childrenDefaultValue;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement workTrip;

	@FindBy(css = "div.sb-searchbox__row.u-clearfix span.sb-submit-helper")
	private WebElement buttonCheckPrice;

	@FindBy(xpath = ".//li[@data-label='"+ CHOOSE_MINSK +"']")
	private WebElement chooseMinsk;
	
	@FindBy(xpath = ".//input[@name='sb_travel_purpose']")
	private WebElement checkboxWorktrip;
	
	@FindBy(xpath = ".//input[@name='sb_travel_purpose']/..")
	private WebElement checkboxWorktripText;
	
	@FindBy(xpath = "(.//div[@class='fe_banner__message '])[1]")
	private WebElement emptySearchText;
	

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
	
	public void checkDefaultPresets() {
		String adults_dv = adultsDefaultValue.getText();
		assertEquals(adults_dv, "2");
		
		String children_dv = childrenDefaultValue.getText();
		assertEquals(children_dv, "0");
		
		String rooms_dv = roomsDefaultValue.getText();
		assertEquals(rooms_dv, "1");
	}

	public void checkWorktrip() {
		checkboxWorktrip.click();
		
		assertEquals(checkboxWorktripText.getText(), "\r\n" + 
				"Я путешествую по работе");
	}

	public void checkDepartureText() {
		assertEquals(dateDeparture.getText(), "понедельник, 1 января 2018");
	}

	public void checkEmptySearchLink() {
		assertEquals(emptySearchText.getText(), "Чтобы начать поиск, введите направление.");
	}


}
