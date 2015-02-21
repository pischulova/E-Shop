<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link href="../../resources/total.css" rel="stylesheet" type="text/css">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>
<html>
<body>
<div id="navigation">
    <ul>
        <li class="top"><a href="/home"><fmt:message key="home"/></a></li>
        <li class="top"><a href="/flights"><fmt:message key="flights"/></a></li>
        <li class="top">
            <a href="javascript:document.logout.submit();"><fmt:message key="log_out"/></a>
            <form action="/auth" method="POST" name="logout">
                <input type="hidden" name="command" value="logout"></form>
        </li>
        <li class="top">
            <a href="javascript:document.langEn.submit();"><fmt:message key="en"/></a>
            <FORM ACTION="/auth" METHOD="POST" NAME="langEn">
                <input type="hidden" name="language" value="en">
                <input type="hidden" name="command" value="language"></FORM>
        </li>
        <li class="top">
            <a href="javascript:document.langRu.submit();"><fmt:message key="ru"/></a>
            <FORM ACTION="/auth" METHOD="POST" NAME="langRu">
                <input type="hidden" name="language" value="ru">
                <input type="hidden" name="command" value="language"></FORM>
        </li>
    </ul>
</div>

<ul id="side">
    <li><a href="/profile"><fmt:message key="profile"/></a></li>
    <li><a href="javascript:document.orders.submit();"><fmt:message key="orders"/></a>
        <form action="/auth" method="POST" name="orders">
            <input type="hidden" name="command" value="show_orders">
        </form>
    </li>
    <li><a href="javascript:document.clients.submit();"><fmt:message key="clients"/></a>
        <form action="/auth" method="POST" name="clients">
            <input type="hidden" name="command" value="show_clients">
        </form>
    </li>
</ul>

</body>
</html>
