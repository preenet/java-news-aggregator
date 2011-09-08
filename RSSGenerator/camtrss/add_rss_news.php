<?
$link = mysql_pconnect("localhost","camt_root","root") or die('Count not connect database');
//$link = mysql_pconnect("localhost","root","camt") or die('Count not connect database');
$dbname="camt_news";
mysql_db_query($dbname,"SET NAMES utf8");

$query = "SELECT * FROM news where shows = 1 ORDER BY id DESC";
$result = mysql_query($query) or die(mysql_error()); 
if (mysql_num_rows($result) < 1) { 
    die("No records"); 
} 

$items = "";
$i = 1; 
while ($row = mysql_fetch_assoc($result)) { 
	$num = $i;
    $stitle = $row["news"]; 
	$link = "";
    if ($row[file1] != ""){
	
		$link .= '<![CDATA[<a href="http://www.camt.cmu.ac.th/th/docs/'.$row["attach1"].'"  target="_blank">'.$row[file1].'</a>  ]]> ';
	}
	if ($row[file2] != "") { 
	
		$link .= '<![CDATA[ <a href="http://www.camt.cmu.ac.th/th/docs/'.$row["attach2"].'"  target="_blank">'.$row[file2].'</a>  ]]> '; 
	
	}
	if ($row[file3] != "") {

		$link3 .= '<![CDATA[ <a href="http://www.camt.cmu.ac.th/th/docs/'.$row["attach3"].'"  target="_blank">'.$row[file3].'</a>  ]]>';

	}
   
    $items .= "
		<item>
			<title>$stitle</title>
			<description>$link</description>
			<category>News</category>
			<guid>http://www.camt.cmu.ac.th/#".$row["id"]."</guid>
        </item>";
$i = $i+1;
} 

$content = '<?xml version="1.0"?>
<rss version="2.0" xmlns:atom="http://www.w3.org/2005/Atom">
        <channel>      
			<title>CAMT News</title>
			<link>http://www.camt.cmu.ac.th</link>
			<description>College of Arts, Media and Techonology (CAMT) News</description>	
			<language>en-us</language>
			<copyright>Copyright 2010-2012 College of Arts, Media and Techonology (CAMT)</copyright>
			<lastBuildDate>'.date("D, d M y H:i:s O").'</lastBuildDate>
			<generator>Kanitta</generator>
			<managingEditor>camt_cmu@hotmail.com (College of Arts, Media and Technology)</managingEditor>
			<webMaster>camt_cmu@hotmail.com (College of Arts, Media and Technology)</webMaster>
			<ttl>60</ttl>
			<atom:link href="http://www.camt.cmu.ac.th/th/camtrss/rss/rss_news.xml" rel="self" type="application/rss+xml" />		
      '.$items.'
        </channel> 
</rss> 
';

$f = fopen("rss/rss_news.xml","w"); // open new file
//fputs($f,"header('Content-type: application/rss+xml'); ");// wrire
fputs($f,$content);// wrire
//echo'<script>location.href="index.php";</script>';
//header('Content-type: application/rss+xml'); 
//echo $content; 
 ?>