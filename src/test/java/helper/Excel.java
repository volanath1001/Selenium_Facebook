package helper;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import core.Constant;

public class Excel {
	
	static String path= null;
	
	public static void setExcetDataFile(String path) {

		Excel.path = path;
	}
	public String [] getExcelData(){
		
		String []da = new String[20];
		
		
			XSSFWorkbook workbook = null;
			try {
				workbook = new XSSFWorkbook(System.getProperty("user.dir")+"/src/test/resources/" + path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			int rn = workbook.getSheetAt(0).getLastRowNum();
			int i =0;
			
			for(i = 0; i<=rn;i++){
				
				if(workbook.getSheetAt(0).getRow(i).getCell(0).getStringCellValue().equals(Constant.TCID)){
					int cn = workbook.getSheetAt(0).getRow(i).getLastCellNum();
					for(int j=1;j<cn;j++){
						String d=workbook.getSheetAt(0).getRow(i).getCell(j).getStringCellValue();
						
						da[j-1]=d;
						
					}
				}
			}
		
		return da;
	}
	
	
	
	

}
