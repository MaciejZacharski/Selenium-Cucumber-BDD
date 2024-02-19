package SeleniumDemo.Pages;

import SeleniumDemo.Utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage {

    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;


    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDashboardLink() {
        return dashboardLink;
    }

    public boolean checkIfLogoutLinkIsDisplayed() {

        SeleniumHelper.waitForIsPresent(By.linkText("Logout"), driver);
        return logoutLink.isDisplayed();
    }

}
