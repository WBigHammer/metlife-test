<html>
<head>
<script language="javascript">
	function printdiv(printpage) {
		
		var printData = document.getElementById(printpage).innerHTML; 
		window.document.body.innerHTML = printData;  
		window.print(); 
		
		/* var headstr = "<html><head><title></title></head><body>";
		var footstr = "</body>";
		var printData = document.getElementById(printpage).innerHTML;
		var oldstr = document.body.innerHTML;
		document.body.innerHTML = headstr + printData + footstr;
		window.print();
		document.body.innerHTML = oldstr;
		return false; */
	}
</script>
<title>div print</title>
</head>

<body>
	<input name="b_print" type="button" class="ipt"
		onClick="printdiv('div_print');" value=" Print ">

	<div id="div_print">

		<h1 style="Color:Red">The Div content which you want to print</h1>

	</div>
</body>

</html>
