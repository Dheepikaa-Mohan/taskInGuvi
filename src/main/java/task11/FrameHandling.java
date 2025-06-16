package task11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {
	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("http://the-internet.herokuapp.com/nested_frames");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  
	        WebElement topFrame = driver.findElement(By.cssSelector("frame[src='/frame_top']"));
	        driver.switchTo().frame(topFrame);
	       
	        List<WebElement> topFrames = driver.findElements(By.cssSelector("frame"));
	        if (topFrames.size() == 3) {
	            System.out.println("Verified 3 frames inside top frame.");
	        } else {
	            System.out.println("Frame count mismatch.");
	        }

	        driver.switchTo().frame(topFrames.get(0));
	        String leftText = driver.findElement(By.cssSelector("body")).getText();
	        if (leftText.contains("LEFT")) {
	            System.out.println("Verified LEFT frame text.");
	        }
	        
	        driver.switchTo().parentFrame(); 
	        driver.switchTo().frame(topFrames.get(1));
	        String middleText = driver.findElement(By.cssSelector("body")).getText();
	        if (middleText.contains("MIDDLE")) {
	            System.out.println("Verified MIDDLE frame text.");
	        }
	        driver.switchTo().parentFrame();

	        driver.switchTo().frame(topFrames.get(2));
	        Thread.sleep(1000);
	        String rightText = driver.findElement(By.cssSelector("body")).getText();
	        if (rightText.contains("RIGHT")) {
	            System.out.println("Verified RIGHT frame text.");
	        }
	        driver.switchTo().defaultContent(); 

	        WebElement bottomFrame = driver.findElement(By.cssSelector("frame[src='/frame_bottom']"));
	        driver.switchTo().frame(bottomFrame);
	        String bottomText = driver.findElement(By.cssSelector("body")).getText();
	        if (bottomText.contains("BOTTOM")) {
	            System.out.println("Verified BOTTOM frame text.");
	        }

	        driver.switchTo().defaultContent();

	        driver.quit();
	    }
	}
