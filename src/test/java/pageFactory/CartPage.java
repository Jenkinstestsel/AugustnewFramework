package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	@FindBy(xpath="//cite[@class='mid']/span[2]")
	public WebElement imgcartbook;
	
	@FindBy(id="frmCart")
	public WebElement frmCart;
	
	public CartPage(WebDriver driver){
		PageFactory.initElements(driver, this);		
	}

}
