import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; 


public class ChromeDriverTest {
    public static void main(String[] args)throws Exception{
        System.setProperty("webdriver.chrome.driver", "/root/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-extensions");

        ChromeDriver chrome =  new ChromeDriver(chromeOptions);
        // run against chrome
        chrome.get("https://www.google.com");
        System.out.println(chrome.getTitle());


        chrome.quit();
    }
}