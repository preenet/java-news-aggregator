<?
$link = mysql_pconnect("localhost","camt_root","root") or die('Count not connect database');
//$link = mysql_pconnect("localhost","root","camt") or die('Count not connect database');
$dbname="camt_activity";
mysql_db_query($dbname,"SET NAMES utf8");

$query = "SELECT * FROM activity where groups2 = 1 ORDER BY id DESC limit 0,1";
$result = mysql_query($query) or die(mysql_error()); 
if (mysql_num_rows($result) < 1) { 
    die("No records"); 
} 

$items = '';
$i = 1; 
while ($row = mysql_fetch_assoc($result)) { 
 $dt = $row["id"];
    $stitle = $row["content"]; 
	$desc = $row["details"];
	}
    $link = '<![CDATA[<a href="http://www.camt.cmu.ac.th/th/main/activity1.php"  target="_blank">'.$row[file1].'</a>  ]]> ';



if ($dt == "") {$dt=0;}
$dirname = "./activity/images/".$dt;		
$dh = opendir($dirname);
$photo = "";
$img = "";
$encloure = "";
		$i = 1;
					while ((false !== ($pic = readdir($dh))) && ($i <= 1)) 
					{ 
					if (($pic == ".") || ($pic == "..") || ($pic == "Thumbs.db")) { } else 
							{
										 $photo = $photo.'<img src= "http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic.' "/>   ';
										$img ='http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic ;
										$encloure.="<enclosure url='".$img."' type='image/jpg'/>";		
										
										$i = $i+1;
							}
						
						
					}closedir($dh);	//while			

		$photo = "<![CDATA[<div>".$photo."</div>  ]]>";
   
    $items .= "
		<item>
		<title>$stitle</title>
			<link>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</link>
			<description>$desc.$photo</description>
			<guid>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</guid>
			<category>ข่าวสำหรับบุคลากร</category>
			<comments>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</comments>
        </item> 
";
//<enclosure url='$img' length='1069871' type='image/jpg'/>;

/*========================================================================================*/
$query = "SELECT * FROM activity where groups2 = 2 ORDER BY id DESC limit 0,1";
$result = mysql_query($query) or die(mysql_error()); 
if (mysql_num_rows($result) < 1) { 
    die("No records"); 
} 

$items2 = '';
$i = 1; 
while ($row = mysql_fetch_assoc($result)) { 
 $dt = $row["id"];
    $stitle = $row["content"]; 
	$desc = $row["details"];
	}

if ($dt == "") {$dt=0;}
$dirname = "./activity/images/".$dt;		
$dh = opendir($dirname);
$photo = "";
$img = "";
$encloure = "";
		$i = 1;
					while ((false !== ($pic = readdir($dh))) && ($i <= 1)) 
					{ 
					if (($pic == ".") || ($pic == "..") || ($pic == "Thumbs.db")) { } else 
							{
										 $photo = $photo.'<img src= "http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic.' "/>   ';
										$img ='http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic;
										
										$encloure.="<enclosure url='".$img."' type='image/jpg'/>";
										$i = $i+1;
							}
						
					}closedir($dh);	//while				

		$photo = "<![CDATA[<div>".$photo."</div>  ]]>";
   
    $items2 .= "
				<item>
		<title>$stitle</title>
			<link>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</link>
			<description>$desc.$photo</description>
			<guid>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</guid>
			<category>Activity Group 2</category>
			<comments>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</comments>
        </item> 
";
/*========================================================================================*/
$query = "SELECT * FROM activity where groups2 = 3 ORDER BY id DESC limit 0,1";
$result = mysql_query($query) or die(mysql_error()); 
if (mysql_num_rows($result) < 1) { 
    die("No records"); 
} 

$items3 = '';
$i = 1; 
while ($row = mysql_fetch_assoc($result)) { 
 $dt = $row["id"];
    $stitle = $row["content"]; 
	$desc = $row["details"];
	}

if ($dt == "") {$dt=0;}
$dirname = "./activity/images/".$dt;		
$dh = opendir($dirname);
$photo = "";
//$img = "";
$encloure = "";
		$i = 1;
					while ((false !== ($pic = readdir($dh))) && ($i <= 1)) 
					{ 
					if (($pic == ".") || ($pic == "..") || ($pic == "Thumbs.db")) { } else 
							{
										 $photo = $photo.'<img src= "http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic.' "/>   ';
										$img ='http://www.camt.cmu.ac.th/th/activity/images/'.$dt.'/'.$pic;
										
										$encloure.="<enclosure url='".$img."' type='image/jpg'/>";
										
										$i = $i+1;
							}
							
						
					}closedir($dh);	//while				

		$photo = "<![CDATA[<div>".$photo."</div>  ]]>";
   
    $items3 .= "			
		<item>
		<title>$stitle</title>
			<link>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</link>
			<description>$desc.$photo</description>
			<guid>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</guid>
			".$encloure."
			<category>Activity Group 3</category>
			<comments>http://www.camt.cmu.ac.th/th/rss/activity_detail?id=$dt</comments>
        </item> 
";
/*========================================================================================*/


$content = '<?xml version="1.0"?>
<rss version="2.0" xmlns:atom="http://www.w3.org/2005/Atom">
        <channel>      
			<title>College of Arts, Media and Techonology (CAMT)s Activity RSS</title>
			<link>http://www.camt.cmu.ac.th</link>
			<description>College of Arts, Media and Techonology (CAMT)s Activity RSS</description>	
			<language>en-us</language>
			<copyright>Copyright 2010-2012 College of Arts, Media and Techonology (CAMT)</copyright>
			<lastBuildDate>'.date("D, d M y H:i:s O").'</lastBuildDate>
			<generator>Kanitta</generator>
			<managingEditor>camt_cmu@hotmail.com (College of Arts, Media and Technology)</managingEditor>
			<webMaster>camt_cmu@hotmail.com (College of Arts, Media and Technology)</webMaster>
			<ttl>60</ttl>
			<atom:link href="http://www.camt.cmu.ac.th/th/camtrss/rss/rss_activity.xml" rel="self" type="application/rss+xml" />
		  '.$items . $items2 . $items3.'
        </channel> 
</rss> 
';

$f = fopen("rss/rss_activity.xml","w"); // open new file
//fputs($f,"header('Content-type: application/rss+xml'); ");

// write rss file
fputs($f,$content);

// Redirect
//echo'<script>location.href="index.php";</script>';
//header('Content-type: application/rss+xml'); 
//echo $content; 
 ?>