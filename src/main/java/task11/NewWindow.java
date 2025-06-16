package task11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewWindow {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/windows");

		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> windows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(windows.get(1));

		String title = driver.getTitle();

		if ("New Window".equals(driver.getTitle())){

		    System.out.println(" 'New Window' text is present in the page.");

		} else {

		    System.out.println("'New Window' text not found.");

		    driver.close();
		}

		driver.switchTo().window(windows.get(0));

		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.equals("https://the-internet.herokuapp.com/windows")) {

		    System.out.println("Switched back to original window");

		} else {
			System.out.println("Did not switch to original window");

		}

		driver.quit();
}}