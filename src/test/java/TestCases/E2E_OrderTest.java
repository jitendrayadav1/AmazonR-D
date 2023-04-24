package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CommonActions.BaseTest;
import PageObject.LoginPage;
import PageObject.OrderPage;
import Utils.TestData;
import junit.framework.Assert;

public class E2E_OrderTest extends BaseTest {

	Utils.ExtentListeners e=new Utils.ExtentListeners();
	public OrderPage order;
	public LoginPage lpage;
	TestData tdata ;

	@Test
	public void LoginFunctionality() throws Exception
	{
		tdata =new TestData();
		lpage=new LoginPage(driver);
		act.moveToElement(lpage.getLogin()).perform();
		Thread.sleep(2000);
		lpage.getSignin().click();
		lpage.getPhnumber().sendKeys(tdata.u);
		lpage.getContinueBtn().click();
		lpage.getPassword().sendKeys(tdata.password);
		lpage.getSigninBtn().click();
     e.test.log(Status.INFO,"Login successfully");
	}
	@Test
	public void placeOrder() throws InterruptedException
	{
		order=new OrderPage(driver);
		//click on search Box

		order.getSearchBox().sendKeys(order.product,Keys.ENTER);
		//enter MinValue
		order.getMinValue().click();
		order.getMinValue().sendKeys(tdata.min);
		Thread.sleep(2000);
		order.getMaxValue().click();
		order.getMaxValue().sendKeys(tdata.max);

		//click on go
		order.getGo().click();

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		//get list of products
		int productSize=order.getProducts().size();
		 e.test.log(Status.INFO,"Product search successfully");
		for(int i=0;i<productSize;i++)
		{
			String allProduct = order.getProducts().get(i).getText();
			if(allProduct.equalsIgnoreCase(order.selectProduct))

				order.getProducts().get(i).click();
			
			//break;
		}
		 e.test.log(Status.INFO,"Product Matches successfully");
		Thread.sleep(2000);
		order.UserWindowHandle(driver);
		WebElement ele= driver.findElement(By.id("quantity"));
		Select sel=new Select(ele);
		sel.selectByValue("2");
		 e.test.log(Status.INFO,"Product quantity selected");
		 
		//click on add to cart
		order.getAddToCart().click();

		//click on cart
		order.getCart().click();
		String actual = order.getSingleprize().getText();
		int a=order.dataConversion(actual);
		Integer actTotal=a*2;//for 2 product
		
		String actual1= order.getTotal().getText();
		int expTotal=order.dataConversion(actual1);
        assertEquals(expTotal,actTotal,"Assertion on Principal amount is not successfull");
        e.test.log(Status.INFO,"Total Amount verified");
        //click on proceed to by
        order.getProceedToBy().click();
        
        
        //click on use this address
        order.getUseThisAddress().click();
        e.test.log(Status.INFO," Done!!! Product Orderd completed");
	}
	


}
