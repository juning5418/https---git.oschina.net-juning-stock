<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>黑球网_自选股页</title>
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
.ft03 { color:#F0F8FF}



/* 第一种 */

.f_red:link{ color:#FF0000; text-decoration:none;}
.f_red:visited{ color:#FF0000; text-decoration:none;}
.f_red:hover{ color:#FF0000; text-decoration:underline;}
.f_red:actived{ color:#FF0000; text-decoration:none;}

.f_black:link{color:#FF0000; text-decoration:none;}
.f_black:visited{color:#FF0000; text-decoration:none;}
.f_black:hover{color:#FF0000; text-decoration:underline;}
.f_black:actived{color:#FF0000; text-decoration:none;}


/* 第三种 */
.f_blue:link{ color:#0000ff; text-decoration:none;}
.f_blue:visited{ color:#0000ff; text-decoration:none;}
.f_blue:hover{ color:#ff2020; text-decoration:underline;}
.f_blue:actived{ color:#0000ff; text-decoration:none;}

.f_black3:link{color:#000000; text-decoration:none;}
.f_black3:visited{color:#000000; text-decoration:none;}
.f_black3:hover{color:#999999; text-decoration:underline;}
.f_black3:actived{color:#000000; text-decoration:none;}

.bg{background-image:url(../assets/images/assets-bj3.png);background-repeat:no-repeat;_background-image:url(../assets/images/assets-bj4.gif)}
input{border:0;padding:0}
.s_ipt{width:405px;height:22px;font-size:16px;line-height:22px;font-family:arial;margin:5px 0 0 7px;background:#fff;outline:0;-webkit-appearance:none}
.s_ipt_wr{width:418px;height:30px;display:inline-block;margin-right:5px;background-position:0 -288px;border:1px solid #b6b6b6;border-color:#9a9a9a #cdcdcd #cdcdcd #9a9a9a;vertical-align:top}
.s_btn{width:95px;height:32px;padding-top:2px\9;font-size:14px;background-color:#ddd;background-position:0 -240px;cursor:pointer}.s_btn_h{background-position:-240px -240px}.s_btn_wr{width:97px;height:34px;display:inline-block;background-position:-120px -240px;*position:relative;z-index:0;vertical-align:top}
</style>
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
</td>

</tr>
	</tbody>
</table>


<table class="tb01" width="100%" border="0" cellpadding="5" cellspacing="1"> 
	<tbody>
		<tr align="center">
		        <td width="3.5%">操作</td>
			<td width="4.5%">代码</td>
			<td width="19%">公司名称</td>
			<td width="5%">当前价</td>
			<td width="5%">涨跌额</font></td>
			<td width="5%">涨跌幅</td>
			<td width="5%">盘后额</td>
			<td width="5%">盘后幅</td>
			<td width="5%">盘前额</td>
			<td width="5%">盘前幅</td>
			<td width="9.5%">52周幅度($)</td>
			<td width="6%">成交量</td>
			<td width="9%">总股本</td>
			<td width="8.5%">市值($)</td>
			<td width="5%">市盈率</td>
		 </tr> 
</tbody></table>

<table class="bg01" width="100%" border="0" cellpadding="5" cellspacing="1"> 
	<tbody>
		<#if list ??>
			<#list list as l>
				<tr class="bg02">
					<td width="3.5%" align="center"><a href="#" onclick="delStock('${l.code}')">删</a></td>
					<td width="4.5%"><a href="http://xueqiu.com/S/${l.code}" target="_blank">${l.code}</a></td>
					<td width="19%"><a href="http://finance.yahoo.com/q/pr?s=${l.code}+Profile" target="_blank">${l.company}</a></td>
					<td width="5%" class="bg03" align="right">${l.currentPrice}</td>
					<#if (l.quoteChangeTd?length gt 0) && (l.quoteChangeTd?substring(0,1) == '-')><td width="5%"   align="right"><#elseif l.quoteChangeTd==''><td width="5%" class="ft01" align="right"><#else><td width="5%"  class="ft01" align="right"></#if>${l.quoteChangeTd}</font></td>
					<#if (l.amountChangeTd?length gt 0) && (l.amountChangeTd?substring(0,1) == '-')><td width="5%"   align="right"><#elseif l.amountChangeTd==''><td width="5%" class="ft01" align="right"><#else><td width="5%"  class="ft01"  align="right"></#if>${l.amountChangeTd}</td>
					<#if (l.quoteChangeYa?length gt 0) && (l.quoteChangeYa?substring(0,1) == '-')><td width="5%"   align="right"><#elseif l.quoteChangeYa==''><td width="5%" class="ft01" align="right"><#else><td width="5%" class="ft01"  align="right"></#if>${l.quoteChangeYa}</font></td>
					<#if (l.amountChangeYa?length gt 0) && (l.amountChangeYa?substring(0,1) == '-')>
						<td width="5%"   align="right"><a  class="f_black3 f_blue" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
					<#elseif l.amountChangeYa==''>
						<td width="5%" class="ft01" align="right"><a  class="f_black3 f_blue" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
					<#else>
						<td width="5%"  class="ft01" align="right"><a  class="f_black f_red" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
					</#if>${l.amountChangeYa}</a></td>
					<#if (l.quoteChangeTb?length gt 0) && (l.quoteChangeTb?substring(0,1) == '-')><td width="5%"   align="right"><#elseif l.quoteChangeTb==''><td width="5%" class="ft01" align="right"><#else><td width="5%" class="ft01"  align="right"></#if>${l.quoteChangeTb}</font></td>
					<#if (l.amountChangeTb?length gt 0) && (l.amountChangeTb?substring(0,1) == '-')>
						<td width="5%"   align="right"><a  class="f_black3 f_blue"  href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
					<#elseif l.amountChangeTb==''>
						<td width="5%" class="ft01" align="right"><a  class="f_black3 f_blue" href="http://www.nasdaq.com/symbol/${l.code}/after-hours" target="_blank">
					<#else>
						<td width="5%" class="ft01"  align="right"><a  class="f_black f_red"  href="http://www.nasdaq.com/symbol/${l.code}/premarket" target="_blank">
					</#if>${l.amountChangeTb}</a></td>
					<td width="9.5%" align="right">${l.amplitude}</font></td>
					<td width="6%" align="right">${l.tradingVolume}</td>
					<td width="9%" align="right">${l.capitalization}</td>
					<td width="8.5%" align="right">${l.marketCap}</td>
					<td width="5%" align="right">${l.pe}</td>
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
<script src="../assets/js/jquery/jquery-1.9.1.min.js"></script>
<script src="../assets/js/user/stock.js"></script>
</html>