import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class SearchFlights {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.makemytrip.com/");

        driver.manage().window().maximize();
        // Zoom out to 80%
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.body.style.zoom='80%'");



        Thread.sleep(3000); // Wait for the page to load

        // Close any pop-ups
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement popup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='popup'], [class*='close'], [id*='popup']")));
            popup.click();
            System.out.println("Popup closed successfully.");
        } catch (Exception e) {
            System.out.println("No popup found or unable to close.");
        }

        // Select "One Way" travel mode
        driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']")).click();
        Thread.sleep(2000);

        // Enter departure city (Bengaluru)
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();
        WebElement fromInput = driver.findElement(By.xpath("//input[@placeholder='From']"));
        fromInput.sendKeys("Bengaluru");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(text(),'Bengaluru')]")).click();
        Thread.sleep(2000);
        // Enter destination city (Delhi)
        WebElement toCity = driver.findElement(By.id("toCity"));
        toCity.click();
        WebElement toInput = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toInput.sendKeys("Delhi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[contains(text(),'Delhi')]")).click();
        Thread.sleep(2000);
        // Select departure date
       // driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Mon Jun 30 2025']")).click(); // Example date
        Thread.sleep(2000);

        // Click the "Search" button
        driver.findElement(By.xpath("//a[text()='Search']")).click();

        // Wait for search results to load
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}