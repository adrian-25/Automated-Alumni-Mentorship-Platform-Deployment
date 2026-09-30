package com.adrian.mentorship.e2e;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.net.URL;
import java.time.Duration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

@Tag("selenium")
@EnabledIfEnvironmentVariable(named = "RUN_SELENIUM", matches = "true")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MentorshipJourneyE2ETest {
    @RegisterExtension static ScreenshotOnFailure screenshots = new ScreenshotOnFailure();
    private static WebDriver driver;
    private static String baseUrl;
    @BeforeAll static void startBrowser() throws Exception {
        baseUrl = System.getenv().getOrDefault("APP_BASE_URL", "http://host.docker.internal:8080");
        driver = new RemoteWebDriver(new URL(System.getenv().getOrDefault("SELENIUM_REMOTE_URL", "http://localhost:4444")), new ChromeOptions().addArguments("--headless=new", "--window-size=1440,1000"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); ScreenshotOnFailure.DRIVER.set(driver);
    }
    @AfterAll static void stopBrowser() { if (driver != null) driver.quit(); ScreenshotOnFailure.DRIVER.remove(); }
    @Test @Order(1) void dashboardIsAvailable() { driver.get(baseUrl + "/"); assertTrue(driver.getPageSource().contains("Mentorship dashboard")); }
    @Test @Order(2) void studentAndAlumniCanBeCreatedAndSearched() {
        driver.get(baseUrl + "/students/new"); fill("name", "Selenium Student"); fill("email", "student.selenium@example.test"); fill("course", "Computer Science"); fill("graduationYear", "2027"); submit();
        assertTrue(driver.getPageSource().contains("Selenium Student"));
        driver.get(baseUrl + "/alumni/new"); fill("name", "Selenium Alumni"); fill("email", "alumni.selenium@example.test"); fill("company", "Test Labs"); fill("expertise", "DevOps"); fill("graduationYear", "2020"); submit();
        driver.findElement(By.name("query")).sendKeys("DevOps"); submit(); assertTrue(driver.getPageSource().contains("Selenium Alumni"));
    }
    @Test @Order(3) void requestedMentorshipCanBeAcceptedByAlumni() {
        driver.get(baseUrl + "/requests/new"); new Select(driver.findElement(By.name("studentId"))).selectByVisibleText("Selenium Student"); new Select(driver.findElement(By.name("alumniId"))).selectByVisibleText("Selenium Alumni"); fill("message", "Please mentor me on CI/CD."); submit();
        new Select(driver.findElement(By.name("role"))).selectByValue("ALUMNI"); new Select(driver.findElement(By.name("status"))).selectByValue("ACCEPTED"); submit(); assertTrue(driver.getPageSource().contains("ACCEPTED"));
    }
    @Test @Order(4) void acceptedMentorshipCanBeCompletedByAdmin() {
        new Select(driver.findElement(By.name("role"))).selectByValue("ADMIN"); new Select(driver.findElement(By.name("status"))).selectByValue("COMPLETED"); submit(); assertTrue(driver.getPageSource().contains("COMPLETED"));
    }
    private static void fill(String name, String value) { WebElement field = driver.findElement(By.name(name)); field.clear(); field.sendKeys(value); }
    private static void submit() { driver.findElement(By.cssSelector("button[type='submit'], button")).click(); }
}
