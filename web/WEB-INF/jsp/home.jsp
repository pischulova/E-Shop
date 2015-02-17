<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<%@include file="/WEB-INF/layout/menu.jsp"%>
<div class="center">
    <c:if test="${not empty sessionScope.user}">
         Hello, ${user.login}!<br><br>
    </c:if>
    <fmt:message key="welcome_text"/>
</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>