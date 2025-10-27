package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends BasePage {

    private final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");
    private By siteLogo = By.xpath("//div[contains(text(), 'Swag Labs')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        logger.info("Usuario se loguea");
        if (isDisplayed(usernameInput)) {
            type("standard_user", usernameInput);
            type("secret_sauce", passwordInput);
            click(loginButton);
        } else {
            System.out.println("Usuario y/o contraseña incorrecta");
        }
    }

    public void loginFail() {
        logger.info("Usuario se loguea incorrectamente");
        if (isDisplayed(usernameInput)) {
            type("standard_userrrr", usernameInput);
            type("secret_sauceeee", passwordInput);
            click(loginButton);
        } else {
            System.out.println("Usuario y/o contraseña incorrecta");
        }

    }

    public boolean isErrorVisible() {
        return isDisplayed(errorMessage);
    }

    public String loginSuccessful() {
        return driver.findElement(siteLogo).getText();
    }

}

