package by.htp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultPage extends AbstractPage {

	private final String BASE_URL = "https://www.booking.com/searchresults";
	
	@FindBy(xpath = ".//b[@class='price_font_display_two']")
	private List<WebElement> searchResultPrices;
	
	public ResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
	
	public void verifySearchResults() {
		List<WebElement> list = searchResultPrices;

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
		}
		
		if(list.size() < 5) {
			System.out.println("Less than 5 elements!");
		}
	}

}
