<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style type="text/css">


#apDiv2 {
	font-size:16px;
	position:absolute;
	left:100px;
	top:8px;
	width:755px;
	height:127px;
	z-index:2;
}

#apDiv2:hover{
	background-color:#EBEBEB;}
#apDiv2  a:link,a:visited{
	 text-decoration: none;
	color:#000}
#apDiv2 a:hover{
		 text-decoration: none;
		background-color:#CCC
		}

#apDiv3 {
	font-weight:bold;
	font-size:24px;
	position:absolute;
	left:942px;
	top:28px;
	width:345px;
	height:32px;
	z-index:3;
}

#apDiv13 {
	border:1px solid #CCC;
	position:absolute;
	left:910px;
	top:12px;
	width:0px;
	height:1070px;
	z-index:13;
}



#apDiv1 {
	position:absolute;
	left:100px;
	width:755px;
	height:162px;
	z-index:29;
	top: 134px;
}
#apDiv1:hover{
	background-color:#EBEBEB;}

#apDiv4 {
	position:absolute;
	left:255px;
	top:20px;
	width:496px;
	height:118px;
	z-index:30;
}
#apDiv4 a1{
	font-size:25px;
	font-weight:bold
	}
#apDiv4 a1 a:link,a:visited{
	 text-decoration: none;
	color:#000}
	#apDiv4 a1 a:hover{
		 text-decoration: none;
		background-color:#CCC
		}
#apDiv5 {
	position:absolute;
	left:100px;
	top:296px;
	width:755px;
	height:162px;
	z-index:31;
}
#apDiv5:hover{
	background-color:#EBEBEB;}

#img{
	position:absolute;
	left:0px;
	top:20px;
	width:236px;
	height:118px;
	z-index:31;
	}
#apDiv6 {
	position:absolute;
	left:255px;
	top:20px;
	width:496px;
	height:118px;
	z-index:30;
}

#apDiv6 a1{
	font-size:25px;
	font-weight:bold;
	}

#apDiv7 {
	position:absolute;
	left:100px;
	top:461px;
	width:755px;
	height:143px;
	z-index:32;
}
	
#apDiv7 a1{
	font-size:28px;
	font-weight:bold;
	}
#apDiv7:hover{
	background-color:#EBEBEB;}	

#apDiv8 {
	position:absolute;
	left:101px;
	top:607px;
	width:755px;
	height:143px;
	z-index:33;
}
#apDiv8:hover{
	background-color:#EBEBEB;}
#text {
	position:absolute;
	left:0px;
	top:23px;
	width:755px;
	height:97px;
	z-index:30;
}
#apDiv8 a1{
	font-size:28px;
	font-weight:bold;
	}
#apDiv9 {
	position:absolute;
	left:100px;
	top:753px;
	width:755px;
	height:143px;
	z-index:33;
}
#apDiv9 a1{
	font-size:28px;
	font-weight:bold;
	}
	#apDiv9:hover{
	background-color:#EBEBEB;}
#apDiv10 {
	position:absolute;
	left:102px;
	top:897px;
	width:755px;
	height:143px;
	z-index:33;
}
#apDiv10 a1{
	font-size:28px;
	font-weight:bold;
	}
	#apDiv10:hover{
	background-color:#EBEBEB;}
#border{
	width:755px;
	border:1px solid #CCC;
	position:absolute;
	left:-6px;
	top:-816px;
	
	z-index:30;
}
#all {
	position:absolute;
	left:-1px;
	top:8px;
	width:1275px;
	height:1206px;
	z-index:34;
}
#all-1 {
	position:absolute;
	left:2px;
	top:7px;
	width:890px;
	height:1135px;
	z-index:35;
}
#apDiv11 {
	position:absolute;
	left:896px;
	top:28px;
	width:331px;
	height:485px;
	z-index:35;
}
#apDiv12 {
	font-weight:bold;
	color:#039;
	font-size:24px;
	position:absolute;
	left:6px;
	top:17px;
	width:125px;
	height:27px;
	z-index:36;
}
#apDiv14 {
	border:1px solid #CCC;
	position:absolute;
	left:6px;
	top:50px;
	width:255px;
	height:0px;
	z-index:36;
}
#apDiv15 {
	position:absolute;
	left:-4px;
	top:27px;
	width:292px;
	height:374px;
	z-index:36;
}
#apDiv16 {
	position:absolute;
	left:4px;
	top:10px;
	width:268px;
	height:25px;
	z-index:36;
}
#apDiv17 {
	position:absolute;
	left:4px;
	top:46px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv18 {
	position:absolute;
	left:4px;
	top:99px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv19 {
	position:absolute;
	left:6px;
	top:154px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv20 {
	position:absolute;
	left:6px;
	top:205px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv21 {
	position:absolute;
	left:7px;
	top:258px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv22 {
	position:absolute;
	left:7px;
	top:314px;
	width:271px;
	height:44px;
	z-index:36;
}
#apDiv23 {
	position:absolute;
	left:896px;
	top:531px;
	width:364px;
	height:592px;
	z-index:36;
}
#apDiv24 {
	font-size:24px;
	font-weight:bold;
	color:#039;
	position:absolute;
	left:8px;
	top:14px;
	width:209px;
	height:31px;
	z-index:37;
}
#apDiv25 {
	border:1px solid #CCC;
	position:absolute;
	left:6px;
	top:53px;
	width:293px;
	height:0px;
	z-index:37;
}
#apDiv26 {
	position:absolute;
	left:899px;
	top:601px;
	width:340px;
	height:229px;
	z-index:37;
}
#apDiv27 {
	position:absolute;
	left:6px;
	top:8px;
	width:311px;
	height:177px;
	z-index:38;
}
#apDiv28 {
	font-size::20px;
	font-weight:bold;
	position:absolute;
	left:7px;
	top:190px;
	width:311px;
	height:25px;
	z-index:38;
}
#apDiv29 {
	position:absolute;
	left:897px;
	top:834px;
	width:337px;
	height:248px;
	z-index:38;
}
#apDiv30 {
	position:absolute;
	left:6px;
	top:9px;
	width:311px;
	height:177px;
	z-index:39;
}
#apDiv31 {
	font-size::20px;
	font-weight:bold;
	position:absolute;
	left:5px;
	top:196px;
	width:319px;
	height:44px;
	z-index:39;
}
#apDiv32 {
	position:absolute;
	left:122px;
	top:1170px;
	width:398px;
	height:2px;
	z-index:39;
}
#border1 {
	position:absolute;
	left:102px;
	top:301px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv33 {
	position:absolute;
	left:102px;
	top:465px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv34 {
	position:absolute;
	left:103px;
	top:611px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv35 {
	position:absolute;
	left:103px;
	top:758px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv36 {
	position:absolute;
	left:102px;
	top:901px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv37 {
	position:absolute;
	left:102px;
	top:1047px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
#apDiv38 {
	position:absolute;
	left:100px;
	top:141px;
	width:755px;
	border:1px solid #CCC;
	height:0px;
	z-index:39;
}
</style>
</head>

<body >

<div id="all">
<div id="all-1">
<div id="apDiv2">
  <h1 align="center" ><a href="#">中国国际青年电影展&ldquo;网大盛典&rdquo;圆满落幕，映美传媒4部作品获7项提名2个奖项</a></h1>
</div>
<div id="apDiv1"><div id="img"><img src="img/movie1.jpg" width="236" height="118" /></div><div id="apDiv4"><a1><a href="#">"比利林恩"11月6日内地首映 李安携主创双城亮相</a></a1><br />
<a2>李安导演将于11月初携新作《比利·林恩的中场战事》亮相内地，分别于11月6日至8日在北京、上海两地举办首映礼。"　　11月6日，导演李安将携主演乔·阿尔文、李淳等人在北京参加红毯首映。</a2></div></div>

<div id="apDiv5"><div id="img"><img src="img/movie2.jpg" width="236" height="118" /></div>
  <div id="apDiv6">
    <a1><a href="#">《乘风破浪》赵丽颖担纲女主 惊喜现身引热议亮相</a></a1>
    <br />
    <a2>近日，韩寒在微博曝出赵丽颖将参演新片《乘风破浪》，一时间全网热闹非凡。首映。</a2>
  </div>
</div>




<div id="apDiv7"><div id="text"><a1>${moviePage.pageBeanList[0].ntitle}</a1><br />
<a2>${moviePage.pageBeanList[0].ncontent}</a2></div>
</div>
<div id="apDiv8"><div id="text">
<a1>${moviePage.pageBeanList[1].ntitle}</a1><br /><a2>${moviePage.pageBeanList[1].ncontent}</a2></div>
</div>
<div id="apDiv9"><div id="text">
<a1>${moviePage.pageBeanList[2].ntitle}</a1><br /><a2>${moviePage.pageBeanList[2].ncontent}</a2></div>
</div>
<div id="apDiv10">

   <div id="text">
        <a1>${moviePage.pageBeanList[3].ntitle}</a1><br /><a>${moviePage.pageBeanList[3].ncontent}</a>



    </div>
</div>
</div>
<div id="apDiv38"></div>
<div id="border1"></div>
<div id="apDiv33"></div>
<div id="apDiv34"></div>
<div id="apDiv35"></div>
<div id="apDiv36"></div>
<div id="apDiv37"></div>
</div>

<div id="apDiv11"><div id="apDiv12">最热新闻 </div>
<div id="apDiv14">
<div id="apDiv15">
<div id="apDiv16">日本老龄化严重 八九十岁仍外出打工</div> 
<div id="apDiv17">安迪上线！刘涛受邀出席巴黎时装周酷帅启程</div>  
<div id="apDiv18">浙江杭州萧山机场现国内首家"胶囊"旅馆</div>  
<div id="apDiv19">朱莉皮特宣布离婚 回顾两人昔日甜蜜瞬间</div>  
<div id="apDiv20">癌症晚期狗狗陪主人完婚 婚礼成泪海</div> 
<div id="apDiv21">新版吉尼斯世界纪录 只有想不到没有做不到</div> 
<div id="apDiv22">16岁英国女孩靠给中国宝宝取英文名已赚超4万英镑</div> 
</div></div>
</div>



<div id="apDiv23">
<div id="apDiv24">精彩推荐</div>
<div id="apDiv25"></div>
</div>


<div id="apDiv26"><div id="apDiv27"><img src="img/movie3.jpg" width="310" height="175" /></div>
<div id="apDiv28">经典照"胜利之吻"女主角去世</div>
</div>


<div id="apDiv29"><div id="apDiv30"><img src="img/movie4.jpg" width="311" height="175" /></div>
<div id="apDiv31">华裔女孩22年前被弃天坛公园 从美返京寻亲</div></div>








</body>
</html>
