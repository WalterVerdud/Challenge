package pinApp.frontend;

import base.frontend.BaseTest;
import base.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.buyPage;

public class buyTest extends BaseTest {

    @Test(description = "Agrega items al carrito de compra", priority = 1)
    public void buyTest() {
        LoginPage loginPage = new LoginPage(driver);
        buyPage buyPage = new buyPage(driver);

        loginPage.login();
        buyPage.ShirtItem();
        buyPage.clickCartBuy();
        buyPage.clickCheckoutButtom();
        buyPage.fillForm();
        Assert.assertTrue(buyPage.succesBuy(), "El mensaje no contiene 'Thank you'");
    }

}
