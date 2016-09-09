package com.metlife.cutfile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class ReplaceCR {
	public static void main(String[] args) {
		Scanner sc = null;
		String line;
		String newline;
//		File f_src = new File("D:\\20160411\\20160412\\LA_CLBAPF.txt");
//		File f_t = new File("D:\\20160411\\20160412\\LA_CLBAPFttttt.txt");
		//D:\zip-test\metlife-work
		
//		File f_src = new File("D:\\zip-test\\metlife-work\\LA_CLBAPF.txt");
//		File f_t = new File("D:\\zip-test\\metlife-work\\LA_CLBAPFttttt.txt");
		File f_src = new File("D:\\20.txt");
		File f_t = new File("D:\\TAR.txt");
		FileOutputStream t_fout = null;
		
		
		System.out.println("begin");
		Long startTime = System.currentTimeMillis();
		try {
			sc = new Scanner(f_src,"GBK");
			t_fout = new FileOutputStream(f_t);
			while (sc.hasNext()) {
				line = sc.nextLine();
				newline = line.replaceAll("( \\|\\| HUAN HANG)", "\n");
				newline = newline.replaceAll("\\\\r\\\\n", "");
				t_fout.write((newline).getBytes());
			}
			sc.close();
			t_fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		System.out.println("�ܺ�ʱ��" + time + "����");
		System.out.println("end");
	}
}
