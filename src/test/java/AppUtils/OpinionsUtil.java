package AppUtils;

import Common.BaseTest;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OpinionsUtil extends BaseTest {

    /** Fetch the First 5 Articles from the page, print their heading and title and save images if any */
    public void extractFirstFiveArticlesAndSaveImages(){

        List<WebElement> articleHeadings = getDriver().findElements(opinionsPage.articleHeading());
        List<WebElement> articleContent = getDriver().findElements(opinionsPage.articleContent());

        for(int i = 1 ; i <= 5 ; i++){

            //Print the Article
            System.out.println("Article : " + i);
            System.out.println("Title : " + articleHeadings.get(i-1).getText());
            System.out.println(articleContent.get(i-1).getText());
            System.out.println();


            //If Image is available then save it in local machine
            if(commonUtils.isDisplayed(opinionsPage.articleImageBasedOnArticleIndex(i))){
                String imageURL = getDriver().findElement(opinionsPage.articleImageBasedOnArticleIndex(i)).getAttribute("src");
                commonUtils.downloadImage(imageURL);

                System.out.println("Image Saved for Article " + i);
            }
        }
    }


    /** Return the First Five Article headings from the page */
    public List<String> getTopFiveHeadings(){

        List<String> headers = new ArrayList<>();
        List<WebElement> allHeaders = getDriver().findElements(opinionsPage.articleHeading());

        for(int i = 0 ; i < 5 ; i++)
            headers.add(allHeaders.get(i).getText());

        return headers;
    }
}
