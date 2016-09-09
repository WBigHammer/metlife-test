package com.metlife.dom4jxml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.*;
import org.dom4j.dom.DOMCDATA;
import org.dom4j.io.*;
/**
 * 利用DOM4J写出xml文件
 *
 */
public class Dom4jXml3 {
  
  /**
   * 根据配置文件生成xml格式的数据到指定名字的xml文件中
   * @param outfilename 要生成的xml文件名(指定路径)
   * @param infilename 要生成的xml文件名(指定路径)
 * @throws IOException 
   */
  public static void writeBook(String outfilename,String infilename) throws IOException{
	  
	  
	  //解析这个路径字符串      
	  String testsus=infilename.substring(infilename.lastIndexOf("/")+1, infilename.length());
	  String DongName=testsus.substring(0, testsus.lastIndexOf("."));
	  //装载这个指定文件   按行读取   使用嵌套集合进行获取？
	  List<List<String>> txt=HelpUntil3.readeTxt(infilename);
	  
	  //初始化全局变量
	  int offset=0;
	  int poffset=0;
	  
	  
	  
	  //********************************************xml结构建立
    //1. 构造空的Document
    Document doc = DocumentHelper.createDocument();
    doc.addDocType("POWERMART", null, "powrmart.dtd");//添加  Doctype 验证文件信息
    
    //2. 构造根元素
    Element rootElmt = doc.addElement("POWERMART");
    //增加属性值   先进行生成 不考虑灵活性
    rootElmt.addAttribute("CREATION_DATE","04/12/2016 14:11:48");
    rootElmt.addAttribute("REPOSITORY_VERSION","181.90");
    
    //3. 递归构造子元素		固定元素可以考虑提取成公共的
      Element bookElmt = rootElmt.addElement("REPOSITORY");
      //REPOSITORY元素增加属性
      bookElmt.addAttribute("NAME", "Rep_UAT");
      bookElmt.addAttribute("VERSION","181");
      bookElmt.addAttribute("CODEPAGE","UTF-8");
      bookElmt.addAttribute("DATABASETYPE","Microsoft SQL Server");
     
      //这边再增加一个 FOLDER 标签  里面还嵌套包含几个标签
      Element folderElmt = bookElmt.addElement("FOLDER");
      //FOLDER标签增加属性值  属性值是固定的   
      folderElmt.addAttribute("NAME", "DI_MIS");
      folderElmt.addAttribute("GROUP", "");
      folderElmt.addAttribute("OWNER", "Administrator");
      folderElmt.addAttribute("SHARED", "NOTSHARED");
      folderElmt.addAttribute("DESCRIPTION", "");
      folderElmt.addAttribute("PERMISSIONS", "rwx---r--");
      folderElmt.addAttribute("UUID", "d30d8f0f-df3b-4e61-ab71-7b38629c3248");
      
      //增加  SOURCE 标签
      Element sourceElmt = folderElmt.addElement("SOURCE");
      //FOLDER标签增加属性值  属性值是固定的   
      sourceElmt.addAttribute("BUSINESSNAME", "");
      sourceElmt.addAttribute("DATABASETYPE", "Flat File");
      sourceElmt.addAttribute("DBDNAME", "FlatFile");
      sourceElmt.addAttribute("DESCRIPTION", "");
      
      //name属性是通过  输入参数获得的 	DongName 是根据扫描指定文件获得绝对路径进行字符串截取获取的.txt后缀的文件名称
      sourceElmt.addAttribute("NAME", "F_"+DongName);//动态参数 
      
      sourceElmt.addAttribute("OBJECTVERSION", "1");
      sourceElmt.addAttribute("OWNERNAME", "");
      sourceElmt.addAttribute("VERSIONNUMBER", "1");
      
   // SOURCE 标签下面的  FLATFILE 子标签
      Element sourceflatElmt = sourceElmt.addElement("FLATFILE");
      sourceflatElmt.addAttribute("CODEPAGE", "MS936");
      sourceflatElmt.addAttribute("CONSECDELIMITERSASONE", "NO");
      sourceflatElmt.addAttribute("DELIMITED", "YES");
      sourceflatElmt.addAttribute("DELIMITERS", " || ");
      sourceflatElmt.addAttribute("ESCAPE_CHARACTER", "");
      sourceflatElmt.addAttribute("KEEPESCAPECHAR", "NO");
      sourceflatElmt.addAttribute("LINESEQUENTIAL", "NO");
      sourceflatElmt.addAttribute("MULTIDELIMITERSASAND", "YES");
      sourceflatElmt.addAttribute("NULLCHARTYPE", "ASCII");
      sourceflatElmt.addAttribute("NULL_CHARACTER", "*");
      sourceflatElmt.addAttribute("PADBYTES", "1");
      sourceflatElmt.addAttribute("QUOTE_CHARACTER", "NONE");
      sourceflatElmt.addAttribute("REPEATABLE", "NO");
      sourceflatElmt.addAttribute("ROWDELIMITER", "0");
      sourceflatElmt.addAttribute("SHIFTSENSITIVEDATA", "NO");
      sourceflatElmt.addAttribute("SKIPROWS", "0");
      sourceflatElmt.addAttribute("STRIPTRAILINGBLANKS", "NO");
      
      for(int i=0;i<7;i++){
	      Element sourceElmttableattributeElmt = sourceElmt.addElement("TABLEATTRIBUTE");
	      if(i==0){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Base Table Name");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "");
	      }else if(i==1){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Search Specification");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "");
	      }else if(i==2){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Sort Specification");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "");
	      }else if(i==3){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Datetime Format");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "A  19 mm/dd/yyyy hh24:mi:ss");
	      }else if(i==4){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Thousand Separator");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "None");
	      }else if(i==5){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Decimal Separator");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", ".");
	      }else if(i==6){
	    	  sourceElmttableattributeElmt.addAttribute("NAME", "Add Currently Processed Flat File Name Port");
	    	  sourceElmttableattributeElmt.addAttribute("VALUE", "NO");
	      }
      }
      //增加  SOURCEFIELD 标签    这里边应该增加一个循环
      for(int i=0;i<txt.size();i++){
	      //从工具类获取集合  初始化出来
	      Map<String, String> paramMap=HelpUntil3.byteConver(txt,i);
	      Element sourcefieldElmt = sourceElmt.addElement("SOURCEFIELD");
	      sourcefieldElmt.addAttribute("BUSINESSNAME", "");
	      
	      
	      sourcefieldElmt.addAttribute("DATATYPE", "string");
	      //转换成infoematic的数据类型  属性赋值的时候调用一个工具类的方法		byteConver
	      sourcefieldElmt.addAttribute("DESCRIPTION", "");
	      
	      //这边是顺序生成  从1 开始就行	这边使用  循环参数 i 进行 动态值的改变
	      sourcefieldElmt.addAttribute("FIELDNUMBER", ""+(i+1));
	      
	      
	      sourcefieldElmt.addAttribute("FIELDPROPERTY", "0");
	      sourcefieldElmt.addAttribute("FIELDTYPE", "ELEMITEM");
	      sourcefieldElmt.addAttribute("HIDDEN", "NO");
	      sourcefieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
	      
	      sourcefieldElmt.addAttribute("LENGTH", paramMap.get("len"));
	      
	      sourcefieldElmt.addAttribute("LEVEL", "0");
	      sourcefieldElmt.addAttribute("NAME", paramMap.get("name"));
	      sourcefieldElmt.addAttribute("NULLABLE", paramMap.get("nullable"));
	      sourcefieldElmt.addAttribute("OCCURS", "0");
	      sourcefieldElmt.addAttribute("OFFSET", "0");
	      if(i!=0){
	    	  offset=Integer.valueOf(HelpUntil3.byteConver(txt,i-1).get("plen"))+offset;//上一步的offset值  本次使用
	    	  sourcefieldElmt.addAttribute("OFFSET", String.valueOf((offset)));
	      }
	      
	      sourcefieldElmt.addAttribute("PHYSICALLENGTH", paramMap.get("plen"));
	      sourcefieldElmt.addAttribute("PHYSICALOFFSET", "0");
	      if(i!=0){
	    	  poffset=Integer.valueOf(HelpUntil3.byteConver(txt,i-1).get("plen"))+poffset;//上一步的offset值  本次使用
	    	  sourcefieldElmt.addAttribute("PHYSICALOFFSET", String.valueOf((poffset)));
	      }
	      sourcefieldElmt.addAttribute("PICTURETEXT", "");
	      sourcefieldElmt.addAttribute("PRECISION", paramMap.get("pric"));
	      sourcefieldElmt.addAttribute("SCALE", paramMap.get("scal"));
	      sourcefieldElmt.addAttribute("USAGE_FLAGS", "");
//	      offset=offset;
	      if(i==txt.size()-1){
		      for(int d=1;d<3;d++){
			      Element sourcefieldGDElmt = sourceElmt.addElement("SOURCEFIELD");
			      if(d==1){
				      sourcefieldGDElmt.addAttribute("BUSINESSNAME", "");
				      sourcefieldGDElmt.addAttribute("DATATYPE", "string");
				      sourcefieldGDElmt.addAttribute("DESCRIPTION", "");
				      sourcefieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      sourcefieldGDElmt.addAttribute("FIELDPROPERTY", "0");
				      
				      sourcefieldGDElmt.addAttribute("FIELDTYPE", "ELEMITEM");
				      sourcefieldGDElmt.addAttribute("HIDDEN", "NO");
				      sourcefieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      sourcefieldGDElmt.addAttribute("LENGTH", "35");
				      sourcefieldGDElmt.addAttribute("LEVEL", "0");
				      
				      sourcefieldGDElmt.addAttribute("NAME", "MD5_KEY");
				      sourcefieldGDElmt.addAttribute("NULLABLE", "NULL");
				      sourcefieldGDElmt.addAttribute("OCCURS", "0");
				      offset=Integer.valueOf(HelpUntil3.byteConver(txt,i-1).get("plen"))+offset;//上一步的offset值  本次使用
				      sourcefieldGDElmt.addAttribute("OFFSET", String.valueOf((offset)));
				      
				      sourcefieldGDElmt.addAttribute("PHYSICALLENGTH", "32");
				      poffset=Integer.valueOf(HelpUntil3.byteConver(txt,i-1).get("plen"))+poffset;//上一步的offset值  本次使用
				      sourcefieldGDElmt.addAttribute("PHYSICALOFFSET", String.valueOf((poffset)));
				      sourcefieldGDElmt.addAttribute("PICTURETEXT", "");
				      sourcefieldGDElmt.addAttribute("PRECISION", "35");
				      sourcefieldGDElmt.addAttribute("SCALE", "0");
				      sourcefieldGDElmt.addAttribute("USAGE_FLAGS", "");
			      }else if(d==2){
			    	  sourcefieldGDElmt.addAttribute("BUSINESSNAME", "");
				      sourcefieldGDElmt.addAttribute("DATATYPE", "string");
				      sourcefieldGDElmt.addAttribute("DESCRIPTION", "");
				      sourcefieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      sourcefieldGDElmt.addAttribute("FIELDPROPERTY", "0");
				      
				      sourcefieldGDElmt.addAttribute("FIELDTYPE", "ELEMITEM");
				      sourcefieldGDElmt.addAttribute("HIDDEN", "NO");
				      sourcefieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      sourcefieldGDElmt.addAttribute("LENGTH", "13");
				      sourcefieldGDElmt.addAttribute("LEVEL", "0");
				      
				      sourcefieldGDElmt.addAttribute("NAME", "BATCHCODE");
				      sourcefieldGDElmt.addAttribute("NULLABLE", "NULL");
				      sourcefieldGDElmt.addAttribute("OCCURS", "0");
				      
				      sourcefieldGDElmt.addAttribute("OFFSET", String.valueOf((offset+35)));
				      
				      sourcefieldGDElmt.addAttribute("PHYSICALLENGTH", "13");
				      //这边需要注意  循环中的自增条件在这里已经不再适用了
				      sourcefieldGDElmt.addAttribute("PHYSICALOFFSET", String.valueOf((poffset+35)));
				      sourcefieldGDElmt.addAttribute("PICTURETEXT", "");
				      sourcefieldGDElmt.addAttribute("PRECISION", "13");
				      sourcefieldGDElmt.addAttribute("SCALE", "0");
				      sourcefieldGDElmt.addAttribute("USAGE_FLAGS", "");
			      }
		      }
	      }
      }
      
      
      
      //这里需要根据配置文件字段的数量进行循环读取，然后根据配置文件进行字段类型的判断进行不同的处理
      
      
      //SOURCE  标签的同级子标签  TARGET
      Element targetElmt = folderElmt.addElement("TARGET");
      // target 标签增加属性 
      targetElmt.addAttribute("BUSINESSNAME", "");
      targetElmt.addAttribute("CONSTRAINT", "");
      targetElmt.addAttribute("DATABASETYPE", "Oracle");
      targetElmt.addAttribute("DESCRIPTION", "");
      targetElmt.addAttribute("NAME", DongName);
      targetElmt.addAttribute("OBJECTVERSION", "1");
      targetElmt.addAttribute("TABLEOPTIONS", "");
      targetElmt.addAttribute("VERSIONNUMBER", "1");
      
      // TARGET 标签下面的  FLATFILE 子标签
      /*Element flatfileElmt = targetElmt.addElement("FLATFILE");
      flatfileElmt.addAttribute("CODEPAGE", "MS936");
      flatfileElmt.addAttribute("CONSECDELIMITERSASONE", "NO");
      flatfileElmt.addAttribute("DELIMITED", "YES");
      flatfileElmt.addAttribute("DELIMITERS", " || ");
      flatfileElmt.addAttribute("ESCAPE_CHARACTER", "");
      flatfileElmt.addAttribute("KEEPESCAPECHAR", "NO");
      flatfileElmt.addAttribute("LINESEQUENTIAL", "NO");
      flatfileElmt.addAttribute("MULTIDELIMITERSASAND", "NO");
      flatfileElmt.addAttribute("NULLCHARTYPE", "ASCII");
      flatfileElmt.addAttribute("NULL_CHARACTER", "*");
      flatfileElmt.addAttribute("PADBYTES", "1");
      flatfileElmt.addAttribute("QUOTE_CHARACTER", "NONE");
      flatfileElmt.addAttribute("REPEATABLE", "NO");
      flatfileElmt.addAttribute("ROWDELIMITER", "0");
      flatfileElmt.addAttribute("SKIPROWS", "0");
      flatfileElmt.addAttribute("STRIPTRAILINGBLANKS", "NO");*/
      
      
      //TARGET 标签下面的  TARGETFIELD 子标签   多个同级标签  通过循环进行生成   targetfield
      for(int i=0;i<txt.size();i++){
    	  if(i==0){
		      for(int d=1;d<6;d++){
			      Element targetfieldGDElmt = targetElmt.addElement("TARGETFIELD");
			      targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
			      targetfieldGDElmt.addAttribute("DATATYPE", "varchar2");
			      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
			      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d));
			      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
			      targetfieldGDElmt.addAttribute("NAME", "SRC_SY_CODE");
			      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
			      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
			      targetfieldGDElmt.addAttribute("PRECISION",  "32");
			      targetfieldGDElmt.addAttribute("SCALE","0");
			      if(d==1){
				      targetfieldGDElmt.addAttribute("NAME", "SRC_SY_CODE");
			      }else if(d==2){
				      targetfieldGDElmt.addAttribute("NAME", "MD5_KEY");
			      }else if(d==3){
				      targetfieldGDElmt.addAttribute("NAME", "BATCH_ID");
			      }else if(d==4){
				      targetfieldGDElmt.addAttribute("NAME", "ADI_BATCH_ID");
			      }else if(d==5){
			    	  targetfieldGDElmt.addAttribute("DATATYPE", "TIMESTAMP");
				      targetfieldGDElmt.addAttribute("NAME", "ETL_TIME");
				      targetfieldGDElmt.addAttribute("PRECISION",  "29");
				      targetfieldGDElmt.addAttribute("SCALE","9");
			      }
		      }
	      }
    	  Map<String, String> paramMap2=HelpUntil3.byteConver2(txt,i);
	      Element targetfieldElmt = targetElmt.addElement("TARGETFIELD");
	      targetfieldElmt.addAttribute("BUSINESSNAME", "");
	      targetfieldElmt.addAttribute("DATATYPE", paramMap2.get("filedtype"));
	      targetfieldElmt.addAttribute("DESCRIPTION", "");
	      targetfieldElmt.addAttribute("FIELDNUMBER", ""+(i+6));
	      targetfieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
	      targetfieldElmt.addAttribute("NAME", paramMap2.get("name"));
	      targetfieldElmt.addAttribute("NULLABLE", paramMap2.get("nullable"));
	      targetfieldElmt.addAttribute("PICTURETEXT", "");
	      targetfieldElmt.addAttribute("PRECISION",  paramMap2.get("pric"));
	      targetfieldElmt.addAttribute("SCALE",  paramMap2.get("scal"));
	      /*if(i==txt.size()-1){
		      for(int d=1;d<4;d++){
			      Element targetfieldGDElmt = targetElmt.addElement("TARGETFIELD");
			      if(d==1){
				      targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "varchar2");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "MD5_KEY");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "35");
				      targetfieldGDElmt.addAttribute("SCALE","0");
			      }else if(d==2){
			    	  targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "number(p,s)");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "WORK_BATCH");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "11");
				      targetfieldGDElmt.addAttribute("SCALE","0");
			      }
		      }
	      }*/
      }
      
      //TARGET 标签下面的  TABLEATTRIBUTE 子标签   多个同级标签  通过循环进行生成   tableattribute
      /*for(int i=0;i<4;i++){
	      Element tableattributeElmt = targetElmt.addElement("TABLEATTRIBUTE");
	      if(i==0){
	      tableattributeElmt.addAttribute("NAME", "Datetime Format");
	      tableattributeElmt.addAttribute("VALUE", "A  19 mm/dd/yyyy hh24:mi:ss");
	      }else if(i==1){
	    	  tableattributeElmt.addAttribute("NAME", "Thousand Separator");
		      tableattributeElmt.addAttribute("VALUE", "None");
	      }else if(i==2){
	    	  tableattributeElmt.addAttribute("NAME", "Decimal Separator");
		      tableattributeElmt.addAttribute("VALUE", ".");
	      }else{
	    	  tableattributeElmt.addAttribute("NAME", "Line Endings");
		      tableattributeElmt.addAttribute("VALUE", "System default");
	      }
      }*/
      //SOURCE  标签的同级子标签  MAPPING   mapping
      Element mappingElmt = folderElmt.addElement("MAPPING");
      // MAPPING 标签增加属性 
      mappingElmt.addAttribute("DESCRIPTION", "");
      mappingElmt.addAttribute("ISVALID", "YES");
      mappingElmt.addAttribute("NAME", "m_AZ_I_"+DongName);
      mappingElmt.addAttribute("OBJECTVERSION", "1");
      mappingElmt.addAttribute("VERSIONNUMBER", "1");
      
      //MAPPING 标签下面的  TRANSFORMATION 子标签   多个同级标签  通过循环进行生成   transformation    ********
      Element transformationElmt = mappingElmt.addElement("TRANSFORMATION");
      transformationElmt.addAttribute("DESCRIPTION", "");
      transformationElmt.addAttribute("NAME", "SQ_F_"+DongName);
      transformationElmt.addAttribute("OBJECTVERSION", "1");
      transformationElmt.addAttribute("REUSABLE", "NO");
      transformationElmt.addAttribute("TYPE", "Source Qualifier");
      transformationElmt.addAttribute("VERSIONNUMBER", "1");
      
      
      //MAPPING 标签下面的  TRANSFORMFIELD 子标签   多个同级标签  通过循环进行生成   transformfield
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil3.byteConver3(txt,i);
	      Element transformfieldElmt = transformationElmt.addElement("TRANSFORMFIELD");
	      transformfieldElmt.addAttribute("DATATYPE", "string");
	      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
	      transformfieldElmt.addAttribute("DESCRIPTION", "");
	      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
	      transformfieldElmt.addAttribute("PICTURETEXT", "");
	      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
	      transformfieldElmt.addAttribute("PRECISION", String.valueOf(Integer.valueOf(paramMap3.get("plen"))+3));
	      transformfieldElmt.addAttribute("SCALE", "0");
	      if(i==txt.size()-1){
		      for(int d=1;d<3;d++){
			      Element transformfieldGDElmt = transformationElmt.addElement("TRANSFORMFIELD");
			      if(d==1){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "35");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }else if(d==2){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("NAME", "BATCHCODE");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "13");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }
		      }
	      }
      }
      //MAPPING 标签下面的  TABLEATTRIBUTE 子标签   多个同级标签  通过循环进行生成   tableattribute  
      for(int i=1;i<11;i++){
    	  Element tableattributeSqlMapElmt = transformationElmt.addElement("TABLEATTRIBUTE");
    	  if(i==1){
	          tableattributeSqlMapElmt.addAttribute("NAME", "Sql Query");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==2){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "User Defined Join");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==3){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Source Filter");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==4){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Number Of Sorted Ports");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "0");
    	  }else if(i==5){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Tracing Level");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "Normal");
    	  }else if(i==6){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Is Partitionable");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "NO");
    	  }else if(i==7){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Pre SQL");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==8){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Post SQL");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==9){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Output is deterministic");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "NO");
    	  }else if(i==10){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Output is repeatable");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "Never");
    	  }
      }
      
      //手动生成的  TRANSFORMATION 标签
      Element transformation2Elmt = mappingElmt.addElement("TRANSFORMATION");
      transformation2Elmt.addAttribute("DESCRIPTION", "");
      transformation2Elmt.addAttribute("NAME", "F_"+DongName+"_EXPTRANS");
      transformation2Elmt.addAttribute("OBJECTVERSION", "1");
      transformation2Elmt.addAttribute("REUSABLE", "NO");
      transformation2Elmt.addAttribute("TYPE", "Expression");
      transformation2Elmt.addAttribute("VERSIONNUMBER", "1");
      //脚本进行了改动   进行相应的调整 
      for(int d=1;d<4;d++){
	      Element transformfieldGDElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
	      if(d==1){
	    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
	    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldGDElmt.addAttribute("EXPRESSION", "$$SRC_SY_CODE");
	    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	    	  transformfieldGDElmt.addAttribute("NAME", "SRC_SY_CODE");
	    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldGDElmt.addAttribute("PRECISION", "32");
	    	  transformfieldGDElmt.addAttribute("SCALE", "0");
	      }else if(d==2){
	    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
	    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldGDElmt.addAttribute("EXPRESSION", "$$ADI_BATCH_ID");
	    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	    	  transformfieldGDElmt.addAttribute("NAME", "ADI_BATCH_ID");
	    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldGDElmt.addAttribute("PRECISION", "32");
	    	  transformfieldGDElmt.addAttribute("SCALE", "0");
	      }else if(d==3){
	    	  transformfieldGDElmt.addAttribute("DATATYPE", "date/time");
	    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
	    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldGDElmt.addAttribute("EXPRESSION", "SYSDATE");
	    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	    	  transformfieldGDElmt.addAttribute("NAME", "ETL_TIME");
	    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldGDElmt.addAttribute("PRECISION", "29");
	    	  transformfieldGDElmt.addAttribute("SCALE", "9");
	      }
      }
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil3.byteConver4(txt,i);
	      Element transformfieldElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
	      Element transformfieldsecondElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
	      if(paramMap3.get("filedtype").equals("TIMESTAMP")){
		      transformfieldElmt.addAttribute("DATATYPE", "string");
		      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
		      transformfieldElmt.addAttribute("DESCRIPTION", "");
		      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
		      transformfieldElmt.addAttribute("PICTURETEXT", "");
		      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
		      transformfieldElmt.addAttribute("PRECISION", "26");
		      transformfieldElmt.addAttribute("SCALE", "0");
		      
		      transformfieldsecondElmt.addAttribute("DATATYPE","date/time");
		      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
		      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
		      transformfieldsecondElmt.addAttribute("EXPRESSION","TO_DATE(LTRIM(RTRIM("+paramMap3.get("name")+")),'MM/DD/YYYY HH24:MI:SS')");
		      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
		      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
		      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
		      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
		      transformfieldsecondElmt.addAttribute("PRECISION","29");
		      transformfieldsecondElmt.addAttribute("SCALE","9");
	      }else if(paramMap3.get("filedtype").equals("NUMBER")){
			      transformfieldElmt.addAttribute("DATATYPE", "string");
			      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldElmt.addAttribute("DESCRIPTION", "");
			      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("PICTURETEXT", "");
			      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
			      transformfieldElmt.addAttribute("PRECISION", String.valueOf((Integer.valueOf(paramMap3.get("plen"))+3)));
			      transformfieldElmt.addAttribute("SCALE", "0");
			      
			      transformfieldsecondElmt.addAttribute("DATATYPE","decimal");
			      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
			      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
			      transformfieldsecondElmt.addAttribute("EXPRESSION","TO_DECIMAL(LTRIM(RTRIM("+paramMap3.get("name")+")))");
			      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
			      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
			      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
			      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
			      transformfieldsecondElmt.addAttribute("PRECISION",String.valueOf((Integer.valueOf(paramMap3.get("plen"))+2)));
			      transformfieldsecondElmt.addAttribute("SCALE",String.valueOf((Integer.valueOf(paramMap3.get("scal")))));
	      }else if(paramMap3.get("filedtype").equals("NUMBERNULLTen")){
			      transformfieldElmt.addAttribute("DATATYPE", "string");
			      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldElmt.addAttribute("DESCRIPTION", "");
			      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("PICTURETEXT", "");
			      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
			      transformfieldElmt.addAttribute("PRECISION", String.valueOf((Integer.valueOf(paramMap3.get("plen"))+3)));
			      transformfieldElmt.addAttribute("SCALE", "0");
			      
			      transformfieldsecondElmt.addAttribute("DATATYPE","bigint");
			      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
			      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
			      transformfieldsecondElmt.addAttribute("EXPRESSION","TO_bigint(LTRIM(RTRIM("+paramMap3.get("name")+")))");
			      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
			      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
			      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
			      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
			      transformfieldsecondElmt.addAttribute("PRECISION","19");
			      transformfieldsecondElmt.addAttribute("SCALE","0");
	      }else if(paramMap3.get("filedtype").equals("NUMBERNULL")){
			      transformfieldElmt.addAttribute("DATATYPE", "string");
			      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldElmt.addAttribute("DESCRIPTION", "");
			      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("PICTURETEXT", "");
			      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
			      transformfieldElmt.addAttribute("PRECISION", String.valueOf((Integer.valueOf(paramMap3.get("plen"))+3)));
			      transformfieldElmt.addAttribute("SCALE", "0");
			      
			      transformfieldsecondElmt.addAttribute("DATATYPE","integer");
			      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
			      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
			      transformfieldsecondElmt.addAttribute("EXPRESSION","TO_integer(LTRIM(RTRIM("+paramMap3.get("name")+")))");
			      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
			      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
			      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
			      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
			      transformfieldsecondElmt.addAttribute("PRECISION","10");
			      transformfieldsecondElmt.addAttribute("SCALE","0");
	      }else{
		    	  transformfieldElmt.addAttribute("DATATYPE", "string");
			      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldElmt.addAttribute("DESCRIPTION", "");
			      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("PICTURETEXT", "");
			      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
			      transformfieldElmt.addAttribute("PRECISION", String.valueOf((Integer.valueOf(paramMap3.get("plen"))+3)));
			      transformfieldElmt.addAttribute("SCALE", "0");
			      
			      transformfieldsecondElmt.addAttribute("DATATYPE","string");
			      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
			      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
			      transformfieldsecondElmt.addAttribute("EXPRESSION","LTRIM(RTRIM("+paramMap3.get("name")+"))");
			      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
			      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
			      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
			      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
			      transformfieldsecondElmt.addAttribute("PRECISION",String.valueOf((Integer.valueOf(paramMap3.get("plen")))));
			      transformfieldsecondElmt.addAttribute("SCALE","0");
	      }
	      if(i==txt.size()-1){
		      for(int d=1;d<5;d++){
			      Element transformfieldGDElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
			      if(d==1){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "35");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }else if(d==2){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("EXPRESSION", "LTRIM(RTRIM(MD5_KEY))");
			    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
			    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY_OUT");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "32");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }else if(d==3){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("NAME", "BATCHCODE");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "13");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }else if(d==4){
			    	  transformfieldGDElmt.addAttribute("DATATYPE", "bigint");
			    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
			    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
			    	  transformfieldGDElmt.addAttribute("EXPRESSION", "TO_bigint(LTRIM(RTRIM(BATCHCODE)))");
			    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
			    	  transformfieldGDElmt.addAttribute("NAME", "BATCHCODE_OUT");
			    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
			    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
			    	  transformfieldGDElmt.addAttribute("PRECISION", "19");
			    	  transformfieldGDElmt.addAttribute("SCALE", "0");
			      }
		      }
	      }
      }
      Element tableattributeSDMapElmt = transformation2Elmt.addElement("TABLEATTRIBUTE");
      tableattributeSDMapElmt.addAttribute("NAME", "Tracing Level");
      tableattributeSDMapElmt.addAttribute("VALUE", "Normal");
      
      //INSTANCE 标签  进行判断  是否含有子标签   INSTANCE标签跟  TRANSFORMATION标签同级   instance
      //MAPPING 标签下面的  INSTANCE 子标签   多个同级标签  通过循环进行生成   instance    ********
      for(int i=1;i<5;i++){
	      Element instanceElmt = mappingElmt.addElement("INSTANCE");
	      if(i==1){
	    	  instanceElmt.addAttribute("DBDNAME", "FlatFile");
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "1");
	    	  instanceElmt.addAttribute("NAME", "F_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "F_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Definition");
	    	  instanceElmt.addAttribute("TYPE", "SOURCE");
	      }else if(i==2){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "2");
	    	  instanceElmt.addAttribute("NAME", "SQ_F_"+DongName);
	    	  instanceElmt.addAttribute("REUSABLE", "NO");
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "SQ_F_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Qualifier");
	    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
	    	  
	    	  Element associated_source_instanceElmt = instanceElmt.addElement("ASSOCIATED_SOURCE_INSTANCE");
	    	  associated_source_instanceElmt.addAttribute("NAME", "F_"+DongName);
	      }else if(i==3){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "3");
	    	  instanceElmt.addAttribute("NAME", "AZ_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
	    	  instanceElmt.addAttribute("TYPE", "TARGET");
	      }else if(i==4){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "4");
	    	  instanceElmt.addAttribute("NAME", "F_"+DongName+"_EXPTRANS");
	    	  instanceElmt.addAttribute("REUSABLE", "NO");
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "F_"+DongName+"_EXPTRANS");
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
	    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
	      }
	      
	      //这边需要根据配置文件进行判断   是否需要生成子标签  ASSOCIATED_SOURCE_INSTANCE  associated_source_instance
      }
      
      //MAPPING 标签下面的  CONNECTOR 子标签   多个同级标签  通过循环进行生成   connector    ********
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil3.byteConver3(txt,i);
	      Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("FROMINSTANCE", "F_"+DongName);
	      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
	      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("TOINSTANCE", "SQ_F_"+DongName);
	      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
	      if(i==txt.size()-1){
		      for(int d=1;d<3;d++){
			      Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
			      if(d==1){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName);
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
			    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "SQ_F_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
			      }else if(d==2){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCHCODE");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName);
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
			    	  connectorGDElmt.addAttribute("TOFIELD", "BATCHCODE");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "SQ_F_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
			      }
		      }
	      }
      }
      /**
       * ===========================================================第二次循环
       */
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil3.byteConver3(txt,i);
	      Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("FROMINSTANCE", "SQ_F_"+DongName);
	      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
	      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("TOINSTANCE", "F_"+DongName+"_EXPTRANS");
	      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
	      if(i==txt.size()-1){
		      for(int d=1;d<3;d++){
			      Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
			      if(d==1){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "SQ_F_"+DongName);
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
			    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
			      }else if(d==2){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCHCODE");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "SQ_F_"+DongName);
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
			    	  connectorGDElmt.addAttribute("TOFIELD", "BATCHCODE");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
			      }
		      }
	      }
      }
      /**
       * ===========================================================第三次循环
       */
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil3.byteConver3(txt,i);
	      Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"_OUT");
	      connectorElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
	      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
	      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      if(i==txt.size()-1){
		      for(int d=1;d<6;d++){
			      Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
			      if(d==1){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "SRC_SY_CODE");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			    	  connectorGDElmt.addAttribute("TOFIELD", "SRC_SY_CODE");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
			      }else if(d==2){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "ADI_BATCH_ID");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			    	  connectorGDElmt.addAttribute("TOFIELD", "ADI_BATCH_ID");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
			      }else if(d==3){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "ETL_TIME");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			    	  connectorGDElmt.addAttribute("TOFIELD", "ETL_TIME");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
			      }else if(d==4){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY_OUT");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
			      }else if(d==5){
			    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCHCODE_OUT");
			    	  connectorGDElmt.addAttribute("FROMINSTANCE", "F_"+DongName+"_EXPTRANS");
			    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			    	  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
			    	  connectorGDElmt.addAttribute("TOINSTANCE", "AZ_"+DongName);
			    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
			      }
		      }
	      }
      }
      //手工生成  3个同类型标签
      
      //MAPPING 标签下面的  TARGETLOADORDER 子标签   多个同级标签  通过循环进行生成   targetloadorder    ********
      Element targetloadorderElmt = mappingElmt.addElement("TARGETLOADORDER");
      targetloadorderElmt.addAttribute("ORDER", "1");
      targetloadorderElmt.addAttribute("TARGETINSTANCE", DongName);
      for(int d=1;d<3;d++){
    	  Element mappingvariableElmt = mappingElmt.addElement("MAPPINGVARIABLE");
    	  if(d==1){
		      mappingvariableElmt.addAttribute("DATATYPE", "string");
		      mappingvariableElmt.addAttribute("DEFAULTVALUE", "LA");
		      mappingvariableElmt.addAttribute("DESCRIPTION", "");
		      mappingvariableElmt.addAttribute("ISEXPRESSIONVARIABLE", "NO");
		      mappingvariableElmt.addAttribute("ISPARAM", "YES");
		      mappingvariableElmt.addAttribute("NAME", "$$SRC_SY_CODE");
		      mappingvariableElmt.addAttribute("PRECISION", "100");
		      mappingvariableElmt.addAttribute("SCALE", "0");
		      mappingvariableElmt.addAttribute("USERDEFINED", "YES");
    	  }else if(d==2){
    		  mappingvariableElmt.addAttribute("DATATYPE", "string");
		      mappingvariableElmt.addAttribute("DEFAULTVALUE", "20160415999");
		      mappingvariableElmt.addAttribute("DESCRIPTION", "");
		      mappingvariableElmt.addAttribute("ISEXPRESSIONVARIABLE", "NO");
		      mappingvariableElmt.addAttribute("ISPARAM", "YES");
		      mappingvariableElmt.addAttribute("NAME", "$$ADI_BATCH_ID");
		      mappingvariableElmt.addAttribute("PRECISION", "100");
		      mappingvariableElmt.addAttribute("SCALE", "0");
		      mappingvariableElmt.addAttribute("USERDEFINED", "YES");
    	  }
      }
      Element erpinfoElmt = mappingElmt.addElement("ERPINFO");
      //4. 输出
      HelpUntil3.outputXml(doc, outfilename);
  }
}