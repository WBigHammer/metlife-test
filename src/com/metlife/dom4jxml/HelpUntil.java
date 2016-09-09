package com.metlife.dom4jxml;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class HelpUntil {

	/**
	   * 将doc写出到filename中
	   * @param doc 文档对象
	   * @param filename 要输出的xml文件名
	   */
	  public static void outputXml(Document doc, String filename) {
	    try {
	      //定义输出流的目的地
	      FileWriter fw = new FileWriter(filename);
	       
	      //定义输出格式和字符集
	      OutputFormat format 
	        = OutputFormat.createPrettyPrint();
	      format.setEncoding("UTF-8");
	       
	      //定义用于输出xml文件的XMLWriter对象
	      XMLWriter xmlWriter = new XMLWriter(fw, format);
	      xmlWriter.write(doc);
	      xmlWriter.close(); 
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	     
	  }
	  
	  /**
	   * 按行读取.txt文件中的内容   存放 在 List集合中
	 * @throws IOException 
	   * 
	   */
	  public static List<List<String>> readeTxt(String filedirname) throws IOException {
			
			List<List<String>> txtList = new ArrayList<List<String>>();// 存放txt文件单行数据
			
			File filename=new File(filedirname);//创建 文件对象
			FileReader fr = new FileReader(filename);//打开文件读取流
			BufferedReader bf = new BufferedReader(fr);//使用缓冲区进行文件的读取
			
			
			try {
				int id = 0;// 用来记录读到第几行记录
				while (bf.ready()) {
				List<String> tempList = new ArrayList<String>();//用于存放文件中的单行数据  |分隔符进行拆分后的数据
				String str = bf.readLine();
				id++;// 用于存放txt文件里每行数据
				String[] strs = str.split("\\|");//这里边必须使用反斜杠进行转义  否则会拆分成单个字母
				
					if (strs[0] != null && !strs[0].equals("") && strs[1] != null && !strs[1].equals("")) {
						tempList.add(strs[0]);
						tempList.add(strs[1]);
						if(strs.length>=3){
							tempList.add(strs[2]);
						}
					} else {
					System.out.println("读取第" + id + "行txt文档内容时，发现不合要求的数据！");
					}
					txtList.add(tempList);
				}
			} catch (Exception e) {
				System.out.println("读取txt文档内容时，发生异常！");
				e.printStackTrace();
			}finally 
			{ 
				bf.close();
				fr.close();
			} 
			return txtList;
			}
	  
	   /*字符类型转换方法	通过list集合将字段类型和数据长度等信息返回
	   	  使用hashmap集合会更好一点		List<List<String>>  将获得的所有参数进行输入*/	
	  	  public static Map<String, String> byteConver(List<List<String>> txt,int i){	
	  		  
	  		  String type=txt.get(i).get(1).toString();
			  Map<String, String> typemap=new HashMap<String, String>();
			  
			  String oncetype=txt.get(i).get(0);
			  typemap.put("name",oncetype);
			  
			  if(txt.get(i).size()>=3){
				  String threetype=txt.get(i).get(2).toString();
				  if(threetype!=null&&!threetype.equals("")){
				  typemap.put("nullable", "NOTNULL");
				  }
			  }else{
				  typemap.put("nullable", "NULL");
			  }
			  if(type!=""&&type!=null){
				  //通过 ( 对type 进行分割
				  //这边需要进行一个判断
				  int pan=type.lastIndexOf("(");
				  String filedtype=null;
				  String endtype=null;
				  if(pan!=-1){
					  filedtype=type.substring(0, type.lastIndexOf("("));
					  endtype=type.substring(type.lastIndexOf("("),type.length());
				  }else{
					  filedtype=type.substring(0, type.length());
				  }
				  //定义初始值   如果有变化  则在下面的判断条件中进行改变
				  typemap.put("filedtype", type);
		            typemap.put("scal", "0");
				  if(filedtype.equals("DATE")){
					  	type="datetime";
			            typemap.put("filedtype", type);
			            typemap.put("plen", "23");
			            typemap.put("len", "19");
			            typemap.put("pric", "23");
			            typemap.put("scal", "3");
				  }else if(filedtype.equals("NUMBER")){
					  type="decimal";
					  typemap.put("filedtype", type);
					  int index=endtype.indexOf(",");
					  	if(index==-1){
					  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  	}else{
					  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
				            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
					  	}
			            typemap.put("len", String.valueOf((Integer.valueOf(typemap.get("plen")).intValue()+2)));
			            typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("VARCHAR2")){
					  type="varchar";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("CHAR")){
					  type="char";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("NCHAR")){
					  type="nchar";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }
			  }
//			  typemap.put("offset",typemap.get("len"));
//			  typemap.put("poffset",typemap.get("plen"));
			  return typemap;
		  }
	  	  
	  	  
	  	/**
	  	 * 因为第二段标签的属性值  转换规则和第一部的转换规则不同  因此从新定义方法
	  	 * 
	  	 */	
	  	  public static Map<String, String> byteConver2(List<List<String>> txt,int i){	
	  		  String type=txt.get(i).get(1).toString();
			  Map<String, String> typemap=new HashMap<String, String>();
			  
			  String oncetype=txt.get(i).get(0);
			  typemap.put("name",oncetype);
			  if(txt.get(i).size()>=3){
				  String threetype=txt.get(i).get(2).toString();
				  if(threetype!=null&&!threetype.equals("")){
				  typemap.put("nullable", "NOTNULL");
				  }
			  }else{
				  typemap.put("nullable", "NULL");
			  }
			  typemap.put("nullable", "NULL");
			  if(type!=""&&type!=null){
				  //通过 ( 对type 进行分割
				  int pan=type.lastIndexOf("(");
				  String filedtype=null;
				  String endtype=null;
				  if(pan!=-1){
					  filedtype=type.substring(0, type.lastIndexOf("("));
					  endtype=type.substring(type.lastIndexOf("("),type.length());
				  }else{
					  filedtype=type.substring(0, type.length());
				  }
				  //定义初始值   如果有变化  则在下面的判断条件中进行改变
				  typemap.put("filedtype", type);
		            typemap.put("scal", "0");
				  if(filedtype.equals("DATE")){
					  	type="datetime";
			            typemap.put("filedtype", type);
			            typemap.put("plen", "29");
			            typemap.put("len", "29");
			            typemap.put("pric", "29");
			            typemap.put("scal", "9");
				  }else if(filedtype.equals("NUMBER")){
					  type="number";
					  typemap.put("filedtype", type);
					  int index=endtype.indexOf(",");
					  	if(index==-1){
					  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  	}else{
					  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
				            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
					  	}
			            typemap.put("len", String.valueOf((Integer.valueOf(typemap.get("plen")).intValue()+2)));
			            typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("VARCHAR2")){
					  type="string";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("CHAR")){
					  type="string";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("NCHAR")){
					  type="nstring";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }
				  
			  }
			  return typemap;
		  }
	  	  
	  	/**
		  	 * 因为第三段标签的属性值  转换规则和第二部的转换规则不同  因此从新定义方法
		  	 * 
		  	 */	
		  	  public static Map<String, String> byteConver3(List<List<String>> txt,int i){	
		  		  String type=txt.get(i).get(1).toString();
				  Map<String, String> typemap=new HashMap<String, String>();
				  
				  String oncetype=txt.get(i).get(0);
				  typemap.put("name",oncetype);
				  if(txt.get(i).size()>=3){
					  String threetype=txt.get(i).get(2).toString();
					  if(threetype!=null&&!threetype.equals("")){
					  typemap.put("nullable", "NOTNULL");
					  }
				  }else{
					  typemap.put("nullable", "NULL");
				  }
				  typemap.put("nullable", "NULL");
				  if(type!=""&&type!=null){
					  //通过 ( 对type 进行分割
					  int pan=type.lastIndexOf("(");
					  String filedtype=null;
					  String endtype=null;
					  if(pan!=-1){
						  filedtype=type.substring(0, type.lastIndexOf("("));
						  endtype=type.substring(type.lastIndexOf("("),type.length());
					  }else{
						  filedtype=type.substring(0, type.length());
					  }
					  //定义初始值   如果有变化  则在下面的判断条件中进行改变
					  typemap.put("filedtype", type);
			            typemap.put("scal", "0");
					  if(filedtype.equals("DATE")){
						  	type="date/time";
				            typemap.put("filedtype", type);
				            typemap.put("plen", "29");
				            typemap.put("len", "29");
				            typemap.put("pric", "29");
				            typemap.put("scal", "9");
					  }else if(filedtype.equals("NUMBER")){
						  type="decimal";
						  typemap.put("filedtype", type);
						  int index=endtype.indexOf(",");
						  	if(index==-1){
						  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  	}else{
						  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
					            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
						  	}
				            typemap.put("len", String.valueOf((Integer.valueOf(typemap.get("plen")).intValue()+2)));
				            typemap.put("pric", typemap.get("plen"));
					  }else if(filedtype.equals("VARCHAR2")){
						  type="string";
						  typemap.put("filedtype", type);
						  typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  typemap.put("len", "0");
						  typemap.put("pric", typemap.get("plen"));
					  }else if(filedtype.equals("CHAR")){
						  type="string";
						  typemap.put("filedtype", type);
						  typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  typemap.put("len", "0");
						  typemap.put("pric", typemap.get("plen"));
					  }else if(filedtype.equals("NCHAR")){
						  type="nstring";
						  typemap.put("filedtype", type);
						  typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  typemap.put("len", "0");
						  typemap.put("pric", typemap.get("plen"));
					  }
					  
				  }
				  return typemap;
			  }
		  	  
		  	  
		  	public static void SingleWrite(File file,String str) throws IOException {
				
				BufferedWriter bswp=null;
				try{
					bswp=new BufferedWriter(new FileWriter(file));
					bswp.write(str);
					bswp.flush();
				}catch(IOException ex){
					ex.printStackTrace();
				}finally{
					bswp.flush();
					bswp.close();
				}
			}
		  	/**
		  	 * 格式化输出  xml格式的字符串
		  	 * @param str
		  	 * @return
		  	 * @throws Exception
		  	 */
		  	/*public static String formatXml(String str) throws Exception {
		  	  Document document = null;
		  	  document = DocumentHelper.parseText(str);
		  	  // 格式化输出格式
		  	  OutputFormat format = OutputFormat.createPrettyPrint();
		  	  format.setEncoding("UTF-8");
		  	  StringWriter writer = new StringWriter();
		  	  // 格式化输出流
		  	  XMLWriter xmlWriter = new XMLWriter(writer, format);
		  	  // 将document写入到输出流
		  	  xmlWriter.write(document);
		  	  xmlWriter.close();
		  	  writer.close();
		  	  return writer.toString();
		  	 }*/
		  	
		  	
		  	/**
			 * 将xml格式的字符串按照格式输出
			 * @param inputXML
			 * @return
			 * @throws Exception
			 */
			public static String formatXML(String inputXML) throws Exception {
				//创建一个SAX解析器reader,使用SAX将指定的数据流读入到document中
			    SAXReader reader = new SAXReader();
			    Document document = reader.read(new StringReader(inputXML));
			    
			    String requestXML = null;
			    //XMLWriter将普通流转换成Xml标准流
			    XMLWriter writer = null;
			    
			    if (document != null) {
			      try {
			        StringWriter stringWriter = new StringWriter();
			        //OutputFormat是用来规范我们要输出的Xml的格式
			        OutputFormat format = new OutputFormat("  ", true);
			        writer = new XMLWriter(stringWriter, format);//这里可以使用一行代码，不过可读性降低
			        
			        //writer.write(document)是用来将Document输出到指定的输出流
			        writer.write(document);
			        writer.flush();
			        //再这里对返回报文进行进一步处理
			        /*网上查找资料，LZ最初处理方式，未对报文头格式进行限制
			        requestXML = stringWriter.getBuffer().toString();*/
			        //这里的报文头返回信息不友好，此处进行处理
			        String abd=stringWriter.getBuffer().toString();
			        /*requestXML=abd.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n\n", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");*/
			        requestXML=abd;
			      } finally {
			        if (writer != null) {
			          try {
			            writer.close();
			          } catch (IOException e) {
			          }
			        }
			      }
			    }
			    return requestXML;
			  }
			
			
			public static String cachexml(Object xmlObj) throws IOException {

				String zhongjain=null;
				String anb=null;
				String str=null;
				JAXBContext context;
				StringWriter writer= new StringWriter();
				try {
					context = JAXBContext.newInstance(xmlObj.getClass());
					Marshaller mar = context.createMarshaller();
					mar.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.FALSE);
					mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					mar.setProperty(Marshaller.JAXB_ENCODING, "GB2312");
					
						mar.marshal(xmlObj,writer);
						//使用下面的方法去除不需要的 standalone="yes" 这个头信息
//						anb=writer.toString().replace(" xmlns=\"http://ecif.flystone.com/message/ws\"","");
//						
//						zhongjain=anb.replace(" xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
//						
//						str=zhongjain.replace(" standalone=\"yes\"","");
						str=writer.toString();
						writer.flush();
				} catch (JAXBException e) {
					e.printStackTrace();
				}finally{
					writer.flush();
					writer.close();
				}
				return str;
			}
		  	
}
