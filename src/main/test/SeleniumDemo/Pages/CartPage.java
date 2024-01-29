package SeleniumDemo.Pages;

import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(xpath = "//div[@class='wc-proceed-to-checkout']//a")
    private WebElement checkoutButton;


private WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public BillingDetailsPage proceedCheckout() {
        SeleniumHelper.waitForClickable(checkoutButton, driver);
        checkoutButton.click();
        return new BillingDetailsPage(driver);
    }

}