public class ScannerReplaceCR {

	public static void main(java.lang.String[] args) {
		java.lang.String inDirectory="D:\\java\\before";
		java.lang.String outDirectory="D:\\java\\after";
		java.lang.String filetype="txt";
		java.io.File filess=new java.io.File(inDirectory);
		java.util.List<java.io.File> ll = getFiles(filess, filetype);
		java.lang.String infilepath;
		java.lang.String outfilepath;
		if(ll.size()<2&&ll.size()!=0){
			for (java.io.File ff : ll) {
				infilepath=ff.getPath();
				outfilepath=getOutfileString(outDirectory,infilepath);
				outTxt(infilepath, outfilepath);
				deleteall(inDirectory);
			}
		}else{
			System.out.println("dddd");
		}
	}
	public static java.util.List<java.io.File> getFiles(java.io.File fileDir, java.lang.String fileType) {
		java.util.List<java.io.File> lfile = new java.util.ArrayList<java.io.File>();
        java.io.File[] fs = fileDir.listFiles();
        for (java.io.File f : fs) {
            if (f.isFile()) {
                if (fileType
                        .equals(f.getName().substring(
                                f.getName().lastIndexOf(".") + 1,
                                f.getName().length())))
                    lfile.add(f);
            } else {
            	java.util.List<java.io.File> ftemps = getFiles(f,fileType);
                lfile.addAll(ftemps);
            }
        }
        return lfile;
    }
	
	public static java.lang.String getOutfileString(java.lang.String outDirectory,java.lang.String infilepath){
		java.lang.String outfilepath;
		java.lang.String split=infilepath.substring(infilepath.lastIndexOf("\\"),infilepath.length());
		outfilepath=outDirectory+split;
		return outfilepath;
	}
	
	public static void outTxt(java.lang.String filepath,java.lang.String outfilepath){
		java.util.Scanner sc = null;
		java.lang.String line;
		java.lang.String newline;
		
		java.io.File f_src = new java.io.File(filepath);
		java.io.File f_t = new java.io.File(outfilepath);
		
		java.io.FileOutputStream t_fout = null;
			try {
				sc = new java.util.Scanner(f_src,"GBK");
//				sc = new java.util.Scanner(f_src,"UTF-8");
				t_fout = new java.io.FileOutputStream(f_t);
				while (sc.hasNext()) {
					line = sc.nextLine();
					newline = line.replaceAll("( \\|\\| HUAN HANG)", "\n");
					newline = newline.replaceAll("\\\\r\\\\n", "");
					t_fout.write((newline).getBytes());
				}
				sc.close();
				t_fout.close();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
	}
	public static void deleteall(java.lang.String Directory){
		java.io.File file = new java.io.File(Directory);
		java.io.File[] files = file.listFiles();
        for(int i=0; i<files.length; i++){
        	java.io.File tmp = files[i];
            if(tmp.toString().endsWith(".txt")){
                tmp.delete();
            }
        }
	}
}
