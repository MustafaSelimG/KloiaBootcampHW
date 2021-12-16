package bootcamp.utils;

import org.openqa.selenium.*;

import java.util.Set;

public class Helper {
    private static WebDriver driver;

    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    public static void clickWithLinkText(String linktext){
        Driver.get().findElement(By.linkText(linktext)).click();
    }

    public static void switchLastTab(){
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for (String tab : allTabs) {
            if (!originTab.equals(tab)){
                Driver.get().switchTo().window(tab);
            }
        }
    }

    public static void switchToNewWindow(){
        String winHandleBefore = driver.getWindowHandle();

        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);

        }
    }

    public static void openNewTab(String url){
        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText(url)).sendKeys(selectLinkOpeninNewTab);
    }


    public static void previousWindow(){
        String winHandleBefore = driver.getWindowHandle();
        driver.switchTo().window(winHandleBefore);
    }



}
