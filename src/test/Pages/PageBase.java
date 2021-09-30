package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PageBase
{
    public static WebDriver driver;

    public PageBase(WebDriver driver)
    {
        PageBase.driver = driver;
    }

    public void enter(By locator, String text)throws Exception
    {
        driver.findElement(locator).sendKeys(text);
        Thread.sleep(1000);
    }

    public void click_On(By locator)throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        Thread.sleep(1000);
    }

    public String getElementText(By locator)
    {
        return driver.findElement(locator).getText();
    }
}

