package Tests;

import Common.BaseTest;
import CommonUtils.RapidAPITranslationUtil;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserStackAssessmentTest extends BaseTest {


    @Test(groups = {"TC_01"}, priority = 1)
    //Task 1 : Verify the Language is Spanish
    public void verify_Language(){

        System.out.println("\nTask 1 : Verify the Language is Spanish");
        commonUtils.verifyPageLanguage("es-ES");
    }


    @Test(groups = {"TC_02"}, priority = 2)
    //Task 2 : Scrape Articles from the Opinion Section
    public void scrape_Articles(){

        System.out.println("\nTask 2 : Scrape Articles from the Opinion Section");
        homePageUtil.navigateToSection("opinion");
        opinionsUtil.extractFirstFiveArticlesAndSaveImages();
    }


    @Test(groups = {"TC_03", "TC_04"}, priority = 3)
    //Task 3 : Translate Article Headers
    //Task 4 : Analyze Headers
    public void translate_And_Analyse_Articles(){

        System.out.println("\nTask 3 : Translate Article Headers");
        homePageUtil.navigateToSection("opinion");
        List<String> headers = opinionsUtil.getTopFiveHeadings();
        List<String> translatedHeaders = new ArrayList<>();

        for (String heading : headers){

            System.out.println("Original Text in Spanish : " + heading);
            String translatedText = RapidAPITranslationUtil.translate(heading, "es", "en");
            translatedHeaders.add(translatedText);
            System.out.println("Translated Text in English : " + translatedText);
            System.out.println();
        }


        System.out.println("\nTask 4 : Analyze Translated Headers by printing words that are repeated more than twice across all headers combined:");
        String combinedHeader = String.join(" ", translatedHeaders);
        commonUtils.printWordsRepeatedMoreThanTwice(combinedHeader);
    }
}
