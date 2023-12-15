package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String mainUsername = "hanstl";
        String mainEmail = "hanstl@gamail.com";
        String mainPassword = "Hans.123$";

        String sndUsername = "hans";
        String sndEmail = "hans@gmail.com";
        String sndPassword = "hanS.123$!";

        String path = "E:\\Kuliah\\Out_of_Campus\\Bootcamp\\JuaraCoding\\chromedriver-win64\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);

        WebDriver driver = new ChromeDriver();
        Perintah perintah = new Perintah();
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://shop.demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("WEB OPENED");

        driver.findElement(By.cssSelector("body > p > a")).click();
        driver.findElement(By.cssSelector("#noo-site > header > div.noo-topbar > div > ul.pull-right.noo-topbar-right > li:nth-child(2) > a")).click();
        String url = driver.getCurrentUrl();
        if (url.equals("https://shop.demoqa.com/my-account/")){

            System.out.println("BERHASIL PINDAH KE MY ACCOUNT");
//            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            js.executeScript("window.scrollBy(0, 500);");

            WebElement usernameForm = driver.findElement(By.cssSelector("#reg_username"));
            WebElement mailForm = driver.findElement(By.cssSelector("#reg_email"));
            WebElement passForm = driver.findElement(By.cssSelector("#reg_password"));
            usernameForm.sendKeys(sndUsername);
            mailForm.sendKeys(sndEmail);
            passForm.sendKeys(sndPassword);
            driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(3) > span > span")).click();



        } else{
            System.out.println("GAGAL");
            driver.quit();

        }

        perintah.delay(5);
        driver.quit();



    }
}