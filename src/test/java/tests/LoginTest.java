package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

import org.testng.Assert;

public class LoginTest extends BaseTest {
	
	@Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("wrong@gmail.com", "12FF34");

        Assert.assertTrue(loginPage.isErrorVisible(), "El mensaje de error debería ser visible.");
        System.out.println("Mensaje de error: " + loginPage.getErrorText());
    }

	
//     @Test
//     public void testValidLogin() {
//         // Create an instance of the LoginPage to interact with the login functionality.
//         LoginPage loginPage = new LoginPage(driver);

//         // Perform a login with valid credentials.
//         loginPage.login("tucorreo@valido.com", "tuPasswordCorrecto");

//         // Assert that the current URL contains the expected value, indicating a successful login.
//         Assert.assertTrue(driver.getCurrentUrl().contains("https://automationexercise.com"), 
//             "La URL debería indicar que el login fue exitoso.");
//     }

}