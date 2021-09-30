package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FeedsPage extends PageBase
{
    public FeedsPage(WebDriver driver)
    {
        super(driver);
    }

    public By username_text = By.className("menu-txt");
    public By create_post = By.xpath("//button[contains(text(),'Create Post')]");
    public By post_popup = By.xpath("//div[@class='modal-content']");

    public By title_box = By.xpath("//div[@class='d-flex mb-3']//textarea[@type='text']");
    public By description_box = By.xpath("//textarea[@class='form-control border-0 post-desc ng-untouched ng-pristine ng-valid']");
    public By tags_field = By.xpath("//div[@class='form-group mb-2']//textarea[@type='text']");
    public By file_upload = By.xpath("//input[@type='file']");
    public By post_button = By.xpath("//button[@type='submit'][contains(text(),'Post')]");

    public By postSuccess_toast = By.xpath("//div[@class='toast-message ng-star-inserted']");

//    public By post_tags = By.xpath("//body[@class='mat-typography ng-tns-0-3']/app-root[@ng-version='9.1.12']/" +
//            "app-app-layout[@class='ng-star-inserted']" +
//            "/div[@class='web-layout']/section[@class='page-content show_pagecontent']" +
//            "/app-feed[@class='ng-star-inserted']" +
//            "/section[@class='feed']/div[@class='feed-container']" +
//            "/div[@class='post-container']/app-feed-post" +
//            "/div[@class='feed-post-container my-2 ng-star-inserted']" +
//            "/div[@class='search-results']/div/div[1]/div[1]/ul[1]/li[2]/p[2]");

    public  By profile_drop = By.xpath("//div[@class='list-inline-item w-auto']//div[@class='position-relative']//button[@id='button-basic']");
    public By profile = By.xpath("//a[contains(text(),'My Profile')]");


    public String getUserName()throws Exception
    {
        String user = getElementText(username_text);
        return user;
    }

    public void click_createPost()throws Exception
    {
        click_On(create_post);
    }

    public void post(String title,String description,String tag,String img_path  )throws Exception
    {
        try
        {
            driver.findElement(post_popup).isDisplayed();
        }
        catch (Exception e)
        {
            System.out.println("Pop Up is Not Available");
            e.printStackTrace();
        }
        enter(title_box,title);
        enter(description_box,description);
        enter(tags_field,tag);
        String image_path = System.getProperty("user.dir")+img_path;
        enter(file_upload,image_path);
        Thread.sleep(7000);

        click_On(post_button);

    }

    public String getToastText()
    {
        return getElementText(postSuccess_toast);
    }


    public boolean check_post(String tag)throws Exception
    {
        Thread.sleep(5000);
        click_On(profile_drop);
        click_On(profile);

        By post_tags = By.xpath("//p[contains(text(),'" + tag + "')]");

        WebElement element = driver.findElement(post_tags);
        String text = element.getText();

        if(text.equalsIgnoreCase(tag))
        {
            return  true;

        }
        return false;


    }


}
