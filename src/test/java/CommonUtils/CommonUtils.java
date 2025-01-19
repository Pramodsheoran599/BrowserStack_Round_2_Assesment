package CommonUtils;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CommonUtils extends BaseTest {

    /** Verify the Language of the Web Page */
    public void verifyPageLanguage(String langCode){

        // We will check the 'lang' attribute of the html tag
        WebElement htmlTag = getDriver().findElement(By.tagName("html"));
        String lang = htmlTag.getAttribute("lang");

        Assert.assertEquals(langCode, lang, "The webpage is not in desired Language.");
        System.out.println("Verified that the Page language is in this format : " + langCode);

    }


    /** Check if a webElement is displayed on web page or not */
    public boolean isDisplayed(By locator){

        try{
            WaitUtils.waitForElementToBeVisible(locator);
            return true;
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


    /** Print Words that are Repeated more than twice in the given string */
    public void printWordsRepeatedMoreThanTwice(String text) {

        // Convert the sentence to lowercase and split into words
        String[] words = text.toLowerCase().split("\\s+");

        // Create a map to store word frequencies
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the occurrences of each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Track if any word repeats more than twice
        boolean hasRepeatingWords = false;

        // Print words that appear more than twice
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > 2) {
                if (!hasRepeatingWords)
                    hasRepeatingWords = true;

                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }

        // If no words repeat more than twice
        if (!hasRepeatingWords) {
            System.out.println("No words repeat more than twice.");
        }
    }
}
