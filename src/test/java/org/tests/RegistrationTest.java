package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pages.RegistrationPage;

public class RegistrationTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // Disable extensions

        WebDriverManager.chromedriver().setup();  // Set up the WebDriver
        driver = new ChromeDriver(options);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser and clean up the WebDriver
        }
    }

    @Test
    public void testRegistrationFormValidation() {
        // Navigate to the website
        registrationPage.navigateTo(" https://moneygaming.qa.gameaccount.com/");

        // Click JOIN NOW
        registrationPage.clickJoinNow();

        // Fill the registration form
        registrationPage.fillForm("Mr", "Steve", "Smith");

        // Submit the form
        registrationPage.submitForm();

        // Validate that the DOB error message is displayed
        Assertions.assertTrue(registrationPage.isDobErrorDisplayed(), "DOB error message is not displayed.");
        Assertions.assertEquals(registrationPage.dobErrorMessage(), "This field is required", "DOB error message is incorrect.");
    }
}
