package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://jqueryui.com/datepicker/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.switchTo().frame(0);
WebElement dateField=driver.findElement(By.xpath("//input[@id=\"datepicker\"]"));
dateField.click();
WebElement selectMonth=driver.findElement(By.xpath("//span[text()='Next']"));
selectMonth.click();
WebElement selectDate=driver.findElement(By.xpath("//a[text()='22']"));
selectDate.click();
String selectedDate=dateField.getAttribute("value");
System.out.println("Selected Date:" +selectedDate);

driver.quit();
	}
}
