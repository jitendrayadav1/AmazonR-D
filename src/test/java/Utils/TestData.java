package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
public class TestData {
	
	 public long userName;
	public String password;
	public String u;
	public long minVal;
	public long maxVal;
	public String min;
	public String max;
	public TestData() throws Exception
	{
   FileInputStream fis=new FileInputStream("F:\\Workspace3\\AmazonRnDProject\\datafiles\\login.xlsx");
		
		XSSFWorkbook wrk=new XSSFWorkbook(fis);
		XSSFSheet sht=wrk.getSheet("Book1");
		
		int rows=sht.getLastRowNum();
		int cols=sht.getRow(1).getLastCellNum();
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sht.getRow(r);
			 userName=(long) row.getCell(0).getNumericCellValue();
			 password=row.getCell(1).getStringCellValue();
			  minVal = (long) row.getCell(2).getNumericCellValue();
			  maxVal = (long) row.getCell(3).getNumericCellValue();
			
		}
		 u=String.valueOf(userName);
		  min = String.valueOf(minVal);
		 max = String.valueOf(maxVal);
		
	}
}




































































//			if(Principal.equals("Principal"))
//			{
//				 Principal=Principal;
//			}
//			else
//				{
//				if(rate.equals("Rate"))
//					 rate=rate;
//				else if(year.equals("Year"))
//						 year=year;
//				}
//			
			//		}		
		
//		String Principal= String.valueOf(Principal);
//		String rate= String.valueOf(rate);
//		String year=String.valueOf(year);
		//}
//		System.out.println("principal amount="+Principal);
//		System.out.println("rate="+rate);
//		System.out.println("year="+year);
	
	//}

//}


















//FileInputStream fis=new FileInputStream("C:\\Users\\RESHMA\\git\\Kotak\\DataFiles\\Book1.xlsx");
//XSSFWorkbook wrk=new XSSFWorkbook(fis);
//XSSFSheet sht=wrk.getSheet("Book1");
//DataFormatter dff=new DataFormatter();
//
//int rows=sht.getLastRowNum();	
//int cols=sht.getRow(0).getLastCellNum();
//System.out.println("rows="+rows);
//System.out.println("cols="+cols);
//String[][] data=new String[rows][cols];
//
//
//for(int r=0;r<rows;r++)
//{
//	XSSFRow row=sht.getRow(r); //due to index of row of array and Excel sheet 
//	for(int c=0;c<cols;c++)
//	{
//		data[r][c]=dff.formatCellValue(row.getCell(c));				
//		System.out.print(data[r][c]+"    ");
//		System.out.println("excel data"+data[r][c]);
//	}
//}
//fis.close();
//wrk.close();
//System.out.println("Done!!");
////	return data;
//				
//