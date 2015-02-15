<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${userLocale}" />
<fmt:setBundle basename="resources.bundle"/>

<c:choose>
    <c:when test="${sessionScope.isAdmin=='true'}">
        <jsp:include page="/WEB-INF/layout/menu_admin.jsp"/>
    </c:when>
    <c:when test="${sessionScope.isAdmin=='false'}">
        <jsp:include page="/WEB-INF/layout/menu_client.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="/WEB-INF/layout/menu_start.jsp"/>
    </c:otherwise>
</c:choose>