package com.quangnn.getdatacafe;

import java.io.IOException;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Main {
	public static void main(String[] args) throws RowsExceededException,
			WriteException, IOException {
		XMLParse xml = new XMLParse();
		xml.parse("/data/cafe_badinh.xml");
		xml.parse("/data/cafe_caugiay.xml");
		xml.parse("/data/cafe_dongda.xml");
		xml.parse("/data/cafe_hadong.xml");
		xml.parse("/data/cafe_thanhxuan.xml");
		xml.parse("/data/cafe_tuliem.xml");
		xml.parse("/data/coffee_badinh.xml");
		xml.parse("/data/coffee_caugiay.xml");
		xml.parse("/data/coffee_dongda.xml");
		xml.parse("/data/coffee_hadong.xml");
		xml.parse("/data/coffee_hoankiem.xml");
		xml.parse("/data/coffee_thanhxuan.xml");
		xml.parse("/data/coffee_tuliem.xml");
		xml.parse("/data/hanoi_cafe.xml");
		xml.parse("/data/hoangmai.xml");
		xml.parse("/data/haibatrung.xml");
		xml.parse("/data/sontay.xml");
		xml.parse("/data/tayho.xml");
		xml.parse("/data/chuongmy.xml");
		xml.parse("/data/bavi.xml");
		xml.parse("/data/thachthat.xml");
		xml.showArrs();
	}
}
