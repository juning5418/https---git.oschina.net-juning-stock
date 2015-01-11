<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <@block name="head">
        <@block name="beforePage"></@block>
        <@block name="pageTitle">
            <title>${APP_TITLE}</title>

            <link rel="shortcut icon" href="${APP_URL}/favicon.ico" type="images/icon">
            <link rel="icon" href="${APP_URL}/favicon.ico" type="images/icon">

            <!--[if lt IE 9]>
                <@js file="${JS_PATH}/html5.js" />
            <![endif]-->
        </@block>
        <@block name="afterHead"></@block>
    </@block>
</head>
<body>
	<@block name="body">
		<@block name="header"></@block>
		<@block name="footer"></@block>
	</@block>

	<@block name="afterPage"></@block>
	<#-- ${SITE_STATE} -->
</body>
</html>
