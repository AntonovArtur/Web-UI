package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BasePage {
    public WebDriver driver;
    public Actions actions;
    public WebDriverWait webDriverWait;
    protected static Properties properties = new Properties();

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public static void getProperties() {

        try (InputStream output = new FileInputStream("src/main/resources/Login.properties")) {
            properties.load(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElement(WebElement e) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(e));
    }

    public WebElement waitForElementToClick(WebElement e) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(e));
    }

    public WebElement waitForHiddenElement(String e) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(e)));
    }

    public void clickToElement(WebElement e){
        waitForElementToClick(e).click();
    }
    public String getTextOfElement (WebElement e){
        waitForElement(e);
        return e.getText();
    }
}
