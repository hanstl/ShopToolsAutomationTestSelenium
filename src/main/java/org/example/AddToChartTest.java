package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AddToChartTest {
    public static void main(String[] args) {
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

        js.executeScript("window.scrollBy(0, 1000);");
        driver.findElement(By.cssSelector("#noo-site > div.page_fullwidth > div:nth-child(3) > div > div.padding-stylebox.wpb_column.vc_column_container.vc_col-sm-12.vc_col-lg-7.vc_col-md-7.vc_hidden-sm > div > div > div > div.noo-sh-product-grid.woocommerce > div.noo-sh-product-html.columns_3.no_masonry.three.row.is-flex > div.noo-product-item.noo-product-sm-4.not_featured.post-1491.product.type-product.status-publish.has-post-thumbnail.product_cat-t-shirt.product_tag-t-shirt.product_tag-women.has-featured.instock.shipping-taxable.purchasable.product-type-variable > div > h3 > a")).click();
        String txtProductName = driver.findElement(By.cssSelector("#product-1491 > div.single-product-content > div.summary.entry-summary > h1")).getText();
        if (txtProductName.contains("MISSGUIDED PLUS")){
            System.out.println("BERHASIL PINDAH KE PAGE PRODUCT");
            js.executeScript("window.scrollBy(0, 500);");

            WebElement colorDropdown = driver.findElement(By.cssSelector("#pa_color"));
            WebElement sizeDropdown = driver.findElement(By.cssSelector("#pa_size"));

            Select selectColorDropdown = new Select(colorDropdown);
            Select selectSizeDropdown = new Select(sizeDropdown);

            selectColorDropdown.selectByIndex(1);
            selectSizeDropdown.selectByIndex(2);

            String txtColorChose = colorDropdown.getText();
            String txtSizeChoose = sizeDropdown.getText();

            if (txtColorChose.contains("Grey")){
                System.out.println("WARNA GREY DIPILIH");
                if (txtSizeChoose.contains("42")){
                    System.out.println("SIZE 42 DIPILIH");
                    driver.findElement(By.cssSelector("#product-1491 > div.single-product-content > div.summary.entry-summary > form > div > div.woocommerce-variation-add-to-cart.variations_button.woocommerce-variation-add-to-cart-enabled > button")).click();
                    String txtTheChart = driver.findElement(By.cssSelector("#nav-menu-item-cart > a > span > span.cart-name-and-total")).getText();
                    if (txtTheChart.contains("Cart(1)")){
                        System.out.println("=BERHASIL CART +1");
                    }else{
                        System.out.println("GAGAL");
                    }
                }else{
                    System.out.println("GAGAL MEMILIH SIZE 42");
                }
            } else{
                System.out.println("GAGAL MEMILIH WARNA GREY");
            }

        }else{
            System.out.println("GAGAL PINDAH KE PAGE PRODUCT");
        }


        perintah.delay(5);
        driver.quit();
    }
}
