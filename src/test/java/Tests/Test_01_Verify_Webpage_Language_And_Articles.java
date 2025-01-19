package Tests;

import Common.BaseTest;
import org.testng.annotations.Test;

public class Test_01_Verify_Webpage_Language_And_Articles extends BaseTest {

    @Test(groups = {"TC_01"})
    public void verify_Webpage_Language_And_Articles(){

        //Task 1 : Navigare to the WebPage and verify the Language is Spanish
        getDriver().get("https://elpais.com/");
        commonUtils.verifyPageLanguage("es-ES");


        //Task 2 : Scrape Articles from the Opinion Section:
        homePageUtil.navigateToSection("opinion");
        opinionsUtil.extractFirstFiveArticlesAndSaveImages();

    }
}
