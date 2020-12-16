import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test1 {
public static void main(String[] args) throws IOException {
	File loc=new File("C:\\Users\\Chellappa\\eclipse-workspace\\Practise\\target\\Book1.xlsx");
	FileInputStream f=new FileInputStream(loc);
	Workbook w=new XSSFWorkbook(f);
	Sheet s = w.getSheet("Sheet1");
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row row = s.getRow(i);
		for (int j = 0; j <row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			int type = cell.getCellType();
			if(type==1) {
				String st = cell.getStringCellValue();
				System.out.println(st);
				
			}
			else if(type==0) {
				if(DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat sim= new SimpleDateFormat("dd/MMM/yy");
				String fi = sim.format(cell);	
				System.out.println(fi);
				}
				else {
					double d = cell.getNumericCellValue();
					long l=(long)d;
					String v = String.valueOf(l);
					System.out.println(v);
				}
			}
			
		}
		
	}
	
	
}
}
