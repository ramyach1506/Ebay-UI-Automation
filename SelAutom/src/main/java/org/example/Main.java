package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //TIP To <b>Debug</b> code, press <shortcut actionId="Debug"/> or
        // click the <icon src="AllIcons.Actions.StartDebugger"/> icon in the gutter.

        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        Thread.sleep(6000);
        driver.close();

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
       // System.out.printf("Hello and welcome!");


        }
    }
