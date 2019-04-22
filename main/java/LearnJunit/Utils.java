package LearnJunit;

import LearnJunit.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils extends BasePage {

    //Resuable method for click
    public static void clickElementBy(By by) {
        driver.findElement(by).click();

    }

    //Reusable method for entering any text/string (eg: entering name/password/email)
    public static void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    //Reusable method for Assert equals where we want to know expected = actual
    public static String textGet(By by) {
        return driver.findElement(by).getText();
    }

    //Reusable method to clear the text from input box
    public static void textClear(By by) {
        driver.findElement(by).clear();
    }

    //Reusable method to check if element is present and element is not present
    public static void webElementPresent(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is Present");
        } else {
            System.out.println("Element is not Present");
        }
    }

    //Reusable method to check if element is displayed and element is not displayed
    public static void webElementDisplayed(By by) {
        if (driver.findElement(by).isDisplayed()) {
            System.out.println("Element is Displayed");
        } else {
            System.out.println("Element is not Displayed");
        }
    }

    //Reusable method to try to click element three times if not available in first go
    public static void elementThreeTimes(By by) {
        if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else if (driver.findElement(by).isDisplayed()) {
            driver.findElement(by).click();
        } else {
            System.out.println("Element is not Visible");
        }
    }

    //Method for Explicit wait for element to be displayed/visible
    public static void waitForElementDisplay(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //Reusable method for Explicit wait for element to be clickable
    public static void waitForElementClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Method for Explicit wait for locator to be clickable
    public static void waitForLocatorClickable(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Method for Explicit wait for element to be invisible
    public static void waitForElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

//Method for date short
    public static void shortDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println("Current date and time is = " + dateFormat.format(date));
    }

    //Method for date long
    public static void longDate() {
        Date ts = new Date(System.currentTimeMillis());
        Date date = new Date(ts.getTime());
        System.out.println("Current date and time is = " + date);
    }

    //Method for selecting any text/string from dropdown or list (eg: dropdown menu for month/week etc)
    public static void selectVisibleTextBy(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    //Method for selecting any value i.e.numbers (eg: dropdown menu for selecting numbers)
    public static void selectTextByValue(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(text);
    }


    //Method for selecting any value i.e.numbers (eg: dropdown menu for selecting numbers)
    public static void selectByNumber(By by, int number) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(number);
    }

    //Method for selecting value from dropdown
    public static void selectValueFromDropdown(By by, String text, int number) {
        Select select = new Select(driver.findElement(by));
        WebElement option = select.getFirstSelectedOption();
        String selectedValue = option.getText();
        System.out.println(selectedValue);
    }

    //Method used for scroll to view element
    public static void scrollViewElement(By by) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        System.out.println(element.getText());
    }

    //Method for Scroll to view element and click
    public static void scrollElementClick(By by) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(by);
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        System.out.println(element.getText());
    }

    //Method for alert to display
    public static void alertDisplay(By by, int time) {
        try {

            WebDriverWait wait = new WebDriverWait(driver, time);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println("Alert box text " + alert.getText());
            alert.accept();

        } catch (NoAlertPresentException noAlert) {
            noAlert.getMessage();
        }
    }

    //Method to get attribute of element
    public static void attributeGet(By by, String text, int number) {
        driver.findElement(by).getAttribute(text);
    }

//Method to get css property of element
    public static void propertyOfCss(By by, String text) {
        driver.findElement(by).getCssValue(text);
    }

//Method to get screenshot of browser
        public static void browserScreentshot() {
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("c:\\tmp\\screenshot.png"));
        } catch (IOException ex) {
            System.out.println("There is a problem in taking a screenshot");
        }
    }

//Method to get screenshot of current display full
        public static void fullDisplayScreenshot() {
            Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(driver);
            try {
                ImageIO.write(screenshot.getImage(), "PNG", new File("c:\\tmp\\screenshot.png"));
            } catch (IOException ex) {
                System.out.println("There is a problem in taking a screenshot");

            }
        }

//Method to convert date into String
        public static void StringDate()
        {
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
        }

    }


