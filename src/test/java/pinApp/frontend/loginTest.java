package pinApp.frontend;

import base.frontend.BaseTest;
import base.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {

    @Test(description = "Login exitoso", priority = 1)
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        String actualMessage = loginPage.loginSuccessful();
        System.out.println("Test login " + actualMessage);
        Assert.assertEquals(actualMessage, "Swag Labs");
    }

    @Test(description = "Login fallido con credenciales inválidas", priority = 2, enabled = false)
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFail();
        Assert.assertTrue(loginPage.isErrorVisible(), "Debería mostrarse un mensaje de error en el login fallido");
    }


}
