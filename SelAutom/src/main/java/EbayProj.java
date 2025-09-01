import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;

public class EbayProj {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        // Locate search box, enter "book", and submit
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("book");
        driver.findElement(By.xpath("//span[text()=\"Search\"]")).click();
        Thread.sleep(3000);
        String originalHandle = driver.getWindowHandle();
        // Click the first book in the results
        WebElement firstResult = driver.findElement(By.xpath("//ul/li[@data-view=\"mi:1686|iid:1\"]/div/div[2]/div[1]"));

        firstResult.click();
        Thread.sleep(9000);
        Thread.sleep(3000);

//       //switch to original tab
//        driver.switchTo().window(originalHandle);
        //switch to new tab
        Set<String> s = driver.getWindowHandles();
        Iterator<String> i = s.iterator();
        while (i.hasNext()) {
            String childWindow = i.next();
            if (!originalHandle.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }

      //  driver.switchTo().frame("tt");
      driver.findElement(By.xpath("//*[@id=\"atcBtn_btn_1\"]")).click();
//    WebElement atcButton = driver.findElement(By.xpath("//html/body/div[2]/main/div[1]/div[1]/div[4]/div/div/div[2]/div/div/div[7]/ul/li[2]/div/a"));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", atcButton);
//         atcButton.click();


        Thread.sleep(9000);
        //closing popup
        driver.findElement(By.xpath("(//div[@data-testid=\"ux-overlay\"])[2]/div/div[@class=\"lightbox-dialog__header\"]/button")).click();

        //Mouse over & validation of items
        WebElement cartIcon = driver.findElement(By.className("gh-cart__icon"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartIcon);
        Thread.sleep(3000); //
        Actions actions = new Actions(driver);
        actions.moveToElement(cartIcon).perform();
        System.out.println("Number of items in cart: " + cartIcon.getText());
        Thread.sleep(3000);

        driver.quit();
    }
}