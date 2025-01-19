package Tests;

import Common.BaseTest;
import CommonUtils.RapidAPITranslationUtil;
import org.testng.annotations.Test;

import java.util.List;

public class Test_01_Verify_Webpage_Language_And_Articles extends BaseTest {

    @Test(groups = {"TC_01"})
    public void verify_Webpage_Language_And_Articles(){

        //Task 1 : Navigare to the WebPage and verify the Language is Spanish
        getDriver().get("https://elpais.com/");
        commonUtils.verifyPageLanguage("es-ES");


        //Task 2 : Scrape Articles from the Opinion Section:
        homePageUtil.navigateToSection("opinion");
        opinionsUtil.extractFirstFiveArticlesAndSaveImages();


        //Task 3 : Translate Article Headers
        List<String> headers = opinionsUtil.getTopFiveHeadings();
        for (String heading : headers)
            System.out.println(RapidAPITranslationUtil.translate(heading, "es", "en"));
    }
}
