<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<ul id="top">
    <li class="top"><a href="/home"><fmt:message key="home"/></a></li>
    <li class="top"><a href="/flights"><fmt:message key="flights"/></a></li>
    <li class="top"><a href="/contact"><fmt:message key="contact"/></a></li>
    <li class="top"><a href="/login"><fmt:message key="log_in"/></a></li>
</ul>
