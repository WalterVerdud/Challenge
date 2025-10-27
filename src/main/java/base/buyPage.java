package pages;

import base.BasePage;
import base.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class buyPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(pages.buyPage.class);

    private By shirtItem = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By lightItem = By.id("add-to-cart-sauce-labs-bike-light");
    private By cartBuy = By.id("shopping_cart_container");
    private By checkoutButtom = By.id("checkout");
    private By inputName = By.id("first-name");
    private By inputLastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButtom = By.id("continue");
    private By finishButtom = By.id("finish");
    private By backHomeButtom = By.id("back-to-products");
    private By orderBuy = By.xpath("//h2[contains(text(), 'Thank you for your order')]");

    public buyPage(WebDriver driver) {
        super(driver);
    }

    public void ShirtItem(){
        logger.info("Agrega items al carrito de compra");
        click(shirtItem);
        click(lightItem);
    }

    public void clickCartBuy() {
        logger.info("click en el carrito de compras");
        click(cartBuy);
    }

    public void clickCheckoutButtom() {
        logger.info("click en el boton de checkout ");
        click(checkoutButtom);
    }

    public void fillForm(){
        logger.info("Completa el formulario");
        type("Walter", inputName);
        type("Verdud",inputLastName);
        type("5300",postalCode);
        click(continueButtom);
        click(finishButtom);
        click(backHomeButtom);
    }

    public boolean succesBuy(){
        logger.info("Compra Finalizada!");
        return isDisplayed(orderBuy);
    }
}
