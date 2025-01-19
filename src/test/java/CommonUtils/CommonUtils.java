package CommonUtils;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Random;

public class CommonUtils extends BaseTest {

    /** Verify the Language of the Web Page */
    public void verifyPageLanguage(String langCode){

        // We will check the 'lang' attribute of the html tag
        WebElement htmlTag = getDriver().findElement(By.tagName("html"));
        String lang = htmlTag.getAttribute("lang");

        Assert.assertEquals(langCode, lang, "The webpage is not in desired Language.");
    }


    /** Check if a webElement is displayed on web page or not */
    public boolean isDisplayed(By locator){

        WaitUtils.waitForPageLoad();

        try{
            return getDriver().findElement(locator).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }


    /** Save an image from a URL to a local file */
    public void downloadImage(String imageUrl) {

        if (imageUrl == null) return;

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            Random random = new Random();

            String fileName = Paths.get(System.getProperty("user.home"), "Downloads", random.nextInt() + ".jpg").toString();
            try (FileOutputStream fos = new FileOutputStream(fileName)) {
                fos.write(connection.getInputStream().readAllBytes());
            }
        }

        catch (Exception e){

            Assert.fail("Failed to Download Image" + e.getMessage());
        }
    }
}
