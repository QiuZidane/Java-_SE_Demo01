package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.stream.FileImageInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import file.FileUtil;

public class ExcelTest {

	private static final String classname = "excel.ExcelTest";
	private static final String filename = "工作簿AA.xls";
	private static final String filepath = FileUtil.getClassPathByUri(classname) + filename; // 当前类目录下的文件

	/**
	 * 读取单元格内容
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 * @throws ClassNotFoundException
	 */
	private static void getCell() throws IOException, URISyntaxException, ClassNotFoundException {

		File file = new File(filepath);

		// 创建POI文件系统对象
		POIFSFileSystem fs = new POIFSFileSystem(file);

		// 获取工作簿对象
		HSSFWorkbook workbook = new HSSFWorkbook(fs);

		// 获取工作表Sheet对象
		int sheetNumbers = workbook.getNumberOfSheets();
		HSSFSheet sheet = workbook.getSheetAt(sheetNumbers - 1);

		// 获取工作表的行
		int lastRow = sheet.getLastRowNum(); // 获取最后一行，这个是从0开始算
		HSSFRow row = sheet.getRow(lastRow);
		System.out.println("lastRow=" + lastRow);

		// 获取指定单元格
		int lastCellNum = row.getLastCellNum() - 1; // 这个是从1开始算起，所以要减一
		HSSFCell cell = row.getCell(lastCellNum);
		System.out.println("lastCellNum=" + lastCellNum);

		// 打印具体单元格内容
		System.out.println("单元格(" + lastRow + "," + lastCellNum + ")的内容是:" + cell);

	}

	private static void writeCell() throws FileNotFoundException, IOException {

		File file = new File(filepath);

		// 创建POI文件系统对象
		POIFSFileSystem fs = new POIFSFileSystem(file);

		// 获取工作簿对象
		HSSFWorkbook workbook = new HSSFWorkbook(fs);

		// // 获取工作簿对象
		// HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new
		// File(filepath)));
		// System.out.println(filepath);

		// HSSFSheet sheet = workbook.createSheet("生成的SHEET");
		HSSFSheet sheet = workbook.getSheetAt(0);

		HSSFRow row1 = sheet.createRow(0);

		row1.createCell(0).setCellValue("111");

		FileOutputStream out = new FileOutputStream(filepath);

		workbook.write(out);

		out.close();

	}

	public static void write2003Excel(String filePath, List<String> list) {

		try {

			// 创建excel文件对象

			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));

			// 创建一个张表

			HSSFSheet sheet = wb.getSheetAt(0);

			// 创建行对象

			HSSFRow row = null;

			// 创建表格对象

			HSSFCell cell = null;

			// 循环行

			for (int i = sheet.getFirstRowNum(); i <= sheet.getPhysicalNumberOfRows(); i++) {

				row = sheet.getRow(i);

				if (row == null) {// 判断是否为空

					continue;

				}

				// 循环列

				for (int j = 0; j < list.size(); j++) {

					cell = row.createCell(j);// 创建单元格

					String m = list.get(j);

					cell.setCellValue(m);// 赋值

				}

			}

			FileOutputStream out = new FileOutputStream(filePath);

			wb.write(out);

			out.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void main(String[] args)
			throws IOException, URISyntaxException, ClassNotFoundException {

		// getCell();
		// writeCell();
		List<String> list1 = new ArrayList<>();
		list1.add("111");
		list1.add("222");
		list1.add("333");
		list1.add("444");
		write2003Excel(filepath, list1);

	}

}
