package PageObject;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderPage {
	WebDriver ldriver;
	public String product="Netlink HG323DAC Dual Band Fibernet Wifi Router High";
	public String selectProduct="NET Link GPON ONT 2GE+1POTS+AC 1000 megabits_per_second WiFi (HG323DAC), 5GHz Dual Band Wi-Fi MU-MIMO with 4 Antennas - Compatible for All FTTH PON Broadband Connections, White";
	public OrderPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//click on search box
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement searchBox;
	public WebElement getSearchBox() {
		return searchBox;
	}

	//min prize
	@FindBy(xpath="//input[@id='low-price']") WebElement minValue;
	public WebElement getMinValue() {
		return minValue;
	}
	//max prize
	@FindBy(xpath="//input[@id='high-price']") WebElement maxValue;
	public WebElement getMaxValue() {
		return maxValue;
	}
	//click on Go
	@FindBy(xpath="(//input[@type='submit'])[2]") WebElement go;
	public WebElement getGo() {
		return go;
	}
	
	//get products name
	@FindAll(@FindBy(xpath="//div[@data-component-type='s-search-result']//h2//a//span"))List<WebElement> products;
	public List<WebElement> getProducts() {
		return products;
	}
	
	//click on add to cart
	@FindBy(xpath="//input[@id='add-to-cart-button']") WebElement addToCart;
	public WebElement getAddToCart() {
		return addToCart;
	}
	
	public void UserWindowHandle(WebDriver driver) {
		String parentHandle = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();
		for (String handle : allhandles) {
			if (!parentHandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	
	@FindBy(xpath="//input[@id='mbb-offeringID-1']") WebElement extended_Warranty;
		
	public WebElement extended_Warranty() {
		return extended_Warranty;
	}
	
	@FindBy(xpath="//span[@class='a-color-price']") WebElement ewPrice;

	public WebElement getEwPrice() {
		return ewPrice;
	}

	//click on cart button 
	@FindBy(xpath="//div[@id='nav-cart-text-container']//span[@class='nav-line-2']") WebElement cart;
	public WebElement getCart() {
		return cart;
	}
	
	//get prize
	@FindBy(xpath="//p[@class='a-spacing-mini']") WebElement singleprize;
	public WebElement getSingleprize() {
		return singleprize;
	}
	
	@FindBy(xpath="(//span[@class='a-dropdown-prompt'])[2]") WebElement ewqty;
	
	public WebElement getEwqty() {
		return ewqty;
	}

	//get total prize
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart']") WebElement total;
	public WebElement getTotal() {
		return total;
	}
	
	public Integer dataConversion(String actual)
	{
		String actualP=actual.trim();
		String actualPP=actualP.replaceAll(",","");
		double a = Double.parseDouble(actualPP);
		Integer a_Amount=(int)Math.round(a);
		return a_Amount;
	}
	public Integer dataConversion1(String actual)
	{
		String actualP=actual.trim().replace("₹","");
		System.out.println(actualP);
		//String actualPP=actualP.replaceAll(".","");
		double a = Double.parseDouble(actualP);
		Integer a_Amount=(int)Math.round(a);
		return a_Amount;
	}
	
	
	@FindBy(xpath="(//input[@type='submit'])[2]") WebElement proceedToBy;
	public WebElement getProceedToBy() {
		return proceedToBy;
	}
	
	//click on use this address
	@FindBy(xpath="(//input[@type='submit'])[2]") WebElement useThisAddress;
	public WebElement getUseThisAddress() {
		return useThisAddress;
	}
}
