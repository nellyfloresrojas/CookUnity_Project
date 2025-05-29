package Sanity_test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class web_cookunity_test {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    //Verify meals are shown for a user logged in successfully
    
    public void testMealPlanSelection() {
    	
        driver.get("https://www.cookunity.com");

        WebElement zip_Input = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("zipcode")));
        zip_Input.sendKeys("10001");
        zip_Input.sendKeys(Keys.RETURN);

        WebElement skipAll_label = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div/div[2]/div/button[1]")));
        skipAll_label.click();
        
        WebElement sixMeals = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div[1]/div[1]/div[2]/div[2]/div[2]/div[2]/div/button[4]")));
        sixMeals.click();
        
        WebElement continue_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"main\"]/div[2]/button")));
        continue_button.click();
        
        WebElement sing_up_email_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div/div/div/div/div/button[1]")));
        sing_up_email_button.click();
        
        WebElement sing_up_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div/div/div/div/form/button")));
        sing_up_button.click();
        
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        email.sendKeys("qa.mail_10@gmail.com");

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        password.sendKeys("123123123");

        WebElement continueBtn = driver.findElement(By.xpath("/html/body/main/div[2]/div/div/div/div/form/button"));
        continueBtn.click();
        
        //URL must contain “en/meal-select
        wait.until(ExpectedConditions.urlContains("en/meal-select"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("en/meal-select"), "URL must contain 'en/meal-select'");
        
        //Check that there is more than one meal in the meals list
        
        List<WebElement> mealTiles = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".meal-card"), 1));
        assertTrue(mealTiles.size() > 1, "Expected more than one meal in the list, but found: " + mealTiles.size());
        
        //Ensure that in the "Meal selected" section at the bottom right, "0/6" is displayed
        WebElement counter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div[5]/div/div/p")));
        assertEquals(counter.getText().trim(), "Meal selected 0/6", "The selection counter should say 'Meal selected 0/6'"); 
    }
}