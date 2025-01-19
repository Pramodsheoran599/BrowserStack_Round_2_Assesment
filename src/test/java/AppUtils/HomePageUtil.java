package AppUtils;

import Common.BaseTest;
import org.testng.Assert;

public class HomePageUtil extends BaseTest {

    /** Navigate to a Section on the WebPage using the hamburger menu */
    public void navigateToSection(String title){

        //if cookies accept button is displayed then click it
        if(commonUtils.isDisplayed(homePage.acceptBtn()))
            getDriver().findElement(homePage.acceptBtn()).click();

        //Navigation
        getDriver().findElement(homePage.hamburgerMenu()).click();
        getDriver().findElement(homePage.hamburgerMenuItem(title)).click();

        Assert.assertTrue(getDriver().getCurrentUrl().contains(title), "Failed to navigate to the "+ title +" Section");
    }
}
