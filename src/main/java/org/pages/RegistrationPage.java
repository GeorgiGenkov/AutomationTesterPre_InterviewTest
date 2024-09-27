package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;

    // Locators
    private final By joinNowButton = By.xpath("//a[@href='/sign-up.shtml']");
    private final By titleDropdown = By.id("title");
    private final By firstNameInput = By.id("forename");
    private final By surnameInput = By.name("map(lastName)");
    //    private final By dobDayDropdown = By.id("dobDay");
    //    private final By dobMonthDropdown = By.id("dobMonth");
    //    private final By dobYearDropdown = By.id("dobYear");
    private final By termsCheckbox = By.id("checkbox");
    private final By submitButton = By.id("form");
    private final By dobErrorMessage = By.xpath("//label[@for='dob']");

    // Constructor
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with the page
    public void navigateTo(String url) {
        driver.get(url);
    }

    public void clickJoinNow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // 30 seconds timeout
        WebElement registrationButton = wait.until(ExpectedConditions.visibilityOfElementLocated(joinNowButton));
        // WebElement registrationButton = wait.until(ExpectedConditions.elementToBeClickable(joinNowButton));

        if (registrationButton.isDisplayed()) {
            registrationButton.click();
        } else {
            System.out.println("Join Now button not displayed!");
        }
    }

    public void fillForm(String title, String firstName, String surname) {
        new Select(driver.findElement(titleDropdown)).selectByVisibleText(title);
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(surnameInput).sendKeys(surname);
        driver.findElement(termsCheckbox).click();
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isDobErrorDisplayed() {
        return driver.findElement(dobErrorMessage).isDisplayed();
    }

    public String dobErrorMessage() {
        return driver.findElement(dobErrorMessage).getText();
    }
}