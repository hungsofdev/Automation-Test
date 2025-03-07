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

public class RegistrationTest {
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
            options.addArguments("--window-size=1920,1080");

        } else {
            // Nếu chạy local, bạn có thể bật chế độ headless theo nhu cầu
            options.addArguments("--start-maximized");
        }

        // Nếu vẫn gặp lỗi liên quan đến user data directory, hãy thêm dòng sau để tạo một thư mục tạm thời riêng:
        // options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testRegistration() {
        // Mở trang chủ
        driver.get("https://vitimex.com.vn/");

        // Click vào biểu tượng để hiển thị modal đăng nhập/đăng ký
        WebElement modalIcon = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.li_log a[data-bs-target='#ModalLogin']")));
        modalIcon.click();

        // Tìm và click link "Đăng ký" (giả định)
        WebElement registerLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Đăng ký tài khoản mới")));
        registerLink.click();

        // Điền thông tin đăng ký
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))); // Điều chỉnh ID
        nameField.sendKeys("erentest");

        WebElement phoneField = driver.findElement(By.id("phone")); // Điều chỉnh ID
        phoneField.sendKeys("0915031164");

        WebElement emailField = driver.findElement(By.id("email")); // Điều chỉnh ID
        emailField.sendKeys("email@example.com");

        WebElement passwordField = driver.findElement(By.id("pass-regis")); // Điều chỉnh ID
        passwordField.sendKeys("MatKhau123");

        WebElement confirmPasswordField = driver.findElement(By.id("pass-confirm")); // Điều chỉnh ID
        confirmPasswordField.sendKeys("MatKhau123");

        // Click nút đăng ký
        WebElement registerButton = driver.findElement(By.id("register-btn")); // Điều chỉnh ID
        registerButton.click();

        // Kiểm tra đăng ký thành công (giả định có thông báo)
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("success_message"))); // Điều chỉnh ID
//        assertTrue(successMessage.getText().contains("Đăng ký thành công"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Đóng trình duyệt sau khi test xong
        }
    }
}