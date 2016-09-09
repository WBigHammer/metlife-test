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
public class Dom4jXml {
  
  /**
   * 根据配置文件生成xml格式的数据到指定名字的xml文件中
   * @param outfilename 要生成的xml文件名(指定路径)
   * @param infilename 要生成的xml文件名(指定路径)
 * @throws IOException 
   */
  public static void writeBook(String outfilename,String infilename) throws IOException{
	  
	  //这边的infilename  可以通过扫描器在本地指定路径进行扫描获得    功能暂时未实现   HelpUntil.byteConver2(txt, i)
	  
	  //解析这个路径字符串      
	  String testsus=infilename.substring(infilename.lastIndexOf("/")+1, infilename.length());
	  String DongName=(testsus.substring(0, testsus.lastIndexOf(".")));
	  //装载这个指定文件   按行读取   使用嵌套集合进行获取？
	  List<List<String>> txt=HelpUntil.readeTxt(infilename);
	  
	  //定义全局变量
	  int plen;
	  int len;
	  int pric;
	  int scal;
	  
	  int offset=0;
	  int poffset=0;
	  //*****************************************上面为变量定义、接收阶段
	  
	  
	  
	  //********************************************xml结构建立
    //1. 构造空的Document
    Document doc = DocumentHelper.createDocument();
//    doc.setText("/</!DOCTYPE POWERMART SYSTEM /'powrmart.dtd/'/>");
    doc.addDocType("POWERMART", null, "powrmart.dtd");
//    doc.normalize();
    
    
    //2. 构造根元素
    Element rootElmt = doc.addElement("POWERMART");
    //增加属性值   先进行生成 不考虑灵活性
    rootElmt.addAttribute("CREATION_DATE","05/20/2016 15:09:23");
    rootElmt.addAttribute("REPOSITORY_VERSION","181.90");
    
    //3. 递归构造子元素
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
      sourceElmt.addAttribute("DATABASETYPE", "Microsoft SQL Server");
      sourceElmt.addAttribute("DBDNAME", "SQL_Stage");
      sourceElmt.addAttribute("DESCRIPTION", "");
      
      //name属性是通过  输入参数获得的 	DongName 是根据扫描指定文件获得绝对路径进行字符串截取获取的.txt后缀的文件名称
      sourceElmt.addAttribute("NAME", DongName);//动态参数 
      
      sourceElmt.addAttribute("OBJECTVERSION", "1");
      sourceElmt.addAttribute("OWNERNAME", "dbo");
      sourceElmt.addAttribute("VERSIONNUMBER", "1");
      
      //增加  SOURCEFIELD 标签    这里边应该增加一个循环
      
      for(int i=0;i<txt.size();i++){
	      //从工具类获取集合  初始化出来
	      Map<String, String> paramMap=HelpUntil.byteConver(txt,i);
	      Element sourcefieldElmt = sourceElmt.addElement("SOURCEFIELD");
	      //FOLDER标签增加属性值  属性值是固定的   根据一个txt或者cfg配置文件 进行生成属性及属性的值   (需要进行一系列的判断)  
	      sourcefieldElmt.addAttribute("BUSINESSNAME", "");
	      
	      
	      //字段类型的不同 
	//      sourcefieldElmt.addAttribute("DATATYPE", HelpUntil.byteConver(txt.get(i).get(1).toString()).get("filedtype"));
	      sourcefieldElmt.addAttribute("DATATYPE", paramMap.get("filedtype"));
	      
	      //转换成infoematic的数据类型  属性赋值的时候调用一个工具类的方法		byteConver
	      sourcefieldElmt.addAttribute("DESCRIPTION", "");
	      
	      //这边是顺序生成  从1 开始就行	这边使用  循环参数 i 进行 动态值的改变
	      sourcefieldElmt.addAttribute("FIELDNUMBER", ""+(i+1));
	      
	      
	      sourcefieldElmt.addAttribute("FIELDPROPERTY", "0");
	      sourcefieldElmt.addAttribute("FIELDTYPE", "ELEMITEM");
	      sourcefieldElmt.addAttribute("HIDDEN", "NO");
	      sourcefieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
	      if(i==0){
		      sourcefieldElmt.addAttribute("KEYTYPE", "PRIMARY KEY");
	      }
	      sourcefieldElmt.addAttribute("LENGTH", paramMap.get("len"));
	      
	      sourcefieldElmt.addAttribute("LEVEL", "0");
	      sourcefieldElmt.addAttribute("NAME", paramMap.get("name"));
	      sourcefieldElmt.addAttribute("NULLABLE", paramMap.get("nullable"));
	      sourcefieldElmt.addAttribute("OCCURS", "0");
	      sourcefieldElmt.addAttribute("OFFSET", "0");
	      if(i!=0){
	    	  offset=Integer.valueOf(HelpUntil.byteConver(txt,i-1).get("len"))+offset;//上一步的offset值  本次使用
	    	  sourcefieldElmt.addAttribute("OFFSET", String.valueOf((offset)));
	      }
	      
	      sourcefieldElmt.addAttribute("PHYSICALLENGTH", paramMap.get("plen"));
	      sourcefieldElmt.addAttribute("PHYSICALOFFSET", "0");
	      if(i!=0){
	    	  poffset=Integer.valueOf(HelpUntil.byteConver(txt,i-1).get("plen"))+poffset;//上一步的offset值  本次使用
	    	  sourcefieldElmt.addAttribute("PHYSICALOFFSET", String.valueOf((poffset)));
	      }
	      sourcefieldElmt.addAttribute("PICTURETEXT", "");
	      sourcefieldElmt.addAttribute("PRECISION", paramMap.get("pric"));
	      sourcefieldElmt.addAttribute("SCALE", paramMap.get("scal"));
	      sourcefieldElmt.addAttribute("USAGE_FLAGS", "");
//	      offset=offset;
      }
      
      
      
      //这里需要根据配置文件字段的数量进行循环读取，然后根据配置文件进行字段类型的判断进行不同的处理
      
      
      //SOURCE  标签的同级子标签  TARGET
      Element targetElmt = folderElmt.addElement("TARGET");
      // target 标签增加属性 
      targetElmt.addAttribute("BUSINESSNAME", "");
      targetElmt.addAttribute("CONSTRAINT", "");
      targetElmt.addAttribute("DATABASETYPE", "Flat File");
      targetElmt.addAttribute("DESCRIPTION", "");
      targetElmt.addAttribute("NAME", "f_"+DongName);
      targetElmt.addAttribute("OBJECTVERSION", "1");
      targetElmt.addAttribute("TABLEOPTIONS", "");
      targetElmt.addAttribute("VERSIONNUMBER", "1");
      
      // TARGET 标签下面的  FLATFILE 子标签
      Element flatfileElmt = targetElmt.addElement("FLATFILE");
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
      flatfileElmt.addAttribute("STRIPTRAILINGBLANKS", "NO");
      
      
      //TARGET 标签下面的  TARGETFIELD 子标签   多个同级标签  通过循环进行生成   targetfield
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap2=HelpUntil.byteConver2(txt,i);
	      Element targetfieldElmt = targetElmt.addElement("TARGETFIELD");
	      targetfieldElmt.addAttribute("BUSINESSNAME", "");
	      targetfieldElmt.addAttribute("DATATYPE", paramMap2.get("filedtype"));
	      targetfieldElmt.addAttribute("DESCRIPTION", "");
	      targetfieldElmt.addAttribute("FIELDNUMBER", ""+(i+1));
	      targetfieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
	      targetfieldElmt.addAttribute("NAME", paramMap2.get("name"));
	      targetfieldElmt.addAttribute("NULLABLE", paramMap2.get("nullable"));
	      targetfieldElmt.addAttribute("PICTURETEXT", "");
	      targetfieldElmt.addAttribute("PRECISION",  paramMap2.get("pric"));
	      targetfieldElmt.addAttribute("SCALE",  paramMap2.get("scal"));
	      if(i==txt.size()-1){
		      for(int d=1;d<4;d++){
			      Element targetfieldGDElmt = targetElmt.addElement("TARGETFIELD");
			      if(d==1){
			    	  targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "string");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "BATCH_ID");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "11");
				      targetfieldGDElmt.addAttribute("SCALE","0");
			      }else if(d==2){
				      
				      targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "string");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "MD5_KEY");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "32");
				      targetfieldGDElmt.addAttribute("SCALE","0");
			      }else if(d==3){
			    	  targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "string");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "HHF");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "10");
				      targetfieldGDElmt.addAttribute("SCALE","0");
			      }
		      }
	      }
      }
      
      //TARGET 标签下面的  TABLEATTRIBUTE 子标签   多个同级标签  通过循环进行生成   tableattribute
      for(int i=0;i<4;i++){
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
      }
      //SOURCE  标签的同级子标签  MAPPING   mapping
      Element mappingElmt = folderElmt.addElement("MAPPING");
      // MAPPING 标签增加属性 
      mappingElmt.addAttribute("DESCRIPTION", "");
      mappingElmt.addAttribute("ISVALID", "YES");
      mappingElmt.addAttribute("NAME", "m_s_e_"+DongName);
      mappingElmt.addAttribute("OBJECTVERSION", "1");
      mappingElmt.addAttribute("VERSIONNUMBER", "1");
      
      //MAPPING 标签下面的  TRANSFORMATION 子标签   多个同级标签  通过循环进行生成   transformation    ********
      Element transformationElmt = mappingElmt.addElement("TRANSFORMATION");
      transformationElmt.addAttribute("DESCRIPTION", "");
      transformationElmt.addAttribute("NAME", "SQ_"+DongName);
      transformationElmt.addAttribute("OBJECTVERSION", "1");
      transformationElmt.addAttribute("REUSABLE", "NO");
      transformationElmt.addAttribute("TYPE", "Source Qualifier");
      transformationElmt.addAttribute("VERSIONNUMBER", "1");
      
      
      //MAPPING 标签下面的  TRANSFORMFIELD 子标签   多个同级标签  通过循环进行生成   transformfield
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil.byteConver3(txt,i);
	      Element transformfieldElmt = transformationElmt.addElement("TRANSFORMFIELD");
	      transformfieldElmt.addAttribute("DATATYPE", paramMap3.get("filedtype"));
	      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
	      transformfieldElmt.addAttribute("DESCRIPTION", "");
	      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
	      transformfieldElmt.addAttribute("PICTURETEXT", "");
	      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
	      transformfieldElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	      transformfieldElmt.addAttribute("SCALE", paramMap3.get("scal"));
      }
      //MAPPING 标签下面的  TABLEATTRIBUTE 子标签   多个同级标签  通过循环进行生成   tableattribute  
      for(int i=1;i<12;i++){
    	  Element tableattributeSqlMapElmt = transformationElmt.addElement("TABLEATTRIBUTE");
    	  if(i==1){
	          tableattributeSqlMapElmt.addAttribute("NAME", "Sql Query");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "SELECT LA_ZPCMPF.HIST_ID, LA_ZPCMPF.ZACTCODE, LA_ZPCMPF.BILLFREQ, LA_ZPCMPF.CRTABLE, LA_ZPCMPF.CNTTYPE, LA_ZPCMPF.ZPLANDESC, LA_ZPCMPF.ETL_DATATIME, LA_ZPCMPF.ETL_DATATYPE, LA_ZPCMPF.DT_DATATIME, LA_ZPCMPF.SRCEBUS FROM LA_ZPCMPF WHERE ETL_DATATIME=$$START_TIME AND ETL_DATATIME&lt;=$$END_TIME");
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
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Select Distinct");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "NO");
    	  }else if(i==7){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Is Partitionable");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "NO");
    	  }else if(i==8){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Pre SQL");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==9){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Post SQL");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "");
    	  }else if(i==10){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Output is deterministic");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "NO");
    	  }else if(i==11){
    		  tableattributeSqlMapElmt.addAttribute("NAME", "Output is repeatable");
	          tableattributeSqlMapElmt.addAttribute("VALUE", "Never");
    	  }
      }
      
      //手动生成的  TRANSFORMATION 标签
      Element transformation2Elmt = mappingElmt.addElement("TRANSFORMATION");
      transformation2Elmt.addAttribute("DESCRIPTION", "");
      transformation2Elmt.addAttribute("NAME", "EXPTRANS");
      transformation2Elmt.addAttribute("OBJECTVERSION", "1");
      transformation2Elmt.addAttribute("REUSABLE", "NO");
      transformation2Elmt.addAttribute("TYPE", "Expression");
      transformation2Elmt.addAttribute("VERSIONNUMBER", "1");
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil.byteConver3(txt,i);
	      Element transformfieldElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
	      transformfieldElmt.addAttribute("DATATYPE", paramMap3.get("filedtype"));
	      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
	      transformfieldElmt.addAttribute("DESCRIPTION", "");
	      transformfieldElmt.addAttribute("EXPRESSION", paramMap3.get("name"));
	      transformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
	      transformfieldElmt.addAttribute("PICTURETEXT", "");
	      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
	      transformfieldElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	      transformfieldElmt.addAttribute("SCALE", paramMap3.get("scal"));
      }
      for(int i=1;i<4;i++){
	      Element transformfieldSDElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
	      transformfieldSDElmt.addAttribute("DATATYPE", "string");
//	      transformfieldSDElmt.addAttribute("DEFAULTVALUE","ERROR(&apos;transformation error&apos;)===========").setAttributeValue("ee", "test");;
//	      DOMCDATA dd=new DOMCDATA("ERROR(&apos;transformation error&apos;)");
	      
	      /*transformfieldSDElmt.addAttribute("DEFAULTVALUE","ERROR(&apos;transformation error&apos;)");//原始的属性备份
*///	      transformfieldSDElmt.addAttribute("DEFAULTVALUE=======","<![CDATA[&apos;]]>");
	      //使用转义过后的字符  进行替换    转义字符java转换xml的时候没法控制 (以后再想办法)
	      transformfieldSDElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
	      
	      
	      transformfieldSDElmt.addAttribute("DESCRIPTION", "");
	      if(i==1){
	    	  transformfieldSDElmt.addAttribute("EXPRESSION", "$$BATCH_ID");
	      }else if(i==2){
	    	  transformfieldSDElmt.addAttribute("EXPRESSION", "MD5(TO_CHAR(HIST_ID))");
	      }else{
	    	  /*transformfieldSDElmt.addAttribute("EXPRESSION", "&apos;HUAN HANG&apos;");*/
	    	  transformfieldSDElmt.addAttribute("EXPRESSION", "'HUAN HANG'");
	      }
	      transformfieldSDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	      if(i==1){
	    	  transformfieldSDElmt.addAttribute("NAME","BATCH_ID");
	      }else if(i==2){
	    	  transformfieldSDElmt.addAttribute("NAME","MD5_KEY");
	      }else{
	    	  transformfieldSDElmt.addAttribute("NAME","HHF");
	      }
	      transformfieldSDElmt.addAttribute("PICTURETEXT", "");
	      transformfieldSDElmt.addAttribute("PORTTYPE", "OUTPUT");
	      if(i==1){
	    	  transformfieldSDElmt.addAttribute("PRECISION", "11");
	      }else if(i==2){
	    	  transformfieldSDElmt.addAttribute("PRECISION", "32");
	      }else{
	    	  transformfieldSDElmt.addAttribute("PRECISION", "10");
	      }
	      transformfieldSDElmt.addAttribute("SCALE", "0");
      }
      Element tableattributeSDMapElmt = transformation2Elmt.addElement("TABLEATTRIBUTE");
      tableattributeSDMapElmt.addAttribute("NAME", "Tracing Level");
      tableattributeSDMapElmt.addAttribute("VALUE", "Normal");
      
      //INSTANCE 标签  进行判断  是否含有子标签   INSTANCE标签跟  TRANSFORMATION标签同级   instance
      //MAPPING 标签下面的  INSTANCE 子标签   多个同级标签  通过循环进行生成   instance    ********
      for(int i=1;i<5;i++){
	      Element instanceElmt = mappingElmt.addElement("INSTANCE");
	      if(i==1){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "3");
	    	  instanceElmt.addAttribute("NAME", "f_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
	    	  instanceElmt.addAttribute("TYPE", "TARGET");
	      }else if(i==2){
	    	  instanceElmt.addAttribute("DBDNAME", "SQL_Stage");
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "1");
	    	  instanceElmt.addAttribute("NAME", DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Definition");
	    	  instanceElmt.addAttribute("TYPE", "SOURCE");
	      }else if(i==3){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "2");
	    	  instanceElmt.addAttribute("NAME", "SQ_"+DongName);
	    	  instanceElmt.addAttribute("REUSABLE", "NO");
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "SQ_"+DongName);
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Qualifier");
	    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
	    	  Element associated_source_instanceElmt = instanceElmt.addElement("ASSOCIATED_SOURCE_INSTANCE");
	    	  associated_source_instanceElmt.addAttribute("NAME", DongName);
	      }else if(i==4){
	    	  instanceElmt.addAttribute("DESCRIPTION", "");
	    	  instanceElmt.addAttribute("INSTANCEID", "4");
	    	  instanceElmt.addAttribute("NAME", "EXPTRANS");
	    	  instanceElmt.addAttribute("REUSABLE", "NO");
	    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS");
	    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
	    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
	      }
	      
	      //这边需要根据配置文件进行判断   是否需要生成子标签  ASSOCIATED_SOURCE_INSTANCE  associated_source_instance
      }
      
      //MAPPING 标签下面的  CONNECTOR 子标签   多个同级标签  通过循环进行生成   connector    ********
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil.byteConver3(txt,i);
	      Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
	      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));//
	      connectorElmt.addAttribute("TOINSTANCE", "f_"+DongName);
	      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
      }
      //手工生成  3个同类型标签
      for(int i=1;i<4;i++){
	      Element connectorSDElmt = mappingElmt.addElement("CONNECTOR");
	      if(i==1){
	    	  connectorSDElmt.addAttribute("FROMFIELD", "BATCH_ID");
	    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
	    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    	  connectorSDElmt.addAttribute("TOFIELD", "BATCH_ID");
	    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName);
	    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      }else if(i==2){
	    	  connectorSDElmt.addAttribute("FROMFIELD", "MD5_KEY");
	    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
	    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    	  connectorSDElmt.addAttribute("TOFIELD", "MD5_KEY");
	    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName);
	    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      }else if(i==3){
	    	  connectorSDElmt.addAttribute("FROMFIELD", "HHF");
	    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
	    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    	  connectorSDElmt.addAttribute("TOFIELD", "HHF");
	    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName);
	    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      }
      }
      
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil.byteConver3(txt,i);
	      Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("FROMINSTANCE", DongName);
	      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
	      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
	      connectorElmt.addAttribute("TOINSTANCE", "SQ_"+DongName);
	      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
      }
      
      for(int i=0;i<txt.size();i++){
    	  Map<String, String> paramMap3=HelpUntil.byteConver3(txt,i);
	      Element connector2Elmt = mappingElmt.addElement("CONNECTOR");
	      connector2Elmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	      connector2Elmt.addAttribute("FROMINSTANCE", "SQ_"+DongName);
	      connector2Elmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
	      connector2Elmt.addAttribute("TOFIELD", paramMap3.get("name"));
	      connector2Elmt.addAttribute("TOINSTANCE", "EXPTRANS");
	      connector2Elmt.addAttribute("TOINSTANCETYPE", "Expression");
      }
      
      
      //MAPPING 标签下面的  TARGETLOADORDER 子标签   多个同级标签  通过循环进行生成   targetloadorder    ********
      Element targetloadorderElmt = mappingElmt.addElement("TARGETLOADORDER");
      targetloadorderElmt.addAttribute("ORDER", "1");
      targetloadorderElmt.addAttribute("TARGETINSTANCE", "f_"+DongName);
      
      //MAPPING 标签下面的  MAPPINGVARIABLE 子标签   多个同级标签  通过循环进行生成   mappingvariable    ********
      for(int i=1;i<4;i++){
	      Element mappingvariableElmt = mappingElmt.addElement("MAPPINGVARIABLE");
	      mappingvariableElmt.addAttribute("DATATYPE", "string");
	      mappingvariableElmt.addAttribute("DEFAULTVALUE", "");
	      mappingvariableElmt.addAttribute("DESCRIPTION", "");
	      mappingvariableElmt.addAttribute("ISEXPRESSIONVARIABLE", "NO");
	      mappingvariableElmt.addAttribute("ISPARAM", "YES");
	      mappingvariableElmt.addAttribute("NAME", "$$BATCH_ID");
	      mappingvariableElmt.addAttribute("PRECISION", "100");
	      mappingvariableElmt.addAttribute("SCALE", "0");
	      mappingvariableElmt.addAttribute("USERDEFINED", "YES");
	      if(i==2){
	    	  mappingvariableElmt.addAttribute("NAME", "$$START_TIME");
	      }else if(i==3){
	    	  mappingvariableElmt.addAttribute("NAME", "$$END_TIME");
	      }
      }
    //MAPPING 标签下面的  ERPINFO 子标签   多个同级标签  通过循环进行生成   erpinfo    ********
      Element erpinfoElmt = mappingElmt.addElement("ERPINFO");//属性暂时未知
    //4. 输出
      HelpUntil.outputXml(doc, outfilename);
  }
}