package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	//move to hello sign inn
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement login;

	public WebElement getLogin() {
		return login;
	}
	//click on sign in
	@FindBy(xpath="(//span[@class='nav-action-inner'])[1]") WebElement signin;

	public WebElement getSignin() {
		return signin;
	}
//enter phone Number
	@FindBy(xpath="//input[@id='ap_email']") WebElement phnumber;

	public WebElement getPhnumber() {
		return phnumber;
	}

	//enter continue
	@FindBy(xpath="//input[@id='continue']") WebElement ContinueBtn;

	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	
	//enter password
	@FindBy(xpath="//input[@id='ap_password']") WebElement password;

	public WebElement getPassword() {
		return password;
	}
	//click on signin
	@FindBy(xpath="//input[@id='signInSubmit']") WebElement signinBtn;

	public WebElement getSigninBtn() {
		return signinBtn;
	}
	
	
}
