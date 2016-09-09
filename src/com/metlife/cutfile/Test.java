package com.metlife.cutfile;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.Timestamp;
import java.util.Date;

public class Test {
	/**
	 * 
	 * Description: ���ټ����ı��ļ�����
	 * 
	 * @param filePath
	 * @return
	 * 
	 *         Modification History: Date Version Author Description
	 *         ------------
	 *         ------------------------------------------------------ 2016��5��10��
	 *         test pactera ����
	 */
	static Long getLineNumbers(String filePath) {
		File test = new File(filePath);
		long fileLength = test.length();
		long lines = 0;
		LineNumberReader rf = null;
		try {
			rf = new LineNumberReader(new FileReader(test));
			if (rf != null) {
				rf.skip(fileLength);
				lines = rf.getLineNumber();
				rf.close();
			}
		} catch (IOException e) {
			if (rf != null) {
				try {
					rf.close();
				} catch (IOException ee) {
					e.printStackTrace();
				}
			}
			e.printStackTrace();

		}
		return lines;

	}

	public static void main(String[] args) {
		System.out.println(new Timestamp(new Date().getTime()));
//		System.out.println(getLineNumbers("D:/20.txt"));
	}
}
