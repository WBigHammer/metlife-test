my ($tgt_fh, $src_fh, $line,@value,$tablename,$i,$j,$plen,$filedtype,$len,$nullval,$offset,$pric,$scal,$poffset,$sql,$checknum) = ();

open $src_fh,  "<$ARGV[0]" or die exit 1;	
open $tgt_fh, ">$ARGV[1]";	

$checknum=$ARGV[2];
$tablename = substr($ARGV[0],0,length($ARGV[0])-4);

while($line=<$src_fh>) {
     chomp($line);
     push @name, $line;
}	

print $tgt_fh '<?xml version="1.0" encoding="UTF-8"?>'."\n";
print $tgt_fh '<!DOCTYPE POWERMART SYSTEM "powrmart.dtd">'."\n";
print $tgt_fh '<POWERMART CREATION_DATE="04/22/2016 11:06:18" REPOSITORY_VERSION="181.90">'."\n";
print $tgt_fh '<REPOSITORY NAME="Rep_UAT" VERSION="181" CODEPAGE="UTF-8" DATABASETYPE="Microsoft SQL Server">'."\n";
print $tgt_fh '<FOLDER NAME="DI_MIS" GROUP="" OWNER="Administrator" SHARED="NOTSHARED" DESCRIPTION="" PERMISSIONS="rwx---r--" UUID="d30d8f0f-df3b-4e61-ab71-7b38629c3248">'."\n";

#SOURCE
print $tgt_fh '    <SOURCE BUSINESSNAME ="" DATABASETYPE ="Flat File" DBDNAME ="FlatFile" DESCRIPTION ="" NAME ="F_'.$tablename.'" OBJECTVERSION ="1" OWNERNAME ="" VERSIONNUMBER ="3">'."\n";
print $tgt_fh '        <FLATFILE CODEPAGE ="MS936" CONSECDELIMITERSASONE ="NO" DELIMITED ="YES" DELIMITERS ="||" ESCAPE_CHARACTER ="" KEEPESCAPECHAR ="NO" LINESEQUENTIAL ="NO" MULTIDELIMITERSASAND ="YES" NULLCHARTYPE ="ASCII" NULL_CHARACTER ="*" PADBYTES ="1" QUOTE_CHARACTER ="NONE" REPEATABLE ="NO" ROWDELIMITER ="0" SHIFTSENSITIVEDATA ="NO" SKIPROWS ="0" STRIPTRAILINGBLANKS ="NO"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Base Table Name" VALUE =""/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Search Specification" VALUE =""/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Sort Specification" VALUE =""/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Datetime Format" VALUE ="A  19 mm/dd/yyyy hh24:mi:ss"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Thousand Separator" VALUE ="None"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Decimal Separator" VALUE ="."/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Add Currently Processed Flat File Name Port" VALUE ="NO"/>'."\n";
$offset= 0;
$poffset= 0;
$i=1;
foreach $line (@name) {
     chomp($line);
     @value=split(/\|/,$line); 
	 if(@value[1] =~ /^DATE/){
		$plen=26;
		$len=26;
		$pric=26;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 print $tgt_fh '        <SOURCEFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.$i.'" FIELDPROPERTY ="0" FIELDTYPE ="ELEMITEM" HIDDEN ="NO" KEYTYPE ="NOT A KEY" LENGTH ="'.$len.'" LEVEL ="0" NAME ="'.@value[0].'" NULLABLE ="'.$nullval.'" OCCURS ="0" OFFSET ="'.$offset.'" PHYSICALLENGTH ="'.$plen.'" PHYSICALOFFSET ="'.$poffset.'" PICTURETEXT ="" PRECISION ="'.$pric.'" SCALE ="0" USAGE_FLAGS =""/>'."\n";

     $i= $i +1;
	 $offset= $offset + $len;
	 $poffset= $poffset + $plen;
}	
	 print $tgt_fh '        <SOURCEFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.($i+1).'" FIELDPROPERTY ="0" FIELDTYPE ="ELEMITEM" HIDDEN ="NO" KEYTYPE ="NOT A KEY" LENGTH ="35" LEVEL ="0" NAME ="MD5_KEY" NULLABLE ="NULL" OCCURS ="0" OFFSET ="'.$offset.'" PHYSICALLENGTH ="32" PHYSICALOFFSET ="'.$poffset.'" PICTURETEXT ="" PRECISION ="32" SCALE ="0" USAGE_FLAGS =""/>'."\n";
	 print $tgt_fh '        <SOURCEFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.($i+2).'" FIELDPROPERTY ="0" FIELDTYPE ="ELEMITEM" HIDDEN ="NO" KEYTYPE ="NOT A KEY" LENGTH ="13" LEVEL ="0" NAME ="BATCHCODE" NULLABLE ="NULL" OCCURS ="0" OFFSET ="'.($offset+35).'" PHYSICALLENGTH ="13" PHYSICALOFFSET ="'.($poffset+35).'" PICTURETEXT ="" PRECISION ="13" SCALE ="0" USAGE_FLAGS =""/>'."\n";
 
print $tgt_fh '    </SOURCE>'."\n";











#TARGET  GOOD

print $tgt_fh '    <TARGET BUSINESSNAME ="" CONSTRAINT ="" DATABASETYPE ="Flat File" DESCRIPTION ="" NAME ="F_'.$tablename.'_FINAL" OBJECTVERSION ="1" TABLEOPTIONS ="" VERSIONNUMBER ="1">'."\n";


print $tgt_fh '        <FLATFILE CODEPAGE ="MS936" CONSECDELIMITERSASONE ="NO" DELIMITED ="YES" DELIMITERS =" || " ESCAPE_CHARACTER ="" KEEPESCAPECHAR ="NO" LINESEQUENTIAL ="NO" MULTIDELIMITERSASAND ="NO" NULLCHARTYPE ="ASCII" NULL_CHARACTER ="*" PADBYTES ="1" QUOTE_CHARACTER ="NONE" REPEATABLE ="NO" ROWDELIMITER ="0" SKIPROWS ="0" STRIPTRAILINGBLANKS ="NO"/>'."\n";


$i=1;
foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.$i.'" KEYTYPE ="NOT A KEY" NAME ="'.@value[0].'" NULLABLE ="'.$nullval.'" PICTURETEXT ="" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
     $i= $i +1;
}

print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.$i.'" KEYTYPE ="NOT A KEY" NAME ="MD5_KEY" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="35" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.($i+1).'" KEYTYPE ="NOT A KEY" NAME ="WORK_BATCH" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="14" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="'.($i+2).'" KEYTYPE ="NOT A KEY" NAME ="HHF" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="23" SCALE ="0"/>'."\n";


print $tgt_fh '        <TABLEATTRIBUTE NAME ="Datetime Format" VALUE ="A  19 mm/dd/yyyy hh24:mi:ss"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Thousand Separator" VALUE ="None"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Decimal Separator" VALUE ="."/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Line Endings" VALUE ="System default"/>'."\n";
print $tgt_fh '    </TARGET>'."\n";



#TARGET  BAD

print $tgt_fh '<TARGET BUSINESSNAME ="" CONSTRAINT ="" DATABASETYPE ="Flat File" DESCRIPTION ="" NAME ="BAD_DATA" OBJECTVERSION ="1" TABLEOPTIONS ="" VERSIONNUMBER ="1">'."\n";
print $tgt_fh '        <FLATFILE CODEPAGE ="MS936" CONSECDELIMITERSASONE ="NO" DELIMITED ="YES" DELIMITERS =" || " ESCAPE_CHARACTER ="" KEEPESCAPECHAR ="NO" LINESEQUENTIAL ="NO" MULTIDELIMITERSASAND ="NO" NULLCHARTYPE ="ASCII" NULL_CHARACTER ="*" PADBYTES ="1" QUOTE_CHARACTER ="NONE" REPEATABLE ="NO" ROWDELIMITER ="0" SKIPROWS ="0" STRIPTRAILINGBLANKS ="NO"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="1" KEYTYPE ="NOT A KEY" NAME ="P_KEY" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="2" KEYTYPE ="NOT A KEY" NAME ="P_KEY_VALUE" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="3" KEYTYPE ="NOT A KEY" NAME ="MD5_KEY" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="4" KEYTYPE ="NOT A KEY" NAME ="WRONG_COLUMN_NAME" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="5" KEYTYPE ="NOT A KEY" NAME ="COLUMN_VALUE" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TARGETFIELD BUSINESSNAME ="" DATATYPE ="string" DESCRIPTION ="" FIELDNUMBER ="6" KEYTYPE ="NOT A KEY" NAME ="REASON" NULLABLE ="NULL" PICTURETEXT ="" PRECISION ="100" SCALE ="0"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Datetime Format" VALUE ="A  19 mm/dd/yyyy hh24:mi:ss"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Thousand Separator" VALUE ="None"/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Decimal Separator" VALUE ="."/>'."\n";
print $tgt_fh '        <TABLEATTRIBUTE NAME ="Line Endings" VALUE ="System default"/>'."\n";
print $tgt_fh '    </TARGET>'."\n";



#TRANSFORMATION
print $tgt_fh '    <MAPPING DESCRIPTION ="" ISVALID ="YES" NAME ="m_AZ_TR_'.$tablename.'" OBJECTVERSION ="1" VERSIONNUMBER ="1">'."\n";
print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="SQ_F_'.$tablename.'" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Source Qualifier" VERSIONNUMBER ="1">'."\n";
$i=1;
foreach $line (@name) {
      $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
     $i= $i +1;
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="MD5_KEY" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="35" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="BATCHCODE" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="13" SCALE ="0"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Sql Query" VALUE =""/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="User Defined Join" VALUE =""/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Source Filter" VALUE =""/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Number Of Sorted Ports" VALUE ="0"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Select Distinct" VALUE ="NO"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Is Partitionable" VALUE ="NO"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Pre SQL" VALUE =""/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Post SQL" VALUE =""/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Output is deterministic" VALUE ="NO"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Output is repeatable" VALUE ="Never"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";


$i=1;
while ($i <= $checknum ){
print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="ROUTER_'.$i.'" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Router" VERSIONNUMBER ="1">'."\n";
print $tgt_fh '            <GROUP DESCRIPTION ="" NAME ="INPUT" ORDER ="1" TYPE ="INPUT"/>'."\n";
print $tgt_fh '            <GROUP DESCRIPTION ="" EXPRESSION ="TO_DECIMAL(CLNTNUM)  != 00112746" NAME ="GOOD" ORDER ="2" TYPE ="OUTPUT"/>'."\n";
print $tgt_fh '            <GROUP DESCRIPTION ="Path for the data when none of the group conditions are satisfied." NAME ="DEFAULT1" ORDER ="4" TYPE ="OUTPUT/DEFAULT"/>'."\n";
print $tgt_fh '            <GROUP DESCRIPTION ="" EXPRESSION ="TO_DECIMAL(CLNTNUM)  = 00112746" NAME ="BAD" ORDER ="3" TYPE ="OUTPUT"/>'."\n";

foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="INPUT" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="INPUT" NAME ="MD5_KEY" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="35" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="INPUT" NAME ="BATCHCODE" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="13" SCALE ="0"/>'."\n";
foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="GOOD" NAME ="'.@value[0].'_G" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="'.$pric.'" REF_FIELD ="'.@value[0].'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="GOOD" NAME ="MD5_KEY_G" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="35" REF_FIELD ="MD5_KEY" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="GOOD" NAME ="BATCHCODE_G" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="13" REF_FIELD ="BATCHCODE" SCALE ="0"/>'."\n";
foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="BAD" NAME ="'.@value[0].'_B" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="'.$pric.'" REF_FIELD ="'.@value[0].'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="BAD" NAME ="MD5_KEY_B" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="35" REF_FIELD ="MD5_KEY" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="BAD" NAME ="BATCHCODE_B" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="13" REF_FIELD ="BATCHCODE" SCALE ="0"/>'."\n";

foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="DEFAULT1" NAME ="'.@value[0].'_D" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="'.$pric.'" REF_FIELD ="'.@value[0].'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="DEFAULT1" NAME ="MD5_KEY_D" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="35" REF_FIELD ="MD5_KEY" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" GROUP ="DEFAULT1" NAME ="BATCHCODE_D" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="13" REF_FIELD ="BATCHCODE" SCALE ="0"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";

print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="GOOD_'.$i.'" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Expression" VERSIONNUMBER ="2">'."\n";
foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="'.@value[0].'" EXPRESSIONTYPE ="GENERAL" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="MD5_KEY" EXPRESSIONTYPE ="GENERAL" NAME ="MD5_KEY" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="35" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="BATCHCODE" EXPRESSIONTYPE ="GENERAL" NAME ="BATCHCODE" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="13" SCALE ="0"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";


print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="BAD_'.$i.'" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Expression" VERSIONNUMBER ="1">'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="&apos;HIST_ID&apos;||&apos;#&apos;||&apos;VALIDFLAG&apos;" EXPRESSIONTYPE ="GENERAL" NAME ="P_KEY_NAME" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="10" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="P_KEY1" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="23" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="P_KEY2" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="4" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="P_KEY1||&apos;#&apos;||P_KEY2" EXPRESSIONTYPE ="GENERAL" NAME ="P_KEY_OUT" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="10" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="MD5_KEY3" EXPRESSIONTYPE ="GENERAL" NAME ="MD5_KEY3" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="32" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="&apos;CLNTNUM&apos;" EXPRESSIONTYPE ="GENERAL" NAME ="COLUMN_NAME" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="13" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="COLUMN_VALUE" EXPRESSIONTYPE ="GENERAL" NAME ="COLUMN_VALUE" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="11" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="&apos;CLNTNUM = 00112746&apos;" EXPRESSIONTYPE ="GENERAL" NAME ="REASON" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="50" SCALE ="0"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";



$i= $i +1;
}

print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="RANK" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Rank" VERSIONNUMBER ="1">'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="integer" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="RANKINDEX" EXPRESSIONTYPE ="RANKINDEX" NAME ="RANKINDEX" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="10" SCALE ="0"/>'."\n";

foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 if(@value[0] eq "HIST_ID"){
	 	 	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="'.@value[0].'" EXPRESSIONTYPE ="GROUPBY" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";

	 }elsif(@value[0] eq "ETL_DATATIME"){
	 	 	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="'.@value[0].'" EXPRESSIONTYPE ="RANKPORT" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";

	 }else{
	 	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="'.@value[0].'" EXPRESSIONTYPE ="GENERAL" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
	 }
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="MD5_KEY" EXPRESSIONTYPE ="GENERAL" NAME ="MD5_KEY" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="32" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" EXPRESSION ="BATCHCODE" EXPRESSIONTYPE ="GENERAL" NAME ="BATCHCODE" PICTURETEXT ="" PORTTYPE ="INPUT/OUTPUT" PRECISION ="13" SCALE ="0"/>'."\n";

print $tgt_fh '            <TABLEATTRIBUTE NAME ="Cache Directory" VALUE ="$PMCacheDir"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Top/Bottom" VALUE ="Top"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Number of Ranks" VALUE ="1"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Case Sensitive String Comparison" VALUE ="YES"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Rank Data Cache Size" VALUE ="Auto"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Rank Index Cache Size" VALUE ="Auto"/>'."\n";
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Transformation Scope" VALUE ="All Input"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";


print $tgt_fh '        <TRANSFORMATION DESCRIPTION ="" NAME ="TRIM_WORK" OBJECTVERSION ="1" REUSABLE ="NO" TYPE ="Expression" VERSIONNUMBER ="2">'."\n";
foreach $line (@name) {
     $scal=0;
     chomp($line);
     @value=split(/\|/,$line); 
	 
	 if(@value[1] =~ /^DATE/){
		$plen=23;
		$len=23;
		$pric=23;
	 }elsif(@value[1] =~ /^NUMBER/){
		if(@value[1] =~ /,/){
		    @value[1] =~ /[(](\d+)[,]*(\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}else{
		    @value[1] =~ /[(](\d+)[)]/;
            $plen=$1+3;
			$len=$1+3;
		}
		$pric=$plen;
	 }elsif(@value[1] =~ /^VARCHAR2/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^CHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }elsif(@value[1] =~ /^NCHAR/){
		@value[1] =~ /[(]([\d]+)[)]/;
		$plen=$1+3;
		$len=$1+3;
		$pric=$1+3;
	 }
	 
	 if(@value[2] ne 'NOTNULL'){
	     $nullval='NULL';
	 }else{
	     $nullval='NOTNULL';
	 }
	 
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="'.@value[0].'" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="'.$pric.'" SCALE ="0"/>'."\n";
	 print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="LTRIM(RTRIM('.@value[0].'))" EXPRESSIONTYPE ="GENERAL" NAME ="'.@value[0].'_OUT" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="'.($pric-3).'" SCALE ="0"/>'."\n";
}
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="MD5_KEY" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="35" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="LTRIM(RTRIM(MD5_KEY))" EXPRESSIONTYPE ="GENERAL" NAME ="MD5_KEY_OUT" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="32" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="" DESCRIPTION ="" NAME ="BATCHCODE" PICTURETEXT ="" PORTTYPE ="INPUT" PRECISION ="14" SCALE ="0"/>'."\n";
print $tgt_fh '            <TRANSFORMFIELD DATATYPE ="string" DEFAULTVALUE ="ERROR(&apos;transformation error&apos;)" DESCRIPTION ="" EXPRESSION ="LTRIM(RTRIM(BATCHCODE))" EXPRESSIONTYPE ="GENERAL" NAME ="BATCHCODE_OUT" PICTURETEXT ="" PORTTYPE ="OUTPUT" PRECISION ="11" SCALE ="0"/>'."\n";
 
print $tgt_fh '            <TABLEATTRIBUTE NAME ="Tracing Level" VALUE ="Normal"/>'."\n";
print $tgt_fh '        </TRANSFORMATION>'."\n";


        
print $tgt_fh '        <INSTANCE DBDNAME ="FlatFile" DESCRIPTION ="" INSTANCEID ="1" NAME ="F_'.$tablename.'" TRANSFORMATION_NAME ="F_'.$tablename.'" TRANSFORMATION_TYPE ="Source Definition" TYPE ="SOURCE"/>'."\n";
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="2" NAME ="SQ_F_'.$tablename.'" REUSABLE ="NO" TRANSFORMATION_NAME ="SQ_F_'.$tablename.'" TRANSFORMATION_TYPE ="Source Qualifier" TYPE ="TRANSFORMATION">'."\n";
print $tgt_fh '                    <ASSOCIATED_SOURCE_INSTANCE NAME ="F_'.$tablename.'"/>'."\n";
print $tgt_fh '        </INSTANCE>'."\n";


$i=1;
$j=3;
while ($i <= $checknum ){
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="ROUTER_'.$i.'" REUSABLE ="NO" TRANSFORMATION_NAME ="ROUTER_'.$i.'" TRANSFORMATION_TYPE ="Router" TYPE ="TRANSFORMATION"/>'."\n";
$j=$j+1;
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="GOOD_'.$i.'" REUSABLE ="NO" TRANSFORMATION_NAME ="GOOD_'.$i.'" TRANSFORMATION_TYPE ="Expression" TYPE ="TRANSFORMATION"/>'."\n";
$j=$j+1;
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="BAD_'.$i.'" REUSABLE ="NO" TRANSFORMATION_NAME ="BAD_'.$i.'" TRANSFORMATION_TYPE ="Expression" TYPE ="TRANSFORMATION"/>'."\n";
$j=$j+1;
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="BAD_DATA_'.$i.'" TRANSFORMATION_NAME ="BAD_DATA" TRANSFORMATION_TYPE ="Target Definition" TYPE ="TARGET"/>'."\n";
$j=$j+1;
$i=$i+1;
}
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="F_'.$tablename.'_FINAL" TRANSFORMATION_NAME ="F_'.$tablename.'_FINAL" TRANSFORMATION_TYPE ="Target Definition" TYPE ="TARGET"/>'."\n";
$j=$j+1;
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="RANK" REUSABLE ="NO" TRANSFORMATION_NAME ="RANK" TRANSFORMATION_TYPE ="Rank" TYPE ="TRANSFORMATION"/>'."\n";
$j=$j+1;
print $tgt_fh '        <INSTANCE DESCRIPTION ="" INSTANCEID ="'.$j.'" NAME ="TRIM_WORK" REUSABLE ="NO" TRANSFORMATION_NAME ="TRIM_WORK" TRANSFORMATION_TYPE ="Expression" TYPE ="TRANSFORMATION"/>'."\n";
$j=$j+1;



$i=1;
while ($i <= $checknum ){
print $tgt_fh '        <CONNECTOR FROMFIELD ="P_KEY_NAME" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="P_KEY" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="P_KEY_OUT" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="P_KEY_VALUE" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY3" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="MD5_KEY" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="COLUMN_NAME" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="WRONG_COLUMN_NAME" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="COLUMN_VALUE" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="COLUMN_VALUE" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="REASON" FROMINSTANCE ="BAD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="REASON" TOINSTANCE ="BAD_DATA_'.$i.'" TOINSTANCETYPE ="Target Definition"/>'."\n";
$i=$i+1;
}

foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'" FROMINSTANCE ="RANK" FROMINSTANCETYPE ="Rank" TOFIELD ="'.@value[0].'" TOINSTANCE ="F_'.$tablename.'_FINAL" TOINSTANCETYPE ="Target Definition"/>'."\n"; 
}

print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY" FROMINSTANCE ="RANK" FROMINSTANCETYPE ="Rank" TOFIELD ="MD5_KEY" TOINSTANCE ="F_'.$tablename.'_FINAL" TOINSTANCETYPE ="Target Definition"/>'."\n"; 
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE" FROMINSTANCE ="RANK" FROMINSTANCETYPE ="Rank" TOFIELD ="WORK_BATCH" TOINSTANCE ="F_'.$tablename.'_FINAL" TOINSTANCETYPE ="Target Definition"/>'."\n"; 

foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'" FROMINSTANCE ="SQ_F_'.$tablename.'" FROMINSTANCETYPE ="Source Qualifier" TOFIELD ="'.@value[0].'" TOINSTANCE ="TRIM_WORK" TOINSTANCETYPE ="Expression"/>'."\n"; 
}
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY" FROMINSTANCE ="SQ_F_'.$tablename.'" FROMINSTANCETYPE ="Source Qualifier" TOFIELD ="MD5_KEY" TOINSTANCE ="TRIM_WORK" TOINSTANCETYPE ="Expression"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE" FROMINSTANCE ="SQ_F_'.$tablename.'" FROMINSTANCETYPE ="Source Qualifier" TOFIELD ="BATCHCODE" TOINSTANCE ="TRIM_WORK" TOINSTANCETYPE ="Expression"/>'."\n";


foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'" FROMINSTANCE ="F_'.$tablename.'" FROMINSTANCETYPE ="Source Definition" TOFIELD ="'.@value[0].'" TOINSTANCE ="SQ_F_'.$tablename.'" TOINSTANCETYPE ="Source Qualifier"/>'."\n"; 
}

print $tgt_fh '        <CONNECTOR FROMFIELD ="ID" FROMINSTANCE ="F_'.$tablename.'" FROMINSTANCETYPE ="Source Definition" TOFIELD ="ID" TOINSTANCE ="SQ_F_'.$tablename.'" TOINSTANCETYPE ="Source Qualifier"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY" FROMINSTANCE ="F_'.$tablename.'" FROMINSTANCETYPE ="Source Definition" TOFIELD ="MD5_KEY" TOINSTANCE ="SQ_F_'.$tablename.'" TOINSTANCETYPE ="Source Qualifier"/>'."\n";


foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'_OUT" FROMINSTANCE ="TRIM_WORK" FROMINSTANCETYPE ="Expression" TOFIELD ="'.@value[0].'" TOINSTANCE ="ROUTER_1" TOINSTANCETYPE ="Router"/>'."\n"; 
}
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY_OUT" FROMINSTANCE ="TRIM_WORK" FROMINSTANCETYPE ="Expression" TOFIELD ="MD5_KEY" TOINSTANCE ="ROUTER_1" TOINSTANCETYPE ="Router"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE_OUT" FROMINSTANCE ="TRIM_WORK" FROMINSTANCETYPE ="Expression" TOFIELD ="BATCHCODE" TOINSTANCE ="ROUTER_1" TOINSTANCETYPE ="Router"/>'."\n";


$i=1;
while ($i <= $checknum ){
foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'_G" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="'.@value[0].'" TOINSTANCE ="GOOD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n"; 
}
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY_G" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="MD5_KEY" TOINSTANCE ="GOOD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE_G" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="BATCHCODE" TOINSTANCE ="GOOD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";

print $tgt_fh '        <CONNECTOR FROMFIELD ="HIST_ID_B" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="P_KEY1" TOINSTANCE ="BAD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY_B" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="MD5_KEY3" TOINSTANCE ="BAD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="VALIDFLAG_B" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="P_KEY2" TOINSTANCE ="BAD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="CLNTNUM_B" FROMINSTANCE ="ROUTER_'.$i.'" FROMINSTANCETYPE ="Router" TOFIELD ="COLUMN_VALUE" TOINSTANCE ="BAD_'.$i.'" TOINSTANCETYPE ="Expression"/>'."\n";
if($i < $checknum){
foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="'.@value[0].'" TOINSTANCE ="ROUTER_'.($i+1).'" TOINSTANCETYPE ="Router"/>'."\n"; 
}
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="MD5_KEY" TOINSTANCE ="ROUTER_'.($i+1).'" TOINSTANCETYPE ="Router"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="BATCHCODE" TOINSTANCE ="ROUTER_'.($i+1).'" TOINSTANCETYPE ="Router"/>'."\n";

}else{
foreach $line (@name) {
    chomp($line);
    @value=split(/\|/,$line); 
    print $tgt_fh '        <CONNECTOR FROMFIELD ="'.@value[0].'" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="'.@value[0].'" TOINSTANCE ="RANK" TOINSTANCETYPE ="Rank"/>'."\n"; 
}
print $tgt_fh '        <CONNECTOR FROMFIELD ="MD5_KEY" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="MD5_KEY" TOINSTANCE ="RANK" TOINSTANCETYPE ="Rank"/>'."\n";
print $tgt_fh '        <CONNECTOR FROMFIELD ="BATCHCODE" FROMINSTANCE ="GOOD_'.$i.'" FROMINSTANCETYPE ="Expression" TOFIELD ="BATCHCODE" TOINSTANCE ="RANK" TOINSTANCETYPE ="Rank"/>'."\n";
}


$i=$i+1;
}


$i=1;
while ($i <= $checknum ){
print $tgt_fh '        <TARGETLOADORDER ORDER ="1" TARGETINSTANCE ="BAD_DATA_'.$i.'"/>'."\n";
$i=$i+1;
}

print $tgt_fh '        <TARGETLOADORDER ORDER ="1" TARGETINSTANCE ="F_'.$tablename.'_FINAL"/>'."\n";
print $tgt_fh '        <ERPINFO/>'."\n";
print $tgt_fh '    </MAPPING>'."\n";



print $tgt_fh '</FOLDER>'."\n";
print $tgt_fh '</REPOSITORY>'."\n";
print $tgt_fh '</POWERMART>'."\n";
close $src_fh;
close $tgt_fh;