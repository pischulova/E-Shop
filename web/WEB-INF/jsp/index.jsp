<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
    <ul id="lang">
        <li class="top">
            <a href="javascript:document.langEn.submit();">English</a>
            <FORM ACTION="/auth" METHOD="POST" NAME="langEn">
            <input type="hidden" name="language" value="en">
            <input type="hidden" name="command" value="language"></FORM>
        </li>
        <li class="top">
            <a href="javascript:document.langRu.submit();">Russian</a>
            <FORM ACTION="/auth" METHOD="POST" NAME="langRu">
            <input type="hidden" name="language" value="ru">
            <input type="hidden" name="command" value="language"></FORM>
        </li>
    </ul>
<div class="center">
</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>