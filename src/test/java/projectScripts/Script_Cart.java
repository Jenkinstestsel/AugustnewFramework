package projectScripts;

import genericLibrary.Base;

import java.util.Map;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pageFactory.CartPage;
import pageFactory.HomePage;
import pageFactory.ProductDetailsPage;

public class Script_Cart extends Base{
	
	
	@Test(dataProvider="commondp",dataProviderClass = dataProvider.CommonDataProvider.class,groups={"qa","uat","prod"})
	public void Cart_AddBook(Map<String,String> hm) throws Exception{
		 
		String tcid = hm.get("ID");
		String order = hm.get("Order");		
		 startTest = eReports.startTest(tcid + "_" + order);
		 startTest.assignCategory(btype);
	
		 HomePage hp = new HomePage(ff);
		 ProductDetailsPage pdp = new ProductDetailsPage(ff);
		 CartPage cp = new CartPage(ff);
	
		 if(ff.getTitle().toLowerCase().contains("books")){
				startTest.log(LogStatus.PASS, "Home Page Validation","Successfuly validated");
			}else{
				startTest.log(LogStatus.FAIL, "Home Page Validation","Fialed as not able to locate HomePage" + ff.getTitle()  + startTest.addScreenCapture(fullscreen()));
			}
	
//	search for a book
	      hp.bookSearch(hm);
	      
//	      click on first book
	     Click(hp.imgFirstBook); 
	     
//	     validat product details page
	     if(ff.getTitle().toLowerCase().contains(hm.get("Searchoption").trim().toLowerCase())){
				startTest.log(LogStatus.PASS, "Product Details Page Validation","Successfuly validated");
			}else{
				startTest.log(LogStatus.FAIL, "Product Details Validation","Fialed as not able to locate Product Details" + ff.getTitle()  + startTest.addScreenCapture(fullscreen()));
			}
	
//	     click on buy Now
	     
	     Click(pdp.imgbook);
	     
//	     validat cart page
	     if(ff.getTitle().toLowerCase().contains("shopping")){
				startTest.log(LogStatus.PASS, "Cart Page Validation","Successfuly validated");
			}else{
				startTest.log(LogStatus.FAIL, "Cart Page Validation","Fialed as not able to locate Cart Page" + ff.getTitle()  + startTest.addScreenCapture(fullscreen()));
			}     
	     
//	     ff.switchTo().frame(cp.frmCart);
	     SwitchFrame(ff, cp.frmCart);
	     
//	Validate the book is added
	     String Actual_output = GetText(cp.imgcartbook);
	     

	     if(Actual_output.toLowerCase().contains(hm.get("Searchoption").trim().toLowerCase())){
				startTest.log(LogStatus.PASS, "Add to Cart Validation","Successfuly validated");
			}else{
				startTest.log(LogStatus.FAIL, "Add to Cart Validation","Fialed as actual is " + Actual_output  + " and expected was " + hm.get("Searchoption") + startTest.addScreenCapture(fullscreen()));
			}  
	
	     ff.switchTo().defaultContent();
	}
}
