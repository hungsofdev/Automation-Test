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
        // Nếu chạy trên Windows local với Cốc Cốc/Chrome, đặt property cho ChromeDriver
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            // Thiết lập đường dẫn đến ChromeDriver
            System.setProperty("webdriver.coccoc.driver", "C:/WebDriver/bin/chromedriver-win64/chromedriver-win64/chromedriver.exe"); // Thay đổi đường dẫn nếu cần
        }

        ChromeOptions options = new ChromeOptions();
        // Nếu chạy trong môi trường CI (ví dụ GitHub Actions), bật chế độ headless
        if (System.getenv("CI") != null) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        } else {
            // Nếu chạy local, bạn có thể bật chế độ headless theo nhu cầu
            options.addArguments("--start-maximized");
        }

        // Nếu vẫn gặp lỗi liên quan đến user data directory, hãy thêm dòng sau để tạo một thư mục tạm thời riêng:
        // options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() {
        // Mở trang chủ
        driver.get("https://vitimex.com.vn/");

        // Click vào biểu tượng để hiển thị modal đăng nhập/đăng ký
        WebElement modalIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.li_log a[data-bs-target='#ModalLogin']")));
        modalIcon.click();

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