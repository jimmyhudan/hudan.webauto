package com.t.webauto.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.t.webauto.pojo.ExcelParam;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelUtil {

	public static Object[][] read1(ExcelParam exp)
	{
		//定义一个二维数组，保存取出的数据
		Object [] [] dataobjs=new Object[exp.getEndRow()-exp.getStartRow()+1][exp.getEndcellIndex()-exp.getStartcellIndex()+1];
		try {
			Workbook workbook=WorkbookFactory.create(new File(exp.getFilePath()));
			//拿出我们要操作的表单
			Sheet sht=workbook.getSheetAt(0);
			//取出我们想要的行和列对应的数据
			for(int i=exp.getStartRow();i<=exp.getEndRow();i++)
			{
				//取出区间的每一行
				Row row=sht.getRow(i-1);
				//取出相应列的值
				for(int j=exp.getStartcellIndex();j<=exp.getEndcellIndex();j++)
				{
					//设置空列的处理策略
					Cell cell=row.getCell(j-1,MissingCellPolicy.CREATE_NULL_AS_BLANK);
					//设置列类型为字符串
					cell.setCellType(CellType.STRING);
					//取出列的值
					String strValue=cell.getStringCellValue();
					dataobjs[i-exp.getStartRow()][j-exp.getStartcellIndex()]=strValue;
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dataobjs;
	}
	/**
	 * 
	 * @param filePath 文件路径
	 * @param rows 行
	 * @param cells 列
	 * @param  sheetNum 传的是表单号，不是表单的索引
	 * @return
	 */
	public static Object[][] read(String filePath,int [] rows,int [] cells) {

		//定义一个二维数组，保存取出的数据   
		Object [] [] dataobjs=new Object[rows.length][cells.length];
		try {

			//获取文件的路径
			Workbook workbook=WorkbookFactory.create(new File(filePath));
			//拿出我们要操作的表单
			Sheet sheet=workbook.getSheetAt(0);
			//取出我们想要的行和列对应的数据  处理行
			for(int i=0;i<rows.length;i++)
			{

				//取出区间的每一行
				Row row=sheet.getRow(rows[i]-1);
				//取出对应每一行的相应列的值
				for(int j=0;j<cells.length;j++)
				{

					//设置空列的处理策略
					Cell cell =row.getCell(cells[j]-1, MissingCellPolicy.CREATE_NULL_AS_BLANK);

					//Cell cell =row.getCell(j-1);  

					//设置列类型为字符串
					cell.setCellType(CellType.STRING);
					//取出列的值
					String strValue=cell.getStringCellValue();
					dataobjs[i][j]=strValue;

				}
			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		return dataobjs;

	}


	public static void main(String [] args)
	{
		int [] rows= {2,3,4,5}; 
		int [] cells= {1,2,3,4,5};
		Object [] [] dataOjbs=ExcelUtil.read("src/test/resources/Register.xlsx", rows, cells);
		for(Object [] objects:dataOjbs)
		{
			//打印行的数据
			for(Object objct:objects)
			{
				System.out.print("【"+objct+"】");
			}
			System.out.println();
		}

	}
}
