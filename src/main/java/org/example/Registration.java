package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Registration {
    public static void main(String[] args) {
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
            driver.findElement(By.cssSelector("#reg_username")).sendKeys(sndUsername);
            driver.findElement(By.cssSelector("#reg_email")).sendKeys(sndEmail);
            driver.findElement(By.cssSelector("#reg_password")).sendKeys(sndPassword);
            driver.findElement(By.cssSelector("#customer_login > div.u-column2.col-2 > form > p:nth-child(5) > button")).click();
            perintah.delay(5);

            String txtConfirRegis = driver.findElement(By.cssSelector("#post-8 > div > div > div > p:nth-child(2)")).getText();
            if (txtConfirRegis.contains(sndUsername)){
                System.out.println("BERHASIL REGIS");
            }
            else{
                System.out.println("GAGAL REGIS");
            }



        } else{
            System.out.println("GAGAL");
            driver.quit();

        }

        perintah.delay(5);
        driver.quit();
    }
}
