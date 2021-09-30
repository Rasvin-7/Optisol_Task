package TestCases;

import java.lang.Thread;
import Pages.FeedsPage;
import Pages.LoginPage;
import Pages.RegisterPage;
import Utils.ExcelUtils;
import Utils.ScreenShot;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ScreenShot.class)
public class Tests extends TestBase
{
    @BeforeMethod
    public void setUp()
    {
        init_driver();
        launch_url();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
//Data Provider for Registration
    @DataProvider(name = "registerData")
    public Object[][] registerData()throws Exception
    {
        Object[][] data = ExcelUtils.readXL("Register");
        return data;
    }
//Data Provider for Login
    @DataProvider(name = "loginData")
    public Object[][] loginData()throws Exception
    {
        Object[][] data = ExcelUtils.readXL("Login");
        return data;
    }
//DataProvider for Create Post
    @DataProvider(name = "postData")
    public Object[][] postData()throws Exception
    {
        Object[][] data = ExcelUtils.readXL("Post");
        return data;
    }



// TEST LOGIN
    @Test(description = "Login Test",dataProvider = "loginData")
    public void tc01_login(String user_name,String pass_word) throws Exception
    {
        LoginPage lp = new LoginPage(driver);
        lp.login(user_name, pass_word);
        Thread.sleep(5000);
        FeedsPage fp = new FeedsPage(driver);
        //Check the username after login
        String user = fp.getUserName();
        String exp_user = "celebrity user";
        Assert.assertEquals(user,exp_user);

    }

//TEST REGISTER
    @Test(description = "Test Registration",dataProvider = "registerData")
    public void tc02_register(String F_name,String L_name,String U_name,String email,String password,String confirm_pwd)throws Exception
    {
        RegisterPage rp = new RegisterPage(driver);
        rp.click_register();
        rp.fill_form(F_name,L_name,U_name,email,password,confirm_pwd);
        Thread.sleep(5000);

        String toast = rp.get_registration();
        System.out.println("Status of Registration : "+toast);
        if(toast.contains("Registration Completed"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }

    }

//    Test Post Feed
    @Test(description = "Test Post Feed", dataProvider = "postData")
    public void tc03_postfeed(String title,String description,String tag,String img_path)throws Exception
    {
        login();
        FeedsPage fp = new FeedsPage(driver);
        fp.click_createPost();
        Thread.sleep(5000);
        fp.post(title,description,tag,img_path);
//Check Post Successfully Created
        String toast_text = fp.getToastText();
        System.out.println("Toast : "+toast_text);
        if(toast_text.contains("Successfully"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
// VERIFICATION OF UPLOADED POST By checking the tag
        boolean flag = fp.check_post(tag);
        Assert.assertTrue(flag);
    }
}
