import java.util.List;

//package txt2xml;

public class StandardJob1 {

	  public static void main(java.lang.String[] args) throws Exception {
		  String in="LA_ZPCMPF.txt";
		  String out="out.xml";
//		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+args[0];
//		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+args[1];D:\1txt2xml
		  java.lang.String infiledname="D:/1txt2xml/"+in;
		  java.lang.String outfiledname="D:/1txt2xml/"+out;
		  writeBook(outfiledname,infiledname);
	  }
	  public static void writeBook(String outfilename,String infilename) throws java.io.IOException{
		  java.lang.String lastsus=infilename.substring(infilename.lastIndexOf("/")+1, infilename.length());
		  java.lang.String TableName=(lastsus.substring(0, lastsus.lastIndexOf(".")));
		  List<java.util.List<java.lang.String>> txt=readeTxt(infilename);
		  
		  int offset=0;
		  int poffset=0;
		  org.dom4j.Document doc = org.dom4j.DocumentHelper.createDocument();
		  doc.addDocType("POWERMART", null, "powrmart.dtd");
	    
	    
		  org.dom4j.Element rootElmt = doc.addElement("POWERMART");
	    rootElmt.addAttribute("CREATION_DATE","05/20/2016 15:09:23");
	    rootElmt.addAttribute("REPOSITORY_VERSION","181.90");
	    
	    org.dom4j.Element bookElmt = rootElmt.addElement("REPOSITORY");
	         
	      bookElmt.addAttribute("NAME", "Rep_UAT");
	      bookElmt.addAttribute("VERSION","181");
	      bookElmt.addAttribute("CODEPAGE","UTF-8");
	      bookElmt.addAttribute("DATABASETYPE","Microsoft SQL Server");
	     
	      org.dom4j.Element folderElmt = bookElmt.addElement("FOLDER");
	      folderElmt.addAttribute("NAME", "DI_MIS");
	      folderElmt.addAttribute("GROUP", "");
	      folderElmt.addAttribute("OWNER", "Administrator");
	      folderElmt.addAttribute("SHARED", "NOTSHARED");
	      folderElmt.addAttribute("DESCRIPTION", "");
	      folderElmt.addAttribute("PERMISSIONS", "rwx---r--");
	      folderElmt.addAttribute("UUID", "d30d8f0f-df3b-4e61-ab71-7b38629c3248");
	      
	      org.dom4j.Element sourceElmt = folderElmt.addElement("SOURCE");
	      sourceElmt.addAttribute("BUSINESSNAME", "");
	      sourceElmt.addAttribute("DATABASETYPE", "Microsoft SQL Server");
	      sourceElmt.addAttribute("DBDNAME", "SQL_Stage");
	      sourceElmt.addAttribute("DESCRIPTION", "");
	      
	      sourceElmt.addAttribute("NAME", TableName);
	      
	      sourceElmt.addAttribute("OBJECTVERSION", "1");
	      sourceElmt.addAttribute("OWNERNAME", "dbo");
	      sourceElmt.addAttribute("VERSIONNUMBER", "3");
	      
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap=byteConver(txt,i);
	    	  org.dom4j.Element sourcefieldElmt = sourceElmt.addElement("SOURCEFIELD");
		      sourcefieldElmt.addAttribute("BUSINESSNAME", "");
		      
		      
		      sourcefieldElmt.addAttribute("DATATYPE", paramMap.get("filedtype"));
		      
		      sourcefieldElmt.addAttribute("DESCRIPTION", "");
		      
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
		    	  offset=java.lang.Integer.valueOf(byteConver(txt,i-1).get("len"))+offset;
		    	  sourcefieldElmt.addAttribute("OFFSET", String.valueOf((offset)));
		      }
		      
		      sourcefieldElmt.addAttribute("PHYSICALLENGTH", paramMap.get("plen"));
		      sourcefieldElmt.addAttribute("PHYSICALOFFSET", "0");
		      if(i!=0){
		    	  poffset=java.lang.Integer.valueOf(byteConver(txt,i-1).get("plen"))+poffset;
		    	  sourcefieldElmt.addAttribute("PHYSICALOFFSET", String.valueOf((poffset)));
		      }
		      sourcefieldElmt.addAttribute("PICTURETEXT", "");
		      sourcefieldElmt.addAttribute("PRECISION", paramMap.get("pric"));
		      sourcefieldElmt.addAttribute("SCALE", paramMap.get("scal"));
		      sourcefieldElmt.addAttribute("USAGE_FLAGS", "");
	      }
	      
	      
	      
	      
	      
	      org.dom4j.Element targetElmt = folderElmt.addElement("TARGET");
	      targetElmt.addAttribute("BUSINESSNAME", "");
	      targetElmt.addAttribute("CONSTRAINT", "");
	      targetElmt.addAttribute("DATABASETYPE", "Flat File");
	      targetElmt.addAttribute("DESCRIPTION", "");
	      targetElmt.addAttribute("NAME", "f_"+TableName);
	      targetElmt.addAttribute("OBJECTVERSION", "1");
	      targetElmt.addAttribute("TABLEOPTIONS", "");
	      targetElmt.addAttribute("VERSIONNUMBER", "3");
	      
	      org.dom4j.Element flatfileElmt = targetElmt.addElement("FLATFILE");
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
	      
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap2=byteConver2(txt,i);
	    	  org.dom4j.Element targetfieldElmt = targetElmt.addElement("TARGETFIELD");
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
		      if(i==txt.size()-1){//---------------------------------------------------------------------------
			      for(int d=1;d<4;d++){
			    	  org.dom4j.Element targetfieldGDElmt = targetElmt.addElement("TARGETFIELD");
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
	      
	      for(int i=0;i<4;i++){
	    	  org.dom4j.Element tableattributeElmt = targetElmt.addElement("TABLEATTRIBUTE");
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
	      org.dom4j.Element mappingElmt = folderElmt.addElement("MAPPING");
	      mappingElmt.addAttribute("DESCRIPTION", "");
	      mappingElmt.addAttribute("ISVALID", "YES");
	      mappingElmt.addAttribute("NAME", "m_s_e_"+TableName);
	      mappingElmt.addAttribute("OBJECTVERSION", "1");
	      mappingElmt.addAttribute("VERSIONNUMBER", "4");
	      
	      org.dom4j.Element transformationElmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationElmt.addAttribute("DESCRIPTION", "");
	      transformationElmt.addAttribute("NAME", "SQ_"+TableName);
	      transformationElmt.addAttribute("OBJECTVERSION", "1");
	      transformationElmt.addAttribute("REUSABLE", "NO");
	      transformationElmt.addAttribute("TYPE", "Source Qualifier");
	      transformationElmt.addAttribute("VERSIONNUMBER", "3");
	      
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element transformfieldElmt = transformationElmt.addElement("TRANSFORMFIELD");
		      transformfieldElmt.addAttribute("DATATYPE", paramMap3.get("filedtype"));
		      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
		      transformfieldElmt.addAttribute("DESCRIPTION", "");
		      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
		      transformfieldElmt.addAttribute("PICTURETEXT", "");
		      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
		      transformfieldElmt.addAttribute("PRECISION", paramMap3.get("pric"));
		      transformfieldElmt.addAttribute("SCALE", paramMap3.get("scal"));
	      }
	      for(int i=1;i<12;i++){
	    	  org.dom4j.Element tableattributeSqlMapElmt = transformationElmt.addElement("TABLEATTRIBUTE");
	    	  if(i==1){
		          tableattributeSqlMapElmt.addAttribute("NAME", "Sql Query");
		          java.lang.String sql=null;
		          java.lang.String select="SELECT ";
		          java.lang.String zhong=null;
		          for(int tx=0;tx<txt.size();tx++){
						zhong=TableName+"."+txt.get(tx).get(0)+",";
						if(tx==txt.size()-1){
							zhong=TableName+txt.get(tx).get(0);
						}
						select=select+zhong;
					}
		          sql=select+" from "+TableName+" where ETL_DATATIME=$$START_TIME AND ETL_DATATIME"+"<"+""+"=$$END_TIME";
		          tableattributeSqlMapElmt.addAttribute("VALUE",sql);
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
	      
	      org.dom4j.Element transformation2Elmt = mappingElmt.addElement("TRANSFORMATION");
	      transformation2Elmt.addAttribute("DESCRIPTION", "");
	      transformation2Elmt.addAttribute("NAME", "EXPTRANS");
	      transformation2Elmt.addAttribute("OBJECTVERSION", "1");
	      transformation2Elmt.addAttribute("REUSABLE", "NO");
	      transformation2Elmt.addAttribute("TYPE", "Expression");
	      transformation2Elmt.addAttribute("VERSIONNUMBER", "3");
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element transformfieldElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
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
	    	  org.dom4j.Element transformfieldSDElmt = transformation2Elmt.addElement("TRANSFORMFIELD");
		      transformfieldSDElmt.addAttribute("DATATYPE", "string");
		      transformfieldSDElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
		      
		      
		      transformfieldSDElmt.addAttribute("DESCRIPTION", "");
		      if(i==1){
		    	  transformfieldSDElmt.addAttribute("EXPRESSION", "$$BATCH_ID");
		      }else if(i==2){
		    	  transformfieldSDElmt.addAttribute("EXPRESSION", "MD5(TO_CHAR(HIST_ID))");
		      }else{
		    	  transformfieldSDElmt.addAttribute("EXPRESSION", "'HUAN HANG'");//-------------
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
	      org.dom4j.Element tableattributeSDMapElmt = transformation2Elmt.addElement("TABLEATTRIBUTE");
	      tableattributeSDMapElmt.addAttribute("NAME", "Tracing Level");
	      tableattributeSDMapElmt.addAttribute("VALUE", "Normal");
	      
	      for(int i=1;i<5;i++){
	    	  org.dom4j.Element instanceElmt = mappingElmt.addElement("INSTANCE");
		      if(i==1){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "3");
		    	  instanceElmt.addAttribute("NAME", "f_"+TableName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+TableName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
		    	  instanceElmt.addAttribute("TYPE", "TARGET");
		      }else if(i==2){
		    	  instanceElmt.addAttribute("DBDNAME", "SQL_Stage");
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "1");
		    	  instanceElmt.addAttribute("NAME", TableName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", TableName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Definition");
		    	  instanceElmt.addAttribute("TYPE", "SOURCE");
		      }else if(i==3){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "2");
		    	  instanceElmt.addAttribute("NAME", "SQ_"+TableName);
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "SQ_"+TableName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Qualifier");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		    	  org.dom4j.Element associated_source_instanceElmt = instanceElmt.addElement("ASSOCIATED_SOURCE_INSTANCE");
		    	  associated_source_instanceElmt.addAttribute("NAME", TableName);
		      }else if(i==4){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "4");
		    	  instanceElmt.addAttribute("NAME", "EXPTRANS");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }
		      
	      }
	      org.dom4j.Element connectorgd1Elmt = mappingElmt.addElement("CONNECTOR");
	      connectorgd1Elmt.addAttribute("FROMFIELD", "HHF");
	      connectorgd1Elmt.addAttribute("FROMINSTANCE", "EXPTRANS");
	      connectorgd1Elmt.addAttribute("FROMINSTANCETYPE", "Expression");
	      connectorgd1Elmt.addAttribute("TOFIELD", "HHF");
	      connectorgd1Elmt.addAttribute("TOINSTANCE", "f_"+TableName);
	      connectorgd1Elmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));//
		      connectorElmt.addAttribute("TOINSTANCE", "f_"+TableName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      }
	      for(int i=1;i<3;i++){
	    	  org.dom4j.Element connectorSDElmt = mappingElmt.addElement("CONNECTOR");
		      if(i==1){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "BATCH_ID");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "BATCH_ID");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+TableName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==2){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+TableName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==3){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "HHF");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "HHF");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+TableName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", TableName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "SQ_"+TableName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connector2Elmt = mappingElmt.addElement("CONNECTOR");
		      connector2Elmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connector2Elmt.addAttribute("FROMINSTANCE", "SQ_"+TableName);
		      connector2Elmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
		      connector2Elmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connector2Elmt.addAttribute("TOINSTANCE", "EXPTRANS");
		      connector2Elmt.addAttribute("TOINSTANCETYPE", "Expression");
	      }
	      
	      
	      org.dom4j.Element targetloadorderElmt = mappingElmt.addElement("TARGETLOADORDER");
	      targetloadorderElmt.addAttribute("ORDER", "1");
	      targetloadorderElmt.addAttribute("TARGETINSTANCE", "f_"+TableName);
	      
	      for(int i=1;i<4;i++){
	    	  org.dom4j.Element mappingvariableElmt = mappingElmt.addElement("MAPPINGVARIABLE");
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
	      org.dom4j.Element erpinfoElmt = mappingElmt.addElement("ERPINFO");
	      outputXml(doc, outfilename);
	  }
  	  public static java.util.Map<java.lang.String, java.lang.String> byteConver(java.util.List<java.util.List<java.lang.String>> txt,int i){	
  		  
  		java.lang.String type=txt.get(i).get(1).toString();
  		System.out.println("type:"+type);
  		java.util.Map<java.lang.String, java.lang.String> typemap=new java.util.HashMap<java.lang.String, java.lang.String>();
		  
		  java.lang.String oncetype=txt.get(i).get(0);
		  System.out.println("oncetype:"+oncetype);
		  typemap.put("name",oncetype);
		  
		  if(txt.get(i).size()>=3){
			  java.lang.String threetype=txt.get(i).get(2).toString();
			  if(threetype!=null&&!threetype.equals("")){
			  typemap.put("nullable", "NOTNULL");
			  }
		  }else{
			  typemap.put("nullable", "NULL");
		  }
		  if(type!=""&&type!=null){
			  int pan=type.lastIndexOf("(");
			  java.lang.String filedtype=null;
			  java.lang.String endtype=null;
			  if(pan!=-1){
				  filedtype=type.substring(0, type.lastIndexOf("("));
				  endtype=type.substring(type.lastIndexOf("("),type.length());
			  }else{
				  filedtype=type.substring(0, type.length());
			  }
			  typemap.put("filedtype", type);
	            typemap.put("scal", "0");
			  if(filedtype.equals("DATE")||filedtype.equals("DATETIME")){
				  	type="datetime";
		            typemap.put("filedtype", type);
		            typemap.put("plen", "23");
		            typemap.put("len", "19");
		            typemap.put("pric", "23");
		            typemap.put("scal", "3");
			  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
				  type="decimal";
				  typemap.put("filedtype", type);
				  int index=endtype.indexOf(",");
				  	if(index==-1){
				  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
				  	}else{
				  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
			            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
				  	}
		            typemap.put("len", java.lang.String.valueOf((java.lang.Integer.valueOf(typemap.get("plen")).intValue()+2)));
		            typemap.put("pric", typemap.get("plen"));
			  }else if(filedtype.equals("VARCHAR")){
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
			  }else if(filedtype.equals("NVARCHAR")){
				  type="nvarchar";
				  typemap.put("filedtype", type);
				  typemap.put("plen", endtype.substring(1,endtype.length()-1));
				  typemap.put("len", "0");
				  typemap.put("pric", typemap.get("plen"));
			  }
		  }
		  return typemap;
	  }
  	  
  	public static java.util.Map<java.lang.String, java.lang.String> byteConver2(java.util.List<java.util.List<java.lang.String>> txt,int i){	
  		java.lang.String type=txt.get(i).get(1).toString();
  		java.util.Map<java.lang.String, java.lang.String> typemap=new java.util.HashMap<java.lang.String, java.lang.String>();
		  
  		java.lang.String oncetype=txt.get(i).get(0);
		  typemap.put("name",oncetype);
		  if(txt.get(i).size()>=3){
			  java.lang.String threetype=txt.get(i).get(2).toString();
			  if(threetype!=null&&!threetype.equals("")){
			  typemap.put("nullable", "NOTNULL");
			  }
		  }else{
			  typemap.put("nullable", "NULL");
		  }
		  typemap.put("nullable", "NULL");
		  if(type!=""&&type!=null){
			  int pan=type.lastIndexOf("(");
			  java.lang.String filedtype=null;
			  java.lang.String endtype=null;
			  if(pan!=-1){
				  filedtype=type.substring(0, type.lastIndexOf("("));
				  endtype=type.substring(type.lastIndexOf("("),type.length());
			  }else{
				  filedtype=type.substring(0, type.length());
			  }
			  typemap.put("filedtype", type);
	            typemap.put("scal", "0");
			  if(filedtype.equals("DATE")||filedtype.equals("DATETIME")){
				  	type="datetime";
		            typemap.put("filedtype", type);
		            typemap.put("plen", "29");
		            typemap.put("len", "29");
		            typemap.put("pric", "29");
		            typemap.put("scal", "9");
			  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
				  type="number";
				  typemap.put("filedtype", type);
				  int index=endtype.indexOf(",");
				  	if(index==-1){
				  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
				  	}else{
				  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
			            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
				  	}
		            typemap.put("len", String.valueOf((java.lang.Integer.valueOf(typemap.get("plen")).intValue()+2)));
		            typemap.put("pric", typemap.get("plen"));
			  }else if(filedtype.equals("VARCHAR")||filedtype.equals("CHAR")){
				  type="string";
				  typemap.put("filedtype", type);
				  typemap.put("plen", endtype.substring(1,endtype.length()-1));
				  typemap.put("len", "0");
				  typemap.put("pric", typemap.get("plen"));
			  }else if(filedtype.equals("NCHAR")||filedtype.equals("NVARCHAR")){
				  type="nstring";
				  typemap.put("filedtype", type);
				  typemap.put("plen", endtype.substring(1,endtype.length()-1));
				  typemap.put("len", "0");
				  typemap.put("pric", typemap.get("plen"));
			  }
		  }
		  return typemap;
	  }
  	  
	  	  public static java.util.Map<java.lang.String, java.lang.String> byteConver3(java.util.List<java.util.List<java.lang.String>> txt,int i){	
	  		  java.lang.String type=txt.get(i).get(1).toString();
	  		  java.util.Map<java.lang.String, java.lang.String> typemap=new java.util.HashMap<java.lang.String, java.lang.String>();
			  
	  		java.lang.String oncetype=txt.get(i).get(0);
			  typemap.put("name",oncetype);
			  if(txt.get(i).size()>=3){
				  java.lang.String threetype=txt.get(i).get(2).toString();
				  if(threetype!=null&&!threetype.equals("")){
				  typemap.put("nullable", "NOTNULL");
				  }
			  }else{
				  typemap.put("nullable", "NULL");
			  }
			  typemap.put("nullable", "NULL");
			  if(type!=""&&type!=null){
				  int pan=type.lastIndexOf("(");
				  java.lang.String filedtype=null;
				  java.lang.String endtype=null;
				  if(pan!=-1){
					  filedtype=type.substring(0, type.lastIndexOf("("));
					  endtype=type.substring(type.lastIndexOf("("),type.length());
				  }else{
					  filedtype=type.substring(0, type.length());
				  }
				  typemap.put("filedtype", type);
		            typemap.put("scal", "0");
				  if(filedtype.equals("DATE")||filedtype.equals("DATETIME")){
					  	type="date/time";
			            typemap.put("filedtype", type);
			            typemap.put("plen", "29");
			            typemap.put("len", "29");
			            typemap.put("pric", "29");
			            typemap.put("scal", "9");
				  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
					  type="decimal";
					  typemap.put("filedtype", type);
					  int index=endtype.indexOf(",");
					  	if(index==-1){
					  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  	}else{
					  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
				            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
					  	}
			            typemap.put("len", java.lang.String.valueOf((java.lang.Integer.valueOf(typemap.get("plen")).intValue()+2)));
			            typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("CHAR")||filedtype.equals("VARCHAR")){
					  type="string";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }else if(filedtype.equals("NCHAR")||filedtype.equals("NVARCHAR")){
					  type="nstring";
					  typemap.put("filedtype", type);
					  typemap.put("plen", endtype.substring(1,endtype.length()-1));
					  typemap.put("len", "0");
					  typemap.put("pric", typemap.get("plen"));
				  }
				  
			  }
			  return typemap;
		  }
		  	  
			  public static void outputXml(org.dom4j.Document doc, java.lang.String filename) {
			    try {
			    java.io.FileWriter fw = new java.io.FileWriter(filename);
			       
			    org.dom4j.io.OutputFormat format = org.dom4j.io.OutputFormat.createPrettyPrint();
			        
			      format.setEncoding("UTF-8");
			       
			      org.dom4j.io.XMLWriter xmlWriter = new org.dom4j.io.XMLWriter(fw, format);
			      xmlWriter.write(doc);
			      xmlWriter.close(); 
			    } catch (java.io.IOException e) {
			      e.printStackTrace();
			    }
			     
			  }
			  
			 
			  public static java.util.List<java.util.List<java.lang.String>> readeTxt(java.lang.String filedirname) throws java.io.IOException {
					
				  java.util.List<java.util.List<java.lang.String>> txtList = new java.util.ArrayList<java.util.List<java.lang.String>>();
					
				  java.io.File filename=new java.io.File(filedirname);
				  java.io.FileReader fr = new java.io.FileReader(filename);
				  java.io.BufferedReader bf = new java.io.BufferedReader(fr);
					
					
					try {
						int id = 0;
						while (bf.ready()) {
							java.util.List<java.lang.String> tempList = new java.util.ArrayList<java.lang.String>();
							java.lang.String str = bf.readLine();
						id++;
						java.lang.String[] strs = str.split("\\|");
						
							if (strs[0] != null && !strs[0].equals("") && strs[1] != null && !strs[1].equals("")) {
								tempList.add(strs[0]);
								tempList.add(strs[1]);
								if(strs.length>=3){
									tempList.add(strs[2]);
								}
							} else {
							System.out.println("==============");
							}
							txtList.add(tempList);
						}
					} catch (Exception e) {
						System.out.println("exception");
						e.printStackTrace();
					}finally 
					{ 
						bf.close();
						fr.close();
					} 
					return txtList;
					}
}
