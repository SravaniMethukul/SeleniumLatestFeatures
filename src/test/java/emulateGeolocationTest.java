import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class emulateGeolocationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		WebDriver driverWeb = new ChromeDriver(options);
		driverWeb.manage().window().maximize();

        // Cast to ChromiumDriver to access CDP
        ChromiumDriver driver = (ChromiumDriver) driverWeb;
		
		//ChromeDriver driver = new ChromeDriver(options);
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		//40 - latitude 3-longitude - coordinates of Spain
		
		Map<String, Object> coordinates = new HashMap<>();
		coordinates.put("latitude", 36.0);
		coordinates.put("longitude", 138.0);
		coordinates.put("accuracy", 1.0);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		
		driver.get("https://www.google.com");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click the cookie consent "Alle ablehnen" or "Alle akzeptieren"
        try {
            WebElement rejectBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Alle ablehnen']")));
            rejectBtn.click();
        } catch (Exception e) {
            // fallback in case "Alle ablehnen" doesn't exist
            try {
                WebElement acceptBtn = driver.findElement(By.xpath("//button[.='Alle akzeptieren']"));
                acceptBtn.click();
            } catch (Exception ignored) {}
        }
		
		driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		String netflixText = driver.findElements(By.cssSelector(".default-ltr-cache-l1j3pp")).get(1).getText();
		System.out.println(netflixText);
		
	}

}
