import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class test3 {
public static void main(String[] args) throws IOException {
base e=new base();
WebDriver driver = e.launchBrowser();
e.url(driver, "https://www.facebook.com");
String tit = e.title(driver);
WebElement user = driver.findElement(By.id("email"));
e.type(user, e.excel(1,2));
WebElement pass = driver.findElement(By.id("pass"));
e.type(pass, e.excel(2,2));
WebElement log = driver.findElement(By.name("login"));
e.click(log);




}
}
