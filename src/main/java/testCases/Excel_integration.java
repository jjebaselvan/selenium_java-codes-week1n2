package testCases;



	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class Excel_integration {

		public static Object[][] getExcelData(String excelFileName) throws IOException {

			XSSFWorkbook workbook = new XSSFWorkbook("./data/"+excelFileName+".xlsx");


			XSSFSheet sheet = workbook.getSheetAt(0);



			int lastRowNum = sheet.getLastRowNum();
			short lastCellNum = sheet.getRow(0).getLastCellNum();

			Object[][] data= new Object[lastRowNum][lastCellNum];

			for (int j = 1; j < lastRowNum; j++) 

			{
				XSSFRow row = sheet.getRow(j);


				for (int i = 0; i < lastCellNum; i++) 

				{
					XSSFCell cell = row.getCell(i);
					String stringCellValue = cell.getStringCellValue();
					data[j-1][i]=stringCellValue;
					System.out.print(" "+stringCellValue);

				} 


			}
			return data;   
		}


	}
