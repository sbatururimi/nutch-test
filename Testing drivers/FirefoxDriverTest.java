import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverTest {
        public static void main(String[] args)throws Exception{
                System.setProperty("webdriver.gecko.driver","/root/geckodriver");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                RemoteWebDriver firefox = new FirefoxDriver(firefoxOptions);

                firefox.get("https://www.google.com");
                System.out.println(firefox.getTitle());

                firefox.quit();
        }
}