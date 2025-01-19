package Common;

import AppUtils.OpinionsUtil;
import PageObjects.ElPaisHomePage;
import CommonUtils.CommonUtils;
import AppUtils.HomePageUtil;
import PageObjects.OpinionsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    //ThreadLocal Webdriver to help in Multi Threaded Execution
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected static WebDriverWait webDriverWait;


    //Page Objects
    protected static ElPaisHomePage homePage;
    protected static OpinionsPage opinionsPage;


    //Util Files
    protected static CommonUtils commonUtils;
    protected static HomePageUtil homePageUtil;
    protected static OpinionsUtil opinionsUtil;


    //Method to fetch the current instance of driver in the thread
    protected static WebDriver getDriver(){
        return driver.get();
    }


    @BeforeSuite
    public void initializeClasses(){

        homePage = new ElPaisHomePage();
        opinionsPage = new OpinionsPage();
        commonUtils = new CommonUtils();
        homePageUtil = new HomePageUtil();
        opinionsUtil = new OpinionsUtil();

    }


    @BeforeMethod
    public void setup() {
        driver.set(new ChromeDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        getDriver().manage().window().maximize();
        webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
        getDriver().get("https://elpais.com/");
    }


    @AfterMethod
    public void teardown() {
        if (driver != null) {
            getDriver().quit();
        }
    }
}
