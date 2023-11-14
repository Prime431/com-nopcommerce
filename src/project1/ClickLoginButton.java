package project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class ClickLoginButton {
    static String baseUrl = "https://demo.nopcommerce.com/"; // main Url
    static WebDriver driver; // Driver initialization
    static String navigateToUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";

    public static void main(String[] args) {
        // using scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter browser name");
        String browserName = scanner.nextLine(); // storing browser name in browserName
        checkLoginFunctionality(browserName);
        checkLinkOpening(baseUrl);
        scanner.close(); // closing scanner
    }

    public static void checkLoginFunctionality(String browserName) { //Using separate method choosing browser
        // using if else loop for choosing the browser
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong Browser name");
        }
    }
    public static void checkLinkOpening(String baseUrl) { // using different method for doing the automation
        driver.get(baseUrl); // opening the URL
        driver.manage().window().maximize(); // maximising the window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit time for holding the process
        System.out.println("Title of the Website is : " + driver.getTitle());// getting the title name
        System.out.println("Current URL is : " + driver.getCurrentUrl());// getting the current url
        System.out.println("Website page Source is : " + driver.getPageSource());// getting the whole website source
        driver.navigate().to(navigateToUrl); // navigate to different url
        System.out.println("The current URL is : " + driver.getCurrentUrl()); // printing the current url
        driver.navigate().back(); // using back button
        System.out.println("Clicking on login page : ");
        driver.findElement(By.linkText("Log in")).click();//clicking on log in page
        System.out.println("Login Page URL is : " + driver.getCurrentUrl()); // getting login page url
        driver.navigate().refresh(); //refreshing the page
        driver.findElement(By.id("Email")).sendKeys("visha@gmail.com"); // entering the email
        driver.findElement(By.id("Password")).sendKeys("Password1"); // entering the password
        driver.findElement(By.linkText("Log in")).click(); // click on log in page
        System.out.println("Testing is Pass");
        driver.close(); // closing the page

    }
}
