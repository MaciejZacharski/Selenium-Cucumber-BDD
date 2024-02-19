package SeleniumDemo.Tests;

import SeleniumDemo.Models.Task;
import SeleniumDemo.Pages.HomePage;
import SeleniumDemo.Pages.LoggedUserPage;
import SeleniumDemo.Pages.MyAccountPage;
import SeleniumDemo.Utils.DriverFactory;
import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RegisterAndLoginTestStepDev {

    private HomePage homePage;
    private WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();

    }


    @Given("User is on shop Home Page")
    public void userIsOnShopHomePage() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://seleniumdemo.com/");
    }

    @When("User navigates to MyAccount Page")
    public void userNavigatesToMyAccountPage() {
        homePage = new HomePage(driver);
        homePage.openMyAccountPage();

    }

    @And("User enters invalid data to register form")
    public void userEntersInvalidDataToRegisterForm() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        myAccountPage.registerUserValidData("test@test.com", "Random!$Test123");
    }

    @And("User enters valid data to register form")
    public void userEntersValidDataToRegisterForm() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Faker faker = new Faker();
        myAccountPage.registerUserValidData(faker.internet().emailAddress(), "Random!$Test123");
    }

    @Then("User is navigated to Logged User Page")
    public void userIsNavigatedToLoggedUserPage() {
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertTrue(loggedUserPage.checkIfLogoutLinkIsDisplayed());
    }

    @Then("Error message for invalid email is displayed")
    public void errorMessageForInvalidEmailIsDisplayed() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertTrue(myAccountPage.getErrorText().contains("An account"));
    }

    @But("Register form is not present")
    public void registerFormIsNotPresent() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.getUserNameInputSize(), 0);
    }

    @And("Data for email {string} and password {string}")
    public void dataForEmailAndPassword(String email, String password) {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerUserValidData(email, password);

    }

    @And("Tasks to do Map")
    public void tasksToDoMap(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap();
        Set<String> keys = dataMap.keySet();
        keys.forEach(key -> {
            System.out.println(key);
            System.out.println(dataMap.get(key));
        });
    }

    @And("Tasks to do List")
    public void tasksToDoList(DataTable dataTable) {

        Map<String, String> dataMap = dataTable.asMap();
        Set<String> keys = dataMap.keySet();
        keys.forEach(key -> {
            System.out.println(key);
            System.out.println(dataMap.get(key));
        });
        {
        }
    }

    @And("Tasks to do Class")
    public void tasksToDoClass(List<Task> tasks) {
        tasks.forEach(System.out::println);

    }

    @DataTableType
    public Task handleTask(Map<String,String> table) {
        return new Task(table.get("taskNumber"), table.get("taskDescription"));
    }
}
