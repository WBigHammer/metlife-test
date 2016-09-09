/*The MIT License (MIT)

Copyright (c) 2014 https://github.com/kayalshri/

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/

(function($){
        $.fn.extend({
            tableExport: function(options) {
                var defaults = {
						separator: ',',
						ignoreColumn: [],
						tableName:'yourTableName',
						type:'csv',
						pdfFontSize:14,
						pdfLeftMargin:20,
						escape:'true',
						htmlContent:'false',
						consoleLog:'false'
				};
                
				var options = $.extend(defaults, options);
				var el = this;
				 if(defaults.type == 'excel' || defaults.type == 'doc'|| defaults.type == 'powerpoint'  ){
					var excel="<table>";
					
					$(el).children().each(function(){//table 有thead tbody tfoot 子标签 浏览器解析时默认把除thead和tfoot的内容放到tbody中
						$(this).find('tr:visible').each(function() {//查找所有可见的 tr元素(包括visibility:hidden,不包括display:none)
							if($(this).css('visibility') != 'hidden'){//过滤掉style="visibility:hidden" tr节点
								excel += "<tr>";
								$(this).children().filter(':visible').each(function(){//查找tr节点中所有可见的子元素(包括visibility:hidden,不包括display:none)
										if($(this).css('visibility') != 'hidden'){//过滤掉style="visibility:hidden"子节点
										var str="";
										var rowspan=$(this).attr("rowspan");
										var colspan=$(this).attr("colspan");
										if(rowspan>1)str+=" rowspan="+rowspan;
										if(colspan>1)str+=" colspan="+colspan;
										
										if($(this).is("th")){
											excel += "<th "+str+" >" + parseString($(this))+ "</th>";
										}else if($(this).is("td")){
											excel += "<td "+str+">" + parseString($(this))+ "</td>";
										}
									}
								});
								excel += '</tr>';
							}
						});
					});
					/**
					 * excel+=$(el).html();//可用来直接代替上边的$(el)... 但会把下边后两个tr内容导出
					<tr style="display:none">
						<th class="tabTh tabThA" style="visibility:hidden">2 tr display:none  th  visibility:hidden</th>
						<th class="tabTh tabThA" style="display:none">2  tr display:none  th   display:none</th>
					</tr>
					<tr style="visibility:hidden" >
						<th class="tabTh tabThA" style="visibility:hidden">3 tr visibility:hidden   th visibility:hidden</th>
						<th class="tabTh tabThA" style="display:none">3 tr visibility:hidden  th display:none</th>
					</tr>
					<tr>
						<th class="tabTh tabThA" style="visibility:hidden"> 4    th visibility:hidden</th>
						<th class="tabTh tabThA" style="display:none">4    th display:none</th>
					</tr>
					 */
//					var excel="<table>";
//					excel+=$(el).html();
					excel += '</table>';
					if(defaults.consoleLog == 'true'){
						console.log(excel);
					}
					var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:"+defaults.type+"' xmlns='http://www.w3.org/TR/REC-html40'>";
					excelFile += "<head>";
					excelFile += "<!--[if gte mso 9]>";
					excelFile += "<xml>";
					excelFile += "<x:ExcelWorkbook>";
					excelFile += "<x:ExcelWorksheets>";
					excelFile += "<x:ExcelWorksheet>";
					excelFile += "<x:Name>";
					excelFile += "{worksheet}";
					excelFile += "</x:Name>";
					excelFile += "<x:WorksheetOptions>";
					excelFile += "<x:DisplayGridlines/>";
					excelFile += "</x:WorksheetOptions>";
					excelFile += "</x:ExcelWorksheet>";
					excelFile += "</x:ExcelWorksheets>";
					excelFile += "</x:ExcelWorkbook>";
					excelFile += "</xml>";
					excelFile += "<![endif]-->";
					excelFile += "</head>";
					excelFile += "<body>";
					excelFile += excel;
					excelFile += "</body>";
					excelFile += "</html>";
					var base64data = "base64," + $.base64.encode(excelFile);
					window.open('data:application/vnd.ms-'+defaults.type+';filename=exportData.doc;' + base64data);
				}else if(defaults.type == 'png'){
					html2canvas($(el), {
						onrendered: function(canvas) {										
							var img = canvas.toDataURL("image/png");
							window.open(img);
						}
					});		
				}else if(defaults.type == 'pdf'){
					var doc = new jsPDF('p','pt', 'a4', true);
					doc.setFontSize(defaults.pdfFontSize);
					// Header
					var startColPosition=defaults.pdfLeftMargin;
					var startRowPosition = 20; var page =1;var rowPosition=0;
					// Row Vs Column
					$(el).children().each(function(){//table 有thead tbody tfoot 子标签 浏览器解析时默认把除thead和tfoot的内容放到tbody中
						$(this).find('tr:visible').each(function(index,data) {
							rowCalc = index+1;
							if (rowCalc % 26 == 0){
								doc.addPage();
								page++;
								startRowPosition=startRowPosition+10;
							}
							rowPosition=(startRowPosition + (rowCalc * 10)) - ((page -1) * 280);
							$(this).filter(':visible').children().each(function(index,data) {
								if ($(this).css('display') != 'none'){	
									if(defaults.ignoreColumn.indexOf(index) == -1){
										var colPosition = startColPosition+ (index * 50);									
										doc.text(colPosition,rowPosition, parseString($(this)));
									}
								}
							});															
						});
					});
					// Output as Data URI
					doc.output('datauri');
					
					/*
					var doc = new jsPDF('p','pt', 'a4', true);
					doc.setFontSize(defaults.pdfFontSize);
					// Header
					var startColPosition=defaults.pdfLeftMargin;
					$(el).find('thead').find('tr').each(function() {
						$(this).filter(':visible').find('th').each(function(index,data) {
							if ($(this).css('display') != 'none'){					
								if(defaults.ignoreColumn.indexOf(index) == -1){
									var colPosition = startColPosition+ (index * 50);									
									doc.text(colPosition,20, parseString($(this)));
								}
							}
						});									
					});					
					// Row Vs Column
					var startRowPosition = 20; var page =1;var rowPosition=0;
					$(el).find('tbody').find('tr').each(function(index,data) {
						rowCalc = index+1;
					if (rowCalc % 26 == 0){
						doc.addPage();
						page++;
						startRowPosition=startRowPosition+10;
					}
					rowPosition=(startRowPosition + (rowCalc * 10)) - ((page -1) * 280);
						
						$(this).filter(':visible').find('td').each(function(index,data) {
							if ($(this).css('display') != 'none'){	
								if(defaults.ignoreColumn.indexOf(index) == -1){
									var colPosition = startColPosition+ (index * 50);									
									doc.text(colPosition,rowPosition, parseString($(this)));
								}
							}
							
						});															
						
					});					
										
					// Output as Data URI
					doc.output('datauri');
	
				*/
					}
					
				function parseString(data){
				
					if(defaults.htmlContent == 'true'){
						content_data = data.html().trim();
					}else{
						content_data = data.text().trim();
					}
					
					if(defaults.escape == 'true'){
						content_data = escape(content_data);
					}
					return content_data;
				}
			
			}
        });
    })(jQuery);
        
