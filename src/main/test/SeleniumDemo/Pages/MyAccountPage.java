package SeleniumDemo.Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage {


    @FindBy(id = "reg_email")
    private WebElement registrationEmailInput;
    @FindBy(id = "reg_password")
    private WebElement registrationPasswordInput;
    @FindBy(id = "reg_password")
    private List<WebElement> registrationPasswordInputs;
    @FindBy(name = "register")
    private WebElement registrationButton;

    @FindBy(xpath = "//ul[@class= 'woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement loginUsernameInput;
    @FindBy(id = "password")
    private WebElement loginPasswordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public WebElement getError() {
        return error;
    }

    public String getErrorText() {
        return error.getText();
    }

    public LoggedUserPage registerUserValidData(String email, String password) {

        registerUser(email, password);
        return new LoggedUserPage(driver);
    }
    public int getUserNameInputSize() {
       return registrationPasswordInputs.size();
    }

    public MyAccountPage registerUserInvalidEmail(String email, String password) {

        registerUser(email, password);
        return this;
    }

    private void registerUser(String email, String password) {


        registrationEmailInput.sendKeys(email);
        registrationPasswordInput.sendKeys(password);

        registrationButton.click();

    }

    private void loginUser(String email, String password) {

        loginUsernameInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginButton.click();

    }

    public LoggedUserPage loginUserValidData(String email, String password) {

        loginUser(email, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginUserInvalidEmail(String email, String password) {

        loginUser(email, password);
        return this;
    }
}
