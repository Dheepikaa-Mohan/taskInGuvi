package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement sourceElement= driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
		WebElement targetElement=driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
		Actions actions=new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
		String backGroundColor=targetElement.getCssValue("background-color");
		System.out.println("Background color after drop: "+backGroundColor);
		String droppedvalue=targetElement.getText();
		if(droppedvalue.equals("Dropped!")) {
			System.out.println("Drag and Drop successful");
		}
		else
		{
			System.out.println("Drag and Drop failed");
		}
		driver.quit();
	}}
		