//package txt2xml;

public class SplitCreateFile {

	
	
	public static java.lang.String getTxtFromFile(java.io.File file){
	if(file.exists()){
		java.io.BufferedReader br=null;
		java.lang.String fileName =null;
		try {
			br = new java.io.BufferedReader(new java.io.FileReader(file));
			java.lang.String line =null;
			while((line=br.readLine())!=null){
				fileName = line;
			} 
		} catch (java.io.FileNotFoundException e) {
		e.printStackTrace();
		} catch (java.io.IOException e) {
		e.printStackTrace();
		}finally{
		if(br!=null){ 
		try {
		br.close();
		} catch (java.io.IOException e) {
		e.printStackTrace();
		}
		}
		}
		return fileName;
	}else{
	System.out.println("file is not exsit");
	return new String();
	}
	} 
	
	public static java.util.List<java.lang.String> createNewFile(java.lang.String fileName) {
		java.util.List<java.lang.String> list=new java.util.ArrayList<java.lang.String>();
		try {
			java.lang.String[] fileNames = fileName.split(",");
				int leftpan;
				int rightpan;
				int endleftpan;
				java.lang.String lastst=null;
				for(java.lang.String f:fileNames){
					leftpan=f.lastIndexOf("(");
					rightpan=f.lastIndexOf(")");
					endleftpan=f.indexOf("(");
					if((leftpan==-1&&rightpan==-1)||(leftpan!=-1&&rightpan!=-1)){
						list.add(f);
					}else if(leftpan!=-1&&rightpan==-1){
						if(leftpan==endleftpan){
							list.add(f);
						}
						if(leftpan!=endleftpan){
							lastst=f; 
						}
					}else if(leftpan==-1&&rightpan!=-1){
						f=lastst+","+f;
						list.add(f);
					}
					if((f.indexOf("CONSTRAINT")!=-1)){
						break;
					}
				}
		} catch (Exception e) {
			System.out.println("can not create");
		e.printStackTrace();
		}
		return list;
	}
	
	public static java.util.List<java.lang.String> replaceS(java.util.List<java.lang.String> list){
		java.util.List<java.lang.String> listring=new java.util.ArrayList<java.lang.String>();
		java.lang.String first=null;
		java.lang.String split=null;
		
		
		for(int i=0;i<list.size();i++){
			if(i==0){
				java.lang.String guifan=null;
				first=list.get(0);
				if(first!=null){
					split=first.substring(first.indexOf("(")+1, first.length());
					guifan=split.replace(" ", "|");
						if(guifan.indexOf("COLLATE|Chinese_PRC_CS_AS")!=-1){
							guifan=guifan.replaceAll("COLLATE|Chinese_PRC_CS_AS", "");
						}
							int firstchar=guifan.indexOf("|");
							int secondchar=(guifan.substring(firstchar+1, guifan.length())).indexOf("|")+firstchar;
							if(guifan.indexOf("NOT|NULL")!=-1){
								guifan=(guifan.substring(0, secondchar+1))+"|NOTNULL";
							}else if(guifan.indexOf("NULL")==-1){
								guifan=guifan.substring(0,secondchar);
							}
						listring.add(guifan);
				}
			}else if(i==list.size()-1){
				first=null;
			}else{
				java.lang.String guifan=null;
				java.lang.String zhuanhuan=null;
				java.lang.String fufeng=null;
				first=list.get(i);
				if(first!=null){
					guifan=first.replace(" ", "|");
					
					zhuanhuan=guifan.replace("COLLATE|Chinese_PRC_CS_AS", "");
					zhuanhuan=zhuanhuan.substring(1,zhuanhuan.length());
					int firstchar=zhuanhuan.indexOf("|");
					int secondchar=(zhuanhuan.substring(firstchar+1, zhuanhuan.length())).indexOf("|")+firstchar;
					
							if(zhuanhuan.lastIndexOf("|")==(zhuanhuan.length()-1)){
								fufeng=zhuanhuan.substring(0, zhuanhuan.length());
							}else{
								fufeng=zhuanhuan.substring(0, zhuanhuan.length())+"|";
							}
							
							if(fufeng.indexOf("NOT|NULL")!=-1){
								fufeng=(fufeng.substring(0, secondchar+1))+"|NOTNULL";
							}
					listring.add(fufeng);
				}
			}
		}
		return listring;
	}
	
	public static void whiteToTxt(java.util.List<String> list,java.io.File file) throws java.io.IOException{
		java.io.FileWriter fw=new java.io.FileWriter(file);
		try{
			for(String str:list){
				fw.write(str+"\n");
			}
		}catch(java.io.IOException e){
			e.printStackTrace();
		}finally{
			fw.flush();
			fw.close();
		}
	}
	
	
	public static void main(java.lang.String[] args) throws java.io.IOException {
//		args[0]="COMP_ARS_CTOALOG.txt";
//		args[1]="tt.txt";
		java.io.File infile = new java.io.File("D:\\metlife-xiezhu\\Sql-server-requestion\\"+"COMP_ARS_CTOALOG.txt");
		java.io.File outfile=new java.io.File("D:\\zip-test\\metlife-work\\testoutfile\\"+"tt.txt");
		java.util.List<String> hk=createNewFile(getTxtFromFile(infile));
		whiteToTxt(replaceS(hk),outfile);
	}
}
