<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>黑球网_自选股新闻推送页</title>
<style>
body,td,th {font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 12px; line-height:24px} 
a{ text-decoration:none;}
a:hover{ text-decoration:underline;}

.tb01 { font-size:12px; font-weight:bold; color:#515151; background:url(../assets/images/assets-bj2.png) repeat-x; width:100%; height:43px; border:0px solid #EEE9E9}
.bg01 { background-color:#E5E5E5}
.bg02 { background-color:#FFFFFF}
.bg03 { background-color:#F0F8FF}
.bg04 { background-color:#FF0000}
.bg05 { background-color:#99FFFF}
.bg06 { background-color:#F0F8FF}
.bg07 { background-color:#FF0000}
.ft01 { color:#FF0000}
.ft02 { color:#99FFFF}
.ft03 { color:#3D3D3D}

/* 第一种 */
.f_red:link{ color:#EE3B3B; text-decoration:none;}
.f_red:visited{ color:#EE3B3B; text-decoration:none;}
.f_red:hover{ color:#EE3B3B; text-decoration:underline;}
.f_red:actived{ color:#EE3B3B; text-decoration:none;}

/* 第二种 */
.f_green:link{ color:#228B22; text-decoration:none;}
.f_green:visited{ color:#228B22; text-decoration:none;}
.f_green:hover{ color:#228B22; text-decoration:underline;}
.f_green:actived{ color:#228B22; text-decoration:none;}

/* 第三种 */
.f_black:link{color:#515151; text-decoration:none;}
.f_black:visited{color:#515151; text-decoration:none;}
.f_black:hover{color:#515151; text-decoration:underline;}
.f_black:actived{color:#515151; text-decoration:none;}

.bg{background-image:url(../assets/images/assets-bj3.png);background-repeat:no-repeat;_background-image:url(../assets/images/assets-bj4.gif)}
input{border:0;padding:0}
.s_ipt{width:405px;height:22px;font-size:16px;line-height:22px;font-family:arial;margin:5px 0 0 7px;background:#fff;outline:0;-webkit-appearance:none}
.s_ipt_wr{width:418px;height:30px;display:inline-block;margin-right:5px;background-position:0 -288px;border:1px solid #b6b6b6;border-color:#9a9a9a #cdcdcd #cdcdcd #9a9a9a;vertical-align:top}
.s_btn{width:95px;height:32px;padding-top:2px\9;font-size:14px;background-color:#ddd;background-position:0 -240px;cursor:pointer}.s_btn_h{background-position:-240px -240px}.s_btn_wr{width:97px;height:34px;display:inline-block;background-position:-120px -240px;*position:relative;z-index:0;vertical-align:top}
</style>
<link rel="stylesheet" href="../assets/images/themes/blue/style.css" type="text/css" media="print, projection, screen" />
<script type="text/javascript" src="../assets/js/user/jquery-1.1.3.js"></script>
<script type="text/javascript" src="../assets/js/jquery/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../assets/js/user/jquery.tablesorter.pack.js"></script>
	<script type="text/javascript">
	$(function() {		
		$("#tablesorter-demo").tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']});
	});	
	</script>
</head>
<body>
<table width="100%" height="70px" border="0" cellpadding="5" cellspacing="1"> 
	<tbody>
<tr>

<td align="center" width="22%">
</td>

<td align="center">
<img src="../assets/images/loginlogo2.jpg">
</td>

<td align="center">
<SPAN class="bg s_ipt_wr"><INPUT name="stock" class="s_ipt" id="stock" type="text" maxlength="100"></SPAN>
<SPAN class="bg s_btn_wr"><INPUT class="bg s_btn" id="addStock" onmouseout="this.className='bg s_btn'" onmousedown="this.className='bg s_btn s_btn_h'" type="submit" value="新增股票" onClick="addStock()"></SPAN>
</td>

<td align="center" width="22%">
<a class="f_black" href="#" target="_blank">查看自选股列表页</a>
</td>

</tr>
	</tbody>
</table>


<table id="tablesorter-demo" class="tablesorter" width="100%"  border="0" cellpadding="0" cellspacing="1"> 

        <thead>  
            <tr>  
			<th width="4.5%">代码</th>
			<th width="19%">公司名称</th>
			<th width="5%">当前价</th>
			<th width="5%">涨跌额</th>
			<th width="5%">涨跌幅</th>
			<th width="5%">盘后额</th>
			<th width="5%">盘后幅</th>
			<th width="5%">盘前额</th>
			<th width="5%">盘前幅</th>
			<th width="33%">最后一条新闻标题</th>
			<th width="8.5%">新闻日期</th>
		 </tr> 
        </thead>  

	<tbody>
		<#if list ??>
			<#list list as l>
				<tr>
					<td width="4.5%"><a class="f_black" href="http://xueqiu.com/S/${l.code}" target="_blank">${l.code}</a></td>
					<td width="19%"><a class="f_black" href="http://finance.yahoo.com/q/pr?s=${l.code}+Profile" target="_blank">${l.company}</a></td>
					<td width="5%" align="right">${l.currentPrice}</td>

<#if (l.quoteChangeTd?length gt 0) && (l.quoteChangeTd?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://xueqiu.com/S/${l.code}" target="_blank">
<#elseif l.quoteChangeTd==''>
<td width="5%" align="right"><a class="f_green" href="http://xueqiu.com/S/${l.code}" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://xueqiu.com/S/${l.code}" target="_blank">
</#if>${l.quoteChangeTd}</a></td>

<#if (l.amountChangeTd?length gt 0) && (l.amountChangeTd?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://xueqiu.com/S/${l.code}" target="_blank">
<#elseif l.amountChangeTd==''>
<td width="5%" align="right"><a class="f_green" href="http://xueqiu.com/S/${l.code}" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://xueqiu.com/S/${l.code}" target="_blank">
</#if>${l.amountChangeTd}</a></td>
<#if (l.quoteChangeYa?length gt 0) && (l.quoteChangeYa?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
<#elseif l.quoteChangeYa==''>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
</#if>${l.quoteChangeYa}</a></td>

<#if (l.amountChangeYa?length gt 0) && (l.amountChangeYa?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
<#elseif l.amountChangeYa==''>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
</#if>${l.amountChangeYa}</a></td>

<#if (l.quoteChangeTb?length gt 0) && (l.quoteChangeTb?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
<#elseif l.quoteChangeTb==''>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
</#if>${l.quoteChangeTb}</a></td>

<#if (l.amountChangeTb?length gt 0) && (l.amountChangeTb?substring(0,1) == '-')>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
<#elseif l.amountChangeTb==''>
<td width="5%" align="right"><a class="f_green" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
<#else>
<td width="5%" align="right"><a class="f_red" href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
</#if>${l.amountChangeTb}</a></td>
<td width="33%"><a class="f_black" href="${l.stockInfoUrl}" target="_blank">
${l.stockTitle}</a></td>
					<td width="8.5%">${l.stockInfoTime}</td>
				</tr>
			</#list>
		</#if>
		    
		
	</tbody>
</table>


<table width="100%" height="80px" border="0" cellpadding="5" cellspacing="1"> 
	<tbody>
<tr><td align="center">
黑球网 版权所有 2014-2018   Copyright © HeiQiu Networks. All right reserved.
</td></tr>
	</tbody>
</table>

</body>
<script src="../assets/js/user/stock.js"></script>
</html>