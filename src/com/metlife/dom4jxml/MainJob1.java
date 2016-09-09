package com.metlife.dom4jxml;

public class MainJob1 {

	/**
	   * main方法   调用工具类方法
	   * 调用写入的方法  进行文件写入   指定路径
	 * @throws Exception 
	   */
	  public static void main(String[] args) throws Exception {
		  java.lang.String outfiledname="D:/zip-test/metlife-work/mybookjob1.xml";
		  java.lang.String infiledname="D:/zip-test/metlife-work/infile/LA_ZPCMPF.txt";
		  Dom4jXml domx=new Dom4jXml();
		  domx.writeBook(outfiledname,infiledname);
	  }
	  
	  
	  
}
