package com.example.de_mau.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.coccoc.driver", "C:/WebDriver/bin/chromedriver-win64/chromedriver-win64/chromedriver.exe"); // Thay đổi đường dẫn nếu cần
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() {
        // Mở trang chủ
        driver.get("https://vitimex.com.vn/");

        // Tìm và click link "Đăng nhập" (giả định)
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Đăng nhập")));
        loginLink.click();

        // Điền thông tin đăng nhập
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account"))); // Điều chỉnh ID
        emailField.sendKeys("email@example.com");

        WebElement passwordField = driver.findElement(By.id("pass")); // Điều chỉnh ID
        passwordField.sendKeys("MatKhau123");

        // Click nút đăng nhập
        WebElement loginButton = driver.findElement(By.id("signin-btn")); // Điều chỉnh ID
        loginButton.click();

        // Kiểm tra đăng nhập thành công (giả định có phần profile người dùng)
//        WebElement userProfile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_profile"))); // Điều chỉnh ID
//        assertTrue(userProfile.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}