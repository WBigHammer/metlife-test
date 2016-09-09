package com.metlife.cutfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CutTXTByLine_1 {

	public static void main(String[] args) {
		System.out.println("begin");
		Long startTime = System.currentTimeMillis();
//		test("D:/test.txt", "D:/cutByLine/devisionFiles");
//		 CutTXT("D:/LA_BCRDPF - ����.txt","D:/cutByLine/devisionFiles");
		 CutTXT("D:/20.txt","D:/cutByLine/devisionFiles");
//		CutTXT("D:/test.txt", "D:/cutByLine/devisionFiles");
		 FileCombination("D:/cutByLine/devisionFiles","D:/cutByLine/combinationFile");
		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		System.out.println("�ܺ�ʱ��" + time + "����");
		System.out.println("end");
		// while ((len = reader.read(cbuf, 0, size)) != -1) {
		// BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
		// new FileOutputStream(fileName.replace(".txt", "_" + count)
		// + ".txt")));
		// writer.write(cbuf, 0, len);
		// writer.flush();
		// writer.close();
		// count++;
		// }

	}

	/**
	 * 
	 * Description: TXT�ļ��и�
	 * 
	 * @param fileName
	 *            ���и��ļ���ַ
	 * @param filesPath
	 *            �и���ļ��е�ַ
	 * 
	 *            Modification History: Date Version Author Description
	 *            ----------
	 *            --------------------------------------------------------
	 *            2016��5��10�� test pactera ����
	 */
	public static void CutTXT(String fileName, String filesPath) {
		// fileName = "D:/20.txt";
		BufferedReader reader;
		int columns=24;
		int lines=100000;
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
				String s = "";
				Long lineNumber = 1L;
				Long fileIndex=1L;
				File f = new File(filesPath);
				if (!f.exists() && !f.isDirectory()) {
					f.mkdirs();
				} else {
					clearFiles(filesPath);
					f.mkdirs();
				}
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+System.currentTimeMillis()+"_"+fileIndex+".txt")));
//				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+fileIndex+".txt")));
				while ((s = reader.readLine()) != null) {
					
					if(s.trim().split("\\|\\|").length==columns){
						writer.append(s+"\r\n");
					}else{
						writer.append(s.replaceAll("\\\\r\\\\n", ""));
						while((s = reader.readLine()) != null&&s.trim().split("\\|\\|").length!=columns){
							writer.append(s.replaceAll("\\\\r\\\\n", ""));
						}
						writer.append("\r\n");
					}
					lineNumber++;
					if(lineNumber%lines==1){
						writer.close();
						fileIndex++;
						writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+System.currentTimeMillis()+"_"+fileIndex+".txt")));
					}
					writer.flush();
				}
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	

	public static void test(String fileName, String filesPath) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(fileName)));
			String s = "";
			Long lineNumber = 1L;
			File f = new File(filesPath);
			if (!f.exists() && !f.isDirectory()) {
				f.mkdirs();
			} else {
				clearFiles(filesPath);
				f.mkdirs();
			}
			
			System.out.println(reader.readLine().trim().split("\\|\\|").length);
			System.out.println(reader.readLine().trim().split("\\|\\|").length);
//			String str[]=reader.readLine().trim().split("\\|\\|");
//			System.out.println(str.length);
//			for(String ss:str){
//				System.out.println(ss);
//			}
//			System.out.println(reader.readLine().trim().split("||").length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static void FileDivision(String fileName, int iSize) {

		try {

			DataInputStream in = new DataInputStream(new FileInputStream(
					fileName));
			// Long fileSize = (long)
			// in.available();//int�������ֵ2147483647���ļ���С���ڴ�ֵ����int���ֵ
			File ff = new File(fileName);
			Long fileSize = ff.length();
			System.out.println(fileSize);
			int iPart = 0;
			int mod = 0;
			iPart = (int) (fileSize / iSize);// �ָ�ɼ�����
			mod = (int) (fileSize % iSize);// ���һ����
			// ��չ��
			String ext = fileName.substring(fileName.lastIndexOf("."));
			String filePath = "D:/test/devision";
			File f = new File(filePath);
			if (!f.exists() && !f.isDirectory()) {
				f.mkdirs();
			} else {
				clearFiles(filePath);
				f.mkdirs();
			}
			for (int i = 0; i < iPart; i++) {
				byte[] buffer = new byte[iSize];
				in.read(buffer);
				String newName = "D:/test/devision/test" + i + ext;
				// System.out.println(newName);
				RandomAccessFile hFileWrite = new RandomAccessFile(newName,
						"rw");
				hFileWrite.write(buffer);
				hFileWrite.close();
			}

			if (mod > 0) {
				byte[] buffer = new byte[mod];
				in.read(buffer);
				String newName = "D:/test/devision/test" + iPart + ext;
				RandomAccessFile hFileWrite = new RandomAccessFile(newName,
						"rw");
				hFileWrite.write(buffer);
				hFileWrite.close();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Description: �ļ��ϲ�
	 * 
	 * @param toComDir
	 *            ��ϲ��ļ��е�ַ
	 * @param comDir
	 *            �ϲ����ļ��е�ַ
	 * 
	 *            Modification History: Date Version Author Description
	 *            ----------
	 *            --------------------------------------------------------
	 *            2016��5��10�� test pactera ����
	 */
	public static void FileCombination(String toComDir, String comDir) {

		try {
			// String filePath = "D:/test/combination";
			// File file = new File("D:/test/devision");
			// File[] array = file.listFiles();
			File[] array = new File(toComDir).listFiles();
			File f = new File(comDir);
			if (!f.exists() && !f.isDirectory()) {
				f.mkdirs();
			} else {
				clearFiles(comDir);
				f.mkdirs();
			}
			RandomAccessFile hFileWrite = new RandomAccessFile(comDir
					+ "/�ϲ�����ļ�.txt", "rw");
			for (int i = 0; i < array.length; i++) {
				if (array[i].isFile()) {
					System.out.println(array[i].getName());
					DataInputStream in = new DataInputStream(
							new FileInputStream(array[i]));
					int fileSize = in.available();
					byte[] buffer = new byte[fileSize];
					in.read(buffer);
					in.close();
					hFileWrite.write(buffer);
				}
			}
			hFileWrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ɾ���ļ���Ŀ¼
	private static void clearFiles(String filepath) {
		File file = new File(filepath);
		if (file.exists()) {
			deleteFile(file);
		}
	}

	private static void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}

	private static void getFile(String path) {
		// get file list where the path has
		File file = new File(path);
		// get the folder list
		File[] array = file.listFiles();

		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				// only take file name
				System.out.println("^^^^^" + array[i].getName());
				// take file path and name
				System.out.println("#####" + array[i]);
				// take file path and name
				System.out.println("*****" + array[i].getPath());
			} else if (array[i].isDirectory()) {
				getFile(array[i].getPath());
			}
		}

	}

	// public static void main(String[] args) throws IOException {
	// cutFile("D:/test/test.txt", 2000);
	// }

	public static void cutFile(String fileName, int size) throws IOException {
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName)));
		int len;
		int count = 1;
		char[] cbuf = new char[size];
		while ((len = reader.read(cbuf, 0, size)) != -1) {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileName.replace(".txt", "_" + count)
							+ ".txt")));
			writer.write(cbuf, 0, len);
			writer.flush();
			writer.close();
			count++;
		}
	}
}