<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">
    <form action="/auth?command=${"login"}" method="post">
    <fmt:message key="name"/>
    <input type="text" name="name" required><br/>
    <fmt:message key="pass"/>
    <input type="text" name="pass" required><br/>
    <input type="submit" value="ok">
    </form>
</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>
