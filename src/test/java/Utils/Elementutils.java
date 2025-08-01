package Utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

/**
 * Utility class for interacting with web elements and alerts using Selenium WebDriver.
 */
public class Elementutils {

    // ---------------------- 1. Waiting Utilities ----------------------

    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable within " + durationInSeconds + " seconds", e);
        }
    }

    public static WebElement waitForVisibilityOfElement(WebDriver driver, WebElement element, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not visible within " + durationInSeconds + " seconds", e);
        }
    }

    public static WebElement waitForPresenceOfElementLocated(WebDriver driver, By locator, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not present within " + durationInSeconds + " seconds", e);
        }
    }

    public static boolean waitForTextToBePresentInElement(WebDriver driver, WebElement element, String text, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public static boolean waitForUrlToContain(WebDriver driver, String partialUrl, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.urlContains(partialUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

    // ---------------------- 2. Element Actions ----------------------

    public static void clickElement(WebDriver driver, WebElement element, long durationInSeconds) {
        waitForElementToBeClickable(driver, element, durationInSeconds).click();
    }

    public static void typeText(WebDriver driver, WebElement element, long durationInSeconds, String textToBeTyped) {
        WebElement inputField = waitForElementToBeClickable(driver, element, durationInSeconds);
        inputField.clear();
        inputField.sendKeys(textToBeTyped);
    }

    public static void selectDropdownOption(WebDriver driver, WebElement element, long durationInSeconds, String visibleText) {
        WebElement dropdown = waitForElementToBeClickable(driver, element, durationInSeconds);
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    public static void deselectDropdownOption(WebDriver driver, WebElement element, long durationInSeconds, String visibleText) {
        WebElement dropdown = waitForElementToBeClickable(driver, element, durationInSeconds);
        new Select(dropdown).deselectByVisibleText(visibleText);
    }

    public static void mouseHoverAndClick(WebDriver driver, WebElement element, long durationInSeconds) {
        WebElement hoverTarget = waitForVisibilityOfElement(driver, element, durationInSeconds);
        new Actions(driver).moveToElement(hoverTarget).click().build().perform();
    }

    public static void javaScriptClick(WebDriver driver, WebElement element, long durationInSeconds) {
        WebElement jsElement = waitForVisibilityOfElement(driver, element, durationInSeconds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jsElement);
    }

    public static void javaScriptType(WebDriver driver, WebElement element, long durationInSeconds, String textToBeTyped) {
        WebElement jsElement = waitForVisibilityOfElement(driver, element, durationInSeconds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + textToBeTyped + "'", jsElement);
    }

    public static void scrollToElement(WebDriver driver, WebElement element, long durationInSeconds) {
        WebElement scrollTarget = waitForVisibilityOfElement(driver, element, durationInSeconds);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollTarget);
    }

    // ---------------------- 3. Alert Handling ----------------------

    public static Alert waitForAlert(WebDriver driver, long durationInSeconds) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds))
                    .until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            throw new RuntimeException("Alert not present within " + durationInSeconds + " seconds", e);
        }
    }

    public static void acceptAlert(WebDriver driver, long durationInSeconds) {
        waitForAlert(driver, durationInSeconds).accept();
    }

    public static void dismissAlert(WebDriver driver, long durationInSeconds) {
        waitForAlert(driver, durationInSeconds).dismiss();
    }

    // ---------------------- 4. Status / Getter Utilities ----------------------

    public static String getTextFromElement(WebDriver driver, WebElement element, long durationInSeconds) {
        return waitForVisibilityOfElement(driver, element, durationInSeconds).getText();
    }

    public static boolean displayStatusOfElement(WebDriver driver, WebElement element, long durationInSeconds) {
        try {
            return waitForVisibilityOfElement(driver, element, durationInSeconds).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementEnabled(WebDriver driver, WebElement element, long durationInSeconds) {
        try {
            return waitForVisibilityOfElement(driver, element, durationInSeconds).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}
