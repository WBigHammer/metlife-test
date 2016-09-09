import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CutTXTByLine0 {

	public static void main(String[] args) {
		System.out.println("begin");
		Long startTime = System.currentTimeMillis();
		String file2Cut="E:/cutByLine/source/f_la_acmvpf.txt";//待分割文件
		String devFile="E:/cutByLine/devisionFiles";//分割后文件存放位置
		CutTXT(file2Cut,devFile);
		Long endTime = System.currentTimeMillis();
		Long time = endTime - startTime;
		System.out.println("总耗时：" + time + "毫秒");
		System.out.println("end");
	}

	/**
	 * 
	 * Description: TXT文件切割
	 * 
	 * @param fileName
	 *            待切割文件地址
	 * @param filesPath
	 *            切割后文件夹地址
	 * 
	 */
	public static void CutTXT(String fileName, String filesPath) {
		// fileName = "D:/20.txt";
		BufferedReader reader;
		int columns=63;//||列数
		int lines=10;//每一个子文件中存放行数
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
				String subFileName=System.currentTimeMillis()+"_"+fileIndex+".txt";
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+subFileName)));
				System.out.println("子文件："+subFileName);
				s = reader.readLine();
				while (s!= null) {
					if(s.trim().split("\\|\\@\\|").length==columns&&s.contains("|@| HUAN HANG")){
						writer.append(s.replaceAll("\\\\r\\\\n", "").replaceAll("(\\|\\@\\| HUAN HANG)", "\r\n"));
						s=reader.readLine();
					}else{
						writer.append(s.replaceAll("\\\\r\\\\n", "").replaceAll("(\\|\\@\\| HUAN HANG)", "\r\n"));
						s=reader.readLine();
						while(s!= null&&s.trim().split("\\|\\@\\|").length!=columns){
							if(s.contains("|@| HUAN HANG")){
								writer.append(s.replaceAll("\\\\r\\\\n", "").replaceAll("(\\|\\@\\| HUAN HANG)", "\r\n"));
								s=reader.readLine();
								lineNumber++;
								if(lineNumber%lines==1){
									writer.close();
									fileIndex++;
									subFileName=System.currentTimeMillis()+"_"+fileIndex+".txt";
									writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+subFileName)));
									System.out.println("子文件："+subFileName);
								}
								writer.flush();
								continue;
							}else{
								writer.append(s.replaceAll("\\\\r\\\\n", ""));
								s=reader.readLine();
							}
						}
					}
					lineNumber++;
					if(lineNumber%lines==1){
						writer.close();
						fileIndex++;
						subFileName=System.currentTimeMillis()+"_"+fileIndex+".txt";
						writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filesPath+"/"+subFileName)));
						System.out.println("子文件："+subFileName);
					}
					writer.flush();
				}
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	

	// 删除文件和目录
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

}