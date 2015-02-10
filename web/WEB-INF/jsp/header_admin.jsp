<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link href="../../header.css" rel="stylesheet" type="text/css">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>
<html>
<body>
<div id="header">
    <span class="Centerer"></span>
    <img class="Centered" src="http://fs155.www.ex.ua/get/326460779959/150430845/logo.png"/>
</div>

<form id="log" action="/login">
    <fmt:message key="log_in" var="buttonValue" />
    <input type="submit" class="button" name="login" value="${buttonValue}">
</form>

<ul id="top">
    <li><a href="/home"><fmt:message key="home"/></a></li>
    <li><a href="/WEB-INF/jsp/hotels.jsp"><fmt:message key="hotels"/></a></li>
    <li><a href="/WEB-INF/jsp/flights.jsp"><fmt:message key="flights"/></a></li>
    <li><a href="/WEB-INF/jsp/contact.jsp"><fmt:message key="contact"/></a></li>
    <li><a href="/WEB-INF/jsp/contact.jsp"><fmt:message key="clients"/></a></li>
</ul>

<div id="footer">&#169 2015 Alyona Pischulova</div>

</body>
</html>