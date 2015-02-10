<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<link href="../../header.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<body>
<div id="header">
    <span class="Centerer"></span>
    <img class="Centered" src="http://fs155.www.ex.ua/get/326460779959/150430845/logo.png"/>
</div>

<ul id="lang">
    <li >
        <a href="javascript:document.langEn.submit();">English</a>
        <FORM ACTION="/auth" METHOD="POST" NAME="langEn">
        <input type="hidden" name="language" value="en">
        <input type="hidden" name="command" value="language"></FORM>
    </li>
    <li >
        <a href="javascript:document.langRu.submit();">Russian</a>
        <FORM ACTION="/auth" METHOD="POST" NAME="langRu">
        <input type="hidden" name="language" value="ru">
        <input type="hidden" name="command" value="language"></FORM>
    </li>
</ul>

<div id="footer">&#169 2015 Alyona Pischulova</div>
</body>
</html>
