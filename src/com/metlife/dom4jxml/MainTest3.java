package com.metlife.dom4jxml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URLEncoder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.dom.DOMCDATA;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class MainTest3 {

	/**
	   * main方法   调用工具类方法
	   * 调用写入的方法  进行文件写入   指定路径
	 * @throws Exception 
	   */
	  public static void main(String[] args) throws Exception {
		  /*String outfiledname="D:/zip-test/metlife-work/mybook3.xml";//指定 的转换完成后的文件路径
		  String infiledname="D:/zip-test/metlife-work/infile/LA_ACLHPF.txt";//转换过程需要的配置文件
*/		  
		  
		  String outfiledname="D:/zip-test/metlife-work/testoutfile/LA_ZPCMPF_test.xml";//指定 的转换完成后的文件路径
		  String infiledname="D:/zip-test/metlife-work/infile/LA_ZPCMPF.txt";//转换过程需要的配置文件
		  Dom4jXml3 domx=new Dom4jXml3();//创建对应实体对象 
		  domx.writeBook(outfiledname,infiledname);//调用方法  进行xml生成
		  
		  
		  
	  }
}
