package com.quangnn.getdatacafe;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.Number;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class XMLParse {
	private ArrayList<NewsItem> arr = new ArrayList<NewsItem>();

	public void parse(String filePath) {
		File file = new File(getClass().getResource(filePath).getPath());

		try {
			RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
			String str = randomAccessFile.readLine();
			String name = "", lat = "", vicinity = "", lng = "";
			while (str != null) {
				if (str.length() > 0) {
					String subStr = str.substring(0, 5);

					if (subStr.equals("<name")) {
						NewsItem newsItem = new NewsItem(name, vicinity, lat,
								lng);
						arr.add(newsItem);

						name = str.substring(6, str.lastIndexOf("/") - 1);
					}
					if (subStr.equals("<vici")) {
						vicinity = str.substring(10, str.lastIndexOf("/") - 1);
					}
					if (subStr.equals("<lat>")) {
						lat = str.substring(5, str.lastIndexOf("/") - 1);
					}
					if (subStr.equals("<lng>")) {
						lng = str.substring(5, str.lastIndexOf("/") - 1);
					}

				}
				str = randomAccessFile.readLine();

			}

			randomAccessFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void showArrs() throws RowsExceededException, WriteException, IOException {

			WritableWorkbook workbook = Workbook.createWorkbook(new File(
					"D:\\output.xls"));
			for(int i = 0; i < arr.size(); i++){
				if(arr.get(i).getName() == ""){
					arr.remove(i);
				}
			}
			WritableSheet sheet = workbook.createSheet("First Sheet", 0);
			Label label = new Label(0, 0, "STT");
			sheet.addCell(label);
			Label label2 = new Label(1, 0, "Tên quán");
			sheet.addCell(label2);
			Label label3 = new Label(2, 0, "Địa chỉ");
			sheet.addCell(label3);
			Label label4 = new Label(3, 0, "Kinh độ");
			sheet.addCell(label4);
			Label label5 = new Label(4, 0, "Vĩ độ");
			sheet.addCell(label5);
			Integer i = 1;
			
			for(int j = 0; j< arr.size(); j++){
					sheet.addCell(new Number(0, i, i));
					sheet.addCell(new Label(1, j + 1, convertToUTF8(arr.get(j).getName()) + ""));
					sheet.addCell(new Label(2, j + 1, convertToUTF8(arr.get(j).getVicinity()) + ""));
					sheet.addCell(new Label(3, j + 1, arr.get(j).getLng() + ""));
					sheet.addCell(new Label(4, j + 1, arr.get(j).getLat() + ""));
					i++;
					System.out.println(i);
				
			}
	 
			workbook.write();
			workbook.close();

	}

	public String convertToUTF8(String str) {
		try {
			return new String(str.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	public ArrayList<NewsItem> getArr() {
		return arr;
	}

	public void setArr(ArrayList<NewsItem> arr) {
		this.arr = arr;
	}
	
	
}
