package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends PageBase
{
//    Register Link
    public By register_link = By.linkText("REGISTER");
//    Form Fields
    public By firstname_field = By.xpath("//div[@class='col-md-6 pr-md-1']//div[@class='form-group mb-1']//input[@type='text']");
    public By lastname_field = By.xpath("//div[@class='col-md-6 pl-md-0']//div[@class='form-group mb-1']//input[@type='text']");
    public By username_field = By.xpath("//div[@class='form-group mb-0']//input[@type='text']");
    public By email_field = By.xpath("//input[@type='email']");
    public By password_field = By.xpath("//div[@class='input-group mb-0']//input[@type='password']");
    public By confirm_field = By.xpath("//div[@class='input-group mb-3']//input[@type='password']");
    public By agree_toggle = By.xpath("/html/body/app-root/app-login/section/div/div/div[2]/div/div[2]/div/div/div/form/div[6]/div[3]/div");
    public By register_button = By.xpath("//button[@type='submit']");

    public By register_success_toast = By.xpath("//div[@class='toast-message ng-star-inserted']");




    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }

    public void click_register()throws Exception
    {
        click_On(register_link);
    }

    public void fill_form(String f_name,String l_name,String u_name,String email,String pwd,String cpwd)throws Exception
    {
        enter(firstname_field,f_name);
        enter(lastname_field,l_name);
        enter(username_field,u_name);
        enter(email_field,email);
        enter(password_field,pwd);
        enter(confirm_field,cpwd);
        click_On(agree_toggle);
        click_On(register_button);

    }

    public String get_registration()
    {
        return getElementText(register_success_toast);
    }




}
