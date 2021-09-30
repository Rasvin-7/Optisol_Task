package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static TestCases.TestBase.driver;

public class ScreenShot implements ITestListener
{
    public static void get_screenshot_of_test(ITestResult result, String status) throws IOException
    {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshot_folder = System.getProperty("user.dir")+"\\ScreenShots\\";
        String testMethodName = result.getMethod().getMethodName();
        FileUtils.copyFile(scrFile, new File(screenshot_folder + testMethodName+"_"+status+"_"+ System.currentTimeMillis() + ".png"));
    }

    public void onTestFailure(ITestResult result)
    {
        try
        {
            get_screenshot_of_test(result,"Failed");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void onTestSuccess(ITestResult result)
    {
        try
        {
            get_screenshot_of_test(result,"Passed");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
