package task10;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignUp {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
driver.get("https://www.guvi.in/");

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

driver.findElement(By.xpath("//a[text()='Sign up']")).click();
driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("guviuser");
driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("dummyuser12@gmail.com");
driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Guviuser2345");
driver.findElement(By.xpath("//input[@id=\"mobileNumber\"]")).sendKeys("9876512345");
driver.findElement(By.xpath("//a[@id=\"signup-btn\"]")).click();
WebElement current_profile= driver.findElement(By.xpath("//select[@id=\"profileDrpDwn\"]"));
Select profile= new Select(current_profile);
profile.selectByVisibleText("Looking for a career");
WebElement select_degree=driver.findElement(By.xpath("//select[@id=\"degreeDrpDwn\"]"));
Select degree=new Select(select_degree);
degree.selectByVisibleText("B.Sc. / M.Sc.");
driver.findElement(By.xpath("//input[@id=\"year\"]")).sendKeys("2020");
driver.findElement(By.xpath("//a[text()='Submit']")).click();
System.out.println("Page title after signup: " + driver.getTitle());
driver.navigate().back();
driver.findElement(By.xpath("//a[@id=\"login-btn\"]")).click();
driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys("guviuser25@gmail.com");
driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Guviuser@123");
driver.findElement(By.xpath("//a[@id=\"login-btn\"]")).click();
System.out.println("Page title after Login: " + driver.getTitle());

driver.quit();


}}

