package TestCases;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class TestBase
{
    public static WebDriver driver;

    public TestBase()
    {

    }

    public void init_driver()
    {
        // Chrome Browser version 94, chromedriver version 94
        String driver_path = System.getProperty("user.dir")+"\\WebDrivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driver_path);
        driver = new ChromeDriver();
    }

    public void launch_url()
    {
        driver.get("https://test.smartblacknetwork.com/login/1");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void login()throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login("celebrityuser4@yopmail.com", "Admin@123");
    }



}
