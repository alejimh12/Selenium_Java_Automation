package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
	
	  public LoginPage(WebDriver driver) {
	        super(driver);
	    }

	    @FindBy(xpath = "//input[@data-qa='login-email']")
	    WebElement emailInput;

	    @FindBy(xpath = "//input[@data-qa='login-password']")
	    WebElement passwordInput;

	    @FindBy(xpath = "//button[@data-qa='login-button']")
	    WebElement loginButton;

	    @FindBy(xpath = "//p[@style and contains(text(),'Your email or password is incorrect')]")
	    WebElement errorMessage;

	    public void enterEmail(String email) {
	        waits.sendKeysWhenReady(emailInput, email);
	    }

	    public void enterPassword(String password) {
	        waits.sendKeysWhenReady(passwordInput, password);
	    }

	    public void clickLogin() {
	        waits.clickWhenReady(loginButton);
	    }

	    public void login(String email, String password) {
	        enterEmail(email);
	        enterPassword(password);
	        clickLogin();
	    }

	    public boolean isErrorVisible() {
	        return waits.isElementVisible(errorMessage);
	    }

	    public String getErrorText() {
	        return getTextFromElement(errorMessage);
	    }
}
