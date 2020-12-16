import java.awt.AWTException;
import java.awt.Robot;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class windowsHandl {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chellappa\\eclipse-workspace\\Practise\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:\\amazon.in");
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("i phones");
		WebElement enter = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		enter.click();
		List<WebElement> alllist = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		
	for (WebElement allt : alllist) {
		String text = allt.getText();
		List<String> l=new ArrayList<String>();
        l.add(text);		
		Set<String> s= new HashSet<String>();
		s.addAll(l);
		for (String x : s) {
			
		System.out.println(x);
		List<WebElement> pricelis = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (WebElement x2 : pricelis) {
			String text2 = x2.getText();
			int i=Integer.parseInt(text2);
			if(i>60000) {
				System.out.println(x2.getText());
			}
				
					
		}
		
		
		
		}	
		}
		}
		
		

	}

