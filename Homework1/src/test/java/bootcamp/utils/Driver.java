package bootcamp.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Driver {
    private Driver(){
    }

    private static WebDriver driver;

    public static WebDriver get(){
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }

    public static void moveByOffset(int x,int y){
        Actions actions = new Actions(driver);
        actions.moveByOffset(x,y).click();
        actions.build().perform();
    }


}
