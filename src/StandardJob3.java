//package com.metlife.jobxml;


public class StandardJob3 {

	  public static void main(java.lang.String[] args) throws Exception {
		  
		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+args[0];
		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+args[1];
//		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+"LA_ZPCMPF.txt";
//		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+"LA_ZPCMPF.xml";
		  writeBook(outfiledname,infiledname);
	  }
	  
	  public static void writeBook(java.lang.String outfilename,java.lang.String infilename) throws java.io.IOException{
		  
		  
		  java.lang.String testsus=infilename.substring(infilename.lastIndexOf("/")+1, infilename.length());
		  java.lang.String DongName=testsus.substring(0, testsus.lastIndexOf("."));
		  java.util.List<java.util.List<java.lang.String>> txt=readeTxt(infilename);
		  
		  int offset=0;
		  int poffset=0;
		  
		  
		  
		  org.dom4j.Document doc = org.dom4j.DocumentHelper.createDocument();
	    doc.addDocType("POWERMART", null, "powrmart.dtd");
	    
	    org.dom4j.Element rootElmt = doc.addElement("POWERMART");
	    rootElmt.addAttribute("CREATION_DATE","04/12/2016 14:11:48");
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
	      sourceElmt.addAttribute("DATABASETYPE", "Flat File");
	      sourceElmt.addAttribute("DBDNAME", "Flat_File");
	      sourceElmt.addAttribute("DESCRIPTION", "");
	      
	      sourceElmt.addAttribute("NAME", "f_"+DongName);
	      
	      sourceElmt.addAttribute("OBJECTVERSION", "1");
	      sourceElmt.addAttribute("OWNERNAME", "");
	      sourceElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      org.dom4j.Element sourceflatElmt = sourceElmt.addElement("FLATFILE");
	      sourceflatElmt.addAttribute("CODEPAGE", "MS936");
	      sourceflatElmt.addAttribute("CONSECDELIMITERSASONE", "NO");
	      sourceflatElmt.addAttribute("DELIMITED", "YES");
	      sourceflatElmt.addAttribute("DELIMITERS", "||");
	      sourceflatElmt.addAttribute("ESCAPE_CHARACTER", "");
	      sourceflatElmt.addAttribute("KEEPESCAPECHAR", "YES");
	      sourceflatElmt.addAttribute("LINESEQUENTIAL", "NO");
	      sourceflatElmt.addAttribute("MULTIDELIMITERSASAND", "YES");
	      sourceflatElmt.addAttribute("NULLCHARTYPE", "ASCII");
	      sourceflatElmt.addAttribute("NULL_CHARACTER", "*");
	      sourceflatElmt.addAttribute("PADBYTES", "1");
	      sourceflatElmt.addAttribute("QUOTE_CHARACTER", "NONE");
	      sourceflatElmt.addAttribute("REPEATABLE", "NO");
	      sourceflatElmt.addAttribute("ROWDELIMITER", "10");
	      sourceflatElmt.addAttribute("SHIFTSENSITIVEDATA", "NO");
	      sourceflatElmt.addAttribute("SKIPROWS", "0");
	      sourceflatElmt.addAttribute("STRIPTRAILINGBLANKS", "NO");
	      
	      for(int i=0;i<7;i++){
	    	  org.dom4j.Element sourceElmttableattributeElmt = sourceElmt.addElement("TABLEATTRIBUTE");
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
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap=byteConver(txt,i);
		      org.dom4j.Element sourcefieldElmt = sourceElmt.addElement("SOURCEFIELD");
		      sourcefieldElmt.addAttribute("BUSINESSNAME", "");
		      
		      
		      sourcefieldElmt.addAttribute("DATATYPE", "string");
		      sourcefieldElmt.addAttribute("DESCRIPTION", "");
		      
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
		    	  offset=Integer.valueOf(byteConver(txt,i-1).get("plen"))+offset;
		    	  sourcefieldElmt.addAttribute("OFFSET", java.lang.String.valueOf((offset)));
		      }
		      
		      sourcefieldElmt.addAttribute("PHYSICALLENGTH", paramMap.get("plen"));
		      sourcefieldElmt.addAttribute("PHYSICALOFFSET", "0");
		      if(i!=0){
		    	  poffset=Integer.valueOf(byteConver(txt,i-1).get("plen"))+poffset;
		    	  sourcefieldElmt.addAttribute("PHYSICALOFFSET", java.lang.String.valueOf((poffset)));
		      }
		      sourcefieldElmt.addAttribute("PICTURETEXT", "");
		      sourcefieldElmt.addAttribute("PRECISION", paramMap.get("pric"));
//		      sourcefieldElmt.addAttribute("SCALE", paramMap.get("scal"));
		      sourcefieldElmt.addAttribute("SCALE", "0");
		      sourcefieldElmt.addAttribute("USAGE_FLAGS", "");
//		      offset=offset;
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  org.dom4j.Element sourcefieldGDElmt = sourceElmt.addElement("SOURCEFIELD");
				      int lastlenth=Integer.valueOf(paramMap.get("plen"));
				      if(d==1){
					      sourcefieldGDElmt.addAttribute("BUSINESSNAME", "");
					      sourcefieldGDElmt.addAttribute("DATATYPE", "string");
					      sourcefieldGDElmt.addAttribute("DESCRIPTION", "");
					      sourcefieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d+1));
					      sourcefieldGDElmt.addAttribute("FIELDPROPERTY", "0");
					      
					      sourcefieldGDElmt.addAttribute("FIELDTYPE", "ELEMITEM");
					      sourcefieldGDElmt.addAttribute("HIDDEN", "NO");
					      sourcefieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
					      sourcefieldGDElmt.addAttribute("LENGTH", "14");
					      sourcefieldGDElmt.addAttribute("LEVEL", "0");
					      
					      sourcefieldGDElmt.addAttribute("NAME", "BATCH_ID");
					      sourcefieldGDElmt.addAttribute("NULLABLE", "NULL");
					      sourcefieldGDElmt.addAttribute("OCCURS", "0");
					      
					      sourcefieldGDElmt.addAttribute("OFFSET", java.lang.String.valueOf((offset+lastlenth)));
					      offset=Integer.valueOf(java.lang.String.valueOf((offset+lastlenth)));
					      sourcefieldGDElmt.addAttribute("PHYSICALLENGTH", "14");
					      sourcefieldGDElmt.addAttribute("PHYSICALOFFSET", java.lang.String.valueOf((poffset+lastlenth)));
					      poffset=Integer.valueOf(java.lang.String.valueOf((poffset+lastlenth)));
					      sourcefieldGDElmt.addAttribute("PICTURETEXT", "");
					      sourcefieldGDElmt.addAttribute("PRECISION", "14");
					      sourcefieldGDElmt.addAttribute("SCALE", "0");
					      sourcefieldGDElmt.addAttribute("USAGE_FLAGS", "");
				      }
				      if(d==2){
				    	  lastlenth=14;
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
					      sourcefieldGDElmt.addAttribute("OFFSET", java.lang.String.valueOf((offset+lastlenth)));
					      
					      sourcefieldGDElmt.addAttribute("PHYSICALLENGTH", "35");
					      sourcefieldGDElmt.addAttribute("PHYSICALOFFSET", java.lang.String.valueOf((poffset+lastlenth)));
					      sourcefieldGDElmt.addAttribute("PICTURETEXT", "");
					      sourcefieldGDElmt.addAttribute("PRECISION", "35");
					      sourcefieldGDElmt.addAttribute("SCALE", "0");
					      sourcefieldGDElmt.addAttribute("USAGE_FLAGS", "");
				      }
			      }
		      }
	      }
	      
	      
	      
	      
	      
	      org.dom4j.Element targetElmt = folderElmt.addElement("TARGET");
	      targetElmt.addAttribute("BUSINESSNAME", "");
	      targetElmt.addAttribute("CONSTRAINT", "");
	      targetElmt.addAttribute("DATABASETYPE", "Oracle");
	      targetElmt.addAttribute("DESCRIPTION", "");
	      targetElmt.addAttribute("NAME", "S_"+DongName);
	      targetElmt.addAttribute("OBJECTVERSION", "1");
	      targetElmt.addAttribute("TABLEOPTIONS", "");
	      targetElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      for(int i=0;i<txt.size();i++){
	    	  if(i==0){
			      for(int d=1;d<6;d++){
			    	  org.dom4j.Element targetfieldGDElmt = targetElmt.addElement("TARGETFIELD");
				      targetfieldGDElmt.addAttribute("BUSINESSNAME", "");
				      targetfieldGDElmt.addAttribute("DATATYPE", "varchar2");
				      targetfieldGDElmt.addAttribute("DESCRIPTION", "");
				      targetfieldGDElmt.addAttribute("FIELDNUMBER", ""+(i+d));
				      targetfieldGDElmt.addAttribute("KEYTYPE", "NOT A KEY");
				      targetfieldGDElmt.addAttribute("NAME", "SRC_SYS_CODE");
				      targetfieldGDElmt.addAttribute("NULLABLE", "NULL");
				      targetfieldGDElmt.addAttribute("PICTURETEXT", "");
				      targetfieldGDElmt.addAttribute("PRECISION",  "32");
				      targetfieldGDElmt.addAttribute("SCALE","0");
				      if(d==1){
					      targetfieldGDElmt.addAttribute("NAME", "SRC_SYS_CODE");
				      }else if(d==2){
					      targetfieldGDElmt.addAttribute("NAME", "MD5_KEY");
				      }else if(d==3){
					      targetfieldGDElmt.addAttribute("NAME", "BATCH_ID");
				      }else if(d==4){
					      targetfieldGDElmt.addAttribute("NAME", "BRANCH_CODE");
				      }else if(d==5){
				    	  targetfieldGDElmt.addAttribute("DATATYPE", "timestamp");
					      targetfieldGDElmt.addAttribute("NAME", "ETL_TIME_EDW");
					      targetfieldGDElmt.addAttribute("PRECISION",  "26");
					      targetfieldGDElmt.addAttribute("SCALE","6");
				      }
			      }
		      }
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap2=byteConver2(txt,i);
	    	  org.dom4j.Element targetfieldElmt = targetElmt.addElement("TARGETFIELD");
		      targetfieldElmt.addAttribute("BUSINESSNAME", "");
		      targetfieldElmt.addAttribute("DATATYPE", paramMap2.get("filedtype"));
		      targetfieldElmt.addAttribute("DESCRIPTION", "");
		      targetfieldElmt.addAttribute("FIELDNUMBER", ""+(i+6));
		      targetfieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
		      if(paramMap2.get("name").equals("ZACTCODE")||paramMap2.get("name").equals("BILLFREQ")
		    		  ||paramMap2.get("name").equals("SRCEBUS")){
		    	  targetfieldElmt.addAttribute("KEYTYPE", "PRIMARY KEY");
		      }
		      
		      targetfieldElmt.addAttribute("NAME", paramMap2.get("name"));
		      targetfieldElmt.addAttribute("NULLABLE", paramMap2.get("nullable"));
		      targetfieldElmt.addAttribute("PICTURETEXT", "");
		      targetfieldElmt.addAttribute("PRECISION",  paramMap2.get("pric"));
		      targetfieldElmt.addAttribute("SCALE",  paramMap2.get("scal"));
	      }
	      
	      org.dom4j.Element mappingElmt = folderElmt.addElement("MAPPING");
	      mappingElmt.addAttribute("DESCRIPTION", "");
	      mappingElmt.addAttribute("ISVALID", "YES");
	      mappingElmt.addAttribute("NAME", "m_s_i_"+DongName);
	      mappingElmt.addAttribute("OBJECTVERSION", "1");
	      mappingElmt.addAttribute("VERSIONNUMBER", "2");
	      
	      
	      org.dom4j.Element transformationGDElmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationGDElmt.addAttribute("DESCRIPTION", "");
	      transformationGDElmt.addAttribute("NAME", "EXPTRANS_RENAME");
	      transformationGDElmt.addAttribute("OBJECTVERSION", "1");
	      transformationGDElmt.addAttribute("REUSABLE", "NO");
	      transformationGDElmt.addAttribute("TYPE", "Expression");
	      transformationGDElmt.addAttribute("VERSIONNUMBER", "2");
	      for(int d=1;d<4;d++){
	    	  org.dom4j.Element transformfieldGDElmt = transformationGDElmt.addElement("TRANSFORMFIELD");
		      if(d==1){
		    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
		    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
		    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
		    	  transformfieldGDElmt.addAttribute("EXPRESSION", "'1'");
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
		    	  transformfieldGDElmt.addAttribute("EXPRESSION", "'2'");
		    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
		    	  transformfieldGDElmt.addAttribute("NAME", "BRANCH_CODE");
		    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
		    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
		    	  transformfieldGDElmt.addAttribute("PRECISION", "32");
		    	  transformfieldGDElmt.addAttribute("SCALE", "0");
		      }else if(d==3){
		    	  transformfieldGDElmt.addAttribute("DATATYPE", "date/time");
		    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
		    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
		    	  transformfieldGDElmt.addAttribute("EXPRESSION", "sysdate");
		    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
		    	  transformfieldGDElmt.addAttribute("NAME", "ETL_TIME_EDW");
		    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
		    	  transformfieldGDElmt.addAttribute("PORTTYPE", "OUTPUT");
		    	  transformfieldGDElmt.addAttribute("PRECISION", "29");
		    	  transformfieldGDElmt.addAttribute("SCALE", "9");
		      }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element transformfieldElmt = transformationGDElmt.addElement("TRANSFORMFIELD");
		      if(paramMap3.get("name").equals("ETL_DATATIME")||paramMap3.get("name").equals("DT_DATATIME")
		    		  ||paramMap3.get("name").equals("HIST_ID")){
		    	  org.dom4j.Element transformfieldsecondElmt = transformationGDElmt.addElement("TRANSFORMFIELD");
			      if(paramMap3.get("filedtype").equals("date/time")){
				      transformfieldElmt.addAttribute("DATATYPE", "string");
				      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
				      transformfieldElmt.addAttribute("DESCRIPTION", "");
				      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
				      transformfieldElmt.addAttribute("PICTURETEXT", "");
				      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
				      transformfieldElmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
				      transformfieldElmt.addAttribute("SCALE", "0");
				      //========================================
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
			      }else if(paramMap3.get("filedtype").equals("number(p,s)")){
					      transformfieldElmt.addAttribute("DATATYPE", "string");
					      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
					      transformfieldElmt.addAttribute("DESCRIPTION", "");
					      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
					      transformfieldElmt.addAttribute("PICTURETEXT", "");
					      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
					      transformfieldElmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
					      transformfieldElmt.addAttribute("SCALE", "0");
					      
					      transformfieldsecondElmt.addAttribute("DATATYPE","decimal");
					      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
					      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
					      transformfieldsecondElmt.addAttribute("EXPRESSION","TO_DECIMAL("+paramMap3.get("name")+")");
					      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
					      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
					      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
					      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
					      transformfieldsecondElmt.addAttribute("PRECISION",java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
					      transformfieldsecondElmt.addAttribute("SCALE",paramMap3.get("scal"));
			      }else{
				    	  transformfieldElmt.addAttribute("DATATYPE", "string");
					      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
					      transformfieldElmt.addAttribute("DESCRIPTION", "");
					      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
					      transformfieldElmt.addAttribute("PICTURETEXT", "");
					      transformfieldElmt.addAttribute("PORTTYPE", "INPUT");
					      transformfieldElmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
					      transformfieldElmt.addAttribute("SCALE", "0");
					      
					      transformfieldsecondElmt.addAttribute("DATATYPE","string");
					      transformfieldsecondElmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
					      transformfieldsecondElmt.addAttribute("DESCRIPTION","");
					      transformfieldsecondElmt.addAttribute("EXPRESSION","LTRIM(RTRIM("+paramMap3.get("name")+"))");
					      transformfieldsecondElmt.addAttribute("EXPRESSIONTYPE","GENERAL");
					      transformfieldsecondElmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
					      transformfieldsecondElmt.addAttribute("PICTURETEXT","");
					      transformfieldsecondElmt.addAttribute("PORTTYPE","OUTPUT");
					      transformfieldsecondElmt.addAttribute("PRECISION",java.lang.String.valueOf((Integer.valueOf(paramMap3.get("plen")))));
					      transformfieldsecondElmt.addAttribute("SCALE",paramMap3.get("scal"));
			      }
		      }else{
			      transformfieldElmt.addAttribute("DATATYPE", "string");
			      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldElmt.addAttribute("DESCRIPTION", "");
			      transformfieldElmt.addAttribute("EXPRESSION", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
			      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldElmt.addAttribute("PICTURETEXT", "");
			      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
			      transformfieldElmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
		    	  transformfieldElmt.addAttribute("SCALE", "0");
		      }   
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  org.dom4j.Element transformfieldGDElmt = transformationGDElmt.addElement("TRANSFORMFIELD");
				      if(d==1){
				    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
				    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
				    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
				    	  transformfieldGDElmt.addAttribute("EXPRESSION", "BATCH_ID");
				    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
				    	  transformfieldGDElmt.addAttribute("NAME", "BATCH_ID");
				    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
				    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
				    	  transformfieldGDElmt.addAttribute("PRECISION", "11");
				    	  transformfieldGDElmt.addAttribute("SCALE", "0");
				      }else if(d==2){
				    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
				    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
				    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
				    	  transformfieldGDElmt.addAttribute("EXPRESSION", "MD5_KEY");
				    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
				    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY");
				    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
				    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
				    	  transformfieldGDElmt.addAttribute("PRECISION", "32");
				    	  transformfieldGDElmt.addAttribute("SCALE", "0");
				    	  
				    	  org.dom4j.Element tableattributeSqlMapElmt = transformationGDElmt.addElement("TABLEATTRIBUTE");
				    	  tableattributeSqlMapElmt.addAttribute("NAME", "Tracing Level");
				          tableattributeSqlMapElmt.addAttribute("VALUE", "Normal");
				      }
			      }
		      }
	      }
	      
	      
	      org.dom4j.Element transformationGDTrim2Elmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationGDTrim2Elmt.addAttribute("DESCRIPTION", "");
	      transformationGDTrim2Elmt.addAttribute("NAME", "EXPTRANS_TRIM");
	      transformationGDTrim2Elmt.addAttribute("OBJECTVERSION", "1");
	      transformationGDTrim2Elmt.addAttribute("REUSABLE", "NO");
	      transformationGDTrim2Elmt.addAttribute("TYPE", "Expression");
	      transformationGDTrim2Elmt.addAttribute("VERSIONNUMBER", "1");
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt,i);
	    	  org.dom4j.Element transformfieldsecond2Elmt = transformationGDTrim2Elmt.addElement("TRANSFORMFIELD");
	    	  org.dom4j.Element transformfieldsecond3Elmt = transformationGDTrim2Elmt.addElement("TRANSFORMFIELD");
		    	  transformfieldsecond2Elmt.addAttribute("DATATYPE", "string");
			      transformfieldsecond2Elmt.addAttribute("DEFAULTVALUE", "");
			      transformfieldsecond2Elmt.addAttribute("DESCRIPTION", "");
			      transformfieldsecond2Elmt.addAttribute("EXPRESSION", paramMap3.get("name"));
			      transformfieldsecond2Elmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
			      transformfieldsecond2Elmt.addAttribute("NAME", paramMap3.get("name"));
			      transformfieldsecond2Elmt.addAttribute("PICTURETEXT", "");
			      transformfieldsecond2Elmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
			      transformfieldsecond2Elmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("plen")))));
			      transformfieldsecond2Elmt.addAttribute("SCALE", "0");
				      
		    	  transformfieldsecond3Elmt.addAttribute("DATATYPE","string");
		    	  transformfieldsecond3Elmt.addAttribute("DEFAULTVALUE","ERROR('transformation error')");
		    	  transformfieldsecond3Elmt.addAttribute("DESCRIPTION","");
		    	  transformfieldsecond3Elmt.addAttribute("EXPRESSION","LTRIM(RTRIM("+paramMap3.get("name")+"))");
		    	  transformfieldsecond3Elmt.addAttribute("EXPRESSIONTYPE","GENERAL");
		    	  transformfieldsecond3Elmt.addAttribute("NAME",paramMap3.get("name")+"_OUT");
		    	  transformfieldsecond3Elmt.addAttribute("PICTURETEXT","");
		    	  transformfieldsecond3Elmt.addAttribute("PORTTYPE","OUTPUT");
		    	  transformfieldsecond3Elmt.addAttribute("PRECISION",java.lang.String.valueOf((Integer.valueOf(paramMap3.get("pric")))));
		    	  transformfieldsecond3Elmt.addAttribute("SCALE","0");
		    	  if(i==txt.size()-1){
				      for(int d=1;d<3;d++){
				    	  org.dom4j.Element transformfieldGDElmt = transformationGDTrim2Elmt.addElement("TRANSFORMFIELD");
				    	  org.dom4j.Element transformfieldGDOutElmt = transformationGDTrim2Elmt.addElement("TRANSFORMFIELD");
					      if(d==1){
					    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
					    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
					    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
					    	  transformfieldGDElmt.addAttribute("EXPRESSION", "BATCH_ID");
					    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
					    	  transformfieldGDElmt.addAttribute("NAME", "BATCH_ID");
					    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
					    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
					    	  transformfieldGDElmt.addAttribute("PRECISION", "14");
					    	  transformfieldGDElmt.addAttribute("SCALE", "0");
					    	  
					    	  transformfieldGDOutElmt.addAttribute("DATATYPE", "string");
					    	  transformfieldGDOutElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
					    	  transformfieldGDOutElmt.addAttribute("DESCRIPTION", "");
					    	  transformfieldGDOutElmt.addAttribute("EXPRESSION", "LTRIM(RTRIM(BATCH_ID))");
					    	  transformfieldGDOutElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
					    	  transformfieldGDOutElmt.addAttribute("NAME", "BATCH_ID_OUT");
					    	  transformfieldGDOutElmt.addAttribute("PICTURETEXT", "");
					    	  transformfieldGDOutElmt.addAttribute("PORTTYPE", "OUTPUT");
					    	  transformfieldGDOutElmt.addAttribute("PRECISION", "11");
					    	  transformfieldGDOutElmt.addAttribute("SCALE", "0");
					      }else if(d==2){
					    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
					    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
					    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
					    	  transformfieldGDElmt.addAttribute("EXPRESSION", "MD5_KEY");
					    	  transformfieldGDElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
					    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY");
					    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
					    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
					    	  transformfieldGDElmt.addAttribute("PRECISION", "35");
					    	  transformfieldGDElmt.addAttribute("SCALE", "0");
					    	  
					    	  transformfieldGDOutElmt.addAttribute("DATATYPE", "string");
					    	  transformfieldGDOutElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')");
					    	  transformfieldGDOutElmt.addAttribute("DESCRIPTION", "");
					    	  transformfieldGDOutElmt.addAttribute("EXPRESSION", "LTRIM(RTRIM(MD5_KEY))");
					    	  transformfieldGDOutElmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
					    	  transformfieldGDOutElmt.addAttribute("NAME", "MD5_KEY_OUT");
					    	  transformfieldGDOutElmt.addAttribute("PICTURETEXT", "");
					    	  transformfieldGDOutElmt.addAttribute("PORTTYPE", "OUTPUT");
					    	  transformfieldGDOutElmt.addAttribute("PRECISION", "32");
					    	  transformfieldGDOutElmt.addAttribute("SCALE", "0");
					    	  
					    	  org.dom4j.Element tableattributeSqlMapElmt = transformationGDTrim2Elmt.addElement("TABLEATTRIBUTE");
					    	  tableattributeSqlMapElmt.addAttribute("NAME", "Tracing Level");
					          tableattributeSqlMapElmt.addAttribute("VALUE", "Normal");
					      }
				      }
			      }
	      }
	      
	      
	      
	      
	      org.dom4j.Element transformationElmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationElmt.addAttribute("DESCRIPTION", "");
	      transformationElmt.addAttribute("NAME", "SQ_f_"+DongName);
	      transformationElmt.addAttribute("OBJECTVERSION", "1");
	      transformationElmt.addAttribute("REUSABLE", "NO");
	      transformationElmt.addAttribute("TYPE", "Source Qualifier");
	      transformationElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element transformfieldElmt = transformationElmt.addElement("TRANSFORMFIELD");
		      transformfieldElmt.addAttribute("DATATYPE", "string");
		      transformfieldElmt.addAttribute("DEFAULTVALUE", "");
		      transformfieldElmt.addAttribute("DESCRIPTION", "");
		      transformfieldElmt.addAttribute("NAME", paramMap3.get("name"));
		      transformfieldElmt.addAttribute("PICTURETEXT", "");
		      transformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
		      transformfieldElmt.addAttribute("PRECISION", java.lang.String.valueOf(Integer.valueOf(paramMap3.get("plen"))+3));
		      transformfieldElmt.addAttribute("SCALE", "0");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  org.dom4j.Element transformfieldGDElmt = transformationElmt.addElement("TRANSFORMFIELD");
				      if(d==1){
				    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
				    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
				    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
				    	  transformfieldGDElmt.addAttribute("NAME", "BATCH_ID");
				    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
				    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
				    	  transformfieldGDElmt.addAttribute("PRECISION", "14");
				    	  transformfieldGDElmt.addAttribute("SCALE", "0");
				      }else if(d==2){
				    	  transformfieldGDElmt.addAttribute("DATATYPE", "string");
				    	  transformfieldGDElmt.addAttribute("DEFAULTVALUE", "");
				    	  transformfieldGDElmt.addAttribute("DESCRIPTION", "");
				    	  transformfieldGDElmt.addAttribute("NAME", "MD5_KEY");
				    	  transformfieldGDElmt.addAttribute("PICTURETEXT", "");
				    	  transformfieldGDElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
				    	  transformfieldGDElmt.addAttribute("PRECISION", "35");
				    	  transformfieldGDElmt.addAttribute("SCALE", "0");
				      }
			      }
		      }
	      }
	      
	      for(int i=1;i<12;i++){
	    	  org.dom4j.Element tableattributeSqlMapElmt = transformationElmt.addElement("TABLEATTRIBUTE");
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
	      
	      
	      for(int i=1;i<6;i++){
	    	  org.dom4j.Element instanceElmt = mappingElmt.addElement("INSTANCE");
		      if(i==1){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "25");
		    	  instanceElmt.addAttribute("NAME", "S_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "S_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
		    	  instanceElmt.addAttribute("TYPE", "TARGET");
		      }else if(i==2){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "17");
		    	  instanceElmt.addAttribute("NAME", "EXPTRANS_RENAME");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS_RENAME");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }else if(i==3){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "13");
		    	  instanceElmt.addAttribute("NAME", "EXPTRANS_TRIM");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS_TRIM");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }else if(i==4){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "16");
		    	  instanceElmt.addAttribute("NAME", "SQ_f_"+DongName);
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "SQ_f_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Qualifier");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		    	  org.dom4j.Element associated_source_instanceElmt = instanceElmt.addElement("ASSOCIATED_SOURCE_INSTANCE");
		    	  associated_source_instanceElmt.addAttribute("NAME", "f_"+DongName);
		      }else if(i==5){
		    	  instanceElmt.addAttribute("DBDNAME", "Flat_File");
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "15");
		    	  instanceElmt.addAttribute("NAME", "f_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Definition");
		    	  instanceElmt.addAttribute("TYPE", "SOURCE");
		      }
	      }
	      
	      
	      
	      
	      org.dom4j.Element connectorgd1Elmt = mappingElmt.addElement("CONNECTOR");
	      connectorgd1Elmt.addAttribute("FROMFIELD", "SRC_SYS_CODE");
	      connectorgd1Elmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
	      connectorgd1Elmt.addAttribute("FROMINSTANCETYPE", "Expression");
	      connectorgd1Elmt.addAttribute("TOFIELD", "SRC_SYS_CODE");
	      connectorgd1Elmt.addAttribute("TOINSTANCE", "S_"+DongName);
	      connectorgd1Elmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      for(int i=1;i<5;i++){
	    	  org.dom4j.Element connectorSDElmt = mappingElmt.addElement("CONNECTOR");
		      if(i==1){
		    	  
		    	  
		    	  connectorSDElmt.addAttribute("FROMFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "S_"+DongName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==2){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "BATCH_ID");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "BATCH_ID");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "S_"+DongName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==3){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "BRANCH_CODE");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "BRANCH_CODE");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "S_"+DongName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==4){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "ETL_TIME_EDW");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "ETL_TIME_EDW");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "S_"+DongName);
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt, i);
	    	  if(paramMap3.get("name").equals("HIST_ID")||paramMap3.get("name").equals("ETL_DATATIME")
	    			  ||paramMap3.get("name").equals("DT_DATATIME")){  
	    		  
	    	  }else{
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "S_"+DongName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	    	  }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt, i);
	    	  if(paramMap3.get("name").equals("HIST_ID")||paramMap3.get("name").equals("ETL_DATATIME")
	    			  ||paramMap3.get("name").equals("DT_DATATIME")){  
	    		  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
			      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"_OUT");
			      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
			      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
			      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
			      connectorElmt.addAttribute("TOINSTANCE", "S_"+DongName);
			      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	    	  }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt, i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"_OUT");
		      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_TRIM");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "EXPTRANS_RENAME");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  org.dom4j.Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
				      if(d==1){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID_OUT");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_TRIM");
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
				    	  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "EXPTRANS_RENAME");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
				      }else if(d==2){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY_OUT");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_TRIM");
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
				    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "EXPTRANS_RENAME");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
				      }
			      }
		      }
	      }
	      
	      

	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "SQ_f_"+DongName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "EXPTRANS_TRIM");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
	      }


	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt,i);
	    	  if(i==0){
			      for(int d=1;d<3;d++){
			    	  org.dom4j.Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
				      if(d==1){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "SQ_f_"+DongName);
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
				    	  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "EXPTRANS_TRIM");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
				      }else if(d==2){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "SQ_f_"+DongName);
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
				    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "EXPTRANS_TRIM");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Expression");
				      }
			      }
		      }
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "f_"+DongName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "SQ_f_"+DongName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
		      
		      if(i==txt.size()-1){
			    	  for(int d=1;d<3;d++){
			    		  org.dom4j.Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
					      if(d==1){
					    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID");
					    	  connectorGDElmt.addAttribute("FROMINSTANCE", "f_"+DongName);
					    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
					    	  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
					    	  connectorGDElmt.addAttribute("TOINSTANCE", "SQ_f_"+DongName);
					    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
					      }else if(d==2){
					    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY");
					    	  connectorGDElmt.addAttribute("FROMINSTANCE", "f_"+DongName);
					    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
					    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
					    	  connectorGDElmt.addAttribute("TOINSTANCE", "SQ_f_"+DongName);
					    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
					      }
				      }
		      }
	      }

	      org.dom4j.Element targetloadorderElmt = mappingElmt.addElement("TARGETLOADORDER");
	      targetloadorderElmt.addAttribute("ORDER", "1");
	      targetloadorderElmt.addAttribute("TARGETINSTANCE","S_"+DongName);
	      
	      org.dom4j.Element erpinfoElmt = mappingElmt.addElement("ERPINFO");
	      outputXml(doc, outfilename);
	  }
	  
		  
		  public static java.util.Map<java.lang.String, java.lang.String> byteConver(java.util.List<java.util.List<java.lang.String>> txt,int i){	
	  		  
		  		java.lang.String type=txt.get(i).get(1).toString();
		  		java.util.Map<java.lang.String, java.lang.String> typemap=new java.util.HashMap<java.lang.String, java.lang.String>();
				  
				  java.lang.String oncetype=txt.get(i).get(0);
				  typemap.put("name",oncetype);
				  
				  if(txt.get(i).size()>=3){
					  java.lang.String threetype=txt.get(i).get(2).toString();
					  if(threetype!=null&&!threetype.equals("")){
//					  typemap.put("nullable", "NOTNULL");
						  typemap.put("nullable", "NULL");
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
				            typemap.put("plen", "26");
				            typemap.put("len", "26");
				            typemap.put("pric", "26");
					  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
						  type="decimal";
						  typemap.put("filedtype", type);
						  int index=endtype.indexOf(",");
						  	if(index==-1){
						  		typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
						  	}else{
						  		typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.lastIndexOf(",")))+3));
					            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
						  	}
				            typemap.put("len", typemap.get("plen"));
				            typemap.put("pric", typemap.get("plen"));
					  }else if(filedtype.equals("VARCHAR")){
						  type="varchar";
						  typemap.put("filedtype", type);
						  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
						  typemap.put("len", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
						  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
					  }else if(filedtype.equals("CHAR")){
						  type="char";
						  typemap.put("filedtype", type);
						  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
						  typemap.put("len", typemap.get("plen"));
						  typemap.put("pric", typemap.get("plen"));
					  }else if(filedtype.equals("NCHAR")){
						  type="nchar";
						  typemap.put("filedtype", type);
						  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
						  typemap.put("len", typemap.get("plen"));
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
						  	type="timestamp";
				            typemap.put("filedtype", type);
				            typemap.put("plen", "29");
				            typemap.put("len", "29");
				            typemap.put("pric", "26");
				            typemap.put("scal", "6");
					  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
						  type="number(p,s)";
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
					  }else if(filedtype.equals("VARCHAR")||filedtype.equals("CHAR")){
						  type="varchar2";
						  typemap.put("filedtype", type);
						  typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  typemap.put("len", "0");
						  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))*2));
					  }else if(filedtype.equals("NCHAR")||filedtype.equals("NVARCHAR")){
						  type="varchar2";
						  typemap.put("filedtype", type);
						  typemap.put("plen", endtype.substring(1,endtype.length()-1));
						  typemap.put("len", "0");
						  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))*2));
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
						  typemap.put("nullable", "NULL");
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
					            typemap.put("plen", "23");
					            typemap.put("len", "23");
					            typemap.put("pric", "23");
						  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
							  type="number(p,s)";
							  typemap.put("filedtype", type);
							  int index=endtype.indexOf(",");
							  	if(index==-1){
							  		typemap.put("plen", endtype.substring(1,endtype.length()-1));
							  	}else{
							  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
						            typemap.put("scal", endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1));	
							  	}
					            typemap.put("len", java.lang.String.valueOf((java.lang.Integer.valueOf(typemap.get("plen")).intValue()+2)));
					            typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))));
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
			  	  
		/**
		 *
		 * byteConverTrim	  	  
		 */
			  	public static java.util.Map<java.lang.String, java.lang.String> byteConverTrim(java.util.List<java.util.List<java.lang.String>> txt,int i){	
			  		  java.lang.String type=txt.get(i).get(1).toString();
			  		  java.util.Map<java.lang.String, java.lang.String> typemap=new java.util.HashMap<java.lang.String, java.lang.String>();
					  
			  		java.lang.String oncetype=txt.get(i).get(0);
					  typemap.put("name",oncetype);
					  if(txt.get(i).size()>=3){
						  java.lang.String threetype=txt.get(i).get(2).toString();
						  if(threetype!=null&&!threetype.equals("")){
						  typemap.put("nullable", "NULL");
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
					            typemap.put("plen", "26");
					            typemap.put("len", "26");
					            typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))-3));
						  }else if(filedtype.equals("NUMBER")||filedtype.equals("DECIMAL")){
							  type="number(p,s)";
							  typemap.put("filedtype", type);
							  int index=endtype.indexOf(",");
							  	if(index==-1){
							  		typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
							  	}else{
							  		typemap.put("plen", endtype.substring(1,endtype.lastIndexOf(",")));
						            typemap.put("scal", java.lang.String.valueOf(Integer.valueOf(endtype.substring(endtype.lastIndexOf(",")+1,endtype.length()-1))+3));	
							  	}
					            typemap.put("len", java.lang.String.valueOf((java.lang.Integer.valueOf(typemap.get("plen")).intValue()+2)));
					            typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))-3));
						  }else if(filedtype.equals("CHAR")||filedtype.equals("VARCHAR")){
							  type="string";
							  typemap.put("filedtype", type);
							  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
							  typemap.put("len", "0");
							  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))-3));
						  }else if(filedtype.equals("NCHAR")||filedtype.equals("NVARCHAR")){
							  type="nstring";
							  typemap.put("filedtype", type);
							  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
							  typemap.put("len", "0");
							  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))-3));
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
