package com.adrian.mentorship.e2e;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

class ScreenshotOnFailure implements TestWatcher {
    static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    @Override public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            WebDriver driver = DRIVER.get();
            if (driver instanceof TakesScreenshot shot) {
                Path directory = Path.of("target", "selenium-screenshots");
                Files.createDirectories(directory);
                Files.write(directory.resolve(context.getRequiredTestMethod().getName() + "-" + Instant.now().toEpochMilli() + ".png"), shot.getScreenshotAs(OutputType.BYTES));
            }
        } catch (Exception ignored) { /* Screenshot failure must not hide the test failure. */ }
    }
}
