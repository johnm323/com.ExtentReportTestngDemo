package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SpiceJetDemo {

    @Test
    public void launchApp() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.spicejet.com/");

        driver.findElement(By.xpath("//*[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")).click();

        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='css-1dbjc4n']"));

        for(WebElement ele: elements){

            System.out.println(ele.getText());
            if(ele.getText().contains("Bengaluru")){
                ele.click();
                break;
            }
        }

        Thread.sleep(5000);

        List<WebElement> elements1 = driver.findElements(By.xpath("//*[@class='css-1dbjc4n']"));

        for(WebElement ele: elements1){

            System.out.println(ele.getText());
            if(ele.getText().contains("Amritsar")){
                ele.click();
                break;
            }
        }

driver.close();

    }

}
