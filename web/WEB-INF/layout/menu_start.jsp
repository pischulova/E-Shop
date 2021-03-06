<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<div id="navigation">
    <ul>
        <li class="top"><a href="/home"><fmt:message key="home"/></a></li>
        <li class="top"><a href="/flights"><fmt:message key="flights"/></a></li>
        <li class="top"><a href="/login"><fmt:message key="log_in"/></a></li>
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
