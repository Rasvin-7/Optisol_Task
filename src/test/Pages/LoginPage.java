package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase
{
    public By username_field = By.xpath("//input[@type='email']");
    public By password_field = By.xpath("//input[@type='password']");
    public By login_button = By.xpath("//button[@type='submit']");

    public By register_link = By.linkText("REGISTER");

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    public void login(String username, String password)throws Exception
    {
        enter(username_field, username);
        enter(password_field, password);
        click_On(login_button);
    }


}
