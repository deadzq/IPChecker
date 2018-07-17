package com.ykmimi.ipchecker.util;

/**
 * 判断正确的域名格式,以及再加入错误的域名格式判定
 * 
 * @author SeeClanUkyo
 *
 */
public class AddressFormat {

	public static String formatAddressAll(String address) {
		address = address.trim();
		address = formatAddressByStart(address);
		address = formatAddressByEnd(address);
		return address;

	}

	///// * 如果以http://开头或以https://开头 ,则修剪,如以/结尾,则修剪.返回单纯的地址如: www.ykmimi.com
	public static String formatAddressByStart(String address) {

		if (address.startsWith("http://")) {
			address = address.replace("http://", "");
		} else if (address.startsWith("https://")) {
			address = address.replace("https://", "");
		}

		return address;
	}

	///// * 去掉末尾的/符号
	public static String formatAddressByEnd(String address) {

		if (address.endsWith("/")) {
			address = address.replace("/", "");
		}

		return address;
	}

	/// * 正确域名解析
	public static int checkAddressValidity(String address) {
		Integer validityNum = null;
		// 先看看地址是否为空,否则再判断其是否包含.其次再看域名格式上的错误
		if (address.length() == 0) {
			///// * 如果域名不包含符号. 则返回0 错误码
			validityNum = 0;
			return validityNum;
		}
		if(address.equals("localhost")) {
			/////* 如果输入的是localhost,则输出127.0.0.1
			validityNum = 6;
			return validityNum;
		}
		if (!address.contains(".")) {
			///// * 如果域名不包含符号dot->'.' 则返回4 错误码
			validityNum = 4;
			return validityNum;
		}
		if (address.startsWith("http//") || address.startsWith("https//")) {
			///// * 在http或https后面没有:与//分隔 返回2 错误码
			validityNum = 2;
			return validityNum;

		} 
		

		///// * 1表示正常.
		return 1;
	}
}
