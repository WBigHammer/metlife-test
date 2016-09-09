

import java.util.Map;

import org.dom4j.Element;

import com.metlife.dom4jxml.HelpUntil2;


public class StandardJob2 {

	  public static void main(java.lang.String[] args) throws Exception {
		/*  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+args[0];
		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+args[1];
//		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+"LA_ZPCMPF.txt";
//		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+"LA_ZPCMPF.xml";
		  writeBook(outfiledname,infiledname);*/
		  String in="LA_ZPCMPF.txt";
		  String out="out_t.xml";
//		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/"+args[0];
//		  java.lang.String outfiledname="D:/zip-test/metlife-work/testoutfile/"+args[1];D:\1txt2xml
		  java.lang.String infiledname="D:/1txt2xml/"+in;
		  java.lang.String outfiledname="D:/1txt2xml/"+out;
//		  java.lang.String outfiledname="D:\\workspace\\metlife-test\\"+out;
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
	      
	      //********************************************SOURCE*************************************************
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
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap=byteConverSource(txt,i);
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
		    	  offset=Integer.valueOf(byteConverSource(txt,i-1).get("plen"))+offset;
		    	  sourcefieldElmt.addAttribute("OFFSET", java.lang.String.valueOf((offset)));
		      }
		      
		      sourcefieldElmt.addAttribute("PHYSICALLENGTH", paramMap.get("plen"));
		      sourcefieldElmt.addAttribute("PHYSICALOFFSET", "0");
		      if(i!=0){
		    	  poffset=Integer.valueOf(byteConverSource(txt,i-1).get("plen"))+poffset;
		    	  sourcefieldElmt.addAttribute("PHYSICALOFFSET", java.lang.String.valueOf((poffset)));
		      }
		      sourcefieldElmt.addAttribute("PICTURETEXT", "");
		      sourcefieldElmt.addAttribute("PRECISION", paramMap.get("pric"));
		      sourcefieldElmt.addAttribute("SCALE", "0");
		      sourcefieldElmt.addAttribute("USAGE_FLAGS", "");
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
	      
	      
	      
	      //********************************************TARGET-1*************************************************
	      org.dom4j.Element targetElmt = folderElmt.addElement("TARGET");
	      targetElmt.addAttribute("BUSINESSNAME", "");
	      targetElmt.addAttribute("CONSTRAINT", "");
	      targetElmt.addAttribute("DATABASETYPE", "Flat File");
	      targetElmt.addAttribute("DESCRIPTION", "");
	      targetElmt.addAttribute("NAME", "f_"+DongName+"_bad");
	      targetElmt.addAttribute("OBJECTVERSION", "1");
	      targetElmt.addAttribute("TABLEOPTIONS", "");
	      targetElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      org.dom4j.Element targetflatElmt = targetElmt.addElement("FLATFILE");
	      targetflatElmt.addAttribute("CODEPAGE", "MS936");
	      targetflatElmt.addAttribute("CONSECDELIMITERSASONE", "NO");
	      targetflatElmt.addAttribute("DELIMITED", "YES");
	      targetflatElmt.addAttribute("DELIMITERS", "||");
	      targetflatElmt.addAttribute("ESCAPE_CHARACTER", "");
	      targetflatElmt.addAttribute("KEEPESCAPECHAR", "NO");
	      targetflatElmt.addAttribute("LINESEQUENTIAL", "NO");
	      targetflatElmt.addAttribute("MULTIDELIMITERSASAND", "NO");
	      targetflatElmt.addAttribute("NULLCHARTYPE", "ASCII");
	      targetflatElmt.addAttribute("NULL_CHARACTER", "*");
	      targetflatElmt.addAttribute("PADBYTES", "1");
	      targetflatElmt.addAttribute("QUOTE_CHARACTER", "NONE");
	      targetflatElmt.addAttribute("REPEATABLE", "NO");
	      targetflatElmt.addAttribute("ROWDELIMITER", "0");
	      targetflatElmt.addAttribute("SKIPROWS", "0");
	      targetflatElmt.addAttribute("STRIPTRAILINGBLANKS", "NO");
	      
	      for(int i=1;i<7;i++){
		      Element targetfieldElmt = targetElmt.addElement("TARGETFIELD");
		      targetfieldElmt.addAttribute("BUSINESSNAME", "");
		      targetfieldElmt.addAttribute("DATATYPE", "string");
		      targetfieldElmt.addAttribute("DESCRIPTION", "");
		      targetfieldElmt.addAttribute("FIELDNUMBER", ""+i);
		      targetfieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
		      targetfieldElmt.addAttribute("NAME", "");
		      targetfieldElmt.addAttribute("NULLABLE", "NULL");
		      targetfieldElmt.addAttribute("PICTURETEXT", "");
		      targetfieldElmt.addAttribute("PRECISION",  "100");
		      targetfieldElmt.addAttribute("SCALE",  "0");
		      if(i==1){
		    	  targetfieldElmt.addAttribute("NAME", "P_KEY");
		      }else if(i==2){
		    	  targetfieldElmt.addAttribute("NAME", "P_KEY_VALUE");
		      }else if(i==3){
		    	  targetfieldElmt.addAttribute("NAME", "MD5_KEY");
		      }else if(i==4){
		    	  targetfieldElmt.addAttribute("NAME", "WRONG_COLUMN_NAME");
		      }else if(i==5){
		    	  targetfieldElmt.addAttribute("NAME", "COLUMN_VALUE");
		      }else if(i==6){
		    	  targetfieldElmt.addAttribute("NAME", "REASON");
		      }
		      
	      }
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
	      
	      //********************************************TARGET-2*************************************************
	      Element targetSDElmt = folderElmt.addElement("TARGET");
	      targetSDElmt.addAttribute("BUSINESSNAME", "");
	      targetSDElmt.addAttribute("CONSTRAINT", "");
	      targetSDElmt.addAttribute("DATABASETYPE", "Flat File");
	      targetSDElmt.addAttribute("DESCRIPTION", "");
	      targetSDElmt.addAttribute("NAME", "f_"+DongName+"_good");
	      targetSDElmt.addAttribute("OBJECTVERSION", "1");
	      targetSDElmt.addAttribute("TABLEOPTIONS", "");
	      targetSDElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      Element flatfileElmt = targetSDElmt.addElement("FLATFILE");
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
	    	  Map<String, String> paramMap2=byteConverFtableGood(txt, i);
	    	  Element targetfieldElmt = targetSDElmt.addElement("TARGETFIELD");
	    	  targetfieldElmt.addAttribute("BUSINESSNAME", "");
	    	  targetfieldElmt.addAttribute("DATATYPE", "string");
	    	  targetfieldElmt.addAttribute("DESCRIPTION", "");
	    	  targetfieldElmt.addAttribute("FIELDNUMBER", ""+(i+1));
	    	  targetfieldElmt.addAttribute("KEYTYPE", "NOT A KEY");
	    	  targetfieldElmt.addAttribute("NAME", paramMap2.get("name"));
	    	  targetfieldElmt.addAttribute("NULLABLE", paramMap2.get("nullable"));
	    	  targetfieldElmt.addAttribute("PICTURETEXT", "");
	    	  targetfieldElmt.addAttribute("PRECISION",  paramMap2.get("pric"));
	    	  targetfieldElmt.addAttribute("SCALE",  paramMap2.get("scal"));
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element targetfieldGDElmt = targetSDElmt.addElement("TARGETFIELD");
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
	    			  }
	    		  }
	    	  }
	      }
	      for(int i=0;i<4;i++){
	    	  Element tableattributeElmt = targetSDElmt.addElement("TABLEATTRIBUTE");
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
	      
	      //********************************************MAPPING*************************************************
	      org.dom4j.Element mappingElmt = folderElmt.addElement("MAPPING");
	      mappingElmt.addAttribute("DESCRIPTION", "");
	      mappingElmt.addAttribute("ISVALID", "YES");
	      mappingElmt.addAttribute("NAME", "m_s_t_"+DongName);
	      mappingElmt.addAttribute("OBJECTVERSION", "1");
	      mappingElmt.addAttribute("VERSIONNUMBER", "3");
	      
	      //********************************************MAPPING-TRANSFORMATION-1:NAME ="EXPTRANS_TRIM";TYPE ="Expression"*************************************************
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
	      //********************************************MAPPING-TRANSFORMATION-2:TYPE="Source Qualifier"*************************************************
	      org.dom4j.Element transformationElmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationElmt.addAttribute("DESCRIPTION", "");
	      transformationElmt.addAttribute("NAME", "SQ_f_"+DongName);
	      transformationElmt.addAttribute("OBJECTVERSION", "1");
	      transformationElmt.addAttribute("REUSABLE", "NO");
	      transformationElmt.addAttribute("TYPE", "Source Qualifier");
	      transformationElmt.addAttribute("VERSIONNUMBER", "1");
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt,i);
	    	  Element transformfieldsecond2Elmt = transformationElmt.addElement("TRANSFORMFIELD");
	    	  transformfieldsecond2Elmt.addAttribute("DATATYPE", "string");
	    	  transformfieldsecond2Elmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldsecond2Elmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldsecond2Elmt.addAttribute("NAME", paramMap3.get("name"));
	    	  transformfieldsecond2Elmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldsecond2Elmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
	    	  transformfieldsecond2Elmt.addAttribute("PRECISION", java.lang.String.valueOf((Integer.valueOf(paramMap3.get("plen")))));
	    	  transformfieldsecond2Elmt.addAttribute("SCALE", "0");
	    	  
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element transformfieldGDElmt = transformationElmt.addElement("TRANSFORMFIELD");
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
	      
	      //********************************************MAPPING-TRANSFORMATION-3:NAME="EXPTRANS_RENAME";TYPE="Source Qualifier"*************************************************
	      Element transformationGD3Elmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationGD3Elmt.addAttribute("DESCRIPTION", "");
	      transformationGD3Elmt.addAttribute("NAME", "EXPTRANS_RENAME");
	      transformationGD3Elmt.addAttribute("OBJECTVERSION", "1");
	      transformationGD3Elmt.addAttribute("REUSABLE", "NO");
	      transformationGD3Elmt.addAttribute("TYPE", "Expression");
	      transformationGD3Elmt.addAttribute("VERSIONNUMBER", "1");
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt, i);
	    	  Element transformfieldsecond2Elmt = transformationGD3Elmt.addElement("TRANSFORMFIELD");
	    	  transformfieldsecond2Elmt.addAttribute("DATATYPE", "string");
	    	  transformfieldsecond2Elmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldsecond2Elmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldsecond2Elmt.addAttribute("EXPRESSION", paramMap3.get("name"));
	    	  transformfieldsecond2Elmt.addAttribute("EXPRESSIONTYPE", "GENERAL");
	    	  transformfieldsecond2Elmt.addAttribute("NAME", paramMap3.get("name"));
	    	  transformfieldsecond2Elmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldsecond2Elmt.addAttribute("PORTTYPE", "INPUT/OUTPUT");
	    	  transformfieldsecond2Elmt.addAttribute("PRECISION", paramMap3.get("pric"));
	    	  transformfieldsecond2Elmt.addAttribute("SCALE", "0");
	    	  
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element transformfieldGDElmt = transformationGD3Elmt.addElement("TRANSFORMFIELD");
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
	    				  
	    				  Element tableattributeSqlMapElmt = transformationGD3Elmt.addElement("TABLEATTRIBUTE");
	    				  tableattributeSqlMapElmt.addAttribute("NAME", "Tracing Level");
	    				  tableattributeSqlMapElmt.addAttribute("VALUE", "Normal");
	    			  }
	    		  }
	    	  }
	      }
	      //********************************************MAPPING-TRANSFORMATION-4:NAME="RTRTRANS";TYPE="Router"*************************************************
	      Element transformationRouterElmt = mappingElmt.addElement("TRANSFORMATION");
	      transformationRouterElmt.addAttribute("DESCRIPTION", "");
	      transformationRouterElmt.addAttribute("NAME", "RTRTRANS");
	      transformationRouterElmt.addAttribute("OBJECTVERSION", "1");
	      transformationRouterElmt.addAttribute("REUSABLE", "NO");
	      transformationRouterElmt.addAttribute("TYPE", "Router");
	      transformationRouterElmt.addAttribute("VERSIONNUMBER", "2"); 
	     
	      // 写死的标签  group标签
	      for(int i=1;i<5;i++){
    		  Element groupElmt=transformationRouterElmt.addElement("GROUP");
    		  groupElmt.addAttribute("DESCRIPTION", "");
    		  if(i==1){
    			  groupElmt.addAttribute("NAME", "INPUT");
    			  groupElmt.addAttribute("ORDER", "1");
    			  groupElmt.addAttribute("TYPE", "INPUT");
    		  }else if(i==2){
    			  groupElmt.addAttribute("EXPRESSION", "not isnull(CNTTYPE) and CNTTYPE  != '' and  not isnull(SRCEBUS) and SRCEBUS  != '' ");
    			  groupElmt.addAttribute("NAME", "GOOD");
    			  groupElmt.addAttribute("ORDER", "2");
    			  groupElmt.addAttribute("TYPE", "OUTPUT");
    		  }else if(i==3){
    			  groupElmt.addAttribute("DESCRIPTION", "Path for the data when none of the group conditions are satisfied.");
    			  groupElmt.addAttribute("NAME", "DEFAULT1");
    			  groupElmt.addAttribute("ORDER", "4");
    			  groupElmt.addAttribute("TYPE", "OUTPUT/DEFAULT");
    		  }else if(i==4){
    			  groupElmt.addAttribute("EXPRESSION", "isnull(CNTTYPE) or CNTTYPE  = '' or  isnull(SRCEBUS) or SRCEBUS  = '' ");
    			  groupElmt.addAttribute("NAME", "BAD");
    			  groupElmt.addAttribute("ORDER", "3");
    			  groupElmt.addAttribute("TYPE", "OUTPUT");
    		  }
    	  }
	      
	      for(int i=0;i<txt.size();i++){
	    	  Element transformfieldRouterElmt=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt, i);
	    	  transformfieldRouterElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldRouterElmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldRouterElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldRouterElmt.addAttribute("GROUP", "INPUT");
	    	  transformfieldRouterElmt.addAttribute("NAME",paramMap3.get("name"));
	    	  transformfieldRouterElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldRouterElmt.addAttribute("PORTTYPE", "INPUT");
	    	  transformfieldRouterElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	    	  transformfieldRouterElmt.addAttribute("SCALE", "0");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    	    	  Element transformfieldRouterElmt1=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    			  if(d==1){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    		    	  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    		    	  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    		    	  transformfieldRouterElmt1.addAttribute("GROUP", "INPUT");
	    		    	  transformfieldRouterElmt1.addAttribute("NAME","BATCH_ID");
	    		    	  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    		    	  transformfieldRouterElmt1.addAttribute("PORTTYPE", "INPUT");
	    		    	  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    		    	  transformfieldRouterElmt1.addAttribute("SCALE", "0");  
	    			  }else if(d==2){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    		    	  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    		    	  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    		    	  transformfieldRouterElmt1.addAttribute("GROUP", "INPUT");
	    		    	  transformfieldRouterElmt1.addAttribute("NAME","MD5_KEY");
	    		    	  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    		    	  transformfieldRouterElmt1.addAttribute("PORTTYPE", "INPUT");
	    		    	  transformfieldRouterElmt1.addAttribute("PRECISION", "32");
	    		    	  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }
	    		  }
	    	  }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  Element transformfieldRouterElmt=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt, i);
	    	  transformfieldRouterElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldRouterElmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldRouterElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldRouterElmt.addAttribute("GROUP", "GOOD");
	    	  transformfieldRouterElmt.addAttribute("NAME",paramMap3.get("name")+1);
	    	  transformfieldRouterElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldRouterElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldRouterElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	    	  transformfieldRouterElmt.addAttribute("REF_FIELD", paramMap3.get("name"));
	    	  transformfieldRouterElmt.addAttribute("SCALE", "0");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element transformfieldRouterElmt1=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    			  if(d==1){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "GOOD");
	    				  transformfieldRouterElmt1.addAttribute("NAME","BATCH_ID1");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    				  transformfieldRouterElmt1.addAttribute("REF_FIELD", "BATCH_ID");
	    				  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }else if(d==2){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "GOOD");
	    				  transformfieldRouterElmt1.addAttribute("NAME","MD5_KEY1");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    		    	  transformfieldRouterElmt1.addAttribute("PRECISION", "32");
	    		    	  transformfieldRouterElmt1.addAttribute("REF_FIELD", "MD5_KEY");
	    		    	  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }
	    		  }
	    	  }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  Element transformfieldRouterElmt=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt, i);
	    	  transformfieldRouterElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldRouterElmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldRouterElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldRouterElmt.addAttribute("GROUP", "BAD");
	    	  transformfieldRouterElmt.addAttribute("NAME",paramMap3.get("name")+3);
	    	  transformfieldRouterElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldRouterElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldRouterElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	    	  transformfieldRouterElmt.addAttribute("REF_FIELD", paramMap3.get("name"));
	    	  transformfieldRouterElmt.addAttribute("SCALE", "0");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element transformfieldRouterElmt1=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    			  if(d==1){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "BAD");
	    				  transformfieldRouterElmt1.addAttribute("NAME","BATCH_ID3");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    				  transformfieldRouterElmt1.addAttribute("REF_FIELD", "BATCH_ID");
	    				  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }else if(d==2){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "BAD");
	    				  transformfieldRouterElmt1.addAttribute("NAME","MD5_KEY3");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "32");
	    				  transformfieldRouterElmt1.addAttribute("REF_FIELD", "MD5_KEY");
	    				  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }
	    		  }
	    	  }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  Element transformfieldRouterElmt=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConver3(txt, i);
	    	  transformfieldRouterElmt.addAttribute("DATATYPE", "string");
	    	  transformfieldRouterElmt.addAttribute("DEFAULTVALUE", "");
	    	  transformfieldRouterElmt.addAttribute("DESCRIPTION", "");
	    	  transformfieldRouterElmt.addAttribute("GROUP", "DEFAULT1");
	    	  transformfieldRouterElmt.addAttribute("NAME",paramMap3.get("name")+2);
	    	  transformfieldRouterElmt.addAttribute("PICTURETEXT", "");
	    	  transformfieldRouterElmt.addAttribute("PORTTYPE", "OUTPUT");
	    	  transformfieldRouterElmt.addAttribute("PRECISION", paramMap3.get("pric"));
	    	  transformfieldRouterElmt.addAttribute("REF_FIELD", paramMap3.get("name"));
	    	  transformfieldRouterElmt.addAttribute("SCALE", "0");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element transformfieldRouterElmt1=transformationRouterElmt.addElement("TRANSFORMFIELD");
	    			  if(d==1){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "DEFAULT1");
	    				  transformfieldRouterElmt1.addAttribute("NAME","BATCH_ID2");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    				  transformfieldRouterElmt1.addAttribute("REF_FIELD", "BATCH_ID");
	    				  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }else if(d==2){
	    				  transformfieldRouterElmt1.addAttribute("DATATYPE", "string");
	    				  transformfieldRouterElmt1.addAttribute("DEFAULTVALUE", "");
	    				  transformfieldRouterElmt1.addAttribute("DESCRIPTION", "");
	    				  transformfieldRouterElmt1.addAttribute("GROUP", "DEFAULT1");
	    				  transformfieldRouterElmt1.addAttribute("NAME","MD5_KEY2");
	    				  transformfieldRouterElmt1.addAttribute("PICTURETEXT", "");
	    				  transformfieldRouterElmt1.addAttribute("PORTTYPE", "OUTPUT");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "11");
	    				  transformfieldRouterElmt1.addAttribute("PRECISION", "32");
	    				  transformfieldRouterElmt1.addAttribute("REF_FIELD", "MD5_KEY");
	    				  transformfieldRouterElmt1.addAttribute("SCALE", "0");
	    			  }
	    		  }
	    	  }
	      }
	      
	      Element tableattributeSqlMapElmt = transformationRouterElmt.addElement("TABLEATTRIBUTE");
		  tableattributeSqlMapElmt.addAttribute("NAME", "Tracing Level");
		  tableattributeSqlMapElmt.addAttribute("VALUE", "Normal");
	      //
	      //********************************************MAPPING-TRANSFORMATION-5:NAME="EXPTRANS_BAD";TYPE="Expression"*************************************************
	      Element exptrans_badTransformationElmt = mappingElmt.addElement("TRANSFORMATION");
	      exptrans_badTransformationElmt.addAttribute("DESCRIPTION", "");
	      exptrans_badTransformationElmt.addAttribute("NAME", "EXPTRANS_BAD");
	      exptrans_badTransformationElmt.addAttribute("OBJECTVERSION", "1");
	      exptrans_badTransformationElmt.addAttribute("REUSABLE", "NO");
	      exptrans_badTransformationElmt.addAttribute("TYPE", "Expression");
	      exptrans_badTransformationElmt.addAttribute("VERSIONNUMBER", "3");
	      for(int i=1;i<=9;i++){
	    	  Element exptrans_badTransformfieldElmt = exptrans_badTransformationElmt.addElement("TRANSFORMFIELD");
	    	  exptrans_badTransformfieldElmt.addAttribute("DATATYPE", "string"); 
	    	  if(i==1){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "'HIST_ID'"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "P_KEY_NAME"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "20"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
	    		  
	    	  }
	    	  else if(i==2){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "PK1"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "INTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "20"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 

	    	  }else if(i==3){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "PK1"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "PK1_VALUE"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "20"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
	    		  
	    	  }else if(i==4){
		    	  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", ""); 
		    	  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
		    	  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "MD5_KEY");
		    	  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "MD5_KEY"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "32"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
 
	    	  }else if(i==5){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
		    	  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
		    	  //exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "&apos;CNTTYPE&apos;||&apos;#&apos;||&apos;SRCEBUS&apos;");
		    	  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "'CNTTYPE'||'#'||'SRCEBUS'");
		    	  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "COL_NAME"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "78"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
	    		  
	    	  }else if(i==6){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "CNTTYPE3"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "INPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "3"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
	    	  }else if(i==7){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "SRCEBUS3"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "INPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "2"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0");  

	    	  }else if(i==8){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "CNTTYPE3||'#'||SRCEBUS3"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "COL_VALUE"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "23"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 

	    	  }else if(i==9){
	    		  exptrans_badTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSION", "'isnull(CNTTYPE) or isnull(SRCEBUS)'"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("NAME", "REASON"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("PRECISION", "30"); 
	    		  exptrans_badTransformfieldElmt.addAttribute("SCALE", "0"); 
		    	  Element exptrans_badTableattributeElmt = exptrans_badTransformationElmt.addElement("TABLEATTRIBUTE");
		    	  exptrans_badTableattributeElmt.addAttribute("NAME", "Tracing Level"); 
		    	  exptrans_badTableattributeElmt.addAttribute("VALUE", "Normal"); 
	    	  }
	      }
	      //
	      //********************************************MAPPING-TRANSFORMATION-5:NAME="EXPTRANS_BAD";TYPE="Expression"*************************************************
	      Element rnktransTransformationElmt = mappingElmt.addElement("TRANSFORMATION");
	      rnktransTransformationElmt.addAttribute("DESCRIPTION", "");
	      rnktransTransformationElmt.addAttribute("NAME", "RNKTRANS");
	      rnktransTransformationElmt.addAttribute("OBJECTVERSION", "1");
	      rnktransTransformationElmt.addAttribute("REUSABLE", "NO");
	      rnktransTransformationElmt.addAttribute("TYPE", "Rank");
	      rnktransTransformationElmt.addAttribute("VERSIONNUMBER", "1");
    	  Element rnktransFirstTransformfieldElmt = rnktransTransformationElmt.addElement("TRANSFORMFIELD");
    	 
    	  rnktransFirstTransformfieldElmt.addAttribute("DATATYPE", "integer"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("DEFAULTVALUE", "ERROR('transformation error')"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
    	  rnktransFirstTransformfieldElmt.addAttribute("EXPRESSION", "RANKINDEX"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "RANKINDEX"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("NAME", "RANKINDEX"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
    	  rnktransFirstTransformfieldElmt.addAttribute("PORTTYPE", "OUTPUT"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("PRECISION", "10"); 
    	  rnktransFirstTransformfieldElmt.addAttribute("SCALE", "0"); 

	      for(int i=0;i<txt.size();i++){
	    	  Element rnktransTransformfieldElmt = rnktransTransformationElmt.addElement("TRANSFORMFIELD");
	    	  Map<String,String> paramMap3=byteConver3(txt,i);
	    	  rnktransTransformfieldElmt.addAttribute("DATATYPE", "string"); 
	    	  rnktransTransformfieldElmt.addAttribute("DEFAULTVALUE", ""); 
	    	  rnktransTransformfieldElmt.addAttribute("DESCRIPTION", ""); 
	    	  rnktransTransformfieldElmt.addAttribute("EXPRESSION", paramMap3.get("name")+1); 
	    	  rnktransTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    	  rnktransTransformfieldElmt.addAttribute("NAME", paramMap3.get("name")+1); 
	    	  rnktransTransformfieldElmt.addAttribute("PICTURETEXT", ""); 
	    	  rnktransTransformfieldElmt.addAttribute("PORTTYPE", "INPUT/OUTPUT"); 
	    	  rnktransTransformfieldElmt.addAttribute("PRECISION", paramMap3.get("plen")); 
	    	  rnktransTransformfieldElmt.addAttribute("SCALE", "0"); 
	    	  if("DT_DATATIME".equals(paramMap3.get("name"))){
	    		  rnktransTransformfieldElmt.addAttribute("EXPRESSIONTYPE", "RANKPORT"); 
	    	  }
	    	  if(i==txt.size()-1){
	    		  Element rnktransTransformfieldElmt1 = rnktransTransformationElmt.addElement("TRANSFORMFIELD");
	    		  rnktransTransformfieldElmt1.addAttribute("DATATYPE", "string"); 
	    		  rnktransTransformfieldElmt1.addAttribute("DEFAULTVALUE", ""); 
	    		  rnktransTransformfieldElmt1.addAttribute("DESCRIPTION", ""); 
	    		  rnktransTransformfieldElmt1.addAttribute("EXPRESSION", "BATCH_ID1"); 
	    		  rnktransTransformfieldElmt1.addAttribute("EXPRESSIONTYPE", "GENERAL"); 
	    		  rnktransTransformfieldElmt1.addAttribute("NAME", "BATCH_ID1"); 
	    		  rnktransTransformfieldElmt1.addAttribute("PICTURETEXT", ""); 
	    		  rnktransTransformfieldElmt1.addAttribute("PORTTYPE", "INPUT/OUTPUT"); 
	    		  rnktransTransformfieldElmt1.addAttribute("PRECISION", "11"); 
	    		  rnktransTransformfieldElmt1.addAttribute("SCALE", "0"); 
	    		  Element rnktransTransformfieldElmt2 = rnktransTransformationElmt.addElement("TRANSFORMFIELD");
	    		  rnktransTransformfieldElmt2.addAttribute("DATATYPE", "string"); 
	    		  rnktransTransformfieldElmt2.addAttribute("DEFAULTVALUE", ""); 
	    		  rnktransTransformfieldElmt2.addAttribute("DESCRIPTION", ""); 
	    		  rnktransTransformfieldElmt2.addAttribute("EXPRESSION", "MD5_KEY1"); 
	    		  rnktransTransformfieldElmt2.addAttribute("EXPRESSIONTYPE", "GROUPBY"); 
	    		  rnktransTransformfieldElmt2.addAttribute("NAME", "MD5_KEY1"); 
	    		  rnktransTransformfieldElmt2.addAttribute("PICTURETEXT", ""); 
	    		  rnktransTransformfieldElmt2.addAttribute("PORTTYPE", "INPUT/OUTPUT"); 
	    		  rnktransTransformfieldElmt2.addAttribute("PRECISION", "32"); 
	    		  rnktransTransformfieldElmt2.addAttribute("SCALE", "0"); 
	    		  
	    		  Element rnktransTableattributeElmt1 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt1.addAttribute("NAME", "Cache Directory"); 
	    		  rnktransTableattributeElmt1.addAttribute("VALUE", "$PMCacheDir"); 
	    		  Element rnktransTableattributeElmt2 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt2.addAttribute("NAME", "Top/Bottom"); 
	    		  rnktransTableattributeElmt2.addAttribute("VALUE", "Top"); 
	    		  Element rnktransTableattributeElmt3 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt3.addAttribute("NAME", "Number of Ranks"); 
	    		  rnktransTableattributeElmt3.addAttribute("VALUE", "1"); 
	    		  Element rnktransTableattributeElmt4 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt4.addAttribute("NAME", "Case Sensitive String Comparison"); 
	    		  rnktransTableattributeElmt4.addAttribute("VALUE", "YES"); 
	    		  Element rnktransTableattributeElmt5 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt5.addAttribute("NAME", "Tracing Level"); 
	    		  rnktransTableattributeElmt5.addAttribute("VALUE", "Normal"); 
	    		  Element rnktransTableattributeElmt6 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt6.addAttribute("NAME", "Rank Data Cache Size"); 
	    		  rnktransTableattributeElmt6.addAttribute("VALUE", "Auto"); 
	    		  Element rnktransTableattributeElmt7 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt7.addAttribute("NAME", "Rank Index Cache Size"); 
	    		  rnktransTableattributeElmt7.addAttribute("VALUE", "Auto"); 
	    		  Element rnktransTableattributeElmt8 = rnktransTransformationElmt.addElement("TABLEATTRIBUTE");
	    		  rnktransTableattributeElmt8.addAttribute("NAME", "Transformation Scope"); 
	    		  rnktransTableattributeElmt8.addAttribute("VALUE", "All Input"); 
	    	  }
	      }
	      
	      
	      for(int i=1;i<=9;i++){
	    	  Element instanceElmt = mappingElmt.addElement("INSTANCE");
		      if(i==1){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "19");
		    	  instanceElmt.addAttribute("NAME", "f_"+DongName+"_good");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+DongName+"_good");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
		    	  instanceElmt.addAttribute("TYPE", "TARGET");
		      }else if(i==2){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "22");
		    	  instanceElmt.addAttribute("NAME", "f_"+DongName+"_bad");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+DongName+"_bad");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Target Definition");
		    	  instanceElmt.addAttribute("TYPE", "TARGET");
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
		    	  Element associated_source_instanceElmt = instanceElmt.addElement("ASSOCIATED_SOURCE_INSTANCE");
		    	  associated_source_instanceElmt.addAttribute("NAME", "f_"+DongName);
		      }else if(i==5){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "17");
		    	  instanceElmt.addAttribute("NAME", "EXPTRANS_RENAME");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS_RENAME");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }else if(i==6){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "18");
		    	  instanceElmt.addAttribute("NAME", "RTRTRANS");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "RTRTRANS");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Router");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }else if(i==7){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "23");
		    	  instanceElmt.addAttribute("NAME", "EXPTRANS_BAD");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "EXPTRANS_BAD");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Expression");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
		      }else if(i==8){
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "24");
		    	  instanceElmt.addAttribute("NAME", "RNKTRANS");
		    	  instanceElmt.addAttribute("REUSABLE", "NO");
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "RNKTRANS");
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Rank");
		    	  instanceElmt.addAttribute("TYPE", "TRANSFORMATION");
	  			}else if(i==9){
		    	  instanceElmt.addAttribute("DBDNAME", "Flat_File");
		    	  instanceElmt.addAttribute("DESCRIPTION", "");
		    	  instanceElmt.addAttribute("INSTANCEID", "15");
		    	  instanceElmt.addAttribute("NAME", "f_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_NAME", "f_"+DongName);
		    	  instanceElmt.addAttribute("TRANSFORMATION_TYPE", "Source Definition");
		    	  instanceElmt.addAttribute("TYPE", "SOURCE");
		      }
	      }
	     
	      for(int i=0;i<txt.size();i++){
	    	  Map<String, String> paramMap3=byteConverTrim(txt, i);
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"1");
		      connectorElmt.addAttribute("FROMINSTANCE", "RNKTRANS");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Rank");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_good");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
				      if(d==1){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID1");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "RNKTRANS");
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Rank");
				    	  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_good");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
				      }else if(d==2){
				    	  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY1");
				    	  connectorGDElmt.addAttribute("FROMINSTANCE", "RNKTRANS");
				    	  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Rank");
				    	  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
				    	  connectorGDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_good");
				    	  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
				      }
			      }
		      }
	      }
	      
	      for(int i=1;i<=6;i++){
	    	  Element connectorSDElmt = mappingElmt.addElement("CONNECTOR");
		      if(i==1){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "P_KEY_NAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "P_KEY");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==2){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "PK1_VALUE");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "P_KEY_VALUE");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==3){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "MD5_KEY");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==4){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "COL_NAME");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "WRONG_COLUMN_NAME");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==5){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "COL_VALUE");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "COLUMN_VALUE");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }else if(i==6){
		    	  connectorSDElmt.addAttribute("FROMFIELD", "REASON");
		    	  connectorSDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_BAD");
		    	  connectorSDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		    	  connectorSDElmt.addAttribute("TOFIELD", "REASON");
		    	  connectorSDElmt.addAttribute("TOINSTANCE", "f_"+DongName+"_bad");
		    	  connectorSDElmt.addAttribute("TOINSTANCETYPE", "Target Definition");
		      }
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  Map<String, String> paramMap3=byteConverTrim(txt, i);
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "SQ_f_"+DongName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Qualifier");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "EXPTRANS_TRIM");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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
	      }
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<java.lang.String, java.lang.String> paramMap3=byteConverTrim(txt, i);
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"_OUT");
		      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_TRIM");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "EXPTRANS_RENAME");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "f_"+DongName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "SQ_f_"+DongName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	    	  connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
	    	  connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
	    	  connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    	  connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
	    	  connectorElmt.addAttribute("TOINSTANCE", "RTRTRANS");
	    	  connectorElmt.addAttribute("TOINSTANCETYPE", "Router");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
	    			  if(d==1){
	    				  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID");
	    				  connectorGDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
	    				  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    				  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID");
	    				  connectorGDElmt.addAttribute("TOINSTANCE", "RTRTRANS");
	    				  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Router");
	    			  }else if(d==2){
	    				  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY");
	    				  connectorGDElmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
	    				  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Expression");
	    				  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY");
	    				  connectorGDElmt.addAttribute("TOINSTANCE", "RTRTRANS");
	    				  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Router");
	    			  }
	    		  }
	    	  }
	      }
	      
	      
	      for(int i=0;i<txt.size();i++){
	    	  java.util.Map<String, String> paramMap3=byteConver3(txt,i);
	    	  org.dom4j.Element connectorElmt = mappingElmt.addElement("CONNECTOR");
	    	  connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"1");
	    	  connectorElmt.addAttribute("FROMINSTANCE", "RTRTRANS");
	    	  connectorElmt.addAttribute("FROMINSTANCETYPE", "Router");
	    	  connectorElmt.addAttribute("TOFIELD", paramMap3.get("name")+"1");
	    	  connectorElmt.addAttribute("TOINSTANCE", "RNKTRANS");
	    	  connectorElmt.addAttribute("TOINSTANCETYPE", "Rank");
	    	  if(i==txt.size()-1){
	    		  for(int d=1;d<3;d++){
	    			  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
	    			  if(d==1){
	    				  connectorGDElmt.addAttribute("FROMFIELD", "BATCH_ID1");
	    				  connectorGDElmt.addAttribute("FROMINSTANCE", "RTRTRANS");
	    				  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Router");
	    				  connectorGDElmt.addAttribute("TOFIELD", "BATCH_ID1");
	    				  connectorGDElmt.addAttribute("TOINSTANCE", "RNKTRANS");
	    				  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Rank");
	    			  }else if(d==2){
	    				  connectorGDElmt.addAttribute("FROMFIELD", "MD5_KEY1");
	    				  connectorGDElmt.addAttribute("FROMINSTANCE", "RTRTRANS");
	    				  connectorGDElmt.addAttribute("FROMINSTANCETYPE", "Router");
	    				  connectorGDElmt.addAttribute("TOFIELD", "MD5_KEY1");
	    				  connectorGDElmt.addAttribute("TOINSTANCE", "RNKTRANS");
	    				  connectorGDElmt.addAttribute("TOINSTANCETYPE", "Rank");
	    			  }
	    		  }
	    	  }
	      }
	      Element targetloadorderElmt = mappingElmt.addElement("TARGETLOADORDER");
	      targetloadorderElmt.addAttribute("ORDER", "1");
	      targetloadorderElmt.addAttribute("TARGETINSTANCE","f_"+DongName+"_good");
	      Element targetloadorderElmt1 = mappingElmt.addElement("TARGETLOADORDER");
	      targetloadorderElmt1.addAttribute("ORDER", "1");
	      targetloadorderElmt1.addAttribute("TARGETINSTANCE","f_"+DongName+"_bad");
//	      Element erpinfoElmt = 
	      mappingElmt.addElement("ERPINFO");
	      outputXml(doc, outfilename);
	      System.out.println("end");	      
	     /* 
================================================================================================
			
================================================================================================
	      
	    
	      
	      
	      
	      Element connectorgd1Elmt = mappingElmt.addElement("CONNECTOR");
	      connectorgd1Elmt.addAttribute("FROMFIELD", "SRC_SYS_CODE");
	      connectorgd1Elmt.addAttribute("FROMINSTANCE", "EXPTRANS_RENAME");
	      connectorgd1Elmt.addAttribute("FROMINSTANCETYPE", "Expression");
	      connectorgd1Elmt.addAttribute("TOFIELD", "SRC_SYS_CODE");
	      connectorgd1Elmt.addAttribute("TOINSTANCE", "S_"+DongName);
	      connectorgd1Elmt.addAttribute("TOINSTANCETYPE", "Target Definition");
	      for(int i=1;i<5;i++){
	    	  Element connectorSDElmt = mappingElmt.addElement("CONNECTOR");
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
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
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
	    		  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
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
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name")+"_OUT");
		      connectorElmt.addAttribute("FROMINSTANCE", "EXPTRANS_TRIM");
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Expression");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "EXPTRANS_RENAME");
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Expression");
		      if(i==txt.size()-1){
			      for(int d=1;d<3;d++){
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
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
			    	  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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
	    	  Element connectorElmt = mappingElmt.addElement("CONNECTOR");
		      connectorElmt.addAttribute("FROMFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("FROMINSTANCE", "f_"+DongName);
		      connectorElmt.addAttribute("FROMINSTANCETYPE", "Source Definition");
		      connectorElmt.addAttribute("TOFIELD", paramMap3.get("name"));
		      connectorElmt.addAttribute("TOINSTANCE", "SQ_f_"+DongName);
		      connectorElmt.addAttribute("TOINSTANCETYPE", "Source Qualifier");
		      
		      if(i==txt.size()-1){
			    	  for(int d=1;d<3;d++){
			    		  Element connectorGDElmt = mappingElmt.addElement("CONNECTOR");
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

	     */
	      
	  }
	  
		  
		  public static java.util.Map<java.lang.String, java.lang.String> byteConverSource(java.util.List<java.util.List<java.lang.String>> txt,int i){	
	  		  
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
		  	  
		  	public static java.util.Map<java.lang.String, java.lang.String> byteConverFtableBad(java.util.List<java.util.List<java.lang.String>> txt,int i){	
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
		  	
		  		public static java.util.Map<java.lang.String, java.lang.String> byteConverFtableGood(java.util.List<java.util.List<java.lang.String>> txt,int i){	
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
					            typemap.put("plen", "29");
					            typemap.put("len", "29");
					            typemap.put("pric", "29");
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
							  type="string";
							  typemap.put("filedtype", type);
							  typemap.put("plen", java.lang.String.valueOf(Integer.valueOf(endtype.substring(1,endtype.length()-1))+3));
							  typemap.put("len", "0");
							  typemap.put("pric", java.lang.String.valueOf(Integer.valueOf(typemap.get("plen"))-3));
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
							  type="string";
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
							  type="string";
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
