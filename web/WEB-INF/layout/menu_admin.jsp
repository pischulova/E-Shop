<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<link href="../../resources/total.css" rel="stylesheet" type="text/css">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>
<html>
<body>

<ul id="top">
    <li class="top"><a href="/flights"><fmt:message key="flights"/></a></li>
    <li class="top"><a href="/contact"><fmt:message key="contact"/></a></li>
    <li class="top">
        <a href="javascript:document.logout.submit();"><fmt:message key="log_out"/></a>
        <form action="/auth" method="POST" name="logout">
            <input type="hidden" name="command" value="logout"></form>
    </li>
</ul>

<ul id="side">
    <li><a href="/profile"><fmt:message key="profile"/></a></li>
    <li><a href="/orders"><fmt:message key="orders"/></a></li>
    <li><a href="/clients"><fmt:message key="clients"/></a></li>
</ul>

</body>
</html>
