package Utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils
{
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow x_row;
    public static XSSFCell x_cell;
    public static FileInputStream fin;
    public static File file;

    public static Object[][] readXL(String xsheet)
    {
        String sheetpath = System.getProperty("user.dir")+"\\Files\\Task.xlsx";
        try
        {
            file = new File(sheetpath);
            fin = new FileInputStream(file);

            workbook = new XSSFWorkbook(fin);
            sheet = workbook.getSheet(xsheet);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        x_row = sheet.getRow(0);
        int max_row,max_col;
        max_row = sheet.getLastRowNum();
        max_col = x_row.getLastCellNum();

        Object[][] data = new Object[max_row][max_col];

        for(int row=1; row<=max_row; row++)
        {
            for(int col=0; col<max_col; col++)
            {
                //data[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();

                CellType type = sheet.getRow(row).getCell(col).getCellType();
                if(type.equals(CellType.NUMERIC))
                {
                    data[row-1][col] = sheet.getRow(row).getCell(col).getNumericCellValue();
                }
                else{
                    data[row-1][col] = sheet.getRow(row).getCell(col).getStringCellValue();
                }
            }
        }

        for(int i=0;i<max_row;i++)
        {
            for(int j=0;j<max_col;j++)
            {
                System.out.print(data[i][j]+"\t");
            }
            System.out.println();
        }



        return data;
    }






}
