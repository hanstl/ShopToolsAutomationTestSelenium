package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Perintah {
    public void delay(int detik){
        try{
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
