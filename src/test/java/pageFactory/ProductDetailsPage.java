package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	@FindBy(className="buynowbtnbig")
	public WebElement imgbook;
	
	public ProductDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}
	
	
	
}
