<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<%@include file="/WEB-INF/layout/header.jsp"%>
<div class="center">
    <c:set var="error_mes" value="${sessionScope.error_message}"/>
    <c:if test="${not empty error_mes}">
        <c:choose>
            <c:when test="${error_mes=='bad_login'}">
                <fmt:message key="bad_login"/><br>
            </c:when>
            <c:when test="${error_mes=='db_error'}">
                <fmt:message key="db_error"/><br>
            </c:when>


            <c:otherwise>
                <fmt:message key="unknown_error"/><br>
            </c:otherwise>
        </c:choose>
        <c:remove var="error_message" scope="session"/>
    </c:if>

</div>
<%@include file="/WEB-INF/layout/footer.jsp"%>