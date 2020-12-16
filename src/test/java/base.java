import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	public WebDriver launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chellappa\\eclipse-workspace\\Practise\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
		public void url(WebDriver driver, String s) {
		driver.get(s);

		}
		public String title(WebDriver driver) {
			String tt = driver.getTitle();
			System.out.println(tt);
			return tt;			
		}
		public void type(WebElement e, String s) {
			e.sendKeys(s);
		}
		public void click(WebElement e) {
			e.click();
		}
		public String excel(int row, int cell) throws IOException {
			File loc=new File("C:\\Users\\Chellappa\\eclipse-workspace\\Practise\\Files\\Testtt.xlsx");
			FileInputStream f=new FileInputStream(loc);
			Workbook w=new XSSFWorkbook(f);
			Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		int type = c.getCellType();

		String input=null;
		if(type==1) {
			input = c.getStringCellValue();
		}
		else if(type==0){
			if(DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd//MMM//YYY");
				input = sim.format(d);
			}
			else {
				double d = c.getNumericCellValue();
				long l=(long)d;
				input = String.valueOf(l);
			}
				
				
			}
		return input;
			
		}
		


		}
	

