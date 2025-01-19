package CommonUtils;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtils extends BaseTest {

    /** Wait for the page to be completely loaded.*/
    public static boolean waitForPageLoad() {
        return webDriverWait.until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }

    /** Wait until the element is visible on the page. */
    public static WebElement waitForElementToBeVisible(By locator) {
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
