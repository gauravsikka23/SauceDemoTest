package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utility;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void verifyTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Swag Labs", "Title does not match");
    }

    @Test(priority = 2)
    @Parameters({"validUser", "validPwd"})
    public void testValidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login failed for valid user");
        Utility.captureScreenshot(driver, "ValidLogin");
    }

    @Test(priority = 3)
    @Parameters({"invalidUser", "invalidPwd"})
    public void testInvalidLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not shown for invalid login");
        Utility.captureScreenshot(driver, "InvalidLogin");
    }
}
