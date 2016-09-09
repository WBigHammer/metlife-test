package com.metlife.cutfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

public class CutFile {

	public static void main(String[] args) {

		// �ļ��ָ�����У�java -jar fileDivCom.jar +0 +�ļ��� +�ָ��С
		System.out.println("begin");
		Long startTime = System.currentTimeMillis();

		FileDivision("D:/test/20.txt", 10 * 1024 * 1024);

		// �ļ��ϲ��������У�java -jar fileDivCom.jar +1 +�ļ���1 + �ļ���2 ....

		FileCombination();

		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		System.out.println("�ܺ�ʱ��" + time + "����");
		System.out.println("end");

		// getFile("D:/test/devision");

	}

	public static void FileDivision(String fileName, int iSize) {

		try {

			DataInputStream in = new DataInputStream(new FileInputStream(
					fileName));
			String s=in.readLine();
			
//			Long fileSize = (long) in.available();//int�������ֵ2147483647���ļ���С���ڴ�ֵ����int���ֵ
			File ff= new File(fileName);
			Long fileSize=ff.length();
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
				byte[] buffer = new byte[ mod];
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

	public static void FileCombination() {
		try {
			String filePath = "D:/test/combination";
			File file = new File("D:/test/devision");
			File[] array = file.listFiles();
			File f = new File(filePath);
			if (!f.exists() && !f.isDirectory()) {
				f.mkdirs();
			} else {
				clearFiles(filePath);
				f.mkdirs();
			}
			RandomAccessFile hFileWrite = new RandomAccessFile(filePath
					+ "/�ϲ�����ļ�.txt", "rw");
			for (int i = 0; i < array.length; i++) {
				if (array[i].isFile()) {

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